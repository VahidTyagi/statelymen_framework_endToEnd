package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Statelymen_StandAloneTest {

	public static void main(String[] args) {


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
		wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".next-button.button.text-button")));
		driver.findElement(By.cssSelector(".next-button.button.text-button")).click();
		
		WebDriverWait wait3= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait3.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));	
		driver.findElement(By.cssSelector("")).click();
		
		// What’s got you most excited to try Stately?
		WebDriverWait wait4= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox' and @aria-label='Leveling Up My Style']")));	
		driver.findElement(By.xpath("//input[@type='checkbox' and @aria-label='Leveling Up My Style']")).click();
		
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
		wait11.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Like')]")));
		driver.findElement(By.xpath("//p[contains(text(),'Like')]")).click();
		wait11.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Like')]")));
		driver.findElement(By.xpath("//p[contains(text(),'Like')]")).click();
		wait11.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Like')]")));
		driver.findElement(By.xpath("//p[contains(text(),'Like')]")).click();
		wait11.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Dislike')]")));
		driver.findElement(By.xpath("//p[contains(text(),'Dislike')]")).click();
		wait11.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Like')]")));
		driver.findElement(By.xpath("//p[contains(text(),'Like')]")).click();
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
		select.selectByValue("6'");
		// click on the next button
		
		WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='question_32-feet']"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("2");
		
		WebElement dropdown3 = driver.findElement(By.xpath("//select[@id='question_32-weight']"));
		Select select3 = new Select(dropdown);
		select3.selectByValue("150");
		
		// click on the next button
		driver.findElement(By.id("next-button")).click();

		
		
		// Shirt Fit & Size
		WebDriverWait wait14= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait14.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='label checkbutton']/input[@aria-label='Classic']")));	
		driver.findElement(By.xpath("//div[@class='label checkbutton']/input[@aria-label='Classic']")).click();
		// clcik shirt size 
		driver.findElement(By.xpath("//label[@aria-label='L']")).click();
		// click on the next button
		driver.findElement(By.id("next-button")).click();
		
		
		// Pant Fit & Size
		WebDriverWait wait15= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait15.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.visually-hidden[value='147']")));	
		driver.findElement(By.cssSelector("input.visually-hidden[value='147']")).click();
		driver.findElement(By.cssSelector("label.option.size-option[data-option-id='134']")).click();
		//insem
		driver.findElement(By.cssSelector("label.option.size-option[data-option-id='144']")).click();
		// click on the next button
		driver.findElement(By.id("next-button")).click();
		
		// shoe size
		WebDriverWait wait16= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait16.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label.option.size-option[data-option-id='151']\r\n"
				+ "")));	
		driver.findElement(By.cssSelector("label.option.size-option[data-option-id='151']\r\n"
				+ "")).click();
		// click on the next button
		driver.findElement(By.id("next-button")).click();
		
		// Leave your stylist a message
		WebDriverWait wait17= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait17.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[17]/div/div/div/label[1]/textarea")));	
		driver.findElement(By.xpath("//*[@id=\"quiz\"]/div[2]/div[2]/div[17]/div/div/div/label[1]/textarea")).sendKeys("No thanks");
		
		WebDriverWait wait18= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait18.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email' and @aria-label='Where can we send your style recommendations?']")));
		driver.findElement(By.xpath("//input[@type='email' and @aria-label='Where can we send your style recommendations?']")).sendKeys("amaantyagi007@gmail.com");
		// click on the next button
		driver.findElement(By.id("next-button")).click();
		System.out.println("Quiz Process Completed and it's working fine. ");
		
		// choose Plan 
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
