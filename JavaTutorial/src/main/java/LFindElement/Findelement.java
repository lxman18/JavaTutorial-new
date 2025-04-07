package LFindElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Findelement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub   
		
		WebDriver driver = new ChromeDriver();
		List<WebElement> labels;
		int si;
		try {
			driver.get("https://letcode.in/edit");
			labels = driver.findElements(By.tagName("label"));
			WebElement size= labels.get(labels.size()-2);
			System.out.println(size.getText());
			
			
			WebElement ll =labels.remove(1);
			System.out.println(ll.getText());
			si = labels.size();
			System.out.println(si);
			if(si<=6) {
				System.out.println("it is ok: "+si);
			}else System.out.println("Failed ");
			
			for (WebElement string : labels) {
				
				String text =string.getText();
				System.out.println(text);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(driver!=null) {
				driver.quit();
			}
		}
		
		
	}
	
}
