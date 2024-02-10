package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PayBillsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PayBillsAddNewPayeeTest extends BaseTest {

    WebDriver driver;



    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://zero.webappsecurity.com/login.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);

        loginPage = new LoginPage(driver);
        payBillsPage = new PayBillsPage(driver);

    }

    @Test
    public void addNewPayeeTest() {
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickOnSignInButton();
        driver.navigate().back();
        homePage.clickOnOnlineBanking();
        payBillsPage.clickOnPayBills();
        payBillsPage.clickOnAddNewPayee();

        String payeeName = excelReader.getStringData ("AddNewPayee", 1,0);
        String payeeAddress = excelReader.getStringData("AddNewPayee", 1,1);
        String account = excelReader.getStringData("AddNewPayee", 1,2);
        String payeeDetalis = excelReader.getStringData("AddNewPayee", 1,3);
        payBillsPage.inputPayeeName(payeeName);
        payBillsPage.inputPayeeAddress(payeeAddress);
        payBillsPage.inputAccount(account);
        payBillsPage.inputPayeeDetalis(payeeDetalis);
        payBillsPage.clickOnAddButton();
        Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/bank/pay-bills.html");


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}