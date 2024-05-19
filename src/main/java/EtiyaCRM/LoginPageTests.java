package EtiyaCRM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;

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

        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("user1");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("password1");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".p-element")).click();
        Thread.sleep(2000);
    }

    @Test
    public void input_field_test() throws InterruptedException{

        driver.navigate().to("http://localhost:4200/login");

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
        Thread.sleep(2000);
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("esatyener");
        Thread.sleep(3000);
    }

    @Test
    public void password_lenght() throws InterruptedException{
        driver.navigate().to("http://localhost:4200/login");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("esaty");
        Thread.sleep(2000);
    }

    @Test
    public void hidingShowing_password() throws InterruptedException{
        driver.navigate().to("http://localhost:4200/login");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("test");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".fa-eye-slash")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".fas")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("123");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".fas")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".fas")).click();
        Thread.sleep(2000);
    }

    @Test
    public void testAuthGuard() throws InterruptedException{
        driver.navigate().to("http://localhost:4200/login");
        Thread.sleep(1000);

        driver.navigate().to("http://localhost:4200/search");
        Thread.sleep(2000);
        // AuthGuard ile korunan sayfaya erişim denendiğinde kullanıcı tekrar login sayfasına yönlendirilmelidir
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"), "Kullanıcı login sayfasına yönlendirilmedi!");
        Thread.sleep(1000);
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("user1");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("password1");
        driver.findElement(By.cssSelector(".p-button-label")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".logo-div:nth-child(5) > img")).click();
        Thread.sleep(1000);
        driver.navigate().to("http://localhost:4200/search");
        Thread.sleep(2000);
    }

}
