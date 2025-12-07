package testpages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class Email_To_PlanSelection {

    public WebDriver driver;
    public WebDriverWait wait;

    // ---------------- LOCATORS ---------------- //
    
    @FindBy(xpath = "locators_find_console_path")
    WebElement messageBox;

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailBox;

    @FindBy(id = "next-button")
    WebElement nextBtn;

    @FindBy(xpath = "//h3[contains(text(),'LUXE')]")
    WebElement luxePlan;

    // ---------------- CONSTRUCTOR ---------------- //
    public Email_To_PlanSelection(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ---------------- ACTION METHOD ---------------- //
    public void enterEmailTillPlan() {

        wait.until(ExpectedConditions.elementToBeClickable(messageBox)).sendKeys("No thanks");

        emailBox.sendKeys("amaantyagi007a@gmail.com");

        nextBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(luxePlan)).click();
    }
}
