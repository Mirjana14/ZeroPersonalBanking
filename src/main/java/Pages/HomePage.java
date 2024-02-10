package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getOnlineBanking() { return driver.findElement(By.id("onlineBankingMenu"));}

    public void clickOnOnlineBanking() { getOnlineBanking().click(); }
    public WebElement getFeedback() { return driver.findElement(By.id("feedback"));}
    public void clickOnFeedback() { getFeedback().click();}
    public WebElement getButtonMoreServices(){ return driver.findElement(By.id("online-banking"));}
    public void clickOnButtonMoreServices() {getButtonMoreServices().click();}
    public WebElement getFirstLink(){return driver.findElement(By.id("account_activity_link"));}
    public void clickOnFirstLink() {getFirstLink().click();}
    public WebElement getSecondLink(){return driver.findElement(By.id("transfer_funds_link"));}
    public void clickOnSecondLink() {getSecondLink().click();}
    public WebElement getThirdLink(){return driver.findElement(By.id("money_map_link"));}
    public void clickOnThirdLink() {getThirdLink().click();}
    public WebElement getZeroBankButton(){return driver.findElement(By.linkText("Zero Bank"));}
    public void clickOnZeroBankButton() {getZeroBankButton().click();}

    public WebElement getSearchbox(){return driver.findElement(By.id("searchTerm"));}
    public void clickOnSearchbox(){getSearchbox().click();}
    public void enterInSearchbox() {getSearchbox().sendKeys("banking");}
    public void selectEnter() {getSearchbox().sendKeys(ENTER);}









}
