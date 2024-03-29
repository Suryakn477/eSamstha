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


public class OrgConfigPage {

	WebElement driver;

	public OrgConfigPage(WebElement driver) {
		this.driver = driver;
	}
	
	//Organization Configuration settings - elements
	By min_settings = By.xpath("//*[@id=\"left-panel\"]/nav/ul/li[8]/a");
	By Org_config_min_menu=By.xpath("//*[@id=\"left-panel\"]/nav/ul/li[8]/ul/li[3]/a/span/font");
	
	By fin_start_dt = By.xpath("//*[@id=\"orgFinancialStart\"]");
	By fin_end_dt=By.xpath("//*[@id=\"orgFinancialEnd\"]");
	
	By old_upload_img = By.xpath("//*[@id=\"imagePreview\"]");
	By choose_upload_file = By.xpath("//*[@id=\"uploadFile\"]");
	
	By add_id = By.xpath("//*[@id=\"address\"]");
	By country_id = By.xpath("//*[@id=\"countryId\"]");
	By state_id = By.xpath("//*[@id=\"stateId\"]");
	By gstin_id = By.xpath("//*[@id=\"gstin\"]");
	By org_url = By.xpath("//*[@id=\"orgUrl\"]");
	
	By org_config_submit = By.xpath("//*[@id=\"orgForm\"]/div[9]/div[2]/button[1]");
	By org_config_reset = By.xpath("//*[@id=\"orgForm\"]/div[9]/div[2]/button[2]");
	By org_config_cancel = By.xpath("//*[@id=\"orgForm\"]/div[9]/div[2]/a");
	
	public WebElement min_settings() {
		return driver.findElement(min_settings);
	}

	public WebElement Org_config_min_menu() {
		return driver.findElement(Org_config_min_menu);
	}

	public WebElement fin_start_dt() {
		return driver.findElement(fin_start_dt);
	}

	public WebElement fin_end_dt() {
		return driver.findElement(fin_end_dt);
	}

	public WebElement old_upload_img() {
		return driver.findElement(old_upload_img);
	}

	public WebElement choose_upload_file() {
		return driver.findElement(choose_upload_file);
	}

	public WebElement add_id() {
		return driver.findElement(add_id);
	}

	public WebElement country_id() {
		return driver.findElement(country_id);
	}

	public WebElement state_id() {
		return driver.findElement(state_id);
	}

	public WebElement gstin_id() {
		return driver.findElement(gstin_id);
	}

	public WebElement org_url() {
		return driver.findElement(org_url);
	}

	public WebElement org_config_submit() {
		return driver.findElement(org_config_submit);
	}

	public WebElement org_config_reset() {
		return driver.findElement(org_config_reset);
	}

	public WebElement org_config_cancel() {
		return driver.findElement(org_config_cancel);
	}
	
	
	
	
	public void Select_Fin_Start_Date(String date) {
		//Select organization start date
			fin_start_dt().sendKeys(date);
		fin_start_dt().sendKeys(Keys.RETURN);
		
	}
	
	public void Select_Fin_End_Date(String date) {
		//Select organization end date
		fin_end_dt().sendKeys(date);
		fin_end_dt().sendKeys(Keys.RETURN);
		
	}
	
	public void Select_Upload_File(String uploadfilepath) {
		choose_upload_file().sendKeys(uploadfilepath);
	}
	
	public void Enter_Address_Details(String addressdata) {
		add_id().sendKeys(addressdata);
	}
	

	public void Org_Select_Country(String country) {
		//Select organization Country
		
		/*
		 * CommonUtil cf=new CommonUtil();
		 * cf.selectValueFromDropDownBox("//*[@id=\"countryId\"]", country);
		 */	
		country_id().click();
		
		List<WebElement> lst = country_id().findElements(country_id);

		  Iterator<WebElement> it = lst.iterator();
		  while (it.hasNext()) {
			  WebElement wb = it.next();
			  if(wb.getText().equals(country)) {
				  wb.click(); 
				  break;
				  }
		  }
	}
	
	public void Org_Select_State(String state) {
		//Select organization State
		state_id().click();
		
		List<WebElement> lst = state_id().findElements(state_id);

		  Iterator<WebElement> it = lst.iterator();
		  while (it.hasNext()) {
			  WebElement wb = it.next();
			  if(wb.getText().equals(state)) {
				  wb.click(); 
				  break;
				  }
		  }
	}
	
	public void Org_Enter_Gstin(String gstin) {
		//Enter GSTIN
		gstin_id().sendKeys(gstin);
		
	}
	public void Org_Enter_Url(String url) {
		//Enter Org URL
		org_url().sendKeys(url);
		
	}
	
	public void Org_Submit_Form() {
		org_config_submit().submit();
	}
	
	public void Org_Cancel_Form() {
		org_config_cancel().click();
	}
	
	public void Org_Reset_Form() {
		org_config_reset().click();
	}
	
}
