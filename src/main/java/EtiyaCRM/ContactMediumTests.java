package EtiyaCRM;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ContactMediumTests extends BaseTest{
    @Before
    public void setUp(){
        accessLoginScreen();
        performLogin("user1","password1");
        driver.get("http://localhost:4200/create/add-contact-medium");

    }

    @Test
    public void successful_ContactMedium_Screen()throws InterruptedException {
        driver.findElement(By.xpath("//input[@type='text']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("erkanq@dnm.com");

        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("5534351187");

        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("3336363");

        driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("534563787423");

        driver.findElement(By.xpath("//button[contains(.,'Create')]")).click();

    }

    @Test
    public void unsuccessful_ContactMedium_Screen()throws InterruptedException {
        //bug açıldı - EAT-5454
        driver.findElement(By.xpath("//input[@type='text']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("deneme@test.com");

        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("0");

        Thread.sleep(2000);
    }
    @Test
    public void empty_req_fields_contactmedium()throws InterruptedException {
      Thread.sleep(2000);
        String[] fields={
                "//input[@type='text']",
                "(//input[@type='text'])[2]"
        };
        for (String field : fields) {
            driver.findElement(By.xpath(field)).click();
            driver.findElement(By.cssSelector(".etiya-contact-medium")).click();
            Thread.sleep(2000);
        }
    }

    @Test
    public void create_ContactMedium()throws InterruptedException {
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("deneme@test.com");
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("05534351187");
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("4443444");
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("123424");

        driver.findElement(By.xpath("//button[contains(.,'Create')]")).click();
        Thread.sleep(2000);
        }
    }

