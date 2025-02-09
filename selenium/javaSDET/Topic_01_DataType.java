package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Topic_01_DataType {
    // 1 Kiểu dữ liệu nguyên thuỷ
    // char : ký tự

    // Cách khai báo
    //  Access Modifier: phạm vi truy cập ( private/ public / projected / default )
    // Cách 1. Access Modifier + Kiểu dữ liệu + Tên Biến + Giá trị của biến ( Ngoài hàm / Trong hàm đều được )

    public char cName = 'b';

    // Cách 2.1. Access Modifier + Kiểu dữ liệu + Tên Biến

    private char cAddress;

    // Cách 2.2. Tên Biến + Giá trị gán  (Hàm)

    public void clickToElement() {
        char cAddress = 'c';

        char cCity = 'b';
    }

    // byte/ short/ int/ long : số nguyên
    // float/ double : số thực
    // boolean : logic


    // 2 Kiểu dữ liệu tham chiếu
    // String
    // Class
    FirefoxDriver fDriver = new FirefoxDriver();

    Actions actions = new Actions(fDriver);

    Topic_01_DataType topic01 = new Topic_01_DataType();

    WebDriver driver;

    // Array
        String[] studentName = {"Huynh","Quoc","Viet"};
    // List / Set / Queue
        List<String> studentAddress = new ArrayList<String>();
    // Map
        Map<String, Integer> zip = new HashMap<String, Integer>();
    // Object
        Object name = "Nam";
    Object phone = 1231312;
    Object isDisplayed = true;



}
