package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class Topic_30_Explicit_Funtions {
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        explicitWait =new WebDriverWait(driver, Duration.ofSeconds(10));
       // explicitWait =new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(300));

    }

    @Test
        public void TC_1_() {
        // Wait cho element ko hiển thị ko còn trong HTML (Trước đó có tần tại)
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));

        // Wait cho element ko hiển thị (còn / ko còn trong HTML)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        // Wait cho element được hiển thị (phải có trong HTML/ có trong UI)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));

        // Wait cho element được phép click (button/ link/ radio....)
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));

        // Wait cho url của page tuyêt đối
        explicitWait.until(ExpectedConditions.urlToBe("https://automationfc.github.io/dynamic-loading/"));

        // Wait cho url của page tương đối
        explicitWait.until(ExpectedConditions.urlContains("dynamic-loading"));

        // Wait cho url của page thoả mãn biểu thức (Regex)
        explicitWait.until(ExpectedConditions.urlMatches("*$^"));

        // Wait cho 1 đoạn JS trả về kiểu dữ liệu String
        explicitWait.until(ExpectedConditions.jsReturnsValue("return arguments[0].validationMessage;"));

        // Wait cho cái Alert xuất hiện trong HTML
        explicitWait.until(ExpectedConditions.alertIsPresent());

        // Wait cho title của page tuyệt đối
        explicitWait.until(ExpectedConditions.titleIs("Dynamically Loaded Page Elements"));

        // Wait cho title của page tương đối
        explicitWait.until(ExpectedConditions.titleContains("Dynamically loaded"));

        // Wait thoả mãn 2 điều kiện (AND)
        explicitWait.until(ExpectedConditions.and(
                ExpectedConditions.urlContains(""), ExpectedConditions.titleIs("")));

        // Wait thoả mãn 1 trong 2 điều kiện (OR)
        explicitWait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains(""), ExpectedConditions.titleIs("")));

        // Wait cho 1 element có xuất hiện trong HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        // Wait cho 1 elemetn có thuộc tính chứa 1 giá trị nào đó
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector(""), "class", "email"));

        // Wait cho 1 elemetn có thuộc tính chứa 1 giá trị nào đó
        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector(""), "class", "email"));

        // Wait cho 1 elemetn có thuộc tính ko được rỗng / null
        explicitWait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.cssSelector("")), "email"));

        // Wait cho 1 elemetn có thuộc tính ở trong DOM bằng giá trị nào đó
        explicitWait.until(ExpectedConditions.domAttributeToBe(driver.findElement(By.cssSelector("")),
                "baseURI","https://automationfc.github.io/dynamic-loading/"));

        explicitWait.until(ExpectedConditions.domPropertyToBe(driver.findElement(By.cssSelector("")),
                "innerText","Start"));

        // Wait cho 1 element đã được chọn thành công (checkbox / radio / dropdown..)
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));

        // Wait cho 1 element đã được chọn thành công
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""), true));
        // Wait cho 1 element đã được chọn ko thành công
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""), false));

        // Wait cho frame/ iframe xuất hiện và switch
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("")));

        // Wait cho 1 đoạn JS được thực thi và không trả về Exption
        explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("return arguments[0].validationMessage;"));

        // Wait đinh lại điều wait
        explicitWait.until(ExpectedConditions.not(ExpectedConditions.javaScriptThrowsNoExceptions("return arguments[0].validationMessage;")));

        // Wait cho 1 list element bằng bao nhiêu item
        List<WebElement> allNumberSelected = explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("ol#selectable>li.ul-selected"), 6 ));

        explicitWait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("ol#selectable>li.ul-selected"), 7));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("ol#selectable>li.ul-selected"), 5));

        // Wait cho số lượng window/ tab bằng bao nhiêu
        explicitWait.until(ExpectedConditions.numberOfWindowsToBe(3));

        // Wait cho 1 đoạn text bằng tuyêt đối
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector(""), ""));

        explicitWait.until(ExpectedConditions.textMatches(By.cssSelector(""),  Pattern.compile("a*b")));

        // Wait cho 1 element hay bị change / refresh lại / update lại
        explicitWait.until(ExpectedConditions.refreshed(ExpectedConditions.numberOfWindowsToBe(3)));


    }
    @Test
    public void TC_2_() {

    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
