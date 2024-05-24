package EtiyaCRM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

public class UpdateCustomerAddressInfosTests extends BaseTest{
    @Before
    public void setUp(){
        accessLoginScreen();
        performLogin("user1","password1");
        driver.navigate().to("http://localhost:4200/create/address-info");
    }

    @Test
    public void viewButtonAndAddressModal() throws InterruptedException {
        driver.findElement(By.cssSelector(".add-button")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".add-button"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector(".left-side > .inputs:nth-child(1)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector(".form-select"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.cssSelector(".left-side > .inputs:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".form-select")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector(".form-select"));
            dropdown.findElement(By.xpath("//option[. = 'Ankara']")).click();
        }
        driver.findElement(By.cssSelector(".inputs:nth-child(2) > .ng-untouched")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(2) > .ng-untouched")).sendKeys("1");
        driver.findElement(By.cssSelector(".inputs:nth-child(1) > .ng-untouched")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(1) > .ng-untouched")).sendKeys("Bahçelievler");
        driver.findElement(By.cssSelector(".ng-untouched")).click();
        driver.findElement(By.cssSelector(".ng-untouched")).sendKeys("ankara");
        driver.findElement(By.cssSelector(".save-button")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".save-button"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".menu-button")).click();
        driver.findElement(By.cssSelector(".edit-button")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(3) > .ng-untouched")).click();
    }
    @Test
    public void requiredFieldsViewAndSign(){

    }
    @Test
    public void SuccessfullUpdate() {
        driver.findElement(By.cssSelector(".add-button")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".add-button"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".etiya-add-address")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(2) > .ng-untouched")).click();
        driver.findElement(By.cssSelector(".etiya-add-address")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(3) > .ng-untouched")).click();
        driver.findElement(By.cssSelector(".etiya-add-address")).click();
        driver.findElement(By.cssSelector(".ng-untouched")).click();
        driver.findElement(By.cssSelector(".etiya-add-address")).click();
        driver.findElement(By.cssSelector(".form-select")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector(".form-select"));
            dropdown.findElement(By.xpath("//option[. = 'Ankara']")).click();
        }
        driver.findElement(By.cssSelector(".inputs:nth-child(2) > .ng-pristine")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(2) > .ng-touched")).sendKeys("1");
        driver.findElement(By.cssSelector(".inputs:nth-child(3) > .ng-pristine")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(3) > .ng-touched")).sendKeys("chchfh");
        driver.findElement(By.cssSelector(".ng-pristine")).click();
        driver.findElement(By.cssSelector(".right-side .ng-touched")).sendKeys("hfhfh");
        driver.findElement(By.cssSelector(".save-button")).click();
        driver.findElement(By.cssSelector(".menu-button")).click();
        driver.findElement(By.cssSelector(".edit-button")).click();
        driver.findElement(By.cssSelector(".inputs:nth-child(2) > .ng-untouched")).click();
        driver.findElement(By.cssSelector(".etiya-add-address")).click();
        driver.findElement(By.xpath("(//input[@type=\'text\'])[3]")).sendKeys("hgh");
        driver.findElement(By.xpath("(//input[@type=\'text\'])[2]")).click();
        driver.findElement(By.xpath("//form/div")).click();
        driver.findElement(By.xpath("(//input[@type=\'text\'])[2]")).sendKeys("jvjgj");
        driver.findElement(By.xpath("//button[@type=\'submit\']")).click();
    }



}
