package pl.testeroprogramowaniaiv.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.testeroprogramowaniaiv.utils.DriverFactory;

public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void setUp(){
        DriverFactory.getDriver();

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
