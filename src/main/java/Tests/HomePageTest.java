package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest extends BaseTest {

    WebDriver driver;
    JavascriptExecutor js;



    @BeforeMethod

    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://zero.webappsecurity.com/login.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage=new HomePage(driver);
        js=(JavascriptExecutor) driver;
        loginPage = new LoginPage(driver);
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickOnSignInButton();
        driver.navigate().back();

    }

    @Test (priority = 10)
    public void clickOnSearchboxHomePageTest() {

        homePage.clickOnSearchbox();
        Assert.assertTrue(homePage.getSearchbox().isDisplayed());
        homePage.enterInSearchbox();

        homePage.selectEnter();
        Assert.assertTrue(homePage.getSearchbox().isEnabled());
        driver.navigate().back();
    }

        @Test(priority = 20)
        public void clickOnLinksOnHomePageTest() {

            homePage.clickOnOnlineBanking();
            Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/online-banking.html");
            driver.navigate().back();

            homePage.clickOnFeedback();
            Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/feedback.html");
            driver.navigate().back();
            js.executeScript("window.scrollBy(0,1000);");
            homePage.clickOnButtonMoreServices();
            Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/online-banking.html");
            homePage.clickOnFirstLink();
            Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/bank/account-activity.html");
            driver.navigate().back();
            homePage.clickOnSecondLink();
            Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/bank/transfer-funds.html");
            driver.navigate().back();
            homePage.clickOnThirdLink();
            Assert.assertEquals(driver.getCurrentUrl(),"http://zero.webappsecurity.com/bank/money-map.html");


        }
    }
