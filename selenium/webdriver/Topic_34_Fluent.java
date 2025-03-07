package webdriver;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_34_Fluent {
    WebDriver driver;
    WebDriverWait explicitWait;

    //FluentWait<T> : T là kiểu dữ liệu
    FluentWait<WebDriver> driverFluentWait;
    FluentWait<WebElement> elementFluentWait;
    FluentWait<String> stringFluentWait;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driverFluentWait = new FluentWait<>(driver);
    }

    @Test
        public void TC_1_Dynamic_loading1() {
        driver.get("https://automationfc.github.io/dynamic-loading/");

        findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(getElementText(By.cssSelector("div#finish>h4")), "Hello World!");

        }
    @Test
    public void TC_1_Dynamic_loading2() {
        driver.get("https://automationfc.github.io/dynamic-loading/");

        findElement(By.cssSelector("div#start>button")).click();

        Assert.assertTrue(isElementDisplayed(
                By.xpath("//div[@id='finish']//h4[text()='Hello World!']")));
    }

    @Test
    public void TC_2_CountDown() {
        driver.get("https://automationfc.github.io/fluent-wait/");

        WebElement countDownTime = findElement(By.id("javascript_countdown_time"));

        Assert.assertTrue(isSecondMatching(countDownTime));

    }


    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

    // Viết 1 hàm để tìm element vs timeout / polling tự sét
    // Điều kiện của hàm sẽ là findelement : kiểu trả về của hàm apply
    // findelement thì cần có driver : tham số của hàm apply

    public WebElement findElement( By by) {
        FluentWait<WebDriver> driverFluentWait = new FluentWait<>(driver);

        driverFluentWait.withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofMillis(100))
            .ignoring(NoSuchElementException.class);

       return driverFluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
    }


    // Kiểm tra 1 element hiển thị
    // isDisplayed = boolean
    public boolean isElementDisplayed( By by) {
        FluentWait<WebDriver> driverFluentWait = new FluentWait<>(driver);

        driverFluentWait.withTimeout(Duration.ofSeconds(10))

                .pollingEvery(Duration.ofMillis(100))

                .ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElement(by).isDisplayed();
            }
        });
    }

    public boolean isElementDisplayed( WebElement element) {
    FluentWait<WebElement> driverFluentWait = new FluentWait<>(element);

        driverFluentWait.withTimeout(Duration.ofSeconds(10))

                .pollingEvery(Duration.ofMillis(100))

            .ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebElement, Boolean>() {
        @Override
        public Boolean apply(WebElement element) {
            return element.isDisplayed();
        }
    });
}

    // Lấy ra 1 text của
    // getText String

    public String getElementText( By by) {
        FluentWait<WebDriver> driverFluentWait = new FluentWait<>(driver);

        driverFluentWait.withTimeout(Duration.ofSeconds(10))

                .pollingEvery(Duration.ofMillis(100))

                .ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebDriver, String >() {
            @Override
            public String apply(WebDriver driver) {
                return driver.findElement(by).getText();
            }
        });
    }


    public boolean isSecondMatching( WebElement element) {
        FluentWait<WebElement> driverFluentWait = new FluentWait<>(element);

        driverFluentWait.withTimeout(Duration.ofSeconds(13))

                .pollingEvery(Duration.ofMillis(50)) // 1 giay kiem tra 5 lan

                .ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement element) {
                return element.getText().endsWith("00");
            }
        });
    }
}
