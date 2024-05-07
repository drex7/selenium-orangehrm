package page.objects.Profile;

import driver.annotations.FindByDataTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.AbstractPageObject;

public class PersonalDetailsPage {

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "middleName")
    private WebElement middleName;

//    @FindByDataTest("password")
    @FindBy(name = "lastName")
    private WebElement lastName;

    //    @FindBy(css = ".orangehrm-login-button")
//    @FindByDataTest("login-btn")
    @FindBy(css = "[data-test='login-btn']")
    private WebElement loginBtn;



    //    @FindBy(css = ".oxd-alert-content-text")
    @FindBy(css = "[data-test='error-alert'] p")
    public WebElement errorAlert;

    public void fillUsername(String username) {
        this.username.sendKeys(username);
    }

    public void fillPassword(String password) {
        this.password.sendKeys(password);
    }
    public void clickLogin() {
        System.out.println(this.username.toString());
        this.loginBtn.click();
    }

    public String errorMessage() {
        return this.errorAlert.getText();
    }

}
