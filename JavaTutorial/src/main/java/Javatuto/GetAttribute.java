package Javatuto;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {

	public static void main(String[] args) {
		//
		
		WebDriver driver = new ChromeDriver();
		
		try {
			driver.get("https://www.facebook.com/");
			String url = driver.getCurrentUrl();
			WebElement activerElemnet = driver.switchTo().activeElement();
			activerElemnet.sendKeys("6385533717",Keys.TAB,"Qwer`123",Keys.ENTER);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(driver!=null) {
				System.out.println("-===Done==-");
				driver.quit();
			}
		}
		
		
	}

}
