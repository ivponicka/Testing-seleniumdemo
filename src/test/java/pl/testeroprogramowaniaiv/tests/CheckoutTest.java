package pl.testeroprogramowaniaiv.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowaniaiv.Models.Customer;
import pl.testeroprogramowaniaiv.pages.HomePage;

import java.util.concurrent.TimeUnit;

public class CheckoutTest {
    @Test
    public void checkoutTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://seleniumdemo.com/");

        Customer customer = new Customer();

        new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer);


    }

    @Test
    public void registerUserWithTheSameEmailTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://seleniumdemo.com/");

        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .registerUserInvalidData("test5@test.pl", "test5@test.pl")
                .getError();

        Assert.assertTrue(error.getText().contains("An account is already registered with your email address. Please log in."));

    }
}
