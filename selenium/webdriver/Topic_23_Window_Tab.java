package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_23_Window_Tab {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
        public void TC_1_Windows_tab() throws InterruptedException {
            driver.get("https://automationfc.github.io/basic-form/index.html");

            // Lấy ra ID của tab/window đang active
            String githubWindowID = driver.getWindowHandle();


         driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
         Thread.sleep(3000);


        switchToWindowByTitle("Facebook - log in or sign up");
        // Quay ve github
        switchToWindowByTitle("Selenium WebDriver");


        closeAllWindowWithoutParent(githubWindowID);

    }

    private void closeAllWindowWithoutParent(String githubWindowID) throws InterruptedException {
        Set<String> allWindowIDs = driver.getWindowHandles();
        // dùng vòng lập duyệt  từng ID một
        for(String id : allWindowIDs){
            if(!id.equals(githubWindowID)){
                driver.switchTo().window(id);
                Thread.sleep(2000);
                driver.close();
            }
        }
        driver.switchTo().window(githubWindowID);
    }

    private void switchToWindowByTitle(String expectedPageTitle) throws InterruptedException {
        // Lấy ra hết tất cả các id của window or tab hiện tại
        Set<String> allWindowIDs = driver.getWindowHandles();
        // dùng vòng lập duyệt  từng ID một
        for(String id : allWindowIDs){
            // mỗi lần duyệt sẽ cho nó switch vào trước
            driver.switchTo().window(id);
            Thread.sleep(2000);
            // Get ra title của window/ tab hiện tại
            String pageTitle = driver.getTitle();

            // kiểm tra title
            if(pageTitle.equals(expectedPageTitle)) {
                break;
            }
        }
    }

    private void switchToWindowByID(String WindowId) {
        // Lấy ra hết tất cả các id của window or tab hiện tại
        Set<String> allWindowIDs = driver.getWindowHandles();
        // dùng vòng lập duyệt  từng ID một
        for(String id : allWindowIDs){
            // Kiểm tra điều kiện: nếu ID nào mà khác với ID mong đợi thì switch qua
            if(!id.equals(WindowId)) {
                driver.switchTo().window(id);
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
