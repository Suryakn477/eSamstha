package Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectRepository.HomePage;


public class HomePageScenario {
	
		public void setUp(String testcaseName) {
			System.out.println("=============================" + testcaseName + " Started =============================");
			//String browserType = "firefox";
			String browserType = "chrome";
			System.out.println("DB - BrowserType" + browserType);
			HomePage.openBrowser();
			//HomePage.maximizeWindow();
			HomePage.openUrl("http://esamstha.com/");
		}
		public void tearDown(String testcaseName) {

			HomePage.closeBrowser();
			System.out.println("=============================" + testcaseName + " Ended =============================");
		}

		@Test (priority=1, enabled=false)
		public void TC1_Invalidlogin() throws Exception {
			this.setUp("Verify the login page with invalid credentials");

			//HomePage.validateLoginPage();
			HomePage.invalidLogin("stheharroror@lucidexchange.com", "akdskl");
			//HomePage.InvalidateDashboardPage();

			this.tearDown("Verify the login page with invalid credentials");
		}
		
		@Test
		//(dependsOnMethods = {"TC1_Invalidlogin"}, alwaysRun=true)
		//(priority=2, enabled=true)
		public void TC2_Validlogin() throws Exception {
			this.setUp("Verify the login page with valid credentials");

			HomePage.validLogin("surya5kn@gmail.com", "Fortesting123");

			this.tearDown("Verify the login page with valid credentials");
		}
}