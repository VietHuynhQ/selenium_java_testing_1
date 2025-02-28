package javaSDET;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_04_Wait {
    WebDriver driver;

    WebDriverWait explicitWait;

    FluentWait<WebDriver> fluentWait;

    @BeforeClass
    public  void initialBrowser() {
        driver = new FirefoxDriver();
        // Explicit Wait
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Fluent wait
        fluentWait = new FluentWait<WebDriver>(driver);


    }

    @Test
    public void TC_1_ (){
     // List<WebElement> allItems = driver.findElements(By.cssSelector(""));

        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        fluentWait = new FluentWait<WebDriver>(driver);
    }


}
