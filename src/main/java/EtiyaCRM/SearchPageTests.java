package EtiyaCRM;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

public class SearchPageTests {

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
    public void access_search_screen()throws InterruptedException {
        driver.navigate().to("http://localhost:4200/login");
        driver.manage().window().setSize(new Dimension(1936, 1048));
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("password")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.cssSelector(".p-button-label")).click();
        Thread.sleep(2000);
    }


    @Test
    public void clear_button() throws InterruptedException{
        driver.navigate().to("http://localhost:4200/search");
        driver.manage().window().setSize(new Dimension(1296, 688));
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("esat");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button:nth-child(1)")).click();
        Thread.sleep(2000);
    }

    @Test
    public void filter_by_content() throws InterruptedException {
        driver.navigate().to("http://localhost:4200/search");
        driver.manage().window().setSize(new Dimension(1296, 688));
        WebElement firstName = driver.findElement(By.id("firstName"));
        driver.findElement(By.id("firstName")).click();

        firstName.sendKeys("esat");
        driver.findElement(By.cssSelector("button:nth-child(2)")).click();
        firstName.clear();
        firstName.sendKeys("");
        Thread.sleep(2000);
        driver.findElement(By.id("firstName")).click();
        firstName.sendKeys("es");
        driver.findElement(By.cssSelector(".button-div > button:nth-child(2)")).click();
        firstName.clear();
        firstName.sendKeys("");
        Thread.sleep(2000);
        driver.findElement(By.id("firstName")).click();
        firstName.sendKeys("e");
        driver.findElement(By.cssSelector(".button-div > button:nth-child(2)")).click();
        firstName.clear();
        firstName.sendKeys("");
        Thread.sleep(2000);
        driver.findElement(By.id("firstName")).click();
        firstName.sendKeys("sa");
        driver.findElement(By.cssSelector(".button-div > button:nth-child(2)")).click();

        Thread.sleep(2000);
    }

    @Test
    public void case_sensitivity() throws InterruptedException{
        driver.navigate().to("http://localhost:4200/search");
        driver.manage().window().setSize(new Dimension(1936, 1048));
        driver.findElement(By.id("firstName")).sendKeys("ESAT");
        driver.findElement(By.cssSelector(".button-div > button:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".button-div > button:nth-child(1)")).click();
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("esat");
        driver.findElement(By.cssSelector("button:nth-child(2)")).click();
        Thread.sleep(2000);
        {
            WebElement element = driver.findElement(By.cssSelector("button:nth-child(2)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.close();
    }

    @Test
    public void record_list_sorting() throws InterruptedException{
        driver.navigate().to("http://localhost:4200/search");
        driver.manage().window().setSize(new Dimension(1936, 1048));
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("a");
        driver.findElement(By.cssSelector(".button-div > button:nth-child(2)")).click();
        Thread.sleep(2000);
        {
            WebElement element = driver.findElement(By.cssSelector(".button-div > button:nth-child(2)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        Thread.sleep(2000);
    }

    @Test
    public void record_list_limitation_and_pagination() throws InterruptedException{
        driver.navigate().to("http://localhost:4200/search");
        driver.manage().window().setSize(new Dimension(1936, 1048));
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("a");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button:nth-child(2)")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".p-dropdown-trigger")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("pn_id_3_2")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".p-paginator-page:nth-child(2)")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".p-dropdown-trigger-icon")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("pn_id_3_3")).click();
        Thread.sleep(2000);
    }
}
