package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Statelymen_StandAloneTest {

	public static void main(String[] args) throws InterruptedException {


		System.out.println("Statelymen StandAlone Test executed successfully.");
		System.out.println("Launch Statelymen Application");

		System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://statelymen.com/");
		
		
		// Quiz Process
		System.out.println("Quiz Process Started");
		// click on Start Quiz button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".header_cta.button.button--primary")));
		driver.findElement(By.cssSelector(".header_cta.button.button--primary")).click();
		
		// click on the option for each question and click on next button
		WebDriverWait wait2= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".next-button.button")));
		driver.findElement(By.cssSelector(".next-button.button")).click();
		
//		WebDriverWait wait3= new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait3.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));	
//		driver.findElement(By.cssSelector("")).click();
		
		// What’s got you most excited to try Stately?
		WebDriverWait wait4= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[2]/div[3]/div/div/fieldset/div/label[2]")));	
		driver.findElement(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[2]/div[3]/div/div/fieldset/div/label[2]")).click();
		
		// click on the next button 
		driver.findElement(By.xpath("//button[@id=\"next-button\"]")).click();
		
		//What Are You Dressing For?
		WebDriverWait wait5= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@role='checkbox' and @aria-label='Everyday']")));	
		driver.findElement(By.xpath("//label[@role='checkbox' and @aria-label='Everyday']")).click();
		//More Weekend or Work Looks?
		driver.findElement(By.xpath("//label[@role='button' and @aria-label='50/50']")).click();
		// click on the next button
		driver.findElement(By.id("next-button")).click();
		
		//Workwear For your updated work look, which of these are you drawn to?
		WebDriverWait wait6= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait6.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Mixed')]")));	
		driver.findElement(By.xpath("//p[contains(text(),'Mixed')]")).click();
		// click on the next button
		driver.findElement(By.id("next-button")).click();
		
		//Weekend Looks Which of these are you leaning toward for your updated style?
		WebDriverWait wait7= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Stylish')]")));	
		driver.findElement(By.xpath("//p[contains(text(),'Stylish')]")).click();
		// click on the next button
		driver.findElement(By.id("next-button")).click();
		
		// again next button click to see results
		driver.findElement(By.id("next-button")).click();
		
		//Print Check When it comes to patterns and prints, rock 'em, drop 'em, or sprinkle 'em in?
		WebDriverWait wait8= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait8.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@aria-label=\"I'm open to them\"]")));	
		driver.findElement(By.xpath("//label[@aria-label=\"I'm open to them\"]")).click();
		// click on the next button
		driver.findElement(By.id("next-button")).click();
		
		// Any Pieces to Avoid?
		WebDriverWait wait9= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait9.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'V-neck')]")));	
		driver.findElement(By.xpath("//p[contains(text(),'V-neck')]")).click();
		// click on the next button
		driver.findElement(By.id("next-button")).click();
		
		//What Colors Do You Like?
		WebDriverWait wait10= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait10.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'True Blues')]")));	
		driver.findElement(By.xpath("//p[contains(text(),'True Blues')]")).click();
		// click on the next button
		driver.findElement(By.id("next-button")).click();
		
		
		WebDriverWait wait11= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Like')]")));	
		driver.findElement(By.xpath("//p[contains(text(),'Like')]")).click();
		
		WebDriverWait wait11b= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11b.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[@class='label'][normalize-space()='Dislike'])[2]")));
		driver.findElement(By.xpath("(//p[@class='label'][normalize-space()='Dislike'])[2]")).click();
		
		WebDriverWait wait11c= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11c.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Slide 3 of 12']//p[@class='label'][normalize-space()='Like']")));
		driver.findElement(By.xpath("//div[@aria-label='Slide 3 of 12']//p[@class='label'][normalize-space()='Like']")).click();
		
		WebDriverWait wait11d= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11d.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Slide 4 of 12']//p[@class='label'][normalize-space()='Like']")));
		driver.findElement(By.xpath("//div[@aria-label='Slide 4 of 12']//p[@class='label'][normalize-space()='Like']")).click();
		
		
		WebDriverWait wait11e= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11e.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Slide 5 of 12']//p[@class='label'][normalize-space()='Dislike']")));
		driver.findElement(By.xpath("//div[@aria-label='Slide 5 of 12']//p[@class='label'][normalize-space()='Dislike']")).click();
		
		WebDriverWait wait11f= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11f.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Slide 6 of 12']//p[@class='label'][normalize-space()='Dislike']")));
		driver.findElement(By.xpath("//div[@aria-label='Slide 6 of 12']//p[@class='label'][normalize-space()='Dislike']")).click();
		
		WebDriverWait wait11g= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11g.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Slide 7 of 12']//p[@class='label'][normalize-space()='Dislike']")));
		driver.findElement(By.xpath("//div[@aria-label='Slide 7 of 12']//p[@class='label'][normalize-space()='Dislike']")).click();
		
		WebDriverWait wait11h= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11h.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Slide 8 of 12']//p[@class='label'][normalize-space()='Dislike']")));
		driver.findElement(By.xpath("//div[@aria-label='Slide 8 of 12']//p[@class='label'][normalize-space()='Dislike']")).click();
		
		WebDriverWait wait11i= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11i.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Slide 9 of 12']//p[@class='label'][normalize-space()='Dislike']")));
		driver.findElement(By.xpath("//div[@aria-label='Slide 9 of 12']//p[@class='label'][normalize-space()='Dislike']")).click();
		
		WebDriverWait wait11j= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11j.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Slide 10 of 12']//p[@class='label'][normalize-space()='Dislike']")));
		driver.findElement(By.xpath("//div[@aria-label='Slide 10 of 12']//p[@class='label'][normalize-space()='Dislike']")).click();
		
		WebDriverWait wait11k= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11k.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Slide 11 of 12']//p[@class='label'][normalize-space()='Dislike']")));
		driver.findElement(By.xpath("//div[@aria-label='Slide 11 of 12']//p[@class='label'][normalize-space()='Dislike']")).click();
		
		WebDriverWait wait11l= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11l.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Slide 12 of 12']//p[@class='label'][normalize-space()='Dislike']")));
		driver.findElement(By.xpath("//div[@aria-label='Slide 12 of 12']//p[@class='label'][normalize-space()='Dislike']")).click();
		
