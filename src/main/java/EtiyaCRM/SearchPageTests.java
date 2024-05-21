package EtiyaCRM;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

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

    //access search screen and visibility fields
    public void access_search_screen() throws InterruptedException {
        navigateToLogin();
        maximizeWindow();
        performLogin("user1", "password1");
    }

    private void navigateToLogin() {
        driver.navigate().to("http://localhost:4200/login");
    }

    private void maximizeWindow() {
        driver.manage().window().maximize();
    }

    private void performLogin(String username, String password) throws InterruptedException {
        enterText(By.id("username"), username);
        enterText(By.id("password"), password);
        clickElement(By.xpath("//button[contains(.,'Login')]"));
        Thread.sleep(2000);
    }

    private void enterText(By locator, String text) throws InterruptedException {
        WebElement element = driver.findElement(locator);
        element.click();
        Thread.sleep(500); // Bekleme süresi, kullanıcı etkileşimini simüle etmek için
        element.sendKeys(text);
    }

    private void clickElement(By locator) throws InterruptedException {
        driver.findElement(locator).click();
        Thread.sleep(2000);
    }


    //clear button test

  @Test
  public void clear_button() throws InterruptedException {
      access_search_screen();
      Thread.sleep(3000);


      String[][] testData = {
              {"idNumber", "testid123*.-"},
              {"firstName", "John"},
              {"lastName", "Doe"},
              {"accountNumber", "test123*#?-"},
              {"idNumber", "test12*"},
              {"customerId", "test123*#"},
              {"accountNumber", "test123&?"},
              {"firstName", "John"},
              {"secondName", "Henry"},
              {"lastName", "Doe"},
              {"orderNumber", "order1*#"}
      };

      for (String[] data : testData) {
          driver.findElement(By.id(data[0])).click();
          driver.findElement(By.id(data[0])).sendKeys(data[1]);
      }

      int clearButtonClicks = 3; // Kaç kez Clear butonuna tıklanacağını belirtiyoruz.
      for (int i = 0; i < clearButtonClicks; i++) {
          driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();
          Thread.sleep(2000);
      }
  }

  //search button test
    @Test
    public void search_button() throws InterruptedException{
        access_search_screen();
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("esat");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();
        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).sendKeys("yener");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();
        driver.findElement(By.id("secondName")).click();
        driver.findElement(By.id("secondName")).sendKeys("a");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();
        driver.findElement(By.id("idNumber")).click();
        driver.findElement(By.id("idNumber")).sendKeys("13");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();
        driver.findElement(By.id("customerId")).click();
        driver.findElement(By.id("idNumber")).click();

        driver.findElement(By.id("idNumber")).sendKeys("9");
        driver.findElement(By.id("customerId")).sendKeys("333c");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(2000);
    }

    //successful textbox ve unsuccessful  textbox testleri manuel gösterilebilir


    //no matching customer record test
    @Test
    public void no_matching_customer_record() throws InterruptedException {
        access_search_screen();
        Thread.sleep(2000);
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("nonexist");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();

        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("Ece");
        driver.findElement(By.id("idNumber")).click();
        driver.findElement(By.id("idNumber")).sendKeys("99999999999"); //nationalityid
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(.,'Create Customer')]")).click();
        Thread.sleep(2000);

    }

    //case sensitivity test
    @Test
    public void case_sensitivity() throws InterruptedException {
        String[] firstNames = {"esat", "EsAt", "ESAT"};
        String[] lastNames = {"yEnER", "YENER", "yenER"};

        access_search_screen();

        for (String firstName : firstNames) {
            driver.findElement(By.id("firstName")).click();
            driver.findElement(By.id("firstName")).sendKeys(firstName);
            driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();
        }

        for (String lastName : lastNames) {
            driver.findElement(By.id("lastName")).click();
            driver.findElement(By.id("lastName")).sendKeys(lastName);
            driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();
        }

        Thread.sleep(2000);
    }


//filter by content tests
    @Test
    public void filter_by_content() throws InterruptedException {
        access_search_screen();
        Thread.sleep(3000);
        //firstname ile
        WebElement firstName = driver.findElement(By.id("firstName"));
        driver.findElement(By.id("firstName")).click();
        firstName.sendKeys("John");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(3000);
        firstName.clear(); //driver.findElement(By.xpath("//button[contains(.,\'Clear\')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("firstName")).click();
        firstName.sendKeys("Jo");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(3000);
        firstName.clear();
        Thread.sleep(3000);
        driver.findElement(By.id("firstName")).click();
        firstName.sendKeys("o");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(3000);
        firstName.clear();
        Thread.sleep(3000);
        driver.findElement(By.id("firstName")).click();
        firstName.sendKeys("J");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(2000);
        firstName.clear();
        firstName.sendKeys("hn");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(2000);
        firstName.clear();
        firstName.sendKeys("ohn");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(2000);
     /*
        //second name ve last name için ekstra
        WebElement secondName = driver.findElement(By.id("secondName"));
        driver.findElement(By.id("secondName")).click();
        secondName.sendKeys("eren");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(3000);
        secondName.clear();
        Thread.sleep(3000);

        driver.findElement(By.id("secondName")).click();
        secondName.sendKeys("re");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(3000);
        secondName.clear();
        Thread.sleep(3000);

        driver.findElement(By.id("secondName")).click();
        secondName.sendKeys("en");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(3000);
        secondName.clear();
        Thread.sleep(3000);
        driver.findElement(By.id("secondName")).click();
        secondName.sendKeys("eR");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(3000);
        secondName.clear();
        Thread.sleep(3000);  */

 }

    //Customer ID, ID number, Order Number, Account Number ile arama
    // (Order Number, Account Number ile arama yapma sayfalar gelince eklenecek)
    @Test
    public void filter_by_content_2() throws InterruptedException{

        access_search_screen();
        driver.findElement(By.id("customerId")).click();
        driver.findElement(By.id("customerId")).sendKeys("33c");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();

        driver.findElement(By.id("idNumber")).click();
        driver.findElement(By.id("idNumber")).sendKeys("91");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();
        driver.findElement(By.id("idNumber")).click();
        driver.findElement(By.id("idNumber")).sendKeys("914");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();
        driver.findElement(By.id("idNumber")).click();
        driver.findElement(By.id("idNumber")).sendKeys("91");
        driver.findElement(By.id("customerId")).click();
        driver.findElement(By.id("customerId")).sendKeys("7ad");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(5000);

    }



}
