package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PayBillsPage {

    WebDriver driver;
    String amount = "783";


    public PayBillsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPayBills() {
        return driver.findElement(By.id("pay_bills_link"));
    }
    public WebElement getdropdownElement() {return driver.findElement(By.id("sp_payee"));}
    public WebElement getDropdown1() {return  driver.findElement(By.id("sp_account"));}
    public WebElement getAmount() {return  driver.findElement(By.id("sp_amount"));}
    public WebElement getCalendarField() {return driver.findElement(By.id("sp_date"));}
    public WebElement getTheDate() { return driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[3]/td[4]/a"));}
    public WebElement getDescription() { return driver.findElement(By.id("sp_description"));}
    public WebElement getPayButton() {return  driver.findElement(By.id("pay_saved_payees"));}
    public String getPaymentConfirmationMessage(){ return driver.findElement(By.id("alert_content")).getText();}
    public WebElement getAddNewPayee(){return  driver.findElement(By.linkText("Add New Payee"));}
    public WebElement getPayeeName(){return driver.findElement(By.id("np_new_payee_name"));}
    public WebElement getPayeeDetalis() {return driver.findElement(By.id("np_new_payee_details"));}
    public WebElement getPayeeAddress() { return driver.findElement(By.id("np_new_payee_address"));}
    public WebElement getAccount(){return driver.findElement(By.id("np_new_payee_account"));}
    public WebElement getAddButton() {return driver.findElement(By.id("add_new_payee"));}




    public void clickOnPayBills() {
        getPayBills().click();
    }
    public void enterAmount(){ getAmount().sendKeys(amount);}
    public void clickOnCalendarField() {getCalendarField().click();}
    public void clickOnDate() { getTheDate().click();}
    public void enterDescription1(){getDescription().sendKeys("installment for the apartment");}
    public void clickOnPayButton() {getPayButton().click();}
    public void clickOnAddNewPayee() {getAddNewPayee().click();}
    public void inputPayeeName(String payeeName){getPayeeName().sendKeys(payeeName);}
    public void inputPayeeAddress(String payeeAddress){ getPayeeAddress().sendKeys(payeeAddress);}
    public void inputAccount(String account) {getAccount().sendKeys(account);}
    public void inputPayeeDetalis(String payeeDetalis) {getPayeeDetalis().sendKeys(payeeDetalis);}
    public void clickOnAddButton() {getAddButton().click();}
}

