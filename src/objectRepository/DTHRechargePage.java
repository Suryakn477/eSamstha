/*******************************************************************************
 * © Copyright (C) 2018 Selenium Project @Harish.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package objectRepository;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.CommonFunc;

public class DTHRechargePage {

	AndroidDriver<AndroidElement> driver;

	public DTHRechargePage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}
	
	By viewmore=By.xpath("//*[@text='View More']");
	By DTH_operator_search=By.xpath("//*[@id='edt_search']");

	By DTH_operator_screen=By.xpath("//*[@text='DTH Operators']");
	By DTH_operator_value=By.xpath("//*[@id='txt_operator_name']");
	
	By subscriber_number_field=By.xpath("//*[@id='edt_customer_id']");
	By amount_field=By.xpath("//*[@id='edt_dth_amount']");
	By Recharge_button=By.xpath("//*[@id='btn_dth_pay']");
	
	By subscriber_error=By.xpath("//*[@id='txt_error_customer_id']");
	By amount_error=By.xpath("//*[@id='txt_error_amount']");
	
	By viola_pin_error=By.xpath("//*[@text='Viola PIN Is Not Valid.']");
	By ok_button=By.xpath("//*[@text='OK']");
	
	By subscriber_invalid_error=By.xpath("//*[@id='txt_message']");
	
	By Payment_details_screen=By.xpath("//*[@text='Payment Details']");
	By Payment_details_proceed_button=By.xpath("//*[@text='Proceed']");
	
	public AndroidElement Operator_View_More() {
		return driver.findElement(viewmore);
	}
	
	public AndroidElement DTH_Operator_Search() {
		return driver.findElement(DTH_operator_search);
	}
	
	public AndroidElement DTH_Operator_Screen() {
		return driver.findElement(DTH_operator_screen);
	}
	
	public AndroidElement DTH_Operator_Value() {
		return driver.findElement(DTH_operator_value);
	}
	
	public AndroidElement DTH_Subscriber_Number() {
		return driver.findElement(subscriber_number_field);
	}
	
	public AndroidElement DTH_Amount() {
		return driver.findElement(amount_field);
	}
	
	public AndroidElement Recharge_Button() {
		return driver.findElement(Recharge_button);
	}
	
	public AndroidElement Subscriber_Error() {
		return driver.findElement(subscriber_error);
	}
	
	public AndroidElement Amount_Error() {
		return driver.findElement(amount_error);
	}
	
	public AndroidElement Viola_PIN_Error_Popup() {
		return driver.findElement(viola_pin_error);
	}
	
	public AndroidElement Ok_Button() {
		return driver.findElement(ok_button);
	}
	
	public AndroidElement SubscriberID_Error_Popup() {
		return driver.findElement(subscriber_invalid_error);
	}
	
	public AndroidElement Payment_Details_Screen() {
		return driver.findElement(Payment_details_screen);
	}
	
	public AndroidElement Payment_Details_Proceed_Button() {
		return driver.findElement(Payment_details_proceed_button);
	}
	
	public void DTH_Recharge_Details(String oper,String subnumb,String amt) {
		Select_DTH_Operator(oper);
		DTH_Subscriber_Number().sendKeys(subnumb);
		Enter_DTH_Amount(amt);
		//Recharge_Button().click();
	}
	
	public void Select_DTH_Operator(String operator) {
		Operator_View_More().click();
		Verify_DTH_Operators_Screen();
		DTH_Operator_Search().sendKeys(operator);
		DTH_Operator_Value().click();
	}
	
	public void Enter_DTH_Amount(String amount) {
		CommonFunc cf=new CommonFunc(driver);
		DTH_Amount().click();
		cf.Entering_Keys(amount);
	}
	
	public void Verify_DTH_Operators_Screen() {
		CommonFunc cf=new CommonFunc(driver);
		cf.waitforelement(DTH_operator_screen);
		if(DTH_Operator_Screen().isDisplayed()) {
			cf.Log_Message("DTH Operators screen is displayed", "true");
		}else {
			cf.Log_Message("DTH Operators screen is not displayed", "false");
		}
	}
	
	public void Verify_DTH_Recharge_Empty_Errors() {
		CommonFunc cf=new CommonFunc(driver);
		String x=Subscriber_Error().getText();
		String y=Amount_Error().getText();
		if(x.equalsIgnoreCase("Enter valid Subscriber Number") && y.equalsIgnoreCase("Enter valid Amount")) {
			cf.Log_Message(x+" and "+y+" error messages is displayed", "true");
		}else {
			cf.Log_Message("Enter valid Subscriber Number and Enter valid Amount error messages is not displayed", "false");
		}
	}
	
	public void Verify_DTH_Recharge_Subscriber_Empty_Error(String error1) {
		CommonFunc cf=new CommonFunc(driver);
		String x=Subscriber_Error().getText().trim();
		
		if(x.contains(error1)) {
			cf.Log_Message(x+" error message is displayed", "true");
		}else {
			cf.Log_Message("Enter valid Subscriber Number error messages is not displayed", "false");
		}
	}
		
	public void Verify_DTH_Recharge_Amount_Empty_Error() {
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
	
	public void Verify_DTH_Recharge_Subscriber_Invalid() {
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
	
	public void Verify_Recharge_Payment_Success() {
		CommonFunc cf=new CommonFunc(driver);
		cf.Verify_Success_Message();
		AlertsPage ap=new AlertsPage(driver);
		DashboardPage dp=new DashboardPage(driver);
		dp.Navigate_Alerts_Screen();
		ap.Mark_Alerts_all_Read();
	}
}
