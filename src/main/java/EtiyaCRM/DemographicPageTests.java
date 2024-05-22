package EtiyaCRM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

public class DemographicPageTests extends BaseTest {
    @Before
    public void setUp(){
        accessLoginScreen();
        performLogin("user1","password1");
        driver.navigate().to("http://localhost:4200/create/demographic-info");
    }

    @Test
    public void access_demographic_info_screen_AND_required_field()throws InterruptedException {
        /*driver.navigate().to("http://localhost:4200/login");
        Thread.sleep(2000);
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("user1");
        driver.findElement(By.id("password")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("password1");
        driver.findElement(By.cssSelector(".p-button-label")).click();
        Thread.sleep(2000);*/

        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("beste");
        driver.findElement(By.cssSelector("button:nth-child(2)")).click();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".create-customer-section > button")).click();
        Thread.sleep(2000);


    }
    @Test
    public void cancel_button() throws InterruptedException{
        access_demographic_info_screen_AND_required_field();
       // driver.navigate().to("http://localhost:4200/create/demographic-info");
        driver.findElement(By.cssSelector(".left-side > .inputs:nth-child(1) > .ng-untouched")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input")).sendKeys("test");
        driver.findElement(By.cssSelector(".cancel-button")).click();
        Thread.sleep(2000);
    }
    @Test
    public void empty_required_fields() throws InterruptedException{
        //driver.navigate().to("http://localhost:4200/create/demographic-info");
        driver.findElement(By.cssSelector(".left-side > .inputs:nth-child(1) > .ng-untouched")).click();
        driver.findElement(By.cssSelector(".etiya-demographic")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".left-side > .inputs:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".left-side > .inputs:nth-child(2) > .ng-untouched")).click();
        driver.findElement(By.cssSelector(".form-select")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".etiya-demographic")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(2) > .ng-untouched")).click();
        driver.findElement(By.cssSelector(".etiya-demographic")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".right-side > .inputs:nth-child(4) > .ng-untouched")).click();
        driver.findElement(By.cssSelector(".form")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(4) > .ng-touched")).click();
        Thread.sleep(2000);
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
        driver.findElement(By.cssSelector(".inputs:nth-child(4) > .ng-invalid")).click();
        driver.findElement(By.cssSelector(".form")).click();
        driver.findElement(By.cssSelector(".error")).click();
        driver.findElement(By.cssSelector(".error")).sendKeys("121");
        driver.findElement(By.cssSelector(".form")).click();
        driver.findElement(By.cssSelector(".error")).click();
        driver.findElement(By.cssSelector(".ng-touched:nth-child(2)")).sendKeys("12121221212");
    }
    @Test
    public void nonRequiredFields() throws InterruptedException {
        access_demographic_info_screen_AND_required_field();
        driver.manage().window().setSize(new Dimension(1280, 642));
        driver.findElement(By.cssSelector(".inputs:nth-child(4) > .ng-valid")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(1) > .ng-valid")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(3) > .ng-valid")).click();
        driver.findElement(By.cssSelector(".etiya-demographic")).click();
    }
    @Test
    public void unsuccessfullAddingDemographicInfo() throws InterruptedException{
        access_demographic_info_screen_AND_required_field();
        driver.findElement(By.cssSelector(".inputs:nth-child(1) > .ng-invalid")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Joe");
        driver.findElement(By.cssSelector(".left-side > .inputs:nth-child(2) > .ng-untouched")).click();
        driver.findElement(By.cssSelector(".etiya-demographic")).click();
        driver.findElement(By.cssSelector(".error")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(2) > .ng-touched")).sendKeys("Doe");
        driver.findElement(By.cssSelector(".etiya-demographic")).click();
        driver.findElement(By.cssSelector(".form-select")).click();
        driver.findElement(By.cssSelector(".etiya-demographic")).click();
        driver.findElement(By.cssSelector(".form-select")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector(".form-select"));
            dropdown.findElement(By.xpath("//option[. = 'Female']")).click();
        }
        driver.findElement(By.cssSelector(".etiya-demographic")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(2) > .ng-untouched")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(2) > .ng-untouched")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(2) > .ng-untouched")).sendKeys("0001-09-04");
        driver.findElement(By.cssSelector(".inputs:nth-child(2) > .ng-untouched")).sendKeys("0019-09-04");
        driver.findElement(By.cssSelector(".inputs:nth-child(2) > .ng-untouched")).sendKeys("0199-09-04");
        driver.findElement(By.cssSelector(".inputs:nth-child(2) > .ng-untouched")).sendKeys("1999-09-04");
        driver.findElement(By.cssSelector(".etiya-demographic")).click();
        driver.findElement(By.cssSelector(".ng-invalid:nth-child(2)")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".form"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector(".etiya-demographic"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.cssSelector(".form")).click();
        driver.findElement(By.cssSelector(".right-side > .inputs:nth-child(4) > label")).click();
        driver.findElement(By.cssSelector(".error")).click();
        driver.findElement(By.cssSelector(".error")).sendKeys("12121");
        driver.findElement(By.cssSelector(".etiya-demographic")).click();
        driver.findElement(By.cssSelector(".error")).click();
        driver.findElement(By.cssSelector(".etiya-demographic")).click();


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








}
