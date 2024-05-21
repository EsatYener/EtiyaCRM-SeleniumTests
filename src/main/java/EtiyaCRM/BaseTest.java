package EtiyaCRM;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    // BeforeEach -> TestCase -> AfterEach
        protected WebDriver driver;
        protected JavascriptExecutor js;
        //protected WebElementActions elementActions;
        protected Map<String, Object> vars;

        public BaseTest() {
            //setUp
            driver = new ChromeDriver();
            js = (JavascriptExecutor) driver;
            vars = new HashMap<>();



            // WebElementActions nesnesini WebDriver ile başlat
            //elementActions = new WebElementActions(driver);

            // Değişkenler haritasını oluştur
            // vars = new HashMap<>();
        }

        @After
        public void tearDown() {
            // WebDriver'ı kapat
            driver.quit();
        }


      /*
        public void waitFor(long milliseconds) {

            try {
                Thread.sleep(milliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        */

        protected void accessLoginScreen() {
            driver.navigate().to("http://localhost:4200/login");
            driver.manage().window().maximize();
        }

        protected void performLogin(String username, String password) {
            enterText(By.id("username"), username);
            enterText(By.id("password"), password);
            clickElement(By.xpath("//button[contains(.,'Login')]"));
        }
        protected void enterText(By locator, String text) {
            WebElement element = driver.findElement(locator);
            element.click();
            element.sendKeys(text);
        }
        protected void clickElement(By locator) {
            driver.findElement(locator).click();
        }

    private void maximizeWindow() {
        driver.manage().window().maximize();
    }




}

