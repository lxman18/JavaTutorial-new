package LFindElement;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

public class naturebasket {
   
	public static void main(String[] args) {
	    ChromeOptions options = new ChromeOptions();
	    options.setPageLoadStrategy(PageLoadStrategy.EAGER);
	    WebDriver driver = new ChromeDriver(options);

	    driver.manage().window().maximize();
	    WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));

	    // Define multiple pincodes
	    List<String> pincodes = List.of("400001", "560001", "110001");

	    try {
	        for (String pincode : pincodes) {
	            System.out.println("Opening website for pincode: " + pincode);
	            driver.get("https://www.naturesbasket.co.in/Online-grocery-shopping/Fruits-Vegetables/31_0_0");
	            wait.until(ExpectedConditions.titleContains("Fruits & Vegetables"));

	            // ESC to dismiss popup
	            driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
	            Thread.sleep(1000);

	            // Enter pincode
	            WebElement pincodeTrigger = wait.until(ExpectedConditions.elementToBeClickable(
	                    By.xpath("//input[contains(@class, 'servicablepin')]")));
	            pincodeTrigger.click();

	            WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.id("txt")));
	            searchBar.clear();
	            searchBar.sendKeys(pincode);
	            searchBar.sendKeys(Keys.ENTER);
	            Thread.sleep(500);
	            WebElement searchBar1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAddPin")));
	            searchBar1.click();

	            System.out.println("Pincode " + pincode + " submitted successfully!");
	            Thread.sleep(3000);

	            // Scroll to load all products
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

	            while (true) {
	                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	                Thread.sleep(2000);
	                long newHeight = (long) js.executeScript("return document.body.scrollHeight");
	                if (newHeight == lastHeight) break;
	                lastHeight = newHeight;
	            }

	            // Get all product tiles
	            List<WebElement> products = driver.findElements(By.xpath("//div[@class='source_Class']//*[contains(@class, 'divOuterStructure_Search') and contains(@class, 'pro-id')]"));
	            System.out.println("Total products for pincode " + pincode + ": " + products.size());

	            for (int i = 0; i < products.size(); i++) {
	                WebElement product = products.get(i);
	                String clickLink = product.findElement(By.tagName("a")).getAttribute("href");
	                System.out.println("Product " + (i + 1) + " URL: " + clickLink);

	                // Open in new tab
	                js.executeScript("window.open(arguments[0])", clickLink);
	                List<String> tabs = new java.util.ArrayList<>(driver.getWindowHandles());
	                driver.switchTo().window(tabs.get(1));

	                Thread.sleep(2000);

	                try {
	                    WebElement productNameElem = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                            By.xpath("//div[@class='pro-title-fav flat-div']")));
	                    String fullProductName = productNameElem.getText();
	                    String quantity = "";
	                    String productNameClean = fullProductName;

	                    Pattern pattern = Pattern.compile("^(.*?)(\\(.*?\\)|\\b\\d+\\s?(g|G|gm|Gm|Kg|KG|ml|ML|L|l|pcs?|Pcs?|Pc)\\b.*)$");
	                    Matcher matcher = pattern.matcher(fullProductName);

	                    if (matcher.find()) {
	                        productNameClean = matcher.group(1).trim();
	                        quantity = matcher.group(2).trim();
	                    } else {
	                        try {
	                            WebElement fallbackQtyElem = driver.findElement(By.xpath("(//h1[@class='pd_Title'])[2]"));
	                            quantity = fallbackQtyElem.getText().trim();
	                        } catch (Exception innerEx) {
	                            quantity = "NA";
	                        }
	                    }

	                    System.out.println("Name: " + productNameClean);
	                    System.out.println("Qty: " + quantity);

	                    WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                            By.xpath("//div[contains(@class, 'productlist-price')]//span[contains(@class, 'search_PSelling')]")));
	                    System.out.println("Price: " + price.getText());

	                    int availability = 0;
	                    List<WebElement> addToCartBtn = driver.findElements(By.xpath("//div[@id='btnAddToCartProductDetail']"));
	                    if (!addToCartBtn.isEmpty()) {
	                        availability = 1;
	                    }
	                    System.out.println("Availability: " + availability);

	                } catch (Exception e) {
	                    System.out.println("Details not found for product " + (i + 1));
	                }

	                driver.close();
	                driver.switchTo().window(tabs.get(0));
	                Thread.sleep(1000);
	            }
	        }

	    } catch (Exception e) {
	        System.out.println("Something went wrong: " + e.getMessage());
	    } finally {
	        System.out.println("Closing browser...");
	        driver.quit();
	    }
	}

}
