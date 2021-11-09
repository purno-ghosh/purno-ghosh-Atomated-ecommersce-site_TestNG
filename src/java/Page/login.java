package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.naming.InvalidNameException;
import javax.xml.xpath.XPath;
import java.io.InterruptedIOException;

public class login {
    WebDriver driver;

    @FindBy(className = "login")
    WebElement linkLogin;
    @FindBy(id = "email")
    WebElement txtEmail;
    @FindBy(id= "passwd")
    WebElement txtPassword;
    @FindBy (id = "SubmitLogin")
    WebElement btnSubmitLogin;

    @FindBy (xpath = "//li[contains(.,'Authentication failed.')]")
    WebElement lblAuthError;
    @FindBy(xpath ="//span[contains(.,'Test User')]")
    WebElement lblUsername;

    @FindBy(xpath ="//li[contains(.,'Invalid email address.')]")
    WebElement lblemail;

    //li[contains(.,'Invalid email address.')]



    public login(WebDriver driver){

        this.driver= driver;
        PageFactory.initElements(driver,this);

    }
    public String dologin (String email, String password) throws InterruptedException {

        linkLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmitLogin.click();
        return lblUsername.getText();



    }
    public String dologinForNagetiver (String email, String password) throws InterruptedException {

        linkLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmitLogin.click();
        return lblAuthError.getText();
    }

    public String invalEmail (String email, String password) throws InterruptedException {

        linkLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmitLogin.click();
        return lblemail.getText();
    }


}

