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

public class UserBulkUploadPage {

	WebElement driver;

	public UserBulkUploadPage(WebElement driver) {
		this.driver = driver;
	}
	
	//Users Bulk Upload - elements
	By users_upload_header = By.xpath("//*[@id=\"wid-id-8\"]/header/h2");
	By note_for_template = By.xpath("//*[@id=\"bulkTo\"]/font/p/b");
	
	By template_download = By.xpath("//*[@id=\"bulkTo\"]/label/a/i");
	
	By choose_upload_file = By.xpath("//*[@id=\"empCode\"]");
	
	By users_upload_submit = By.xpath("//*[@id=\"bulkTo\"]/fieldset/div[2]/div/footer/button");
	By users_upload_cancel = By.xpath("//*[@id=\"bulkTo\"]/fieldset/div[2]/div/footer/a");
	
	public WebElement users_upload_header() {
		return driver.findElement(users_upload_header);
	}

	public WebElement note_for_template() {
		return driver.findElement(note_for_template);
	}

	public WebElement template_download() {
		return driver.findElement(template_download);
	}

	public WebElement choose_upload_file() {
		return driver.findElement(choose_upload_file);
	}

	public WebElement users_upload_submit() {
		return driver.findElement(users_upload_submit);
	}

	public WebElement users_upload_cancel() {
		return driver.findElement(users_upload_cancel);
	}

	
	
	
	
	
	
	
	public void Select_Upload_File(String uploadfilepath) {
		choose_upload_file().sendKeys(uploadfilepath);
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
	
	public void Entering_Nipun_PIN(String pin) {
		PrepaidRechargePage pr=new PrepaidRechargePage(driver);
		pr.Entering_NipunPIN(pin);
	}
	
	public void Verify_NipunPIN_Invalid() {
		CommonFunc cf=new CommonFunc(driver);
		cf.waitforelement(Nipun_pin_error);
		if(Nipun_PIN_Error_Popup().isDisplayed()) {
			cf.Log_Message("Nipun PIN is not valid error popup is displayed", "true");
		}else {
			cf.Log_Message("Nipun PIN is not valid error popup is not displayed", "false");
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
