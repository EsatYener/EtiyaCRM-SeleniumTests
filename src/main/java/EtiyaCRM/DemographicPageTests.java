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
        driver.navigate().to("http://localhost:4200/login");
        Thread.sleep(2000);
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("user1");
        driver.findElement(By.id("password")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("password1");
        driver.findElement(By.cssSelector(".p-button-label")).click();
        Thread.sleep(2000);

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
        access_demographic_info_screen_AND_required_field();
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
        access_demographic_info_screen_AND_required_field();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".inputs:nth-child(1) > .ng-invalid")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("beste");


        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".left-side > .inputs:nth-child(2) > .ng-untouched")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("bayraktar");


        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".form-select")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector(".form-select"));
            dropdown.findElement(By.xpath("//option[. = 'Female']")).click();
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='date']")).click();
        driver.findElement(By.xpath("//input[@type='date']")).sendKeys("1999-09-04");


        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@type='text'])[6]")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("12345678910");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".etiya-demographic")).click();


        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".inputs:nth-child(1) > .ng-untouched")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(1) > .ng-untouched")).sendKeys("melodi");


        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".next-button")).click();

    }



}
