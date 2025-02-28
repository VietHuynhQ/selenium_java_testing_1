package javaSDET;

import org.testng.annotations.Test;

import java.util.Random;

public class Topic_3_Random {
    String prefixEmail = "joebiden";

    String postEmail = "@gmail.com";

    @Test
    public  void textEmail() {
        Random random = new Random();

        String fullName = prefixEmail + random.nextInt(9999) + postEmail;

        System.out.println(fullName);

    }
}
