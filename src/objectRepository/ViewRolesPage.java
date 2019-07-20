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

public class ViewRolesPage {

	WebElement driver;

	public ViewRolesPage(WebElement driver) {
		this.driver = driver;
	}
	
	//View Roles List - elements
	By roles_header_title = By.xpath("//*[@id=\"wid-id-12\"]/header/h2");
	By sno_sort_asc_desc =  By.xpath("//*[@id=\"dt_basic\"]/thead/tr/th[1]");
	By appname_sort_asc_desc = By.xpath("//*[@id=\"dt_basic\"]/thead/tr/th[2]");
	By modname_sort_asc_desc = By.xpath("//*[@id=\"dt_basic\"]/thead/tr/th[3]");
	By role_sort_asc_desc = By.xpath("//*[@id=\"dt_basic\"]/thead/tr/th[4]");
	By action_sort_asc_desc = By.xpath("//*[@id=\"dt_basic\"]/thead/tr/th[5]");
	By show_no_records = By.xpath("//*[@id=\"dt_basic_length\"]/label/select");
	By search_role = By.xpath("//*[@id=\"dt_basic_filter\"]/label/input");
	By data_table_info = By.xpath("//*[@id=\"dt_basic_info\"]");
	By prev_link = By.xpath("//*[@id=\"dt_basic_previous\"]/a");
	By next_link = By.xpath("//*[@id=\"dt_basic_next\"]/a");
	By edit_role_action = By.xpath("//*[@id=\"dt_basic\"]/tbody/tr[1]/td[5]/a");
	
	public WebElement roles_header_title() {
		return driver.findElement(roles_header_title);
	}

	public WebElement sno_sort_asc_desc() {
		return driver.findElement(sno_sort_asc_desc);
	}
	public WebElement appname_sort_asc_desc() {
		return driver.findElement(appname_sort_asc_desc);
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
	
	public WebElement search_role() {
		return driver.findElement(search_role);
	}
	
	//below action method has to be modified with dynamic result table data records
	public WebElement edit_role_action() {
		return driver.findElement(edit_role_action);
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
	
	public void click_edit_role(String editrolerecord) {
		//Select organization State
		edit_role_action().click();
		
		List<WebElement> lst = edit_role_action().findElements(edit_role_action);

		  Iterator<WebElement> it = lst.iterator();
		  while (it.hasNext()) {
			  WebElement wb = it.next();
			  
			  if(wb.getText().equals(editrolerecord)) {
				  wb.click(); 
				  break;
				  }
		  }
	}
}
