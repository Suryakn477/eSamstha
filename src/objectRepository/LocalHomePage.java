package objectRepository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LocalHomePage {
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
		
		if(title.contentEquals("Login")) {
			System.out.println("Home page : Login - launched successfully");
			WebElement username = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
			assertTrue(username.isDisplayed());
			if(username.isDisplayed()) {
				System.out.println("LOGIN - Username field showing");
				username.sendKeys(email);
				WebElement firstloginNext = driver.findElement(By.xpath("//*[@id=\"next\"]/i"));
				 assertTrue(firstloginNext.isDisplayed());
				
				if(firstloginNext.isDisplayed()) {
					System.out.println("First login screen 'Next' link is displayed.. before userloginlink is clicked");
					firstloginNext.click();
					Thread.sleep(5000);
					
					if(driver.findElement(By.xpath("//*[@id=\"userName\"]")).isDisplayed()) {
						System.out.println("Second login screen 'Username' field is disabled");
						Thread.sleep(5000);
						WebElement orgCode = driver.findElement(By.xpath("//*[@id=\"orgId\"]"));
						orgCode.click();
						
						
						
						
						/*
						 * Iterator<WebElement> it = lst.iterator(); while (it.hasNext()) { WebElement
						 * wb = it.next(); if(wb.getText().equals("NI")) { wb.click(); break; }
						 * 
						 * }
						 */
						
						
						driver.findElement(By.xpath("//*[@id=\"orgId\"]/option[2]")).click();
						
						Thread.sleep(10000);
						//WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pwd")));
						
						WebElement pwd = driver.findElement(By.name("pwd"));
						assertTrue(pwd.isDisplayed());
						pwd.sendKeys(password);

						Thread.sleep(5000);
						driver.findElement(By.id("login")).submit();

					}
					else {
						System.out.println("Second login screen not reachable... exiting as of now");
						System.exit(1);
					}
										
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
						
						//below URL has to pickup from properties file
						String dashboardurl = "http://192.168.15.27/hrm/dashboard";
						String dashboardtitle = "My Dashboard";
						String dashboardtext = "Dashboard";
						String dashboardTxtXpath = "//*[@id=\"ribbon\"]/ol[1]/li[2]";
						
						WebElement dashboardtxtelement = driver.findElement(By.xpath(dashboardTxtXpath));
						if(dashboardtxtelement.isDisplayed() && dashboardtext.equals(dashboardtxtelement.getText())) {
							System.out.println("Login with user successfully - Dashboard displaying");
							assertEquals(driver.getTitle(), dashboardtitle);
							assertEquals(driver.getCurrentUrl(), dashboardurl);
							
						}
					
					else {
						System.out.println("fields are not identifying");
					}
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