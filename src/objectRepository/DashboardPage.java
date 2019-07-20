package objectRepository;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.PropertiesFileReader;
import utilities.CommonUtil;

public class DashboardPage {
	private static WebElement webElement = null;
	private static String actualMsg = null;
	private static String expectedMsg = null;
	private static String status = null;
	private static String locator = null;
	private static String field = null;
	private static String value = null;
	public static Properties elementProperties = null;
	public static Properties commonProperties = null;
	WebElement driver;
	
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties(
				"element.properties");
		commonProperties = PropertiesFileReader.getInstance().readProperties(
				"common.properties");
	}
	public static void validateDashboard() throws InterruptedException{
		CommonUtil.waitForPageload();
		actualMsg = "DASHBOARD";	
		WebElement wb=CommonUtil.findElement(elementProperties.getProperty("Dashboard.VerifyScreen"));
		expectedMsg =wb.getText();
		if(actualMsg.equalsIgnoreCase(expectedMsg)){
			System.out.println("In If loop");
		}
	}
	public static void validateDashboardPage() throws InterruptedException {
		CommonUtil.waitForPageload();	
		
		actualMsg = "DASHBOARD";	
		WebElement wb=CommonUtil.findElement(elementProperties.getProperty("Dashboard.VerifyScreen"));
		expectedMsg =wb.getText();
		
		System.out.println("AR " + actualMsg +" and ER " + expectedMsg);
		if (actualMsg.equalsIgnoreCase(expectedMsg)) {
			System.out.println("In If loop");
			actualMsg = "Dashboard Page is displayed";
			expectedMsg = "Dashboard Page should be displayed";
			status = "PASS";
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
		} else {
			expectedMsg = CommonUtil.getTitle();
			System.out.println("***"+expectedMsg);
			System.out.println("Not In If loop");
		
			actualMsg = "Dashboard Page is not Displayed to User";
			expectedMsg = "Dashboard Page should Display be displayed";
			status = "FAIL";
			
			CommonUtil.logMessage(expectedMsg, actualMsg, status);
			
		}
		
		CommonUtil.waitForPageload();	
	}
	
	//Dashboard settings - elements
	By dashboard_toc_toggle = By.xpath("//*[@id=\"left-panel\"]/span/i");
	By dashboard_home = By.xpath("//*[@id=\"left-panel\"]/nav/ul/li[1]/a");
	By myapps_list = By.xpath("//*[@id=\"left-panel\"]/nav/ul/li[2]/a");
	By user_mgmt = By.xpath("//*[@id=\"left-panel\"]/nav/ul/li[3]/a");
	By user_bulk_upload = By.xpath("//*[@id=\"left-panel\"]/nav/ul/li[4]/a");
	By roles_mgmt = By.xpath("//*[@id=\"left-panel\"]/nav/ul/li[5]/a");
	By modules_roles = By.xpath("//*[@id=\"left-panel\"]/nav/ul/li[6]/a");
	By user_roles = By.xpath("//*[@id=\"left-panel\"]/nav/ul/li[7]/a");
	By configs = By.xpath("//*[@id=\"left-panel\"]/nav/ul/li[8]/a");
	By logout = By.xpath("//*[@id=\"logout\"]/span/a");
	By confirm_logout = By.xpath("//*[@id=\"bot2-Msg1\"]");
	By cancel_logout = By.xpath("//*[@id=\"bot1-Msg1\"]");
	By logout_msg = By.xpath("//*[@id=\"Msg1\"]/div/p");
	By full_screen = By.xpath("//*[@id=\"fullscreen\"]/span/a");
	
	
	public WebElement dashboard_toc_toggle() {
		return driver.findElement(dashboard_toc_toggle);
	}
	
	public WebElement dashboard_home() {
		return driver.findElement(dashboard_home);
	}
	
	public WebElement myapps_list() {
		return driver.findElement(myapps_list);
	}

	public WebElement user_mgmt() {
		return driver.findElement(user_mgmt);
	}

	public WebElement user_bulk_upload() {
		return driver.findElement(user_bulk_upload);
	}

	public WebElement roles_mgmt() {
		return driver.findElement(roles_mgmt);
	}

	public WebElement modules_roles() {
		return driver.findElement(modules_roles);
	}

	public WebElement user_roles() {
		return driver.findElement(user_roles);
	}

	public WebElement configs() {
		return driver.findElement(configs);
	}

	public WebElement logout() {
		return driver.findElement(logout);
	}

	public WebElement confirm_logout() {
		return driver.findElement(confirm_logout);
	}

	public WebElement cancel_logout() {
		return driver.findElement(cancel_logout);
	}


	public WebElement logout_msg() {
		return driver.findElement(logout_msg);
	}

	public WebElement full_screen() {
		return driver.findElement(full_screen);
	}
	
	/////////////////////////////
	
	public static void Signout() throws InterruptedException{
		CommonUtil.click(elementProperties.getProperty("Dashboard.signout"));
	}
	
	
	public static void Click_Messages(){
		CommonUtil.click(elementProperties.getProperty("Dashboard.Messages"));
	}
	
}
