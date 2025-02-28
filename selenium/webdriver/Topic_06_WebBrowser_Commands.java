package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrowser_Commands {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
//        driver = new EdgeDriver();
//        driver = new ChromeDriver();
//        driver = new SafariDriver();
//        driver = new InternetExplorerDriver();

        // đóng tab driver đang đúng
        driver.close();
        // thoát khỏi tab
        driver.quit();

        // Lấy ra toàn bộ source code HTML
        driver.getPageSource();

        // lấy ra title của page hiện tại
        // 1- lưu dữ liệu lại rồi kiểm tra sau
        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle, "nopCommerce demo store");
        Assert.assertTrue(homePageTitle.contains("demo store"));

        // 2- Kiểm tra dữ liệu
        // Kiểm tra tương đối
        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");

        // Lấy ra URL của page hiện tại
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/cart");

        // Lấy ra page source code
        String HomePageSourceCode = driver.getPageSource();

        // kiểm tra tương đối
        Assert.assertTrue(HomePageSourceCode.contains("Conditions od Use"));

        // Lấy ra ID của tab/window đang active
        driver.getWindowHandle();

        // Lấy ra tất cả ID của tất cả các tab/window đang
        driver.getWindowHandles();

        // Đi tìm 1 element
        driver.findElement(By.xpath(""));

        // Đi tìm n element
        driver.findElements(By.xpath(""));

        // Selenium 3
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // Selenium 4
        // Dùng để chờ cho việc để tìm element (findElement/ findElements)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Dùng để chờ cho việc load page
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        // Dùng để chờ cho 1 đoan script được thưc thi xong ( JS )
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));

        // Thu nhỏ taskbar để chay
        driver.manage().window().minimize();

        // Phóng to lên ( có taskbar )
        driver.manage().window().maximize();

        // Tràn màn hình ( ko có taskbar )
        driver.manage().window().fullscreen();

        // Responsive
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().window().getSize();

        driver.manage().window().setPosition(new Point(0,0));

        driver.manage().window().getPosition();

        // Lấy hết tất cả cookie
      Set<Cookie> cookies = driver.manage().getCookies();

        driver.manage().getCookieNamed("Namecookie");

        // Xoá hết cookie
        driver.manage().deleteAllCookies();

        //
        for (Cookie cookie : cookies)
        {
            // Xoá cookie theo thứ tự
            driver.manage().deleteCookie((Cookie) cookies);
        }

        // Xoá cookie theo tên
        driver.manage().deleteCookieNamed("Namecookie");

//
        for (Cookie cookie : cookies)
        {
            // Add cookie theo thứ tự
            driver.manage().addCookie((Cookie) cookies);
        }
        driver.navigate().refresh();

        WebDriver.Navigation navigation = driver.navigate();

        // F5
        navigation.refresh();

        // QUay lại trang trước
        navigation.back();

        // Chuyển tiếp trang trước đó
        navigation.forward();

        // Mở URL
        navigation.to("https://demo.nopcommerce.com/computers");

        // Alert / Iframe / Window (tab)
        WebDriver.TargetLocator targetLocator = driver.switchTo();

        // Alert
        targetLocator.alert().accept();
        targetLocator.alert().dismiss();

        // Iframe
        targetLocator.frame("");
        targetLocator.defaultContent();

        //Windows
        targetLocator.window("");


    }


    @AfterClass
    public void cleanBrowser () {
        driver.quit();
    }

}
