package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_27_Wait_FindElement {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
//  Total time = 13
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));

    }

    @Test
        public void TC_1_FindElement() {
        driver.get("https://demo.nopcommerce.com/register");

        // 1 -  Nếu tìm thấy duy nhất 1 element

        // Trả về đúng element
        // Không cần chờ hết time của implicit

        driver.findElement(By.cssSelector("input#FirstName"));

        // 2 - Nếu tìm thấy nhiều element
        // Chỉ thao tác với element đầu tiên
        // Lưu ý là khi lấy  locator nên check trước
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Testing");

        // 3 - Nếu Không tìm thấy element nào
        // Mới đầu vào findelement nhưng không thấy:
        // Tìm lại mà thấy element thì không cần chờ hết tổn time còn lại
        // Hết tổng time mà tìm lại không thấy thì đánh  fail testcase
        // Show lỗi : NoSuchElementException
        driver.findElement(By.cssSelector("input#Selenium"));


        }
    @Test
    public void TC_2_FindElements() {
        List<WebElement> elements = null;
        // 1 -  Nếu tìm thấy duy nhất 1 element
        // Trả về đúng 1 cái
        elements = driver.findElements(By.cssSelector("input#FirstName"));
        System.out.println(elements.size());


        // 2 - Nếu tìm thấy nhiều element
        // Trả về hết toàn bộ element matching
        elements = driver.findElements(By.cssSelector("input[type='text']"));
        System.out.println(elements.size());


        // 3 - Nếu Không tìm thấy element nào
        // Mới đầu vào findelement nhưng không thấy:
        // Tìm lại mà thấy element thì không cần chờ hết tổng time còn lại
        // Tìm lại và không thấy và hết tổng time 13s thì :
        // Trả về List element = 0
        // Không đánh fail testcase
        elements = driver.findElements(By.cssSelector("input#RememberMe"));
        System.out.println(elements.size());


    }
    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
