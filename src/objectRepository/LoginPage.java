/*******************************************************************************
 * © Copyright (C) 2019 Selenium Project @Surya.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package objectRepository;

import java.util.Properties;

import org.openqa.selenium.WebElement;

import utilities.PropertiesFileReader;
import utilities.CommonUtil;


public class LoginPage {
	private static WebElement webElement = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String locator = null;
	private static String field = null;
	private static String value = null;
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	
	public static void validateLoginPage() throws InterruptedException {
		CommonUtil.waitForPageload();	
		
		actualMsg = "eSamstha";	
		
		expectedMsg =CommonUtil.getTitle();
		
		System.out.println("AR " + actualMsg +" and ER " + expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("Login Page is displayed");
		} else {
			expectedMsg = CommonUtil.getTitle();
			System.out.println("Login Page not displayed");
			
		}
		
		CommonUtil.waitForPageload();	
	}
	
	public static void InvalidateDashboardPage() throws InterruptedException {
		CommonUtil.waitForPageload();	
		
		expectedMsg = "Username/ Password is invalid";	
		 actualMsg =CommonUtil.findElement(elementProperties.getProperty("login.error")).getText();
		System.out.println("AR " + actualMsg +" and ER " + expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("In If loop");
			actualMsg = "Dashboard Page is displayed";
			expectedMsg = "Dashboard Page should not be displayed";
			status = "FAIL";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			expectedMsg = CommonUtil.getTitle();
			System.out.println("***"+expectedMsg);
			System.out.println("Not In If loop");
		
			actualMsg = "Dashboard Page is not Displayed to User due to invalid credentials";
			expectedMsg = "Dashboard Page is not Displayed to User due to invalid credentials";
			status = "PASS";
			
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			
		}
			
	}
	public static void enterCredentialsforlogin(String username,String password) throws InterruptedException {
		CommonUtil.waitForPageload();
		CommonUtil.click(elementProperties.getProperty("home.login"));
		CommonUtil.explicitlyWait(5);
		CommonUtil.click(elementProperties.getProperty("home.admin"));
		CommonUtil.explicitlyWait(5);
		
		CommonUtil.enterText(elementProperties.getProperty("login.username"),username );
		CommonUtil.explicitlyWait(5);
		
		CommonUtil.enterText(elementProperties.getProperty("login.username"),username );
		CommonUtil.explicitlyWait(5);
		CommonUtil.enterText(elementProperties.getProperty("login.password"), password);
		CommonUtil.click(elementProperties.getProperty("login.submit"));
		CommonUtil.waitForPageload();
		CommonUtil.explicitlyWait(5);
	
	}
}