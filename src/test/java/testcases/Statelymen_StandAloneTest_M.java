package testcases;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class Statelymen_StandAloneTest_M {

    public static void main(String[] args) throws InterruptedException {

        // ---------------------------
        // Setup WebDriver
        // ---------------------------
        System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ---------------------------
        // Open website
        // ---------------------------
        driver.get("https://statelymen.com/");

        // START QUIZ
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".header_cta.button.button--primary"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".next-button.button"))).click();

        // ---------------------------
        // Question: Fit Type
        // ---------------------------
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[2]/div[3]/div/div/fieldset/div/label[2]"))).click();

        driver.findElement(By.id("next-button")).click();

        // ---------------------------
        // Question: Everyday Wear
        // ---------------------------
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[@role='checkbox' and @aria-label='Everyday']"))).click();

        driver.findElement(By.xpath("//label[@role='button' and @aria-label='50/50']")).click();
        driver.findElement(By.id("next-button")).click();

        // ---------------------------
        // Question: Style Mix
        // ---------------------------
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Mixed')]"))).click();
        driver.findElement(By.id("next-button")).click();

        // ---------------------------
        // Question: Style Preference
        // ---------------------------
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Stylish')]"))).click();
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("next-button")).click();

        // ---------------------------
        // Question: Patterns
        // ---------------------------
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[@aria-label=\"I'm open to them\"]"))).click();

        driver.findElement(By.id("next-button")).click();

        // ---------------------------
        // Question: Neck Type
        // ---------------------------
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'V-neck')]"))).click();
        driver.findElement(By.id("next-button")).click();

        // ---------------------------
        // Question: Color Preference
        // ---------------------------
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'True Blues')]"))).click();
        driver.findElement(By.id("next-button")).click();

        // ---------------------------
        // Question: Like / Dislike Slides
        // ---------------------------
        clickLikeDislikeSlides(driver, wait);

        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("next-button")).click();

        // ---------------------------
        // Question: Fit
        // ---------------------------
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Slim')]"))).click();
        driver.findElement(By.id("next-button")).click();

        // ---------------------------
        // Height and Weight
        // ---------------------------
        new Select(wait.until(ExpectedConditions.elementToBeClickable(
                By.id("question_32-feet")))).selectByValue("5'");

        new Select(driver.findElement(By.id("question_32-inches"))).selectByValue("10\"");
        new Select(driver.findElement(By.id("question_33"))).selectByValue("150");

        driver.findElement(By.id("next-button")).click();

        // ---------------------------
        // Body Shape
        // ---------------------------
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[14]/div[2]/div/div[1]/div/label[2]/div/div"))).click();

        driver.findElement(By.xpath(
                "//*[@id=\"quiz\"]/div[2]/div[2]/div[14]/div[2]/div/div[2]/fieldset/div[2]/label[3]")).click();

        driver.findElement(By.id("next-button")).click();

        // ---------------------------
        // Additional Body Preferences
        // ---------------------------
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[15]/div[2]/div/div[1]/div/label[2]/div/div"))).click();

        driver.findElement(By.xpath(
                "//*[@id=\"quiz\"]/div[2]/div[2]/div[15]/div[2]/div/div[2]/fieldset/div[2]/label[4]")).click();

        driver.findElement(By.xpath(
                "//*[@id=\"quiz\"]/div[2]/div[2]/div[15]/div[2]/div/div[3]/fieldset/div[2]/label[2]")).click();

        driver.findElement(By.id("next-button")).click();

        // ---------------------------
        // Fit Question
        // ---------------------------
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[16]/div[3]/div/div[2]/fieldset/div[2]/label[4]"))).click();

        driver.findElement(By.id("next-button")).click();

        // ---------------------------
        // Last textbox + email
        // ---------------------------
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[17]/div/div/div/label[1]/textarea")))
                .sendKeys("No thanks");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@type='email']")))
                .sendKeys("amaantyagi007a@gmail.com");

        driver.findElement(By.id("next-button")).click();

        // ---------------------------
        // Plan Selection
        // ---------------------------
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h3[contains(text(),'LUXE')]"))).click();

        // ---------------------------
        // SCROLL UNTIL CHECKOUT BUTTON APPEARS
        // ---------------------------
        scrollUntilCheckoutAndClick(driver, wait);

        // ---------------------------
        // Continue to next pages
        // ---------------------------
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"csm-wrapper\"]/div/div/div[2]/button"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"plan-upsell\"]/div[2]/div[4]/button"))).click();

        System.out.println("\n=== Test Finished Successfully ===");
    }

    // *********************************************************************
    // Helper method to click Like/Dislike slides
    // *********************************************************************
    private static void clickLikeDislikeSlides(WebDriver driver, WebDriverWait wait) {
        String[] likeXpaths = {
            "//p[contains(text(),'Like')]",
            "(//p[@class='label'][normalize-space()='Dislike'])[2]",
            "//div[@aria-label='Slide 3 of 12']//p[contains(text(),'Like')]",
            "//div[@aria-label='Slide 4 of 12']//p[contains(text(),'Like')]",
            "//div[@aria-label='Slide 5 of 12']//p[contains(text(),'Dislike')]",
            "//div[@aria-label='Slide 6 of 12']//p[contains(text(),'Dislike')]",
            "//div[@aria-label='Slide 7 of 12']//p[contains(text(),'Dislike')]",
            "//div[@aria-label='Slide 8 of 12']//p[contains(text(),'Dislike')]",
            "//div[@aria-label='Slide 9 of 12']//p[contains(text(),'Dislike')]",
            "//div[@aria-label='Slide 10 of 12']//p[contains(text(),'Dislike')]",
            "//div[@aria-label='Slide 11 of 12']//p[contains(text(),'Dislike')]",
            "//div[@aria-label='Slide 12 of 12']//p[contains(text(),'Dislike')]"
        };

        for (String xp : likeXpaths) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xp))).click();
        }
    }

    // *********************************************************************
    // Scroll until checkout button appears
    // *********************************************************************
    private static void scrollUntilCheckoutAndClick(WebDriver driver, WebDriverWait wait) throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        By checkoutButton = By.id("checkout-button");

        while (true) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
                break;
            } catch (Exception e) {
                js.executeScript("window.scrollBy(0, 300);");
                Thread.sleep(400);
            }
        }
    }
}
