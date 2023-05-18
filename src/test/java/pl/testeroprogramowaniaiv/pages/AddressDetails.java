package pl.testeroprogramowaniaiv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.testeroprogramowaniaiv.Models.Customer;

public class AddressDetails {

    @FindBy(id = "billing_first_name")
    private WebElement firstName;

    @FindBy(id = "billing_last_name")
    private WebElement lastName;

    @FindBy(id = "billing_company")
    private WebElement company;

    @FindBy(id = "billing_country")
    private WebElement country;

    @FindBy(id = "billing_address_1")
    private WebElement houseStreet;

    @FindBy(id = "billing_address_2")
    private WebElement houseStreet2;

    @FindBy(id = "billing_postcode")
    private WebElement postcode;

    @FindBy(id = "billing_city")
    private WebElement city;

    @FindBy(id = "billing_phone")
    private WebElement phone;

    @FindBy(id = "billing_email")
    private WebElement email;

    @FindBy(id = "place_order")
    private WebElement placeOrder;

    private WebDriver driver;

    public AddressDetails(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrderDetailsPage fillAddressDetails(Customer customer) {
        firstName.sendKeys(customer.getFirstName());
        lastName.sendKeys(customer.getLastName());
        company.sendKeys(customer.getCompany());
        houseStreet.sendKeys(customer.getAddress1());
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText(customer.getCountry());
        city.sendKeys(customer.getCity());
        postcode.sendKeys(customer.getZipCode());
        phone.sendKeys(customer.getPhone());
        email.sendKeys(customer.getEmail());
        placeOrder.click();
        return new OrderDetailsPage(driver);
    }

}