/*		

		for(int i = 1; i <= 12; i++) {

		    WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(10));

		    // Identify current visible slide like/dislike
		    WebElement element;

		    if(i <= 6) {
		        element = waitt.until(ExpectedConditions.presenceOfElementLocated(
		            By.xpath("//div[contains(@class,'slider-question') and contains(@class,'swiper-slide-active')]//label[./input[@value='like']]")
		        ));
		    } else {
		        element = waitt.until(ExpectedConditions.presenceOfElementLocated(
		            By.xpath("//div[contains(@class,'slider-question') and contains(@class,'swiper-slide-active')]//label[./input[@value='dislike']]")
		        ));
		    }

		    // Scroll into view (swiper sometimes hides top part)
		    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);

		    // Force click using JS (bypasses opacity + intercepted click issue)
		    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

		    // Move to next slide
		    WebElement nextBtn = waitt.until(ExpectedConditions.elementToBeClickable(
		        By.cssSelector("button.swiper-button-next")
		    ));
		    nextBtn.click();

		    Thread.sleep(500);
		}


*/ 

	
		
/*		
		WebDriverWait wait11a= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11a.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swiper-wrapper-3a810a5729b2ed973\"]/div[1]/fieldset/div/label[2]/p")));
		driver.findElement(By.xpath("//*[@id=\"swiper-wrapper-658f64d95e27bef8\"]/div[1]/fieldset/div/label[2]/p")).click();
		
		WebDriverWait wait11a2= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11a2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swiper-wrapper-658f64d95e27bef8\"]/div[2]/fieldset/div/label[2]/p")));
		driver.findElement(By.xpath("//*[@id=\"swiper-wrapper-658f64d95e27bef8\"]/div[2]/fieldset/div/label[2]/p")).click();
		
		WebDriverWait wait11b= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11b.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[3]/fieldset/div/label[2]/p")));
		driver.findElement(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[3]/fieldset/div/label[2]/p")).click();
		
		WebDriverWait wait11c= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11c.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[4]/fieldset/div/label[2]/p")));
		driver.findElement(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[4]/fieldset/div/label[2]/p")).click();
		
		WebDriverWait wait11d= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11d.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[5]/fieldset/div/label[2]/p")));
		driver.findElement(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[5]/fieldset/div/label[2]/p")).click();
		
		WebDriverWait wait11e= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11e.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[6]/fieldset/div/label[2]/p")));
		driver.findElement(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[6]/fieldset/div/label[2]/p")).click();
		
		WebDriverWait wait11f= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11f.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[7]/fieldset/div/label[2]/p")));
		driver.findElement(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[7]/fieldset/div/label[2]/p")).click();
		
		WebDriverWait wait11g= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11g.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[8]/fieldset/div/label[2]/p")));
		driver.findElement(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[8]/fieldset/div/label[2]/p")).click();
		
		WebDriverWait wait11h= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11h.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[9]/fieldset/div/label[2]/p")));
		driver.findElement(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[9]/fieldset/div/label[2]/p")).click();
		
		WebDriverWait wait11i= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11i.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[10]/fieldset/div/label[2]/p")));
		driver.findElement(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[10]/fieldset/div/label[2]/p")).click();
		
		WebDriverWait wait11j= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11j.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[11]/fieldset/div/label[2]/p")));
		driver.findElement(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[11]/fieldset/div/label[2]/p")).click();
		
		WebDriverWait wait11k= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait11k.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[12]/fieldset/div/label[2]/p")));
		driver.findElement(By.xpath("//*[@id=\"swiper-wrapper-7d27cf2adbf12cdc\"]/div[12]/fieldset/div/label[2]/p")).click();
*/ 		
		// click on the next button
		driver.findElement(By.id("next-button")).click();
		// click on the next button  
		driver.findElement(By.id("next-button")).click();
		
		// Body Type
		WebDriverWait wait12= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait12.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Slim')]")));	
		driver.findElement(By.xpath("//p[contains(text(),'Slim')]")).click();
		// click on the next button
		driver.findElement(By.id("next-button")).click();
		
		// build 
		WebDriverWait wait13= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait13.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id=\"question_32-feet\"]")));	
		driver.findElement(By.xpath("//select[@id=\"question_32-feet\"]")).click();
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='question_32-feet']"));
		Select select = new Select(dropdown);
		select.selectByValue("5'");
		
		
		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"question_32-inches\"]"));
		Select select2 = new Select(dropdown2);

		for (WebElement opt : select2.getOptions()) {
		    System.out.println("Value = [" + opt.getAttribute("value") + "] Text = [" + opt.getText() + "]");
		}
		select2.selectByValue("10\"");
		// select2.selectByValue("0\"");

	
		
		WebElement dropdown3 = driver.findElement(By.xpath("//*[@id=\"question_33\"]"));
		Select select3 = new Select(dropdown3);
		select3.selectByValue("150");
		
		// click on the next button
		driver.findElement(By.id("next-button")).click();

		
		
		// Shirt Fit & Size
		WebDriverWait wait14= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait14.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[14]/div[2]/div/div[1]/div/label[2]/div/div")));	
		driver.findElement(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[14]/div[2]/div/div[1]/div/label[2]/div/div")).click();
		// clcik shirt size 
		driver.findElement(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[14]/div[2]/div/div[2]/fieldset/div[2]/label[3]")).click();
		// click on the next button
		driver.findElement(By.id("next-button")).click();
		
		
		// Pant Fit & Size
		WebDriverWait wait15= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait15.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[15]/div[2]/div/div[1]/div/label[2]/div/div")));	
		driver.findElement(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[15]/div[2]/div/div[1]/div/label[2]/div/div")).click();
		driver.findElement(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[15]/div[2]/div/div[2]/fieldset/div[2]/label[4]")).click();
		//insem
		driver.findElement(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[15]/div[2]/div/div[3]/fieldset/div[2]/label[2]")).click();
		// click on the next button
		driver.findElement(By.id("next-button")).click();
		
		// shoe size
		WebDriverWait wait16= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait16.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[16]/div[3]/div/div[2]/fieldset/div[2]/label[4]")));	
		driver.findElement(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[16]/div[3]/div/div[2]/fieldset/div[2]/label[4]")).click();
		// click on the next button
		driver.findElement(By.id("next-button")).click();
		
		// Leave your stylist a message
		WebDriverWait wait17= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait17.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[17]/div/div/div/label[1]/textarea")));	
		driver.findElement(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[17]/div/div/div/label[1]/textarea")).sendKeys("No thanks");
		
		WebDriverWait wait18= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait18.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email' and @aria-label='Where can we send your style recommendations?']")));
		driver.findElement(By.xpath("//input[@type='email' and @aria-label='Where can we send your style recommendations?']")).sendKeys("amaantyagi007a@gmail.com");
		
		// click on the next button
		WebDriverWait wait18b= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait18b.until(ExpectedConditions.elementToBeClickable(By.id("next-button")));
		
		driver.findElement(By.id("next-button")).click();
		System.out.println("Quiz Process Completed and it's working fine. ");
		
		// choose Plan //*[@id="next-button"]
		WebDriverWait wait19= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait19.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),'LUXE')]")));
		driver.findElement(By.xpath("//h3[contains(text(),'LUXE')]")).click();
		
		// click checkout button
		driver.findElement(By.id("checkout-button")).click();
		WebDriverWait wait20= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait20.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".modal-close")));
		driver.findElement(By.cssSelector(".modal-close")).click();
		
		System.out.println("Statelymen StandAlone Test executed successfully and we are on checkout page.");
		
		

	}

}
