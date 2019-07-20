package objectRepository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HomePage {
	static WebDriver driver;
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium-drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		
	}
	
	public static void maximizeWindow() {
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		 }
	
	public static void openUrl(String url) {
		driver.get(url);
	}
	
	public static void closeBrowser() {
		if (driver != null)
			driver.close();
	}

	public static void validLogin(String email, String password) throws InterruptedException {
		Thread.sleep(1000);
		
		String title = driver.getTitle();
		
		if(title.contentEquals("eSamstha")) {
			System.out.println("success");
			WebElement login = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/nav/a"));
			assertTrue(login.isDisplayed());
			if(login.isDisplayed()) {
				System.out.println("LOGIN link present");
				login.click();
				
				WebElement adminloginlink = driver.findElement(By.xpath("//*[@id=\"mySidepanel\"]/div/div/div/ul/li[2]/a"));
				WebElement userloginlink = driver.findElement(By.xpath("//*[@id=\"mySidepanel\"]/div/div/div/ul/li[1]/a"));
				assertTrue(adminloginlink.isDisplayed());
				
				if(adminloginlink.isDisplayed()) {
					System.out.println("Admin link is displayed.. before userloginlink is clicked");
					userloginlink.click();
					System.out.println("after userloginlink is clicked.. before Admin link is clicked");
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					//Thread.sleep(5000);
					adminloginlink.click();
					//Thread.sleep(10000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					driver.findElement(By.xpath("//*[@id=\"admin-username\"]")).sendKeys("surya5kn@gmail.com");
					driver.findElement(By.xpath("//*[@id=\"admin-password\"]")).sendKeys("Fortesting123");

					driver.findElement(By.xpath("//*[@id=\"Admin-Login\"]/button")).submit();
					
					/*
					 * assertTrue(submitfield.isDisplayed()); assertTrue(usernamefield.isEnabled());
					 * assertTrue(passwordfield.isEnabled());
					 */
					 
					
					//if(usernamefield.isDisplayed() && passwordfield.isDisplayed() && submitfield.isDisplayed() ) {
						System.out.println("Username/Password fields are displayed");
					/*
					 * usernamefield.clear(); passwordfield.clear();
					 */
						
					/*
					 * usernamefield.sendKeys(email); passwordfield.sendKeys(password);
					 */
						
						//if(submitfield.isDisplayed()) {
						
						Thread.sleep(5000);
						
						String dashboardurl = "http://esamstha.com/SmartUser/dashboard";
						String dashboardtitle = "Dashboard";
						String dashboardtext = "Dashboard";
						//String dashboardxpath = "//*[@id="ribbon"]/ol/li";
						http://esamstha.com/SmartUser/organization/config
						WebElement dashboardtxt = driver.findElement(By.xpath("//*[@id=\"ribbon\"]/ol/li"));
						if(dashboardtxt.isDisplayed() && dashboardtext.equals(dashboardtxt.getText())) {
							System.out.println("Login with Admin user successfully - Dashboard displaying");
							assertEquals(driver.getTitle(), dashboardtitle);
							assertEquals(driver.getCurrentUrl(), dashboardurl);
							
						}
					/*	}
					else {
						System.out.println("fields are not identifying");
					}*/
					}
				}
			}
		}

	public static void invalidLogin(String email, String password) throws InterruptedException {
		Thread.sleep(1000);
		
		String title = driver.getTitle();
		
		if(title.contentEquals("eSamstha")) {
			System.out.println("success");
			WebElement login = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/nav/a"));
			if(login.isDisplayed()) {
				System.out.println("LOGIN link present");
				login.click();
				
				WebElement loginwindow = driver.findElement(By.xpath("//*[@id=\"mySidepanel\"]/div/div/div/ul/li[2]/a"));
				if(loginwindow.isDisplayed()) {
					System.out.println("Admin link is displayed");
					loginwindow.click();
					WebElement usernamefield = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
					WebElement passwordfield = driver.findElement(By.xpath("//*[@id=\"password\"]"));
					
					if(usernamefield.isDisplayed() && passwordfield.isDisplayed() ) {
						System.out.println("Username/Password fields is displayed");
						
						usernamefield.sendKeys(email);
						passwordfield.sendKeys(password);
						WebElement submitfield = driver.findElement(By.xpath("//*[@id=\"Admin-Login\"]/button"));
						submitfield.click();
						WebElement dashboardtxt = driver.findElement(By.xpath("//*[@id=\"ribbon\"]/ol/li"));
						if(!dashboardtxt.isDisplayed() ) {
							System.out.println("Login failed.. with Invalid Admin user successfully - Dashboard is not displaying");
					}
				}
				
			}
		}
		
		}
			
	}
	
}