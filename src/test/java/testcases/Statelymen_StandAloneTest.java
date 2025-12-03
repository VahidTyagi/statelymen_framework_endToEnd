package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Statelymen_StandAloneTest {

	public static void main(String[] args) {


		System.out.println("Statelymen StandAlone Test executed successfully.");
		System.out.println("Launch Statelymen Application");

		System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://statelymen.com/");
		
		
		// Quiz Process
		System.out.println("Quiz Process Started");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".header_cta.button.button--primary")));
		driver.findElement(By.cssSelector(".header_cta.button.button--primary")).click();
		
		WebDriverWait wait2= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".next-button.button.text-button")));
		driver.findElement(By.cssSelector(".next-button.button.text-button")).click();
		
		
		
		
		
		

	}

}
