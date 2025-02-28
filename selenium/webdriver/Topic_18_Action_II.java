package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_18_Action_II {
    WebDriver driver;
    Actions action;
    String osName = System.getProperty("os.name");
    Keys keys;


    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


        action = new Actions(driver);

        keys = osName.startsWith("Windows") ?  Keys.CONTROL : Keys.COMMAND;
    }

    @Test
        public void TC_1_Click_And_Hole() throws InterruptedException {

        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allNumber = driver.findElements(By.cssSelector("ol>li.ui-state-default"));

        Assert.assertEquals(allNumber.size(), 20);

        action.clickAndHold(allNumber.get(0)).moveToElement(allNumber.get(3)).release().perform();

        Thread.sleep(2000);

        List<WebElement> allNumberSelected = driver.findElements(By.cssSelector("ol>li.ui-selected"));

        Assert.assertEquals(allNumberSelected.size(), 4);

    }
    @Test
    public void TC_2__Click_And_Hole_Random() {

        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allNumber = driver.findElements(By.cssSelector("ol>li.ui-state-default"));

        Assert.assertEquals(allNumber.size(), 20);

        // nhan phim ctrl xuong ( chua nha ra)
        action.keyDown(keys).perform();

        action.click(allNumber.get(0));
        action.click(allNumber.get(3));
        action.click(allNumber.get(7));
        action.click(allNumber.get(10));
        action.click(allNumber.get(13));
        action.click(allNumber.get(17));

        // nhã phim ctrl ra ( chua nha ra)
        action.keyUp(keys).perform();
        List<WebElement> allNumberSelected = driver.findElements(By.cssSelector("ol>li.ui-selected"));

        Assert.assertEquals(allNumberSelected.size(), 6);

    }

    @Test
    public void TC_03_Douple_click() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");

    }

    @Test
    public void TC_04_Right_click() throws InterruptedException {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        // Click chuột phải
        action.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();

        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());

        // hover
        action.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();
        Thread.sleep(3000);

       Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-visible.context-menu-hover")).isDisplayed());

        // Click quit
        action.click(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();
        Thread.sleep(3000);

        driver.switchTo().alert().accept();

        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());

    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
