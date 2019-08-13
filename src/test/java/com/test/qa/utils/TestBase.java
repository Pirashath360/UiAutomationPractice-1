package com.test.qa.utils;


import java.lang.reflect.Method;
import java.net.MalformedURLException;



import com.test.qa.pageobjects.utils.PageBase;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

/**
 * TestBase.java - class to verify TestBase Page functions
 * Created by SrirankanK on 10/3/2018.
 */
public class TestBase {
	public SoftAssert softAssert;
	
	private static final Logger LOGGER = Logger.getLogger(TestBase.class);
	@BeforeSuite
			public void beforesuit(){
		System.out.println("pirashath");
	}

	@BeforeTest
    public void beforeTest() {
        System.out.println("Test Running " + this.getClass().toString());
    }
    @BeforeClass
	public void beforeclass(){
		System.out.println("nivethana loosu");
	}
	
	@BeforeMethod
	public void loadBrowser() {
		LOGGER.info("Initiate Browser");
		try {
			PageBase.initiateDriver();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		LOGGER.info("Browser Initiated");
	}
	
	@BeforeMethod
    public void beforeMethod() { 
		softAssert = new SoftAssert(); 
	}

    @BeforeMethod
    public void nameBefore(Method method) {
        LOGGER.info("Test name: " + method.getName());
    }
    
    @AfterMethod
	public void closeBrowser() {
    	LOGGER.info("Closing Browser");
		PageBase.closeDriver();
		LOGGER.info("Browser Closed");
	}

    @AfterMethod
    public void afterMethod(Method method, ITestResult result) {
        LOGGER.info("Executed test case name:" + method.getName() + " Execution Results : " + result.toString());
    }
}
