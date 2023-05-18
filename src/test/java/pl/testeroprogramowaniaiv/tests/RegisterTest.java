package pl.testeroprogramowaniaiv.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowaniaiv.pages.HomePage;

import java.util.concurrent.TimeUnit;

public class RegisterTest {
    @Test
    public void registerUserTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://seleniumdemo.com/");
        int random = (int) (Math.random() * 1000);
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData("test" + random + "@test.pl", "Testtddadest123$")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
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
