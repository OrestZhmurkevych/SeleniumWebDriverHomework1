package webdrivertest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WebDriverTest {

    private static Logger logger = LogManager.getLogger("WebDriverTest");

    @Test
    public void browserTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Apple");
        element.submit();
        (new WebDriverWait(driver, 10)).until((dr) -> dr.getTitle().toLowerCase().startsWith("apple"));
        logger.info("The page title is: " + driver.getTitle());
        element = driver.findElement(By.xpath("//*[text() = 'Зображення']"));
        element.click();
        Assert.assertNotNull(driver.findElement(By.cssSelector("div[aria-selected='true']")));
        logger.info("Images tab is opened");
        driver.quit();
    }
}
