package com.learning.tests;

import com.learning.functions.DB;
import org.testng.annotations.Test;

/**
 * Created by Syam on 23-10-2015.
 */
public class TrailTestCases {
    @Test
    public void testingDBMethods() throws Exception {
        DB.GetData("login", "TestCase", "Search", "searchTerm");
    }
}
