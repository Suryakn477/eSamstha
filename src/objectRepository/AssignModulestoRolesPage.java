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

public class AssignModulestoRolesPage {

	WebElement driver;

	public AssignModulestoRolesPage(WebElement driver) {
		this.driver = driver;
	}
	
	//Create Role - elements
	By module_role_header = By.xpath("//*[@id=\"wid-id-12\"]/header/h2");
	By app_list = By.xpath("//*[@id=\"application\"]");
	By mod_list = By.xpath("//*[@id=\"module\"]");
	By role_list = By.xpath("//*[@id=\"role\"]");
						    
	By module_role_assign = By.xpath("//*[@id=\"assignForm\"]/footer/button");
	By module_role_cancel = By.xpath("//*[@id=\"assignForm\"]/footer/a");
	
	public WebElement module_role_header() {
		return driver.findElement(module_role_header);
	}

	public WebElement app_list() {
		return driver.findElement(app_list);
	}

	public WebElement mod_list() {
		return driver.findElement(mod_list);
	}
	public WebElement role_list() {
		return driver.findElement(role_list);
	}
	
	public void Module_Role_Select_App(String appname) {
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
	
	public void Module_Role_Select_Module(String modulename) {
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
	
	public void Module_Role_Select_Role(String rolename) {
		//Select module name from the list
		role_list().click();
		
		List<WebElement> lst = role_list().findElements(role_list);

		  Iterator<WebElement> it = lst.iterator();
		  while (it.hasNext()) {
			  WebElement wb = it.next();
			  if(wb.getText().equals(rolename)) {
				  wb.click(); 
				  break;
				  }
		  }
	}
	
	
	public WebElement module_role_assign() {
		return driver.findElement(module_role_assign);
	}

	public WebElement module_role_cancel() {
		return driver.findElement(module_role_cancel);
	}

	
	
}
