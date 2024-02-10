package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FeedbackPage {

    WebDriver driver;

    public FeedbackPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFAQ() {return driver.findElement(By.id("faq-link"));}
    public void clickOnFAQ(){ getFAQ().click();}




}
