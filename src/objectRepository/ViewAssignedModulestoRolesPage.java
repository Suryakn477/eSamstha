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

public class ViewAssignedModulestoRolesPage {

	WebElement driver;

	public ViewAssignedModulestoRolesPage(WebElement driver) {
		this.driver = driver;
	}
	
	//View Roles List - elements
	By assigned_modules_roles_header = By.xpath("//*[@id=\"widget-grid\"]/div/article/div/header/h2");
	By sno_sort_asc_desc =  By.xpath("//*[@id=\"dt_basic\"]/thead/tr/th[1]");
	//By appname_sort_asc_desc = By.xpath("//*[@id=\"dt_basic\"]/thead/tr/th[2]");
	By modname_sort_asc_desc = By.xpath("//*[@id=\"dt_basic\"]/thead/tr/th[2]");
	By role_sort_asc_desc = By.xpath("//*[@id=\"dt_basic\"]/thead/tr/th[3]");
	By action_sort_asc_desc = By.xpath("//*[@id=\"dt_basic\"]/thead/tr/th[4]");
	
	By show_no_records = By.xpath("//*[@id=\"dt_basic_length\"]/label/select");
	By search_module_role = By.xpath("//*[@id=\"dt_basic_filter\"]/label/input");
	By data_table_info = By.xpath("//*[@id=\"dt_basic_info\"]");
	By prev_link = By.xpath("//*[@id=\"dt_basic_previous\"]/a");
	By next_link = By.xpath("//*[@id=\"dt_basic_next\"]/a");
	By edit_module_role_action = By.xpath("//*[@id=\"dt_basic\"]/tbody/tr[1]/td[4]/a");
	
	public WebElement assigned_modules_roles_header() {
		return driver.findElement(assigned_modules_roles_header);
	}

	public WebElement sno_sort_asc_desc() {
		return driver.findElement(sno_sort_asc_desc);
	}
	
	public WebElement modname_sort_asc_desc() {
		return driver.findElement(modname_sort_asc_desc);
	}
	public WebElement role_sort_asc_desc() {
		return driver.findElement(role_sort_asc_desc);
	}
	public WebElement action_sort_asc_desc() {
		return driver.findElement(action_sort_asc_desc);
	}
	public WebElement show_no_records() {
		return driver.findElement(show_no_records);
	}
	
	public WebElement search_module_role() {
		return driver.findElement(search_module_role);
	}
	
	//below action method has to be modified with dynamic result table data records
	public WebElement edit_module_role_action() {
		return driver.findElement(edit_module_role_action);
	}
	
	public WebElement data_table_info() {
		return driver.findElement(data_table_info);
	}
	public WebElement prev_link() {
		return driver.findElement(prev_link);
	}
	public WebElement next_link() {
		return driver.findElement(next_link);
	}
	
	public void Search_module_role(String searchdata) {
		//Search for the entries from the listed data
		search_module_role().sendKeys(searchdata);
	}
	
	public void select_no_records(int records) {
		//Select organization State
		show_no_records().click();
		
		List<WebElement> lst = show_no_records().findElements(show_no_records);

		  Iterator<WebElement> it = lst.iterator();
		  while (it.hasNext()) {
			  WebElement wb = it.next();
			  
			  if(Integer.parseInt(wb.getText()) == records) {
				  wb.click(); 
				  break;
				  }
		  }
	}
	
	public void click_edit_module_role(String assignedmodulerole) {
		//Select organization State
		edit_module_role_action().click();
		
		List<WebElement> lst = edit_module_role_action().findElements(edit_module_role_action);

		  Iterator<WebElement> it = lst.iterator();
		  while (it.hasNext()) {
			  WebElement wb = it.next();
			  
			  if(wb.getText().equals(assignedmodulerole)) {
				  wb.click(); 
				  break;
				  }
		  }
	}
}
