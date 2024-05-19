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
    @Test
    public void access_search_screen()throws InterruptedException {
        driver.navigate().to("http://localhost:4200/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("user1");
        driver.findElement(By.id("password")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("password1");
        driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
        Thread.sleep(5000);
    }

//clear button test
  @Test
  public void clear_button() throws InterruptedException{
      access_search_screen();
      Thread.sleep(3000);
      driver.findElement(By.id("idNumber")).click();
      driver.findElement(By.id("idNumber")).sendKeys("testid123*.-");
      driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();
      Thread.sleep(2000);
      driver.findElement(By.id("firstName")).click();
      driver.findElement(By.id("firstName")).sendKeys("John");
      driver.findElement(By.id("lastName")).click();
      driver.findElement(By.id("lastName")).sendKeys("Doe");
      driver.findElement(By.id("accountNumber")).click();
      driver.findElement(By.id("accountNumber")).sendKeys("test123*#?-");
      driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();
      Thread.sleep(2000);
      driver.findElement(By.id("idNumber")).click();
      driver.findElement(By.id("idNumber")).sendKeys("test12*");
      driver.findElement(By.id("customerId")).click();
      driver.findElement(By.id("customerId")).sendKeys("test123*#");
      driver.findElement(By.id("accountNumber")).click();
      driver.findElement(By.id("accountNumber")).sendKeys("test123&?");
      driver.findElement(By.id("firstName")).click();
      driver.findElement(By.id("firstName")).sendKeys("John");
      driver.findElement(By.id("secondName")).click();
      driver.findElement(By.id("secondName")).sendKeys("Henry");
      driver.findElement(By.id("lastName")).click();
      driver.findElement(By.id("lastName")).sendKeys("Doe");
      driver.findElement(By.id("orderNumber")).click();
      driver.findElement(By.id("orderNumber")).sendKeys("order1*#");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();
      Thread.sleep(2000);
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
        driver.findElement(By.id("secondName")).sendKeys("e");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
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
    public void case_sensitivity() throws InterruptedException{
        access_search_screen();
        Thread.sleep(2000);
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("esat");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();

        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("EsAt");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();

        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("ESAT");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();

        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).sendKeys("yEnER");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();

        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).sendKeys("YENER");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();

        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).sendKeys("yenER");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();

        driver.findElement(By.id("secondName")).click();
        driver.findElement(By.id("secondName")).sendKeys("CAN");
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();

        driver.findElement(By.id("secondName")).click();
        driver.findElement(By.id("secondName")).sendKeys("cAn");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();

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
    public void filter_by_content_2() throws InterruptedException{
    //id ile arama yapma hatalı sonuç veriyor sonra eklenecek
    }



}
