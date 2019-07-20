package Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectRepository.LocalHomePage;


public class LocalHomePageScenario {	

		public void setUp(String testcaseName) {
			System.out.println("=============================" + testcaseName + " Started =============================");
	//		 String browserType = "firefox";
			String browserType = "chrome";
			System.out.println("DB - BrowserType" + browserType);
			LocalHomePage.openBrowser();
			//HomePage.maximizeWindow();
			//Note: below URL to be obtained from properties file
			LocalHomePage.openUrl("http://192.168.15.27/hrm/");
		}
		public void tearDown(String testcaseName) {

			LocalHomePage.closeBrowser();
			System.out.println("=============================" + testcaseName + " Ended =============================");
		}

		@Test (priority=1, enabled=false)
		public void TC1_Invalidlogin() throws Exception {
			this.setUp("Verify the login page with invalid credentials");

			//HomePage.validateLoginPage();
			LocalHomePage.invalidLogin("stheharroror@nipun.net", "akdskl");
			//HomePage.InvalidateDashboardPage();

			this.tearDown("Verify the login page with invalid credentials");
		}
		
		@Test
		//(dependsOnMethods = {"TC1_Invalidlogin"}, alwaysRun=true)
		//(priority=2, enabled=true)
		public void TC2_Validlogin() throws Exception {
			this.setUp("Verify the login page with valid credentials");

			LocalHomePage.validLogin("himabindu.v@nipun.net", "Nipun@123");

			this.tearDown("Verify the login page with valid credentials");
		}
}