package com.learning.functions;

import java.util.ResourceBundle;

/**
 * Created by Syam on 13-10-2015.
 */
public class testClass {
    public static void main(String[] args) {

        ResourceBundle r = ResourceBundle.getBundle("src.Bundles.TestData_en_IN");
        System.out.println(r);

        String signInID = r.getString("emailId");
        System.out.println(signInID);
    }
}