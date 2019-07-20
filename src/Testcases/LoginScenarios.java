/*******************************************************************************
 * © Copyright (C) 2019 Selenium Project @Surya.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package Testcases;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.Test;

import objectRepository.LoginPage;
import objectRepository.DashboardPage;

import utilities.PropertiesFileReader;
import utilities.CommonUtil;

public class LoginScenarios {

	static Map<?, ?> map = null;
	static List<String> testlist;
	static int count;

	public static Properties elementProperties = null;
	public static Properties commonProperties = null;

	static {

		elementProperties = PropertiesFileReader.getInstance().readProperties("element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties("common.properties");
	}
	static String validemail = commonProperties.getProperty("eSamsthan.validemail");
	static String validpwd = commonProperties.getProperty("eSamsthan.validpwd");
	static String invalidemail = commonProperties.getProperty("eSamsthan.invalidemail");
	static String invalidpwd = commonProperties.getProperty("eSamsthan.invalidpwd");
	static String browserType = commonProperties.getProperty("eSamsthan.browserType");
	static String url = commonProperties.getProperty("eSamsthan.url");

	public void setUp(String testcaseName) {
		System.out.println("=============================" + testcaseName + " Started =============================");
//		 String browserType = "firefox";
		// String browserType = "chrome";
		System.out.println("DB - BrowserType" + browserType);
		CommonUtil.openBrowser(browserType);
		CommonUtil.maximizeWindow();
		CommonUtil.openUrl(url);

	}

	public void tearDown(String testcaseName) {

		CommonUtil.closeBrowser();
		System.out.println("=============================" + testcaseName + " Ended =============================");
	}

	// ******************************* Invalid Login *******************************
	@Test
	public void TC1_Invalidlogin() throws Exception {
		this.setUp("Verify the login page with invalid credentials");

		LoginPage.validateLoginPage();
		LoginPage.enterCredentialsforlogin(invalidemail, invalidpwd);
		LoginPage.InvalidateDashboardPage();

		this.tearDown("Verify the login page with invalid credentials");
	}
	// ****************************************************************************

	// ******************************* Valid Login *******************************
	@Test
	public void TC2_validatelogin() throws Exception {
		this.setUp("Verify the login page with valid credentials");

		LoginPage.validateLoginPage();
		LoginPage.enterCredentialsforlogin(validemail, validpwd);
		DashboardPage.validateDashboardPage();

		this.tearDown("Verify the login page with valid credentials");
	}

	// ****************************************************************************

	// *******************************valid Login ****************************

	public void TC3_LoginandLogout() throws Exception {
		this.setUp("Verify the login page after Logout");

		TC2_validatelogin();
		DashboardPage.Signout();
		LoginPage.validateLoginPage();

		this.tearDown("Verify the login page after Logout");
	}
	// ****************************************************************************

}
