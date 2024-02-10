package Base;

import Pages.FeedbackPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PayBillsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;


public class BaseTest {

    public static WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage;
    public PayBillsPage payBillsPage;
    public FeedbackPage feedBackPage;
    public ExcelReader excelReader;



    @BeforeClass

    public void setUp() throws IOException {

        WebDriverManager.chromedriver().setup();
         excelReader = new ExcelReader("TestData.xlsx");



    }


}
