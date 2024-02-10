package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ForgotPasswordTest extends BaseTest {
    WebDriver driver;


    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://zero.webappsecurity.com/login.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
    }

    @Test
    public void forgotPasswordTest() {
        loginPage.clickOnLinkForgotPassword();
        loginPage.enterUserMail();
        loginPage.clickOnButtonSendPassword();

        Assert.assertEquals(loginPage.getForgottenPasswordMessage(), "Forgotten Password\nYour password will be sent to the following email: " + loginPage.userMail);
    }


}