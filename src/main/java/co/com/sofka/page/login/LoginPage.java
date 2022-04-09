package co.com.sofka.page.login;

import co.com.sofka.model.login.LoginModel;
import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends CommonActionOnPages {

    private WebDriver webDriver;


    public LoginPage(WebDriver driver, LoginModel loginModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.loginModel = loginModel;
    }

    public static final Logger LOGGER = Logger.getLogger(LoginPage.class);
    private LoginModel loginModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    //Localizadores Login.

    @CacheLookup
    @FindBy(name = "txtUsername")
    private WebElement txtUsername;

    @CacheLookup
    @FindBy(name = "txtPassword")
    private WebElement txtPassword;

    @CacheLookup
    @FindBy(id = "btnLogin")
    private WebElement submit;

    //Localizadores hacia job title

    @CacheLookup
    @FindBy(className = "firstLevelMenu")
    private WebElement admin;

    @CacheLookup
    @FindBy(xpath = "//a[@id='menu_admin_Job']")
    private WebElement adminJob;

    @CacheLookup
    @FindBy(id = "menu_admin_viewJobTitleList")
    private WebElement viewJobTitleList;

    @CacheLookup
    @FindBy(id = "btnAdd")
    private WebElement btnAdd;

    public void check() throws InterruptedException {

        scrollOn(admin);
        clickOn(admin);

    }

    public void setJob() throws InterruptedException {

        clickOn(adminJob);
        clickOn(viewJobTitleList);
        scrollOn(btnAdd);
        clickOn(btnAdd);

    }

    public void fillLogin() throws InterruptedException {

        loginModel.setUserName("Admin");
        loginModel.setPassword("admin123");

        scrollOn(txtUsername);
        clearOn(txtUsername);
        typeOn(txtUsername, loginModel.getUserName());

        scrollOn(txtPassword);
        clearOn(txtPassword);
        typeOn(txtPassword, loginModel.getPassword());

        doSubmit(submit);
    }
}

