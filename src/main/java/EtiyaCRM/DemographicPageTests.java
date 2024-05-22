package EtiyaCRM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class DemographicPageTests extends BaseTest {
    @Before
    public void setUp(){
        accessLoginScreen();
        performLogin("user1","password1");
        //driver.navigate().to("http://localhost:4200/create/demographic-info");
    }

    @Test
    public void access_demographic_info_screen_AND_required_field()throws InterruptedException {
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("beste");
        driver.findElement(By.cssSelector("button:nth-child(2)")).click();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".create-customer-section > button")).click();
        Thread.sleep(2000);


    }
    @Test
    public void cancel_button() throws InterruptedException{
        //driver.navigate().to("http://localhost:4200/create/demographic-info"); //test sonunda searche değil logine dönüyor
        access_demographic_info_screen_AND_required_field();
        driver.findElement(By.xpath("//input")).sendKeys("test");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".cancel-button")).click();
        Thread.sleep(2000);
  }
    @Test
    public void empty_required_fields() throws InterruptedException{
        driver.navigate().to("http://localhost:4200/create/demographic-info");

        Thread.sleep(5000);
        String[] cssSelectors = {
                ".left-side > .inputs:nth-child(1) > .ng-untouched",//firstname textbox
                ".left-side > .inputs:nth-child(2) > .ng-untouched",//lastname textbox
                ".form-select",//gender
                ".inputs:nth-child(2) > .ng-untouched",//date
                ".right-side > .inputs:nth-child(4) > .ng-untouched",//nationalityid

        };
        for (String selector : cssSelectors) {
            driver.findElement(By.cssSelector(selector)).click();
            driver.findElement(By.cssSelector(".etiya-demographic")).click();//alan dışına tıklama
            Thread.sleep(2000);
        }

    }

    @Test
    public void successfullAddingDemographicInfo() throws InterruptedException {

        String[][] info = {
                {".inputs:nth-child(1) > .ng-invalid", "esat"},
                {".left-side > .inputs:nth-child(2) > .ng-untouched", "yener"},
                {"//input[@type='date']", "0126-20-00"},
                {".inputs:nth-child(4) > .ng-invalid", "14920120212"},
        };

        for (String[] input : info) {
            By locator = input[0].startsWith("//") ? By.xpath(input[0]) : By.cssSelector(input[0]);
            Thread.sleep(500);
            enterText(locator, input[1]);
            Thread.sleep(500);
        }

        Thread.sleep(500);

        selectDropdownOption(By.cssSelector(".form-select"), "Male");
        Thread.sleep(500);
        clickElement(By.cssSelector(".etiya-demographic"));
        Thread.sleep(500);
        clickElement(By.cssSelector(".next-button"));
        Thread.sleep(1000);
    }


    @Test
    public void nationalityIDVerification() throws  InterruptedException {
        access_demographic_info_screen_AND_required_field();
        Thread.sleep(2000);
        WebElement natIdfield = driver.findElement(By.xpath("(//input[@type='text'])[6]"));
        natIdfield.click();

        driver.findElement(By.cssSelector(".form")).click();
        Thread.sleep(2000);

        natIdfield.clear();
        natIdfield.sendKeys("121");
        Thread.sleep(2000);

        natIdfield.clear();
        natIdfield.sendKeys("12121221212");
        Thread.sleep(2000);
    }
    @Test
    public void customer_record_check() throws InterruptedException{
        driver.navigate().to("http://localhost:4200/create/demographic-info");

        fillInputField(By.xpath("//input[@type='text']"), "Emine");
        fillInputField(By.xpath("(//input[@type='text'])[4]"), "Ece");
        fillInputField(By.xpath("(//input[@type='text'])[2]"), "Coşkunçay");
        selectDropdownOption(By.cssSelector(".form-select"), "Female");
        fillInputField(By.xpath("//input[@type='date']"), "01-20-1998");
        Thread.sleep(2000);

        fillInputField(By.xpath("(//input[@type='text'])[6]"), "22805300246");
        driver.findElement(By.cssSelector(".next-button")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[contains(.,'OK')]")).click();
        fillInputField(By.xpath("(//input[@type='text'])[4]"), "");
        Thread.sleep(2000);

        fillInputField(By.xpath("(//input[@type='text'])[6]"), "22805300256");
        driver.findElement(By.cssSelector(".next-button")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[contains(.,'OK')]")).click();
        fillInputField(By.xpath("(//input[@type='text'])[4]"), "");
        Thread.sleep(2000);

        fillInputField(By.xpath("//input[@type='text']"), "Mehmet");
        selectDropdownOption(By.cssSelector(".form-select"), "Male");
        fillInputField(By.xpath("(//input[@type='text'])[4]"), "");
        fillInputField(By.xpath("//input[@type='date']"), "03-14-1965");
        Thread.sleep(2000);

        fillInputField(By.xpath("(//input[@type='text'])[6]"), "22859298476");
        driver.findElement(By.cssSelector(".next-button")).click();

        Thread.sleep(5000);
    }

    private void fillInputField(By locator, String value) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(value);
    }


    @Test
    public void birthdate_check() throws InterruptedException{

        driver.get("http://localhost:4200/create/demographic-info");
        Thread.sleep(2000);

        WebElement dateInput = driver.findElement(By.xpath("//input[@type='date']"));
        dateInput.click();
        Thread.sleep(2000);

        String[] dates = {"05-23-2006", "04-13-2006", "05-12-2010", "01-20-1998"};

        // Her bir tarihi gir ve ardından temizle
        for (String date : dates) {
            enterDate(dateInput, date);
            Thread.sleep(2000);
            clearDate(dateInput);
        }

        // Son tarihi gir
        dateInput.sendKeys(dates[dates.length - 1]);
        Thread.sleep(2000);
        dateInput.click();
    }


    @Test
    public void nonRequiredFields() throws InterruptedException {
        access_demographic_info_screen_AND_required_field();

        String[] cssSelectors={".inputs:nth-child(4) > .ng-valid",
                ".inputs:nth-child(1) > .ng-valid",
                ".inputs:nth-child(3) > .ng-valid"};
        for (String selector : cssSelectors) {
            driver.findElement(By.cssSelector(selector)).click();
            driver.findElement(By.cssSelector(".etiya-demographic")).click();//alan dışına tıklama
            Thread.sleep(2000);
        }


    }
    @Test
    public void unsuccessfullAddingDemographicInfo() throws InterruptedException{
        access_demographic_info_screen_AND_required_field();

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Joe");
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Doe");
        selectDropdownOption(By.cssSelector(".form-select"), "Male");

        String[] dates = {"05-23-2006", "04-13-2006", "05-12-2010", "01-20-1998"};
        WebElement dateInput = driver.findElement(By.xpath("//input[@type='date']"));
        dateInput.click();
        Thread.sleep(2000);
        // Her bir tarihi gir ve ardından temizle
        for (String date : dates) {
            enterDate(dateInput, date);
            Thread.sleep(2000);
            clearDate(dateInput);
        }

        dateInput.sendKeys(dates[dates.length - 1]);
        Thread.sleep(2000);
        dateInput.click();
        driver.findElement(By.cssSelector(".etiya-demographic")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[6]")).click();

        driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("12121");
        driver.findElement(By.cssSelector(".etiya-demographic")).click();

        Thread.sleep(2000);
    }

    @Test
    public void successfull_create_customer() throws InterruptedException{
// Enter demographic information
        String[][] demographicInfo = {
                {".inputs:nth-child(1) > .ng-invalid", "esat"},
                {".left-side > .inputs:nth-child(2) > .ng-untouched", "yener"},
                {"//input[@type='date']", "0126-20-00"},
                {".inputs:nth-child(4) > .ng-invalid", "14920120212"}
        };

        for (String[] info : demographicInfo) {
            By locator = info[0].startsWith("//") ? By.xpath(info[0]) : By.cssSelector(info[0]);
            enterText(locator, info[1]);
        }
        selectDropdownOption(By.cssSelector(".form-select"), "Male");

        clickElement(By.cssSelector(".etiya-demographic"));
        clickElement(By.cssSelector(".next-button"));
        moveToElement(By.tagName("body"));


        clickElement(By.cssSelector(".add-button"));

        selectDropdownOption(By.cssSelector(".form-select"), "Ankara");
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("test");
        Thread.sleep(500);
        driver.findElement(By.cssSelector(".inputs:nth-child(2) > .ng-untouched")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(2) > .ng-untouched")).sendKeys("123");
        driver.findElement(By.cssSelector(".inputs:nth-child(3) > .ng-untouched")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(3) > .ng-untouched")).sendKeys("test");
        Thread.sleep(500);

        clickElement(By.cssSelector(".save-button"));
        moveToElement(By.cssSelector(".save-button"));
        moveToElement(By.tagName("body"));
        Thread.sleep(500);

        clickElement(By.cssSelector(".next-button"));

        String[][] contact_info = {
                {".inputs:nth-child(1) > .ng-invalid", "test@test.com"},
                {".inputs:nth-child(2) > .ng-invalid", "05555555555"}
        };

        for (String[] info : contact_info) {
            By locator = info[0].startsWith("//") ? By.xpath(info[0]) : By.cssSelector(info[0]);
            enterText(locator, info[1]);
        }

        // Create customer
        clickElement(By.cssSelector(".create-button"));
        moveToElement(By.cssSelector(".create-button"));
        moveToElement(By.tagName("body"));
    }

    private void moveToElement(By locator) {
        WebElement element = driver.findElement(locator);
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
    }

    protected void selectDropdownOption(By locator, String optionText) throws InterruptedException {
        WebElement dropdown = driver.findElement(locator);
        dropdown.click();
        Thread.sleep(500);
        dropdown.findElement(By.xpath("//option[. = '" + optionText + "']")).click();
        Thread.sleep(500);
    }

    // Tarih alanına tarih girme
    private void enterDate(WebElement dateInput, String date) {
        dateInput.clear();
        dateInput.sendKeys(date);
    }

    // Tarih alanını temizleme
    private void clearDate(WebElement dateInput) {
        dateInput.clear();
    }

}






