package testpages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.WaitHelper;

public class Quiz_Till_Email {

    public WebDriver driver;
    public WaitHelper waitHelper;

    // ===========================
    // 🔹 Constructor + PageFactory Init
    // ===========================
    public Quiz_Till_Email(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.waitHelper = new WaitHelper(driver);
    }

    // ===========================
    // 🔹 LOCATORS
    // ===========================

    @FindBy(css = ".next-button.button")
    WebElement startQuizNextBtn;

    @FindBy(xpath = "//*[@id='quiz']/div[2]/div[2]/div[2]/div[3]/div/div/fieldset/div/label[2]")
    WebElement q1Option;

    @FindBy(id = "next-button")
    WebElement nextBtn;

    @FindBy(xpath = "//label[@role='checkbox' and @aria-label='Everyday']")
    WebElement dressingEveryday;

    @FindBy(xpath = "//label[@role='button' and @aria-label='50/50']")
    WebElement dressing5050;

    @FindBy(xpath = "//p[contains(text(),'Mixed')]")
    WebElement workwearMixed;

    @FindBy(xpath = "//p[contains(text(),'Stylish')]")
    WebElement weekendStylish;

    @FindBy(xpath = "//label[@aria-label=\"I'm open to them\"]")
    WebElement printsOpenToThem;

    @FindBy(xpath = "//p[contains(text(),'V-neck')]")
    WebElement avoidVneck;

    @FindBy(xpath = "//p[contains(text(),'True Blues')]")
    WebElement colorTrueBlues;

    @FindBy(xpath = "//p[contains(text(),'Like')]")
    WebElement likeOption;

    @FindBy(xpath = "(//p[@class='label'][normalize-space()='Dislike'])[2]")
    WebElement dislikeOption2;


    // ===========================
    // 🔹 ACTION METHOD
    // ===========================
    public void completeQuizTillEmail() throws InterruptedException {

        System.out.println("Quiz Started");

        waitHelper.click(startQuizNextBtn);

        waitHelper.click(q1Option);
        nextBtn.click();

        dressingEveryday.click();
        dressing5050.click();
        nextBtn.click();

        waitHelper.click(workwearMixed);
        nextBtn.click();

        waitHelper.click(weekendStylish);
        nextBtn.click();
        nextBtn.click();

        waitHelper.click(printsOpenToThem);
        nextBtn.click();

        waitHelper.click(avoidVneck);
        nextBtn.click();

        waitHelper.click(colorTrueBlues);
        nextBtn.click();

        waitHelper.click(likeOption);
        waitHelper.click(dislikeOption2);

        nextBtn.click();
        nextBtn.click();

        System.out.println("Email Section Loading...");
    }
}
