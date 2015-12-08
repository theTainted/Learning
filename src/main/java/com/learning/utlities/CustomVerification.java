package com.learning.utlities;

import com.thoughtworks.selenium.SeleneseTestBase;

/**
 * Created by Syam on 12-10-2015.
 */
public class CustomVerification extends SeleneseTestBase {
    private StringBuffer verificationErrors;

    private CustomVerification(){
        verificationErrors = new StringBuffer();
    }
}
