package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogoutTest extends BaseTest {

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
    public void logoutTest() {


        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickOnSignInButton();
        driver.navigate().back();
        loginPage.clickOnDropdownMenu();
        loginPage.clickOnLogoutButton();

        String expectedUrl = "http://zero.webappsecurity.com/index.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        Assert.assertTrue(loginPage.getSignInAgainButton().isDisplayed());


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
