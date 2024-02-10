package Tests;

import Base.BaseTest;
import Pages.FeedbackPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FeedbackPageTest extends BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://zero.webappsecurity.com/login.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        feedBackPage = new FeedbackPage(driver);

    }


    @Test
    public void FAQTestlink() {
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickOnSignInButton();
        driver.navigate().back();
        homePage.clickOnFeedback();
        feedBackPage.clickOnFAQ();

        Assert.assertEquals(driver.getCurrentUrl(),"http://zero.webappsecurity.com/faq.html");




    }
}