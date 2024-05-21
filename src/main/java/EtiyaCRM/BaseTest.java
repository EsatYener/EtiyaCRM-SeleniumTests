package EtiyaCRM;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    // BeforeEach -> TestCase -> AfterEach
        protected WebDriver driver;
        //protected WebElementActions elementActions;
        protected Map<String, Object> vars;

        public BaseTest() {
            //setUp
            driver = new ChromeDriver();

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



        public void login(String username, String password) throws InterruptedException {
            // kullanımı:  login("user1", "password1");
            driver.navigate().to("http://localhost:4200/login");
            driver.manage().window().maximize();

            WebElement usernameInput = driver.findElement(By.id("username"));
            usernameInput.click();
            usernameInput.sendKeys(username);

            WebElement passwordInput = driver.findElement(By.id("password"));
            passwordInput.click();
            //waitFor(2000);
            passwordInput.sendKeys(password);
            driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
            Thread.sleep(2000);
        }
}

