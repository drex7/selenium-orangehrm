package test;

import static org.assertj.core.api.Assertions.assertThat;

import data.UserDataFactory;
import driver.DriverManager;
import model.UserData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.*;
import page.objects.auth.LoginPage;


public class LoginTest extends BaseWeb {

    UserData userData = new UserDataFactory().createUserData();
    String validUsername = "drex_admin";
    LoginPage fillLoginForm(String username, String password) {
        LoginPage loginPage = new LoginPage();

        loginPage.fillUsername(username);
        loginPage.fillPassword(password);
        loginPage.clickLogin();
        return loginPage;
    }

    @Ignore
    @Test(description = "Verify successful login given valid credentials")
    public void login() {
        fillLoginForm(userData.getValidUsername(), userData.getValidPassword());

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 5);
        wait.until(driver -> driver.getCurrentUrl().contains("/dashboard/index"));

        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        assertThat(currentUrl).contains("/dashboard/index");
    }

    @Ignore
    @Test(description = "Failed Login Attempt [Valid `username` and Invalid `password`]")
    public void failedLogin_invalid_password() {
        LoginPage loginPage = fillLoginForm(userData.getValidUsername(), userData.getInvalidPassword());

        // Get the element containing the error message
        WebElement errorAlert = loginPage.errorAlert;
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        wait.until(d -> errorAlert.isDisplayed());
        assertThat(errorAlert.getText()).contains("Invalid credentials");
    }

    @Test(description = "Failed Login Attempt [Invalid `username` and valid `password`]")
    public void failedLogin_invalid_username() {
        LoginPage loginPage = fillLoginForm(userData.getInvalidUsername(), userData.getValidPassword());

        // Get the element containing the error message
        WebElement errorAlert = loginPage.errorAlert;
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        wait.until(d -> errorAlert.isDisplayed());
        assertThat(errorAlert.getText()).contains("Invalid credentials");
    }

    @Test(description = "Failed Login Attempt [Invalid `username` and valid `password`]")
    public void failedLogin_invalid_username_and_password() {
        LoginPage loginPage = fillLoginForm(userData.getInvalidUsername(), userData.getInvalidPassword());

        // Get the element containing the error message
        WebElement errorAlert = loginPage.errorAlert;
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        wait.until(d -> errorAlert.isDisplayed());
        assertThat(errorAlert.getText()).contains("Invalid credentials");
    }

}
