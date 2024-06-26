package EtiyaCRM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class CustomerRecordsTests extends BaseTest {

    @Before
    public void setUp(){
        accessLoginScreen();
        performLogin("user1","password1");
    }
    @Test
    public void record_list_sorting() throws InterruptedException {
        searchAndClear("firstName", "m");
        search("firstName", "m");
        search("lastName", "b");
    }

    @Test
    public void record_list_limitation() throws InterruptedException {

        search("firstName", "a");

        String[] dropdownOptions = {"pn_id_3_2", "pn_id_3_1", "pn_id_3_0"};

        for (String option : dropdownOptions) {
            clickElement(By.cssSelector(".p-dropdown-trigger-icon"));
            clickElement(By.id(option));
            Thread.sleep(1000);
        }
    }

    @Test
    public void record_list_pagination() throws InterruptedException {
        search("firstName", "m");
        performPagination();
    }

    @Test
    public void clickable_customerID() throws InterruptedException {
        search("firstName", "m");
        clickElement(By.xpath("//a[.='9d9b523b-8a6f-42a1-998c-f42f1db2df63']"));
        Thread.sleep(2000);

    }

    private void search(String field, String value) throws InterruptedException {
        enterText(By.id(field), value);
        clickElement(By.xpath(GlobalConstants.SEARCH_BUTTON_LOCATOR));
        Thread.sleep(2000);
    }

    private void searchAndClear(String field, String value) throws InterruptedException {
        search(field, value);
        clickElement(By.xpath(GlobalConstants.CLEAR_BUTTON_LOCATOR));
    }

    private void performPagination() throws InterruptedException {
        clickElement(By.xpath("//span[contains(.,'10')]"));
        clickElement(By.xpath("//li[@id='pn_id_3_1']/span"));
        navigatePagination();
        selectDropdownOption("pn_id_3_2");
        selectDropdownOption("pn_id_3_3");
    }

    private void navigatePagination() throws InterruptedException {
        By[] paginationSteps = {
                By.cssSelector(".p-paginator-next .p-icon"),
                By.cssSelector(".p-paginator-prev .p-icon"),
                By.cssSelector(".p-paginator-last .p-icon"),
                By.xpath("//div[@id='pn_id_1']/p-paginator/div/button"),
                By.xpath("//div[@id='pn_id_3']/span"),
                By.xpath("//li[@id='pn_id_3_0']/span"),
                By.xpath("//button[contains(.,'2')]"),
                By.xpath("//button[contains(.,'3')]"),
                By.xpath("//button[contains(.,'5')]"),
                By.cssSelector(".p-paginator-prev .p-icon"),
                By.cssSelector(".p-paginator-last .p-icon")
        };

        int waitTime = 2000;

        for (By step : paginationSteps) {
            clickElement(step);
            Thread.sleep(waitTime);
        }
    }

    private void selectDropdownOption(String optionId) throws InterruptedException {
        clickElement(By.xpath("//div[@id='pn_id_3']/div"));
        Thread.sleep(2000);
        clickElement(By.id(optionId));
        Thread.sleep(2000);
    }
}