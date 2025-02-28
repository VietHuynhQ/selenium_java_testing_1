package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Custom_Dropdown {

    WebDriver driver;

    WebDriverWait explicitWait;

    @BeforeClass
    public void initialBrowser() {


        driver = new FirefoxDriver();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
        public void TC_1_() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        // 1 chờ cho dropdown có thể thao tác lên được
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span#speed-button>span.ui-selectmenu-icon")));
        // 2 click vào element nào để nó xở cái dropdown ra
        driver.findElement(By.cssSelector("span#speed-butto")).click();
        Thread.sleep(2000);

        // 3 chờ cho tất cả các item được load ra
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#speed-menu>li>div")));

        // 4 tìm cái item đúng với mong đợi

        List<WebElement> allItem = driver.findElements(By.cssSelector("ul#speed-menu>li>div"));

        // 5 click lên item đó
            for (WebElement item : allItem) {
                if(item.getText().equals("Faster")) {
                    item.click();
                    break;
                }

            }
        }
    @Test
    public void TC_2_() {

    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
