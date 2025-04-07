package Javatuto;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.io.Files;

public class Buttons {

	public static <TakesScreenshot> void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		 driver.get("https://www.flipkart.com/account/login");		
//		 driver.findElement(By.xpath("//input[@class='r4vIwl BV+Dqf']")).sendKeys("8778177241");// Update as needed
//	     driver.findElement(By.xpath("//button[@class='QqFHMw twnTnD _7Pd1Fp']")).click();
//	     driver.get("https://www.flipkart.com/search?q=beauty+products+for+women&as=on&as-show=on&otracker=AS_Query_HistoryAutoSuggest_1_2_na_na_na&otracker1=AS_Query_HistoryAutoSuggest_1_2_na_na_na&as-pos=1&as-type=HISTORY&suggestionId=beauty+products+for+women&requestId=e1203b3b-5c91-4a3b-94e3-620fc69d43d1&as-backfill=on");
//	     driver.findElement(By.xpath("(//img[@class='DByuf4'])[1]")).click();
	     driver.get("https://letcode.in/frame");
	     driver.switchTo().frame(0);
	     driver.findElement(By.name("fname")).sendKeys("Lakxman");
	     
	     
	     File screenshot = ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

         // Save screenshot to desired location
         File destination = new File("./snape/screenshot.png");
         FileUtils.copyFile(screenshot, destination);

         System.out.println("Screenshot saved: " + destination.getAbsolutePath());
	     
	       
		
	     
	     
	        

	}

}
