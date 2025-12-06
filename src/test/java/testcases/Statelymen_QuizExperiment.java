//package testcases;
//
//import java.time.Duration;
//import java.util.List;
//import java.util.function.Function;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.ElementClickInterceptedException;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
///**
// * Single-file, PageFactory based, highly-dynamic Selenium program for the Statelymen quiz flow.
// *
// * - All locators at top inside inner PageElements class (PageFactory)
// * - Rich helper methods (safeClick, safeSendKeys, scroll helpers, retry loops)
// * - Step-by-step comments before each major action
// * - The file is intentionally large with many utility methods to make it reusable and readable
// *
// * Save this class as: Statelymen_QuizExperiment_Long.java
// */
//public class Statelymen_QuizExperiment {
//
//    // ---------- Configuration constants ----------
//    private static final String CHROME_DRIVER_PATH = "C:/driver/chromedriver.exe"; // <-- adjust path
//    private static final String APPLICATION_URL = "https://statelymen.com/";
//    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(15);
//    private static final Duration POLLING_INTERVAL = Duration.ofMillis(300);
//    private static final int SCROLL_STEP_PIXELS = 1000;
//    private static final int SCROLL_STEP_PIXELS_SMALL = 100;
//    private static final int MAX_SCROLL_ATTEMPTS = 60; // safety to avoid infinite loops
//    private static final long THREAD_SLEEP_AFTER_SCROLL_MS = 400;
//
//    // ---------- Main entry point ----------
//    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Starting Statelymen standalone test (single file, PageFactory).");
//
//        // Set Chrome driver system property
//        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
//
//        // Create WebDriver instance
//        WebDriver driver = new ChromeDriver();
//
//        try {
//            // Define timeouts and window state
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//            driver.manage().window().maximize();
//
//            // Navigate to application URL
//            driver.get(APPLICATION_URL);
//
//            // Initialize PageFactory elements (locators are grouped in PageElements)
//            PageElements page = new PageElements(driver);
//
//            // Create helper/utility wrapper for interactions
//            SeleniumHelper helper = new SeleniumHelper(driver, DEFAULT_TIMEOUT);
//
//            // ---------- FLOW: Start Quiz ----------
//            // Wait for and click primary "Start Quiz" CTA in the header
//            helper.waitForElementToBeClickableAndClick(page.headerStartQuiz, "Header Start Quiz CTA");
//
//            // Wait for the 'next' button and click to move into the quiz
//            helper.waitForElementToBeClickableAndClick(page.nextButton, "Quiz Next Button (initial)");
//
//            // ---------- FLOW: Questions (selection + next) ----------
//            // Example: "What’s got you most excited to try Stately?"
//            helper.waitForElementToBeClickableAndClick(page.questionWhatsExcitedOption2,
//                    "What's got you most excited - option 2");
//            helper.safeClick(page.nextButton, "Next after 'What's got you most excited'");
//
//            // Example: "What Are You Dressing For?" -> Everyday
//            helper.waitForElementToBeClickableAndClick(page.qDressingForEveryday, "Dressing For - Everyday");
//            helper.safeClick(page.qWeekendWork5050, "More Weekend or Work Looks - 50/50");
//            helper.safeClick(page.nextButton, "Next after dressing preference");
//
//            // Workwear preference -> Mixed
//            helper.waitForElementToBeClickableAndClick(page.qWorkwearMixed, "Workwear - Mixed");
//            helper.safeClick(page.nextButton, "Next after workwear");
//
//            // Weekend looks -> Stylish
//            helper.waitForElementToBeClickableAndClick(page.qWeekendStylish, "Weekend Looks - Stylish");
//            helper.safeClick(page.nextButton, "Next after weekend looks");
//
//            // Click next again to progress to print question
//            helper.safeClick(page.nextButton, "Next to results stage");
//
//            // Print preferences
//            helper.waitForElementToBeClickableAndClick(page.qPrintsOpenToThem, "Prints - I'm open to them");
//            helper.safeClick(page.nextButton, "Next after prints");
//
//            // Any pieces to avoid?
//            helper.waitForElementToBeClickableAndClick(page.qAvoidVneck, "Pieces to avoid - V-neck");
//            helper.safeClick(page.nextButton, "Next after pieces to avoid");
//
//            // Colors preference
//            helper.waitForElementToBeClickableAndClick(page.qColorsTrueBlues, "Colors - True Blues");
//            helper.safeClick(page.nextButton, "Next after colors");
//
//            // Slider-like likes/dislikes (12 slides) — dynamic handling
//            // We'll programmatically handle each slide according to an array of choices.
//            // The helper contains a robust method to interact with the slider and click action labels.
//            String[] slideChoices = new String[] {
//                    "Like", "Dislike", "Like", "Like", "Dislike", "Dislike",
//                    "Dislike", "Dislike", "Dislike", "Dislike", "Dislike", "Dislike"
//            };
//
//            helper.handleSliderQuestions(slideChoices);
//
//            // Click next twice to proceed
//            helper.safeClick(page.nextButton, "Next to after slider 1");
//            helper.safeClick(page.nextButton, "Next to after slider 2 to continue");
//
//            // Body type selection
//            helper.waitForElementToBeClickableAndClick(page.qBodySlim, "Body Type - Slim");
//            helper.safeClick(page.nextButton, "Next after body type");
//
//            // Build (feet + inches + weight)
//            helper.waitForElementPresence(page.selectFeet, "Select - Feet dropdown");
//            helper.selectByValue(page.selectFeet, "5'", "Feet dropdown - select 5'");
//            helper.selectByValue(page.selectInches, "10\"", "Inches dropdown - select 10\"");
//            helper.selectByValue(page.selectWeight, "150", "Weight dropdown - select 150");
//
//            helper.safeClick(page.nextButton, "Next after build");
//
//            // Shirt Fit & Size - dynamic picks
//            helper.waitForElementToBeClickableAndClick(page.qShirtFitMedium, "Shirt Fit - medium");
//            helper.safeClick(page.qShirtSizeM, "Shirt Size - M");
//            helper.safeClick(page.nextButton, "Next after shirt fit & size");
//
//            // Pant Fit & Size
//            helper.waitForElementToBeClickableAndClick(page.qPantFitModern, "Pant Fit - modern");
//            helper.safeClick(page.qPantSize34, "Pant Size - 34");
//            helper.safeClick(page.qPantInseam32, "Pant Inseam - 32");
//            helper.safeClick(page.nextButton, "Next after pant fit & size");
//
//            // Shoe size
//            helper.waitForElementToBeClickableAndClick(page.qShoeSize10, "Shoe size - 10");
//            helper.safeClick(page.nextButton, "Next after shoe size");
//
//            // Leave your stylist a message
//            helper.waitForElementToBeClickableAndSendKeys(page.messageTextarea, "No thanks", "Stylist message textarea");
//            // Email input for recommendations
//            helper.waitForElementToBeClickableAndSendKeys(page.emailInput, "amaantyagi007a@gmail.com",
//                    "Email for recommendations");
//
//            helper.safeClick(page.nextButton, "Final Next after message and email");
//
//            System.out.println("Quiz Process Completed and it's working fine.");
//
//            // Choose plan - click LUXE
//            helper.waitForElementToBeClickableAndClick(page.planLuxeHeader, "Plan - LUXE header click");
//
//            // Wait for page body load before scrolling
//            helper.waitForPageLoad();
//
//            // Robust scroll-until-element-and-click behavior for checkout button
//            helper.scrollUntilElementClickableAndClick(page.checkoutButton, "Checkout button", SCROLL_STEP_PIXELS_SMALL,
//                    MAX_SCROLL_ATTEMPTS);
//
//            // Handle any small modal that appears on checkout page
//            helper.waitForElementToBeClickableAndClick(page.cookieOkButton, "Cookie / csm confirmation button");
//
//            // Plan upsell click if present
//            helper.waitForElementToBeClickableAndClick(page.planUpsellContinue, "Plan upsell continue button");
//
//            System.out.println("Statelymen StandAlone Test executed successfully and we are on checkout page.");
//
//            // End test - optionally close
//            // driver.quit(); // commented here so you can view the page manually; uncomment in CI runs.
//
//        } catch (Exception ex) {
//            System.err.println("An unexpected error occurred during execution: " + ex.getMessage());
//            ex.printStackTrace();
//        } finally {
//            // Closing driver to free resources (kept optional for manual debugging)
//            // Uncomment the next two lines to ensure the driver is closed after run
//            // driver.quit();
//            System.out.println("Test flow finished. Please close the browser if it's still open.");
//        }
//    }
//
//    // ---------- Inner class: PageElements (PageFactory locators) ----------
//    // All locators are declared here near the top of the program so they are easy to find and maintain.
//    public static class PageElements {
//
//        // Store a reference to the driver used for PageFactory
//        private WebDriver driver;
//
//        public PageElements(WebDriver driver) {
//            this.driver = driver;
//            PageFactory.initElements(driver, this);
//        }
//
//        // Header CTA - Start Quiz
//        @FindBy(css = ".header_cta.button.button--primary")
//        public WebElement headerStartQuiz;
//
//        // Global Query: Next button (used many times)
//        @FindBy(css = ".next-button.button")
//        public WebElement nextButton;
//
//        // Question: What's got you most excited -> option 2
//        @FindBy(xpath = "//*[@id='quiz']/div[2]/div[2]/div[2]/div[3]/div/div/fieldset/div/label[2]")
//        public WebElement questionWhatsExcitedOption2;
//
//        // Dressing For - Everyday
//        @FindBy(xpath = "//label[@role='checkbox' and @aria-label='Everyday']")
//        public WebElement qDressingForEveryday;
//
//        // More Weekend or Work Looks -> 50/50
//        @FindBy(xpath = "//label[@role='button' and @aria-label='50/50']")
//        public WebElement qWeekendWork5050;
//
//        // Workwear -> Mixed
//        @FindBy(xpath = "//p[contains(text(),'Mixed')]")
//        public WebElement qWorkwearMixed;
//
//        // Weekend Looks -> Stylish
//        @FindBy(xpath = "//p[contains(text(),'Stylish')]")
//        public WebElement qWeekendStylish;
//
//        // Prints -> I'm open to them
//        @FindBy(xpath = "//label[@aria-label=\"I'm open to them\"]")
//        public WebElement qPrintsOpenToThem;
//
//        // Any pieces to avoid? -> V-neck
//        @FindBy(xpath = "//p[contains(text(),'V-neck')]")
//        public WebElement qAvoidVneck;
//
//        // Colors -> True Blues
//        @FindBy(xpath = "//p[contains(text(),'True Blues')]")
//        public WebElement qColorsTrueBlues;
//
//        // Slider Like/Dislike sample targets (generic)
//        // We'll use dynamic locators in the helper to find the active slide's label elements.
//        // For explicit slide examples, include sample locators mapped to visible DOM patterns.
//        @FindBy(xpath = "(//p[@class='label'][normalize-space()='Like'])[1]")
//        public WebElement sampleLikeFirst;
//
//        @FindBy(xpath = "(//p[@class='label'][normalize-space()='Dislike'])[1]")
//        public WebElement sampleDislikeFirst;
//
//        // Body Type -> Slim
//        @FindBy(xpath = "//p[contains(text(),'Slim')]")
//        public WebElement qBodySlim;
//
//        // Build -> feet, inches, weight selects
//        @FindBy(xpath = "//select[@id='question_32-feet']")
//        public WebElement selectFeet;
//
//        @FindBy(xpath = "//*[@id='question_32-inches']")
//        public WebElement selectInches;
//
//        @FindBy(xpath = "//*[@id='question_33']")
//        public WebElement selectWeight;
//
//        // Shirt fit + size
//        @FindBy(xpath = "//*[@id='quiz']/div[2]/div[2]/div[14]/div[2]/div/div[1]/div/label[2]/div/div")
//        public WebElement qShirtFitMedium;
//
//        @FindBy(xpath = "//*[@id='quiz']/div[2]/div[2]/div[14]/div[2]/div/div[2]/fieldset/div[2]/label[3]")
//        public WebElement qShirtSizeM;
//
//        // Pant fit + size + inseam
//        @FindBy(xpath = "//*[@id='quiz']/div[2]/div[2]/div[15]/div[2]/div/div[1]/div/label[2]/div/div")
//        public WebElement qPantFitModern;
//
//        @FindBy(xpath = "//*[@id='quiz']/div[2]/div[2]/div[15]/div[2]/div/div[2]/fieldset/div[2]/label[4]")
//        public WebElement qPantSize34;
//
//        @FindBy(xpath = "//*[@id='quiz']/div[2]/div[2]/div[15]/div[2]/div/div[3]/fieldset/div[2]/label[2]")
//        public WebElement qPantInseam32;
//
//        // Shoe size
//        @FindBy(xpath = "//*[@id='quiz']/div[2]/div[2]/div[16]/div[3]/div/div[2]/fieldset/div[2]/label[4]")
//        public WebElement qShoeSize10;
//
//        // Message to stylist (textarea)
//        @FindBy(xpath = "//*[@id='quiz']/div[2]/div[2]/div[17]/div/div/div/label[1]/textarea")
//        public WebElement messageTextarea;
//
//        // Email input
//        @FindBy(xpath = "//input[@type='email' and @aria-label='Where can we send your style recommendations?']")
//        public WebElement emailInput;
//
//        // Plan selection - LUXE header
//        @FindBy(xpath = "//h3[contains(text(),'LUXE')]")
//        public WebElement planLuxeHeader;
//
//        // Checkout button (used after scrolling)
//        @FindBy(xpath = "//*[@id='checkout-button']")
//        public WebElement checkoutButton;
//
//        // Cookie / CSM wrapper ok button (example selector)
//        @FindBy(xpath = "//*[@id=\"csm-wrapper\"]/div/div/div[2]/button")
//        public WebElement cookieOkButton;
//
//        // Plan upsell continue / confirm (example)
//        @FindBy(xpath = "//*[@id=\"plan-upsell\"]/div[2]/div[4]/button")
//        public WebElement planUpsellContinue;
//
//        // Generic page body (for page presence)
//        @FindBy(tagName = "body")
//        public WebElement bodyTag;
//    }
//
//    // ---------- Helper: SeleniumHelper ----------
//    // This class contains robust, reusable interactions and wait utilities used by the flow above.
//    public static class SeleniumHelper {
//
//        private final WebDriver driver;
//        private final WebDriverWait wait;
//        private final JavascriptExecutor js;
//        private final Actions actions;
//        private final Duration defaultTimeout;
//
//        public SeleniumHelper(WebDriver driver, Duration defaultTimeout) {
//            this.driver = driver;
//            this.defaultTimeout = defaultTimeout;
//            this.wait = new WebDriverWait(driver, defaultTimeout);
//            this.js = (JavascriptExecutor) driver;
//            this.actions = new Actions(driver);
//        }
//
//        // Wait for page to be present (body tag)
//        public void waitForPageLoad() {
//            try {
//                wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
//            } catch (Exception ex) {
//                // swallow - page presence is best-effort
//            }
//        }
//
//        // Wait for presence of element (not necessarily clickable)
//        public WebElement waitForElementPresence(WebElement element, String name) {
//            try {
//                wait.until(driver -> {
//                    try {
//                        return element.isDisplayed() || element.isEnabled() ? element : null;
//                    } catch (StaleElementReferenceException | NoSuchElementException sx) {
//                        return null;
//                    }
//                });
//                return element;
//            } catch (Exception e) {
//                throw new RuntimeException("Timeout waiting for presence of [" + name + "]: " + e.getMessage(), e);
//            }
//        }
//
//        // Wait for locator presence
//        public WebElement waitForElementPresence(By locator, String name) {
//            try {
//                return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//            } catch (Exception e) {
//                throw new RuntimeException("Timeout waiting for presence of locator [" + name + "]: " + e.getMessage(), e);
//            }
//        }
//
//        // Wait for clickable and click using the WebElement (PageFactory)
//        public void waitForElementToBeClickableAndClick(WebElement element, String name) {
//            try {
//                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
//                log("Clicked element: " + name);
//            } catch (Exception ex) {
//                // fallback to robust click attempt
//                log("Primary click failed for [" + name + "], trying robustClick. Cause: " + ex.getMessage());
//                robustClick(element, name);
//            }
//        }
//
//        // Wait for clickable by locator and click
//        public void waitForElementToBeClickableAndClick(By locator, String name) {
//            try {
//                WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
//                el.click();
//                log("Clicked locator: " + name);
//            } catch (Exception ex) {
//                log("Primary locator click failed for [" + name + "], attempting fallback. Cause: " + ex.getMessage());
//                WebElement f = waitForElementPresence(locator, name);
//                robustClick(f, name);
//            }
//        }
//
//        // Safe click that tolerates interception and staleness
//        public void safeClick(WebElement element, String name) {
//            int tries = 0;
//            while (tries < 4) {
//                try {
//                    wait.until(ExpectedConditions.elementToBeClickable(element));
//                    element.click();
//                    log("safeClick succeeded for " + name);
//                    return;
//                } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
//                    log("safeClick try " + (tries + 1) + " failed for " + name + " due to: " + e.getMessage());
//                    sleep(200);
//                } catch (TimeoutException to) {
//                    log("safeClick timeout waiting for clickable for " + name + ": " + to.getMessage());
//                    break;
//                }
//                tries++;
//            }
//            // As last resort try JS click
//            log("safeClick falling back to JS click for " + name);
//            jsClick(element, name);
//        }
//
//        // Robust click with JS fallback
//        public void robustClick(WebElement element, String name) {
//            try {
//                // Attempt normal click first
//                element.click();
//                log("robustClick normal click succeeded for " + name);
//                return;
//            } catch (Exception e) {
//                log("robustClick: normal click failed, attempting JS click for " + name + ". Cause: " + e.getMessage());
//                jsClick(element, name);
//            }
//        }
//
//        // JS click utility
//        public void jsClick(WebElement element, String name) {
//            try {
//                js.executeScript("arguments[0].scrollIntoView({behavior:'instant', block:'center', inline:'center'});",
//                        element);
//                js.executeScript("arguments[0].click();", element);
//                log("jsClick executed for " + name);
//            } catch (Exception e) {
//                throw new RuntimeException("jsClick failed for " + name + ": " + e.getMessage(), e);
//            }
//        }
//
//        // Wait for clickable and send keys
//        public void waitForElementToBeClickableAndSendKeys(WebElement element, String keys, String name) {
//            try {
//                wait.until(ExpectedConditions.elementToBeClickable(element));
//                element.clear();
//                element.sendKeys(keys);
//                log("sendKeys executed for " + name + " -> " + keys);
//            } catch (Exception ex) {
//                log("sendKeys fallback to JS send for " + name + ": " + ex.getMessage());
//                jsSendKeys(element, keys, name);
//            }
//        }
//
//        // JS-based sendKeys (fallback)
//        public void jsSendKeys(WebElement element, String keys, String name) {
//            try {
//                js.executeScript("arguments[0].value = arguments[1];", element, keys);
//                log("jsSendKeys executed for " + name);
//            } catch (Exception e) {
//                throw new RuntimeException("jsSendKeys failed for " + name + ": " + e.getMessage(), e);
//            }
//        }
//
//        // Select dropdown by visible text
//        public void selectByVisibleText(WebElement selectElem, String visibleText, String name) {
//            try {
//                Select s = new Select(selectElem);
//                s.selectByVisibleText(visibleText);
//                log("selectByVisibleText for " + name + " -> " + visibleText);
//            } catch (Exception e) {
//                throw new RuntimeException("selectByVisibleText failed for " + name + ": " + e.getMessage(), e);
//            }
//        }
//
//        // Select by value
//        public void selectByValue(WebElement selectElem, String value, String name) {
//            try {
//                Select s = new Select(selectElem);
//                s.selectByValue(value);
//                log("selectByValue for " + name + " -> " + value);
//            } catch (Exception e) {
//                throw new RuntimeException("selectByValue failed for " + name + ": " + e.getMessage(), e);
//            }
//        }
//
//        // Scroll by pixels using JS
//        public void scrollByPixels(int x, int y) {
//            js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
//            sleep(THREAD_SLEEP_AFTER_SCROLL_MS);
//        }
//
//        // Scroll element into view
//        public void scrollIntoView(WebElement el) {
//            try {
//                js.executeScript("arguments[0].scrollIntoView({behavior:'instant', block:'center'});", el);
//                sleep(150);
//            } catch (Exception e) {
//                // ignore if fails intermittently
//            }
//        }
//
//        // Scroll until an element becomes clickable, then click it
//        public void scrollUntilElementClickableAndClick(WebElement targetElement, String friendlyName, int stepPixels,
//                int maxAttempts) {
//            int attempts = 0;
//            while (attempts < maxAttempts) {
//                try {
//                    wait.until(ExpectedConditions.elementToBeClickable(targetElement));
//                    // If clickable, click and exit
//                    safeClick(targetElement, friendlyName);
//                    log("scrollUntilElementClickableAndClick - clicked " + friendlyName + " after " + attempts
//                            + " scroll attempts");
//                    return;
//                } catch (Exception ex) {
//                    // Scroll a bit and try again
//                    log("scrollUntilElementClickableAndClick - " + friendlyName
//                            + " not clickable yet. Scrolling and retrying. Attempt: " + (attempts + 1));
//                    scrollByPixels(0, stepPixels);
//                }
//                attempts++;
//            }
//            throw new RuntimeException(
//                    "Element [" + friendlyName + "] was not clickable after " + maxAttempts + " scroll attempts.");
//        }
//
//        // Scroll until a locator becomes visible/clickable and then click - locator variant
//        public void scrollUntilLocatorClickableAndClick(By locator, String friendlyName, int stepPixels,
//                int maxAttempts) {
//            int attempts = 0;
//            while (attempts < maxAttempts) {
//                try {
//                    WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
//                    safeClick(el, friendlyName);
//                    log("scrollUntilLocatorClickableAndClick - clicked " + friendlyName + " after " + attempts
//                            + " scroll attempts");
//                    return;
//                } catch (Exception ex) {
//                    // Scroll a bit and try again
//                    log("scrollUntilLocatorClickableAndClick - " + friendlyName
//                            + " not clickable yet. Scrolling and retrying. Attempt: " + (attempts + 1));
//                    scrollByPixels(0, stepPixels);
//                }
//                attempts++;
//            }
//            throw new RuntimeException(
//                    "Locator [" + friendlyName + "] was not clickable after " + maxAttempts + " scroll attempts.");
//        }
//
//        // Generic wait with FluentWait (for advanced conditions)
//        public <T> T fluentWait(Function<WebDriver, T> condition, Duration timeout, Duration polling) {
//            FluentWait<WebDriver> fw = new FluentWait<>(driver).withTimeout(timeout).pollingEvery(polling)
//                    .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
//            return fw.until(condition);
//        }
//
//        // Sleep safe
//        public void sleep(long ms) {
//            try {
//                Thread.sleep(ms);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
//
//        // Log helper
//        public void log(String message) {
//            System.out.println("[SeleniumHelper] " + message);
//        }
//
//        // Handles slider-like questions by iterating visible slides and clicking the expected label (Like/Dislike)
//        // Implementation notes:
//        // - Finds the currently-active slide using a CSS selector pattern typical of swiper / slider components
//        // - Locates the label matching the desired action within that slide and clicks via JS (robust)
//        // - Advances slides where needed (attempts to click "next" slide arrow if present)
//        public void handleSliderQuestions(String[] choices) {
//            log("Starting slider handling for " + choices.length + " slides.");
//            // Try to find Next button for slider navigation - common pattern
//            By sliderNextBtnLocator = By.cssSelector("button.swiper-button-next, button.next-slide, .swiper-button-next");
//            By activeSlideLocator = By.cssSelector(".swiper-slide-active, .slick-active, .slider-question");
//            for (int i = 0; i < choices.length; i++) {
//                String desired = choices[i];
//                log("Slider iteration " + (i + 1) + " -> Desired choice: " + desired);
//                try {
//                    // wait until an active slide appears
//                    WebElement activeSlide = fluentWait(d -> {
//                        try {
//                            List<WebElement> candidates = d.findElements(activeSlideLocator);
//                            if (candidates != null && candidates.size() > 0) {
//                                return candidates.get(0);
//                            }
//                        } catch (Exception ex) {
//                        }
//                        return null;
//                    }, defaultTimeout, POLLING_INTERVAL);
//
//                    // Within the active slide, find label text matching desired
//                    if (activeSlide == null) {
//                        log("No active slide found, attempting to just click the visible 'Like'/'Dislike' labels from DOM.");
//                        // fallback: try to click a global label element matching desired text
////                        By fallback = By.xpath("//p[@class='label' and normalize-space()='" + desired + "']");
////                        WebElement e = fluentWait(ExpectedConditions::presenceOfElementLocated, defaultTimeout,
////                                POLLING_INTERVAL);
//                        // This is a last-resort attempt; we'll try JS click via locator
//                        try {
// //                           WebElement fallbackElem = driver.findElement(fallback);
// //                           jsClick(fallbackElem, "Fallback slider label - " + desired);
// //                       } catch (Exception fe) {
// //                           log("Fallback slider click failed for " + desired + ": " + fe.getMessage());
//  //                      }
////                    } else {
////                        // Try to find the label element inside active slide
////                        try {
////                            WebElement label = activeSlide.findElement(By.xpath(".//p[@class='label' and normalize-space()='"
////                                    + desired + "']"));
////                            scrollIntoView(label);
////                            jsClick(label, "Slider label [" + desired + "] on slide " + (i + 1));
////                        } catch (NoSuchElementException ne) {
////                            log("Label '" + desired
////                                    + "' not found inside active slide; searching globally for this text and clicking.");
////                            // try global search
////                            try {
////                                WebElement global = driver.findElement(
////                                        By.xpath("//p[@class='label' and normalize-space()='" + desired + "']"));
////                                scrollIntoView(global);
////                                jsClick(global, "Global slider label [" + desired + "]");
////                            } catch (Exception gex) {
////                                log("Global slider click failed for " + desired + ": " + gex.getMessage());
////                            }
////                        }
////                    }
////                } catch (Exception e) {
////                    log("Exception while handling slider slide " + (i + 1) + ": " + e.getMessage());
////                }
////
////                // Advance the slide: try several patterns to move to next
////                try {
////                    log("Attempting to advance slider to next slide (iteration " + (i + 1) + ").");
////                    // Try to click built-in next buttons
////                    List<By> possibleNextLocators = List.of(By.cssSelector("button.swiper-button-next"),
////                            By.cssSelector("button.next-slide"), By.cssSelector(".swiper-button-next"),
////                            By.cssSelector("button.swiper-next"));
//
////                    boolean advanced = false;
////                    for (By nextL : possibleNextLocators) {
////                        try {
////                            List<WebElement> found = driver.findElements(nextL);
////                            if (found != null && found.size() > 0) {
////                                WebElement nextBtn = found.get(0);
////                                if (nextBtn.isDisplayed() && nextBtn.isEnabled()) {
////                                    safeClick(nextBtn, "Slider next button");
////                                    advanced = true;
////                                    break;
////                                }
////                            }
////                        } catch (Exception nested) {
////                            // ignore and try next pattern
////                        }
////                    }
//
//                    // If none worked, try keyboard right-arrow via Actions
//                    if (!advanced) {
//                        try {
//                            actions.sendKeys(org.openqa.selenium.Keys.ARROW_RIGHT).perform();
//                            log("Advanced slider using keyboard arrow.");
//                            advanced = true;
//                        } catch (Exception ke) {
//                            // ignore
//                        }
//                    }
//
//                    // Wait a little for slide transition
//                    sleep(400);
//
//                } catch (Exception exAdvance) {
//                    log("Advance attempt failed: " + exAdvance.getMessage());
//                }
//            }
//            log("Completed slider handling.");
//        }
//
//        // A general-purpose wait for an ExpectedCondition using FluentWait style that returns WebElement
//        public WebElement fluentWait(ExpectedCondition<WebElement> condition, Duration timeout, Duration polling) {
//            FluentWait<WebDriver> fw = new FluentWait<>(driver).withTimeout(timeout).pollingEvery(polling)
//                    .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
//            return fw.until(condition);
//        }
//
//        // Generic function to wait for arbitrary condition using WebDriverWait
//        public <T> T waitFor(Function<WebDriver, T> condition, Duration timeout) {
//            WebDriverWait w = new WebDriverWait(driver, timeout);
//            return w.until(condition);
//        }
//    }
//
//    // ---------------------------
//    // End of class definitions
//    // ---------------------------
//
//}
