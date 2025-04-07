package Javatuto;

import java.awt.RenderingHints.Key;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mnwlogin {

	public static  void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://mpulse.co.in/login");
		
		driver.findElement(By.id("username")).sendKeys("MNW6432");
		driver.findElement(By.id("password")).sendKeys("Qwer~!23");
		driver.findElement(By.name("login_form")).click();
		driver.findElement(By.xpath("(//i[@class='fa fa-users       '])[2]")).click();
		driver.findElement(By.xpath("(//i[@class='fa fa-angle-double-right'])[5]")).click();
		driver.findElement(By.name("leave_sub")).sendKeys("Applying leave",Keys.TAB);
		String date = driver.findElement(By.xpath("(//input[@name='curr_date'])")).getAttribute("value");
		String date1 =driver.findElement(By.xpath("(//input[@name='curr_date'])")).getAttribute("readonly");
		System.out.println(date1);
		System.out.println(date);
		
		
		
	}

}
