package EtiyaCRM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

public class DemographicPageTests {

    // BeforeEach -> TestCase -> AfterEach
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void access_demographic_info_screen_AND_required_field()throws InterruptedException {
        driver.navigate().to("http://localhost:4200/search");
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("sss");
        driver.findElement(By.cssSelector("button:nth-child(2)")).click();
        Thread.sleep(2000);
        {
            WebElement element = driver.findElement(By.cssSelector("button:nth-child(2)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        Thread.sleep(2000);
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".create-customer-section > button")).click();
        Thread.sleep(2000);
    }

    @Test
    public void cancel_button() throws InterruptedException{
        driver.navigate().to("http://localhost:4200/create/demographic-info");
        driver.findElement(By.cssSelector(".left-side > .inputs:nth-child(1) > .ng-untouched")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input")).sendKeys("test");
        driver.findElement(By.cssSelector(".cancel-button")).click();
        Thread.sleep(2000);
    }
    @Test
    public void empty_required_fields() throws InterruptedException{
        driver.navigate().to("http://localhost:4200/create/demographic-info");
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
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://localhost:4200/search");
        driver.manage().window().setSize(new Dimension(1936, 1048));

        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("melodi");
        driver.findElement(By.cssSelector("button:nth-child(2)")).click();

        // Adding a delay
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".create-customer-section > button")).click();

        // Adding a delay
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".inputs:nth-child(1) > .ng-invalid")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("melodi");

        // Adding a delay
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".left-side > .inputs:nth-child(2) > .ng-untouched")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("bayraktar");

        // Adding a delay
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".form-select")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector(".form-select"));
            dropdown.findElement(By.xpath("//option[. = 'Female']")).click();
        }

        // Adding a delay
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@type='date']")).click();
       // driver.findElement(By.xpath("//input[@type='date']")).sendKeys("0001-09-04");
        //driver.findElement(By.xpath("//input[@type='date']")).sendKeys("0019-09-04");
        //driver.findElement(By.xpath("//input[@type='date']")).sendKeys("0199-09-04");
        driver.findElement(By.xpath("//input[@type='date']")).sendKeys("1999-09-04");

        // Adding a delay
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//input[@type='text'])[6]")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("12345678910");

        // Adding a delay
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".etiya-demographic")).click();

        // Adding a delay
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".inputs:nth-child(1) > .ng-untouched")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(1) > .ng-untouched")).sendKeys("melodi");

        // Adding a delay
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".next-button")).click();

        // Close the driver
        driver.quit();
    }



}
