package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24_Shadow_DOM {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
        public void TC_1_Github() {
        driver.get("https://automationfc.github.io/shadow-dom/");

        // Thuôc DOM cha bên ngoài
        driver.findElement(By.xpath("//a[@href='scroll.html']"));

        // Element chứa Shadow host
        WebElement shadowHostParent = driver.findElement(By.cssSelector("div#shadow_host"));

        // Lấy ra element shadow Root
        SearchContext firstShadow = shadowHostParent.getShadowRoot();

       Assert.assertTrue(firstShadow.findElement(By.cssSelector("input[type='file']")).isDisplayed());

        Assert.assertEquals(firstShadow.findElement(By.xpath("//span[@class='info']")).getText(), "some text");

        // Element chứa Shadow host thu 2
        WebElement firstshadowHostParent = driver.findElement(By.cssSelector("div#nested_shadow_host"));

        // Lấy ra element shadow Root
        SearchContext secondShadow = firstshadowHostParent.getShadowRoot();

        Assert.assertEquals(secondShadow.findElement(By.cssSelector("div#nested_shadow_content>div")).getText(), "nested text");

        Assert.assertTrue(firstShadow.findElement(By.xpath("//a[text()='nested scroll.html']")).isDisplayed());

        driver.findElement(By.xpath("//a[text()='scroll.html']"));


        }
    @Test
    public void TC_2_Book() {
        driver.get("https://books-pwakit.appspot.com/");



        WebElement firstShadowElement =  driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"));
        SearchContext firstShadowHost = firstShadowElement.getShadowRoot();

        WebElement secondShadowElement = firstShadowHost.findElement(By.cssSelector("book-input-decorator"));
        SearchContext secondShadowHost = secondShadowElement.getShadowRoot();


        firstShadowHost.findElement(By.cssSelector("input#input")).sendKeys("Harry Poster");

        secondShadowHost.findElement(By.cssSelector("div.icon")).click();



        WebElement thirdShadowElement = firstShadowHost.findElement(By.cssSelector("book-explore"));
        SearchContext thirdShadowHost = thirdShadowElement.getShadowRoot();

        WebElement forthShadowElement = thirdShadowHost.findElement(By.cssSelector("ul>li:ntn-of-type(1)>book-item"));
        SearchContext forthShadowHost = forthShadowElement.getShadowRoot();

        Assert.assertEquals(forthShadowHost.findElement(By.cssSelector("h2.title")).getText(), "Harry Potter and the Sorcerer's Stone");


    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
