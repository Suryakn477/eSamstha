package objectRepository;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import objectRepository.HomePage;

public class VerifyLinks {

	public static Properties elementProperties = null;
	public static Properties commonProperties = null;

	/*
	 * static {
	 * 
	 * elementProperties =
	 * PropertiesFileReader.getInstance().readProperties("element.properties");
	 * commonProperties =
	 * PropertiesFileReader.getInstance().readProperties("common.properties"); }
	 */

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium-drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		/*
		 * ChromeOptions options = new ChromeOptions();
		
		 * options.addArguments("--start-maximized");
		 * options.addArguments("--disable-web-security");
		 * options.addArguments("--no-proxy-server"); Map<String, Object> prefs = new
		 * HashMap<String, Object>(); prefs.put("credentials_enable_service", false);
		 * prefs.put("profile.password_manager_enabled", false);
		 * options.setExperimentalOption("prefs", prefs);
		 */

		driver.manage().window().maximize();

		driver.get("http://esamstha.com/");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/nav/a")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"mySidepanel\"]/div/div/div/ul/li[2]/a")).click();
		Thread.sleep(5000);
		
		//Totallinkscount();

		// Login
		/*
		 * driver.findElement(By.id("userName")).sendKeys("surya5kn@gmail.com");
		 * driver.findElement(By.id("password")).sendKeys("Fortesting123");
		 */
		
		driver.findElement(By.xpath("//*[@id=\"admin-username\"]")).sendKeys("surya5kn@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"admin-password\"]")).sendKeys("Fortesting123");

		driver.findElement(By.xpath("//*[@id=\"Admin-Login\"]/button")).submit();
		
		WebElement w=driver.findElement(By.xpath("//*[@id=\"ribbon\"]/ol/li"));
		if(w.getText().contentEquals("Dashboard")) {
			System.out.println(w.getText());
			Totallinkscount();
		}
		else {
			System.out.println("login failed... exiting");
			System.exit(1);
		}
		
	}

	public static void verifyLinkActive(String linkUrl) {
		try {
			URL url = new URL(linkUrl);

			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

			httpURLConnect.setConnectTimeout(3000);

			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {

		}
	}

	public static void Totallinkscount() {
		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Total links are " + links.size());

		for (int i = 0; i < links.size(); i++) {

			WebElement ele = links.get(i);

			String url = ele.getAttribute("href");

			verifyLinkActive(url);

		}
	}

}
