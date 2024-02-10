package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PayBillsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class PayBillsTest extends BaseTest {

    WebDriver driver;
   // String date;
   String paymentConfirmationMessage = "The payment was successfully submitted.";

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://zero.webappsecurity.com/login.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);

        loginPage = new LoginPage(driver);
        payBillsPage= new PayBillsPage(driver);
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickOnSignInButton();
        driver.navigate().back();
        homePage.clickOnOnlineBanking();
        payBillsPage.clickOnPayBills();

    }

    @Test(priority = 10)
    public void happyPathPaySavedPayeeTest() /*throws Exception*/{


        Assert.assertEquals(driver.getCurrentUrl(),"http://zero.webappsecurity.com/bank/pay-bills.html");

        Select dropdown = new Select(payBillsPage.getdropdownElement());
        String option ="apple";
        dropdown.selectByValue(option);

        List<WebElement> selectedOptions = dropdown.getAllSelectedOptions();

        //provera da li je samo jedna opcija selektovana iz liste
        Assert.assertEquals(selectedOptions.size(), 1);
          //provera da li je selektovana odredjena opcija
        Assert.assertEquals(selectedOptions.get(0).getAttribute("value"), option);

        Select dropdown1 = new Select(payBillsPage.getDropdown1());
        String option1 = "5";
        dropdown1.selectByValue(option1);
        List<WebElement> selectedOptions1 = dropdown1.getAllSelectedOptions();
        Assert.assertEquals(selectedOptions1.size(), 1);
        Assert.assertEquals(selectedOptions.get(0).getAttribute("value"), option);

        payBillsPage.enterAmount();
        payBillsPage.clickOnCalendarField();
        payBillsPage.clickOnDate();
        payBillsPage.enterDescription1();
        payBillsPage.clickOnPayButton();

        Assert.assertFalse(paymentConfirmationMessage.isBlank());
        Assert.assertEquals(payBillsPage.getPaymentConfirmationMessage(),paymentConfirmationMessage);


       /* date="2024-02-05";

        SimpleDateFormat targetDateFormat= new SimpleDateFormat("yyyy-MM-dd");
        Date formattedTargetDate = targetDateFormat.parse(date);
        try {
            targetDateFormat.setLenient(false);
            formattedTargetDate= targetDateFormat.parse(date);
            System.out.println(formattedTargetDate);
        } catch (Exception e) {
            throw new Exception("Invalid date is provided, please check input date");
        }

        */


    }

    @Test(priority = 20)
    public void userMissedOneField(){

        Assert.assertEquals(driver.getCurrentUrl(),"http://zero.webappsecurity.com/bank/pay-bills.html");

        Select dropdown = new Select(payBillsPage.getdropdownElement());
        String option ="apple";
        dropdown.selectByValue(option);
        List<WebElement> selectedOptions = dropdown.getAllSelectedOptions();
        Select dropdown1 = new Select(payBillsPage.getDropdown1());
        String option1 = "5";
        dropdown1.selectByValue(option1);
        List<WebElement> selectedOptions1 = dropdown1.getAllSelectedOptions();
        Assert.assertEquals(selectedOptions1.size(), 1);
        Assert.assertEquals(selectedOptions.get(0).getAttribute("value"), option);

        payBillsPage.enterAmount();
        payBillsPage.enterDescription1();
        payBillsPage.clickOnPayButton();
        Assert.assertFalse(paymentConfirmationMessage.isBlank());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
