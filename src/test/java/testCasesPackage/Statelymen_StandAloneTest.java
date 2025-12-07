//package testCasesPackage;
//
//import java.time.Duration;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.*;
//import org.testng.annotations.Test;
//
//public class Statelymen_StandAloneTest extends BaseClass {
//
//    @Test
//    public void statelyQuizFlow() throws Exception {
//
//        System.out.println("Quiz Process Started");
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Start Quiz
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".header_cta.button.button--primary"))).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".next-button.button"))).click();
//
//        // Question 1
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[2]"))).click();
//        driver.findElement(By.id("next-button")).click();
//
//        // Everyday + 50/50
//        driver.findElement(By.xpath("//label[@aria-label='Everyday']")).click();
//        driver.findElement(By.xpath("//label[@aria-label='50/50']")).click();
//        driver.findElement(By.id("next-button")).click();
//
//        // Workwear
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Mixed')]"))).click();
//        driver.findElement(By.id("next-button")).click();
//
//        // Weekend Style
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Stylish')]"))).click();
//        driver.findElement(By.id("next-button")).click();
//        driver.findElement(By.id("next-button")).click();
//
//        // Patterns
//        driver.findElement(By.xpath("//label[@aria-label=\"I'm open to them\"]")).click();
//        driver.findElement(By.id("next-button")).click();
//
//        // Avoid pieces
//        driver.findElement(By.xpath("//p[contains(text(),'V-neck')]")).click();
//        driver.findElement(By.id("next-button")).click();
//
//        // Colors
//        driver.findElement(By.xpath("//p[contains(text(),'True Blues')]")).click();
//        driver.findElement(By.id("next-button")).click();
//
//        // Slides 12 times (like/dislike)
//        for (int i = 1; i <= 12; i++) {
//
//            WebElement visibleSlide = wait.until(ExpectedConditions.presenceOfElementLocated(
//                    By.cssSelector("div.swiper-slide-active label p")
//            ));
//
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", visibleSlide);
//            visibleSlide.click();
//
//            WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.cssSelector("button.swiper-button-next")
//            ));
//            nextBtn.click();
//
//            Thread.sleep(400);
//        }
//
//        driver.findElement(By.id("next-button")).click();
//        driver.findElement(By.id("next-button")).click();
//
//        // Body Type
//        driver.findElement(By.xpath("//p[contains(text(),'Slim')]")).click();
//        driver.findElement(By.id("next-button")).click();
//
//        // Height
//        Select feet = new Select(driver.findElement(By.id("question_32-feet")));
//        feet.selectByValue("5'");
//
//        Select inch = new Select(driver.findElement(By.id("question_32-inches")));
//        inch.selectByValue("10\"");
//
//        Select weight = new Select(driver.findElement(By.id("question_33")));
//        weight.selectByValue("150");
//
//        driver.findElement(By.id("next-button")).click();
//
//        // Shirt Fit
//        driver.findElement(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[14]/div[2]/div/div[1]/div/label[2]")).click();
//        driver.findElement(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[14]/div[2]/div/div[2]/fieldset/div[2]/label[3]")).click();
//        driver.findElement(By.id("next-button")).click();
//
//        // Pants
//        driver.findElement(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[15]/div[2]/div/div[1]/div/label[2]")).click();
//        driver.findElement(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[15]/div[2]/div/div[2]/fieldset/div[2]/label[4]")).click();
//        driver.findElement(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[15]/div[2]/div/div[3]/fieldset/div[2]/label[2]")).click();
//        driver.findElement(By.id("next-button")).click();
//
//        // Shoe Size
//        driver.findElement(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[16]/div[3]/div/div[2]/fieldset/div[2]/label[4]")).click();
//        driver.findElement(By.id("next-button")).click();
//
//        // Message + Email
//        driver.findElement(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[17]/div/div/div/label[1]/textarea"))
//                .sendKeys("No Thanks");
//
//        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("amaantyagi007a@gmail.com");
//        driver.findElement(By.id("next-button")).click();
//
//        System.out.println("Quiz Completed.");
//
//        // Plan Selection
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),'LUXE')]"))).click();
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        By checkoutBtn = By.id("checkout-button");
//
//        while (true) {
//            try {
//                WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
//                btn.click();
//                break;
//            } catch (Exception e) {
//                js.executeScript("window.scrollBy(0, 200)");
//                Thread.sleep(300);
//            }
//        }
//
//        driver.findElement(By.xpath("//*[@id=\"csm-wrapper\"]/div/div/div[2]/button")).click();
//        driver.findElement(By.xpath("//*[@id=\"plan-upsell\"]/div[2]/div[4]/button")).click();
//
//        System.out.println("Checkout page reached successfully.");
//    }
//}
