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

public class EditModuleRolePage {

	WebElement driver;

	public EditModuleRolePage(WebElement driver) {
		this.driver = driver;
	}
	
	//Edit Module/Role - elements
	By edit_assigned_module_role_header = By.xpath("//*[@id=\"wid-id-12\"]/header/h2");
	By app_name = By.xpath("//*[@id=\"appId\"]");
	By module_name = By.xpath("//*[@id=\"module\"]");
	By role_name = By.xpath("//*[@id=\"role\"]");
	/**
	 * This modules functionality about selecting different sub-modules is not yet designed, PENDING
	 */
	
	By module_list_header = By.xpath("//*[@id=\"assignForm\"]/fieldset[2]/label/strong");
	
	By all_hrm_modules = By.xpath("\"//*[@id=\\\"assignForm\\\"]/fieldset[2]/section/div/ul/");
	
	By leave_mgmt_module_details = By.xpath("//*[@id=\"assignForm\"]/fieldset[2]/section/div/ul/li[1]/span");
	By employee_mgmt_module_details = By.xpath("//*[@id=\"assignForm\"]/fieldset[2]/section/div/ul/li[2]/span");
	By attendance_mgmt_module_details = By.xpath("//*[@id=\"assignForm\"]/fieldset[2]/section/div/ul/li[3]/span");
	By holiday_mgmt_module_details = By.xpath("//*[@id=\"assignForm\"]/fieldset[2]/section/div/ul/li[4]/span");
	By reports_mgmt_module_details = By.xpath("//*[@id=\"assignForm\"]/fieldset[2]/section/div/ul/li[5]/span");
	By config_mgmt_module_details = By.xpath("//*[@id=\"assignForm\"]/fieldset[2]/section/div/ul/li[6]/span");
	By activity_mgmt_module_details = By.xpath("//*[@id=\"assignForm\"]/fieldset[2]/section/div/ul/li[7]/span");
	By tally_mgmt_module_details = By.xpath("//*[@id=\"assignForm\"]/fieldset[2]/section/div/ul/li[8]/span");
	By mobile_mgmt_module_details = By.xpath("//*[@id=\"assignForm\"]/fieldset[2]/section/div/ul/li[9]/span");
	
		
	By edit_assigned_module_role_submit = By.xpath("//*[@id=\"assignForm\"]/footer/button");
	By edit_assigned_module_role_cancel = By.xpath("//*[@id=\"assignForm\"]/footer/a");
	
	public WebElement edit_assigned_module_role_header() {
		return driver.findElement(edit_assigned_module_role_header);
	}

	public WebElement app_name() {
		return driver.findElement(app_name);
	}

	public WebElement module_name() {
		return driver.findElement(module_name);
	}
	
	public WebElement role_name() {
		return driver.findElement(role_name);
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
	
	
	
	
	public WebElement edit_assigned_module_role_submit() {
		return driver.findElement(edit_assigned_module_role_submit);
	}

	public WebElement edit_assigned_module_role_cancel() {
		return driver.findElement(edit_assigned_module_role_cancel);
	}

	
	
}
