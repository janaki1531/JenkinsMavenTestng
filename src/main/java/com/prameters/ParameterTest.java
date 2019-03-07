package com.prameters;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class ParameterTest extends MethodsforGmail {
	
	
	public static String sheetName = "Sheet1";

	@DataProvider(name="janaki")
	public Object[][] Reading() {

		return ExcelFileReading1.excelReading(sheetName);
	}
	
	@BeforeMethod(alwaysRun = true)
	@Parameters({"browser","url"})
	
	public static void setup(String browser, String url) throws Throwable {
		MethodsforGmail.setup(browser, url);

	}


	@Test(priority=1,dataProvider ="janaki",groups= {"functionalTesting"})
	

	public void username(String userName, String password) throws Throwable {
         System.out.println("testcase1" +Thread.currentThread().getId());
         MethodsforGmail.usernameMethod(userName, password);
         MethodsforGmail.compose();
         WebElement newmessage= driver.findElement(By.xpath(" //div[@class='aYF']"));
        String actual = newmessage.getText();
        String expected ="New Message";

           Assert.assertEquals(actual, expected);
         
      
         
       /*  String a ="Skip Test";
         if(a.equals("Skip Test")){
        	
         throw new SkipException("Skipping - This is not ready for testing ");
         }else{
        	 MethodsforGmail.compose();
         System.out.println("I am in else condition"); 
        
         }*/
        
     }
		
		
		
	

	@Test(dataProvider ="janaki",dependsOnMethods="username",groups = { "smokeTest", "functionalTesting" })

	public void compose(String userName,String password) throws Throwable {
	    System.out.println("testcase2" +Thread.currentThread().getId());       
		MethodsforGmail.usernameMethod(userName, password);
		
	}

	@AfterMethod(alwaysRun = true)
	public void teardownTest() {
		MethodsforGmail.teardown();	}
}
