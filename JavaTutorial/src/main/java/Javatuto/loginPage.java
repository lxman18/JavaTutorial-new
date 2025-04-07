package Javatuto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginPage {

    public static void main(String[] args) {
        // Set the path for the ChromeDriver (you may need to adjust this path)
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Open the login page
        driver.get("https://mpulse.co.in/login");

        // Find all elements with name="userName" (they should be in a list)
        List<WebElement> usernameFields = driver.findElements(By.name("username"));

        // Check if the list is not empty before interacting with it
        if (!usernameFields.isEmpty()) {
            // Enter the username in the first input field
            usernameFields.get(0).sendKeys("MNW6432");
        }

        // Find all elements with name="password"
        List<WebElement> passwordFields = driver.findElements(By.name("password"));

        // Check if the list is not empty before interacting with it
        if (!passwordFields.isEmpty()) {
            // Enter the password in the first input field
            passwordFields.get(0).sendKeys("Qwer~!23");
        }
 
        // Click the login button (make sure this XPath is correct)
        driver.findElement(By.xpath("//button[@class='btn btn-md btn-primary']")).click();
        driver.findElement(By.xpath("(//i[@class='fa fa-users       '])[1]")).click();
        driver.findElement(By.xpath("(//i[@class='fa fa-angle-double-right'])[2]")).click();
        driver.findElement(By.xpath("//i[@class='fa fa-angle-double-right']")).click();

        // Optionally, close the driver after completion
        // driver.quit();
    }
}
