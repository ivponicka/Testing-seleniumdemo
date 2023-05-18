package pl.testeroprogramowaniaiv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    @FindBy(id = "reg_email")
    private WebElement registerEmail;
    @FindBy(id = "reg_password")
    private WebElement registerPassword;
    @FindBy(name = "register")
    private WebElement registerButton;

    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private WebElement error;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginbutton;

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage registerUserValidData(String email, String password) {
        registerUser(email, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage registerUserInvalidData(String email, String password) {
        registerUser(email, password);
        return this;
    }

    private void registerUser(String email, String password) {
        registerEmail.sendKeys(email);
        registerPassword.sendKeys(password);
        registerButton.click();
        registerButton.click();
    }

    public LoggedUserPage logInValidData(String username, String password) {
        logIn(username, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage logInInValidData(String username, String password) {
        logIn(username, password);
        return this;
    }

    private void logIn(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginbutton.click();
        loginbutton.click();
    }

    public WebElement getError() {
        return error;
    }
}
