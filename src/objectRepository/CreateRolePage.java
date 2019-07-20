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
import org.openqa.selenium.WebElement;


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

	
	
}
