package LFindElement;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

public class interview_question {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        List<String> pincodes = List.of("400001", "560001", "110001");

        try {
            for (String pincode : pincodes) {
                System.out.println("\n--- Processing Pincode: " + pincode + " ---");
                
                Thread.sleep(2000);
                driver.get("https://www.naturesbasket.co.in/Online-grocery-shopping/Fruits-Vegetables/31_0_0");
                wait.until(ExpectedConditions.titleContains("Fruits & Vegetables"));

                // Wait for and close popup if shown
                closePopupIfPresent(driver);

                // Ensure popup not visible before clicking
                try {
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divPagePopupBackGound")));
                } catch (Exception ignored) {}

                // Enter pincode
                WebElement pincodeTrigger = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[contains(@class, 'servicablepin')]")));
                pincodeTrigger.click();

                WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.id("txt")));
                searchBar.clear();
                searchBar.sendKeys(pincode);
                searchBar.sendKeys(Keys.ENTER);

                WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAddPin")));
                addBtn.click();

                System.out.println("Pincode " + pincode + " submitted.");
                Thread.sleep(3000);

                // Scroll to bottom to load all products
                JavascriptExecutor js = (JavascriptExecutor) driver;
                long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

                while (true) {
                    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                    Thread.sleep(2000);
                    long newHeight = (long) js.executeScript("return document.body.scrollHeight");
                    if (newHeight == lastHeight) break;
                    lastHeight = newHeight;
                }

                // Get product elements
                List<WebElement> products = driver.findElements(By.xpath(
                        "//div[@class='source_Class']//*[contains(@class, 'divOuterStructure_Search') and contains(@class, 'pro-id')]"));

                System.out.println("Total products: " + products.size());

                for (int i = 0; i < products.size(); i++) {
                    WebElement product = products.get(i);
                    String productUrl = product.findElement(By.tagName("a")).getAttribute("href");

                    System.out.println("Opening product " + (i + 1) + ": " + productUrl);
                    js.executeScript("window.open(arguments[0])", productUrl);

                    List<String> tabs = new java.util.ArrayList<>(driver.getWindowHandles());
                    driver.switchTo().window(tabs.get(1));
                    Thread.sleep(2000);
                    int availability = 0;
                    String productName="";
                    String quantity = "NA";
                    String price="";
                    try {
                        WebElement productNameElem = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//div[@class='pro-title-fav flat-div']")));
                        String fullName = productNameElem.getText().trim();

                        productName = fullName;
                        

                        // Extract quantity if available
                        Pattern pattern = Pattern.compile("^(.*?)(\\(.*?\\)|\\b\\d+\\s?(g|G|gm|Gm|Kg|KG|ml|ML|L|l|pcs?|Pcs?|Pc)\\b.*)$");
                        Matcher matcher = pattern.matcher(fullName);

                        if (matcher.find()) {
                            productName = matcher.group(1).trim();
                            quantity = matcher.group(2).trim();
                        } else {
                            try {
                                WebElement qtyElem = driver.findElement(By.xpath("(//h1[@class='pd_Title'])[2]"));
                                quantity = qtyElem.getText().trim();
                            } catch (Exception ignore) {
                                // Leave quantity as "NA"
                            }
                        }
                        if(quantity=="NA") {
                        	System.out.println("if block NA");
                        	System.out.println("nothing: availability = 0");
                        	price = "NA";
                        }else {

                        WebElement priceElem = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//div[contains(@class, 'productlist-price')]//span[contains(@class, 'search_PSelling')]")));
                         price = priceElem.getText().trim();
                        }
                        // Availability: 1 = available, 0 = sold out/notify
                        
                        try {
                            WebElement btn = driver.findElement(By.id("btnAddToCartProductDetail"));
                            if (btn!=null & btn.isDisplayed() && btn.isEnabled()) {
                            	
                                availability = 1;
                            }else {availability = 0;}
                            
                            	
                            	
                        } catch (NoSuchElementException e) {
                        	System.out.println("Inner catch:");
                            availability = 0;
                        
                        }

                        System.out.println("Name: " + productName);
                        System.out.println("Qty: " + quantity);
                        System.out.println("Price: " + price);
                        System.out.println("Availability: " + availability);
                        System.out.println("................................................");

                    } catch (Exception e) {
                    	availability=0;

                        System.out.println("Name: " + productName);
                        System.out.println("Qty: " + quantity);
                        System.out.println("Price: " + price);
                        System.out.println("Availability: " + availability);
                        System.out.println("................................................");

                        System.out.println("Failed to extract product details for item " + (i + 1));
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

    // Method to close popup if present
    private static void closePopupIfPresent(WebDriver driver) {
        try {
            WebDriverWait popupWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement popupOverlay = popupWait.until(ExpectedConditions.presenceOfElementLocated(By.id("divPagePopupBackGound")));

            if (popupOverlay.isDisplayed()) {
                System.out.println("Popup detected. Attempting to close...");

                // Use JavaScript to click it
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", popupOverlay);

                popupWait.until(ExpectedConditions.invisibilityOf(popupOverlay));
                Thread.sleep(1000); // Let UI settle

                System.out.println("Popup closed successfully.");
            }
        } catch (TimeoutException e) {
            System.out.println("Popup not shown (timeout).");
        } catch (Exception e) {
            System.out.println("Popup close error: " + e.getMessage());
        }
    }
}
