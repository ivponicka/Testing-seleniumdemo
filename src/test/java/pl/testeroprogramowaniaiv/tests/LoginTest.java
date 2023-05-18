package pl.testeroprogramowaniaiv.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowaniaiv.pages.HomePage;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    @Test
    public void loginTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://seleniumdemo.com/");

        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .logInValidData("test5@test.pl", "test5@test.pl")
                .getDashboardLink();
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void loginWithInvalidPassword() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://seleniumdemo.com/");

        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .logInInValidData("test5@test.pl", "tesddt5@test.pl")
                .getError();

        Assert.assertTrue(error.getText().contains("Incorrect username or password."));

    }
}
