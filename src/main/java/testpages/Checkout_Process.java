package testpages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class Checkout_Process {

    public WebDriver driver;
    public WebDriverWait wait;
    JavascriptExecutor js;

    // ------------- LOCATORS ------------- //

    @FindBy(xpath = "locators_find_console_path")
    WebElement checkoutBtn;

    @FindBy(xpath = "locators_find_console_path")
    WebElement confirmBtn;

    @FindBy(xpath = "locators_find_console_path")
    WebElement upsellContinueBtn;

    // ------------- CONSTRUCTOR ------------- //
    public Checkout_Process(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // ------------- ACTION METHOD ------------- //
    public void completeCheckout() throws InterruptedException {

        // Scroll until Checkout Button becomes clickable
        while (true) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
                break;
            } catch (Exception e) {
                js.executeScript("window.scrollBy(0, 100);");
                Thread.sleep(400);
            }
        }

        // Confirmation button
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn)).click();

        // Upsell page continue button
        wait.until(ExpectedConditions.elementToBeClickable(upsellContinueBtn)).click();

        System.out.println("User successfully reached checkout page.");
    }
}
