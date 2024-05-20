package EtiyaCRM;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class CustomerRecordsTests {
    //FR3-Customer Records Tests
    private WebDriver driver;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;

        driver.navigate().to("http://localhost:4200/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("user1");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("password1");
        driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();

    }
    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void record_list_sorting() throws InterruptedException{
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("e");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("can");
        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).sendKeys("a");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(5000);
    }

    @Test
    public void record_list_limitation() throws InterruptedException{
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("a");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".p-dropdown-trigger-icon")).click();
        driver.findElement(By.id("pn_id_3_2")).click();
        driver.findElement(By.cssSelector(".p-dropdown-trigger-icon")).click();
        driver.findElement(By.id("pn_id_3_1")).click();
        driver.findElement(By.cssSelector(".p-dropdown-trigger")).click();
        driver.findElement(By.id("pn_id_3_0")).click();

    }

    @Test
    public void record_list_pagination() throws InterruptedException{
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("a");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(.,'10')]")).click();
        driver.findElement(By.xpath("//li[@id='pn_id_3_1']/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".p-paginator-next .p-icon")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".p-paginator-prev .p-icon")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".p-paginator-last .p-icon")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='pn_id_1']/p-paginator/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='pn_id_3']/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@id='pn_id_3_0']/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'2')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'3')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'5')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".p-paginator-last .p-icon")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".p-paginator-prev .p-icon")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@id='pn_id_3']/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@id='pn_id_3_2']/span")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".p-dropdown-trigger")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@id='pn_id_3_3']/span")).click();
        Thread.sleep(2000);
    }



    //Clickable Customer ID eklenecek
    @Test
    public void clickable_customerID() throws InterruptedException{}

}

