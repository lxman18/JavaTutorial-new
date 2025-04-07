package Javatuto;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Snippet {
	public static void main(String[] args) throws Exception{
		 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//driver.get("https://jqueryui.com/droppable/");
//		driver.switchTo().frame(0);
//		driver.findElement(By.name("fname")).sendKeys("Laxman to string");
//		driver.findElement(By.name("lname")).sendKeys("csdm");
//		//driver.findElement(By.name("email")).sendKeys("laxmn@gmail.com");
//		driver.findElement(By.xpath("//input[@name='email']"));
//		driver.findElement(By.name("email")).sendKeys("sdjk");
		
		//Element droggble
//		try {
//			driver.switchTo().frame(0);
//			WebElement source = driver.findElement(By.id("draggable"));
//			WebElement target = driver.findElement(By.id("droppable"));
//			Actions builder = new Actions(driver);
//			builder.dragAndDrop(source, target).perform();
//			System.out.println("Done====Done");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		//  rightclick 
//		
//		driver.get("https://www.flipkart.com/");
//		//driver.findElement(By.className("_18u87m _3WuvDp")).click();
//		//driver.findElement(By.linkText("Request OTP")).click();
//		WebElement ele = driver.findElement(By.xpath("(//span[@class='_1XjE3T'])[3]"));
//		Actions builder = new Actions(driver);
//		builder.contextClick(ele).perform();
		
		//Visible text 
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("(//span[@class='_1XjE3T'])[3]")).click();
		WebElement elel = driver.findElement(By.xpath("(//a[@class='_1BJVlg'])[2]"));
		elel.getText();
		System.out.println(elel);
		
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
		 
	}
}

