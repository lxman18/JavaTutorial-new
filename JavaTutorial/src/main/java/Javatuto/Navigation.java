package Javatuto;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {
    public static void main(String[] args)throws Exception  {
        
        WebDriver driver = new ChromeDriver();
        
        // Navigate to the login page
        driver.get("https://www.flipkart.com/account/login");
        
        // Enter phone number and click "Login"
        driver.findElement(By.xpath("//input[@class='r4vIwl BV+Dqf']")).sendKeys("8778177241");// Update as needed
        driver.findElement(By.xpath("//button[@class='QqFHMw twnTnD _7Pd1Fp']")).click();
        driver.get("https://www.flipkart.com/search?q=beauty+products+for+women&as=on&as-show=on&otracker=AS_Query_HistoryAutoSuggest_1_2_na_na_na&otracker1=AS_Query_HistoryAutoSuggest_1_2_na_na_na&as-pos=1&as-type=HISTORY&suggestionId=beauty+products+for+women&requestId=e1203b3b-5c91-4a3b-94e3-620fc69d43d1&as-backfill=on");
        driver.findElement(By.xpath("(//img[@class='DByuf4'])[1]")).click();
        driver.navigate().back();
        
        //nav.to("https://www.flipkart.com/sotrue-strobe-cream-face-radiance-multipurpose-cream-dewy-glazed-instant-glow-30g-highlighter/p/itm5d0705778d4b4?pid=HGLH29REGGHTNEHZ&lid=LSTHGLH29REGGHTNEHZIDKI1H&marketplace=FLIPKART&q=beauty+products+for+women&store=g9b&srno=s_1_1&otracker=AS_Query_HistoryAutoSuggest_1_2_na_na_na&otracker1=AS_Query_HistoryAutoSuggest_1_2_na_na_na&iid=en_ogQfM7ZD9WMjQgVLpH9BJV-dSxCafm8n1g-rs4Iah6Nlvw3ZxcTqsBUB04sperwqE4avjbQniHEURUnA9M26Rg%3D%3D&ssid=p6kxn0dhcw0000001742050381757&qH=39ce796c58125e0d");
        //driver.navigate().to("https://www.flipkart.com/sotrue-strobe-cream-face-radiance-multipurpose-cream-dewy-glazed-instant-glow-30g-highlighter/p/itm5d0705778d4b4?pid=HGLH29REGGHTNEHZ&lid=LSTHGLH29REGGHTNEHZIDKI1H&marketplace=FLIPKART&q=beauty+products+for+women&store=g9b&srno=s_1_1&otracker=AS_Query_HistoryAutoSuggest_1_2_na_na_na&otracker1=AS_Query_HistoryAutoSuggest_1_2_na_na_na&iid=en_ogQfM7ZD9WMjQgVLpH9BJV-dSxCafm8n1g-rs4Iah6Nlvw3ZxcTqsBUB04sperwqE4avjbQniHEURUnA9M26Rg%3D%3D&ssid=p6kxn0dhcw0000001742050381757&qH=39ce796c58125e0d");
        org.openqa.selenium.WebDriver.Navigation nav = driver.navigate();
        nav.refresh();     
        String url = driver.getCurrentUrl();
        
        System.out.println(url);   
        Thread.sleep(3000);
        
        
       
        
    }
}
