package testpages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitHelper;

public class Homepage_Landing {

    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(css = ".header_cta.button.button--primary")
    WebElement startQuizBtn;

    public Homepage_Landing(WebDriver driver) { // 
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openApplication() {
        System.out.println("Launching Statelymen Application");
    }

    public void clickStartQuiz() {
        System.out.println("Click Start Quiz");

        // WaitHelper use
        WaitHelper waitHelper = new WaitHelper(driver);
        waitHelper.click(startQuizBtn); // ✅ This will now click properly
    }
}
