package EtiyaCRM;

public class GlobalConstants {
    // Demographic Info Locators
    public static final String FIRST_NAME_LOCATOR = ".inputs:nth-child(1) > .ng-invalid";
    public static final String LAST_NAME_LOCATOR = ".left-side > .inputs:nth-child(2) > .ng-untouched";
    public static final String BIRTH_DATE_LOCATOR = "//input[@type='date']";
    public static final String NATIONAL_ID_LOCATOR = ".inputs:nth-child(4) > .ng-invalid";
    public static final String ETIYA_DEMOGRAPHIC_LOCATOR = ".etiya-demographic";

    // Contact Info Locators
    public static final String EMAIL_LOCATOR = ".inputs:nth-child(1) > .ng-invalid";
    public static final String PHONE_LOCATOR = ".inputs:nth-child(2) > .ng-invalid";

    // Address Locators
    public static final String CITY_DROPDOWN_LOCATOR = ".form-select"; // Assuming same dropdown locator is used
    public static final String STREET_lOCATOR = "(//input[@type='text'])[3]";
    public static final String HOUSE_NUMBER_LOCATOR = ".inputs:nth-child(2) > .ng-untouched";
    public static final String DESCRIPTION_LOCATOR = ".inputs:nth-child(3) > .ng-untouched";

    // Other Locators
    public static final String GENDER_DROPDOWN_LOCATOR = ".form-select";
    public static final String ADD_BUTTON_LOCATOR = ".add-button";
    public static final String SAVE_BUTTON_LOCATOR = ".save-button";
    public static final String NEXT_BUTTON_LOCATOR = ".next-button";
    public static final String CREATE_BUTTON_LOCATOR = ".create-button";
    public static final String BODY_LOCATOR = "body";
    public static final String SEARCH_BUTTON_LOCATOR = "//button[contains(.,'Search')]";
    public static final String CLEAR_BUTTON_LOCATOR = "//button[contains(.,'Clear')]";




}
