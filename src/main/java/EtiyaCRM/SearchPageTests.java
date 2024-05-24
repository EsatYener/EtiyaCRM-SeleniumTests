package EtiyaCRM;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class SearchPageTests extends BaseTest{

    @Before
    public void setUp(){
        accessLoginScreen();
        performLogin("user1","password1");
    }

    //access search screen and visibility fields

    private void performSearchAndClear(String fieldId, String value) throws InterruptedException {
        WebElement element = driver.findElement(By.id(fieldId));
        element.click();
        element.sendKeys(value);
        driver.findElement(By.xpath(GlobalConstants.SEARCH_BUTTON_LOCATOR)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(GlobalConstants.CLEAR_BUTTON_LOCATOR)).click();
    }
    private void performSearch(String fieldId, String value) throws InterruptedException {
        WebElement element = driver.findElement(By.id(fieldId));
        element.click();
        element.sendKeys(value);
        driver.findElement(By.xpath(GlobalConstants.CLEAR_BUTTON_LOCATOR)).click();
        Thread.sleep(1000);
    }

    //clear button test

  @Test
  public void clear_button() throws InterruptedException {

      Thread.sleep(1000);

      // Test verileri ve ilgili alanların id'leri
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

      for (int i = 0; i < testData.length; i++) {
          driver.findElement(By.id(testData[i][0])).click();
          driver.findElement(By.id(testData[i][0])).sendKeys(testData[i][1]);
          Thread.sleep(500);
          if (i == 2 || i == 5 || i == 6 || i == 9 || i == testData.length - 1) {
              driver.findElement(By.xpath("//button[contains(.,'Clear')]")).click();
              Thread.sleep(2000);
          }
      }
  }

  //search button test
  @Test
  public void search_button() throws InterruptedException {


      String[][] testData = {
              {"firstName", "melodi"},
              {"lastName", "bayraktar"},
              {"secondName", "b"},
              {"customerId", "9d9b"}
      };

      for (String[] data : testData) {
          driver.findElement(By.id(data[0])).click();
          driver.findElement(By.id(data[0])).sendKeys(data[1]);
          Thread.sleep(2000);
          driver.findElement(By.xpath(GlobalConstants.SEARCH_BUTTON_LOCATOR)).click();
          Thread.sleep(2000);
          driver.findElement(By.xpath(GlobalConstants.CLEAR_BUTTON_LOCATOR)).click();
      }
  }


    //successful textbox ve unsuccessful  textbox testleri manuel gösterilebilir

    //no matching customer record test
    @Test
    public void no_matching_customer_record() throws InterruptedException {

        Thread.sleep(1000);

        performSearchAndClear("firstName", "esat");

        performSearch("firstName", "nonexist");

        driver.findElement(By.xpath("//button[contains(.,'Create Customer')]")).click();
        Thread.sleep(2000);

    }

    //case sensitivity test

    @Test
    public void case_sensitivity() throws InterruptedException {

        String[] firstNames = {"esat", "EsAt", "ESAT"};
        String[] lastNames = {"yEnER", "YENER", "yenER"};



        for (String firstName : firstNames) {
            performSearchAndClear("firstName", firstName);
        }

        // Soyisimler için arama ve temizleme işlemleri
        for (String lastName : lastNames) {
            performSearchAndClear("lastName", lastName);
        }

        Thread.sleep(1000);
    }


//filter by content tests
@Test
public void filter_by_content() throws InterruptedException {



    Thread.sleep(1000);

    String[] firstNames = {"Esat", "Es", "s", "E", "sa", "sat"};

    String[] lastNames = {"yener", "yen", "er", "En"};

    String[] customerIds = {"33c", "7ad"};

    String[] idNumbers = {"91", "914"};

    for (String firstName : firstNames) {
        performSearchAndClear("firstName", firstName);
    }

    for (String lastName : lastNames) {
        performSearchAndClear("lastName", lastName);
    }

    for (String customerId : customerIds) {
        performSearchAndClear("customerId", customerId);
    }

    for (String idNumber : idNumbers) {
        performSearchAndClear("idNumber", idNumber);
    }
}

    // (Order Number, Account Number ile arama yapma sayfalar gelince eklenecek)


}
