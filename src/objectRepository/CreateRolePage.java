/*******************************************************************************
 * © Copyright (C) 2018 Selenium Project @Surya.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package objectRepository;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import utilities.CommonUtil;

public class CreateRolePage {

	WebElement driver;

	public CreateRolePage(WebElement driver) {
		this.driver = driver;
	}
	
	//Create Role - elements
	By create_role_header = By.xpath("//*[@id=\"wid-id-0\"]/header/h2");
	By app_list = By.xpath("//*[@id=\"application\"]");
	By mod_list = By.xpath("//*[@id=\"module\"]");
	By role_name = By.xpath("//*[@id=\"authority\"]");
	By role_code = By.xpath("//*[@id=\"code\"]");
	
	By create_role_submit = By.xpath("//*[@id=\"roleForm\"]/footer/button");
	By create_role_cancel = By.xpath("//*[@id=\"roleForm\"]/footer/a");
	
	public WebElement create_role_header() {
		return driver.findElement(create_role_header);
	}

	public WebElement app_list() {
		return driver.findElement(app_list);
	}

	public WebElement mod_list() {
		return driver.findElement(mod_list);
	}

	public void Role_Select_App(String appname) {
		//Select app from the list
		
	
		app_list().click();
		
		List<WebElement> lst = app_list().findElements(app_list);

		  Iterator<WebElement> it = lst.iterator();
		  while (it.hasNext()) {
			  WebElement wb = it.next();
			  if(wb.getText().equals(appname)) {
				  wb.click(); 
				  break;
				  }
		  }
	}
	
	public void Role_Select_Module(String modulename) {
		//Select module name from the list
		mod_list().click();
		
		List<WebElement> lst = mod_list().findElements(mod_list);

		  Iterator<WebElement> it = lst.iterator();
		  while (it.hasNext()) {
			  WebElement wb = it.next();
			  if(wb.getText().equals(modulename)) {
				  wb.click(); 
				  break;
				  }
		  }
	}
	
	public WebElement role_name() {
		return driver.findElement(role_name);
	}
	public WebElement role_code() {
		return driver.findElement(role_code);
	}
	public WebElement create_role_submit() {
		return driver.findElement(create_role_submit);
	}

	public WebElement create_role_cancel() {
		return driver.findElement(create_role_cancel);
	}

	
	public void Verify_Org_Config_Screen() {
		CommonUtil cf=new CommonUtil(driver);
		cf.waitforelement(DTH_operator_screen);
		if(DTH_Operator_Screen().isDisplayed()) {
			cf.Log_Message("DTH Operators screen is displayed", "true");
		}else {
			cf.Log_Message("DTH Operators screen is not displayed", "false");
		}
	}
	
	public void Verify_Org_Config_Empty_Errors() {
		CommonFunc cf=new CommonFunc(driver);
		String x=Subscriber_Error().getText();
		String y=Amount_Error().getText();
		if(x.equalsIgnoreCase("Enter valid Subscriber Number") && y.equalsIgnoreCase("Enter valid Amount")) {
			cf.Log_Message(x+" and "+y+" error messages is displayed", "true");
		}else {
			cf.Log_Message("Enter valid Subscriber Number and Enter valid Amount error messages is not displayed", "false");
		}
	}
	
	public void Verify_Org_Config_Subscriber_Empty_Error(String error1) {
		CommonFunc cf=new CommonFunc(driver);
		String x=Subscriber_Error().getText().trim();
		
		if(x.contains(error1)) {
			cf.Log_Message(x+" error message is displayed", "true");
		}else {
			cf.Log_Message("Enter valid Subscriber Number error messages is not displayed", "false");
		}
	}
		
	public void Verify_Org_Config_Amount_Empty_Error() {
		CommonFunc cf=new CommonFunc(driver);
		String y=Amount_Error().getText();
		if(y.equalsIgnoreCase("Enter valid Amount")) {
			cf.Log_Message(y+" error messages is displayed", "true");
		}else {
			cf.Log_Message("Enter valid Amount error messages is not displayed", "false");
		}
	}
	
	public void Entering_Viola_PIN(String pin) {
		PrepaidRechargePage pr=new PrepaidRechargePage(driver);
		pr.Entering_ViolaPIN(pin);
	}
	
	public void Verify_ViolaPIN_Invalid() {
		CommonFunc cf=new CommonFunc(driver);
		cf.waitforelement(viola_pin_error);
		if(Viola_PIN_Error_Popup().isDisplayed()) {
			cf.Log_Message("Viola PIN is not valid error popup is displayed", "true");
		}else {
			cf.Log_Message("Viola PIN is not valid error popup is not displayed", "false");
		}
		Ok_Button().click();
	}
	
	public void Verify_Org_Config_Subscriber_Invalid() {
		CommonFunc cf=new CommonFunc(driver);
		cf.waitforelement(subscriber_invalid_error);
		if(SubscriberID_Error_Popup().isDisplayed()) {
			String a=SubscriberID_Error_Popup().getText();
			cf.Log_Message(a+"error popup is displayed", "true");
		}else {
			cf.Log_Message("Invalid Subscriber Id error popup is not displayed", "false");
		}
		Ok_Button().click();
	}
	
	public void Verify_Payment_Details_Screen() {
		CommonFunc cf=new CommonFunc(driver);
		cf.waitforelement(Payment_details_screen);
		if(Payment_Details_Screen().isDisplayed()) {
			cf.Log_Message("Payment details popup is displayed", "true");
		}else {
			cf.Log_Message("Payment details popup is not displayed", "false");
		}
		Payment_Details_Proceed_Button().click();
	}
	
	public void Verify_Org_Config_Changes_Success() {
		CommonFunc cf=new CommonFunc(driver);
		cf.Verify_Success_Message();
		AlertsPage ap=new AlertsPage(driver);
		DashboardPage dp=new DashboardPage(driver);
		dp.Navigate_Alerts_Screen();
		ap.Mark_Alerts_all_Read();
	}
}
