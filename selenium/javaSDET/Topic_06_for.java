package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Topic_06_for {
    public static void main(String[] args) {
        int number = 100;
        // for
        for(int i = 0; i < number ; i++) {
            System.out.println(i);
        }

        // List /Set /Queue /Map
        List<String> name = new ArrayList<String>();
        name.add("A");
        name.add("B");
        name.add("C");

        // for-each
        for(String a : name) {
            if(a.equals("A")){
                System.out.println(a);
            };
        }


        int i = 0;
        // do-while
        do {
            System.out.println(i);
            i++;
        }
        while (i < number);

        //while

        while( i < number) {
            System.out.println(i);
            i++;
        }


    }
}
