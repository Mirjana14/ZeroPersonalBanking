package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

public class LoginPageTest extends BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://zero.webappsecurity.com/login.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);


    }
    @Test(priority = 10)

    public void UserCanLoginWithWalidCredantialsTest(){
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickOnSignInButton();
        driver.navigate().back();
        String expectedUrl= "http://zero.webappsecurity.com/index.html";
       Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

    }

    @Test (priority = 20)
    public void UserCannotLoginWithInvalidCredantialTest(){

loginPage.enterInvalidUsername();
loginPage.enterInvalidPassword();
loginPage.clickOnSignInButton();
Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/login.html?login_error=true");
WebElement titleError = driver.findElement(By.cssSelector(".alert.alert-error"));
String actualTitle = titleError.getText();
String expectedTitle = "Login and/or password are wrong.";
Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Test(priority = 30)
    public void UserCanClickonTextboxAndLoginTest(){
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickOnCheckBox();
        Assert.assertTrue(loginPage.getCheckboxButton().isDisplayed());
         loginPage.clickOnSignInButton();
         driver.navigate().back();
         Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/index.html");
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    }



