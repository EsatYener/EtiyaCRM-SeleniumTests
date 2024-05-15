package EtiyaCRM;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class LoginPageTests {

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
    public void succesfull_login() throws InterruptedException {
        driver.navigate().to("http://localhost:4200/login");
        driver.manage().window().setSize(new Dimension(1054, 654));
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("test");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("test");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".p-element")).click();
        Thread.sleep(2000);
    }

    @Test
    public void input_field_test() throws InterruptedException{
        driver.navigate().to("http://localhost:4200/login");
        driver.manage().window().setSize(new Dimension(1054, 654));
        driver.findElement(By.id("username")).click();
        driver.findElement(By.cssSelector(".half-right")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("password")).click();
        driver.findElement(By.cssSelector(".half-right")).click();
        Thread.sleep(2000);
    }

    @Test
    public void secret_password()  throws InterruptedException{
        driver.navigate().to("http://localhost:4200/login");
        driver.manage().window().setSize(new Dimension(1936, 1048));
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("esatyener");
        Thread.sleep(2000);
    }
}
