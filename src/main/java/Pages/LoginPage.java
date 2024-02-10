package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

    WebDriver driver;
  String validUsername ="username";
 String validPassword= "password";
 String invalidUsername= "Mima";
String invalidPassword = "mima1234!";
 public String userMail = "mima@yopmail.com";



    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getLoginField(){
        return driver.findElement(By.id("user_login"));
    }
    public WebElement getPasswordField(){
        return driver.findElement(By.id("user_password"));
    }
    public WebElement getSignInButton(){
        return  driver.findElement((By.name("submit")));
    }
    public WebElement getCheckboxButton() { return driver.findElement(By.id("user_remember_me"));}
    public WebElement getDropdownMenu() {return driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/ul/li[3]/a"));}
    public  WebElement getLogoutButton() { return  driver.findElement(By.id("logout_link"));}
    public WebElement getLinkForgotPassword() { return  driver.findElement(By.linkText("Forgot your password ?"));}
    public WebElement getUserEmail() {return  driver.findElement(By.id("user_email"));}
    public WebElement getButtonSendPassword() {return driver.findElement(By.name("submit"));}
    public WebElement getSignInAgainButton() { return driver.findElement(By.id("signin_button"));}
    public String getForgottenPasswordMessage(){ return driver.findElement(By.className("row")).getText();}



    public void enterUsername() {getLoginField().sendKeys(validUsername);}
    public void enterInvalidUsername() {getLoginField().sendKeys(invalidUsername);}
    public void enterPassword(){
        getPasswordField().sendKeys(validPassword);
    }
    public void enterInvalidPassword(){getPasswordField().sendKeys(invalidPassword);}
    public void clickOnSignInButton(){
        getSignInButton().click();
   }
    public void clickOnCheckBox(){getCheckboxButton().click();}
    public void clickOnDropdownMenu(){getDropdownMenu().click();}
    public void clickOnLogoutButton() {getLogoutButton().click();}
    public void clickOnLinkForgotPassword(){ getLinkForgotPassword().click();}

    public void enterUserMail(){ getUserEmail().sendKeys(userMail);}

    public void clickOnButtonSendPassword(){getButtonSendPassword().click();}








}
