package pages;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public void assertURL(String expectedURL) {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals("Error: The current URL does not match the expected URL.", expectedURL, currentURL);
        System.out.println("URL assertion passed: " + currentURL);
    }

    public static void nagivateTo(String url) {
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.quit();
    }

    private WebElement Findxpaht(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
    }

    public boolean elementDisplayed(String locator) {
        return Find(locator).isDisplayed();
    }

    public boolean elementDisplayedXpath(String locator) {
        return Findxpaht(locator).isDisplayed();
    }

    public void clickElement(String locator) {
        Find(locator).click();
    }

    public void clickElementByXpath(String locator) {
        Findxpaht(locator).click();
    }

    public void write(String locator, String keysTosend) {
        Find(locator).clear();
        Find(locator).sendKeys(keysTosend);
    }

    public static void scrollUntilTextVisible(String text, int maxScrolls) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int scrolls = 0;

        while (scrolls < maxScrolls) {
            if (driver.getPageSource().contains(text)) {
                return;
            }

            js.executeScript("window.scrollBy(0, window.innerHeight);");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            scrolls++;
        }
    }

    public void scrollAndCaptureText() {
        try {
            Set<String> printedTexts = new HashSet<>();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            long lastHeight = (long) js.executeScript("return document.body.scrollHeight");
            boolean scrolling = true;
            int maxRetries = 3;
            int retries = 0;

            while (scrolling) {
                List<WebElement> elements = wait.until(
                        ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[class*='heading-4']")));

                for (WebElement element : elements) {
                    String text = element.getText().trim();
                    if (!text.isEmpty() && !printedTexts.contains(text)) {
                        System.out.println("Texto encontrado: " + text);
                        printedTexts.add(text);
                    }
                }

                js.executeScript("window.scrollBy(0, document.body.scrollHeight / 2);");
                Thread.sleep(2000);

                long newHeight = (long) js.executeScript("return document.body.scrollHeight");

                if (newHeight == lastHeight) {
                    retries++;
                    if (retries >= maxRetries) {
                        scrolling = false;
                    }
                } else {
                    retries = 0;
                }

                lastHeight = newHeight;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
