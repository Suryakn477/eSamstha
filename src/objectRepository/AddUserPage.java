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

public class AddUserPage {

	WebElement driver;

	public AddUserPage(WebElement driver) {
		this.driver = driver;
	}
	
	//Add User - elements
	
	By add_user_header_title = By.xpath("//*[@id=\"wid-id-8\"]/header/h2");
	By emp_code = By.xpath("//*[@id=\"empCode\"]");
	
	By emp_fname = By.xpath("//*[@id=\"firstName\"]");
	By emp_lname = By.xpath("//*[@id=\"lastName\"]");
	
	By emp_phone = By.xpath("//*[@id=\"phone\"]");
	By emp_email = By.xpath("//*[@id=\"email\"]");
	By emp_local_auth = By.xpath("//*[@id=\"authenticationMode1\"]");
	By emp_ldap_auth = By.xpath("//*[@id=\"authenticationMode2\"]");
	
	
	By emp_oid = By.xpath("//*[@id=\"appList0.status1\"]");
	By emp_mod = By.xpath("//*[@id=\"appList0.modules0.moduleStatus1\"]");
	
	
	By emp_create_submit = By.xpath("//*[@id=\"userInfoform\"]/fieldset/div[5]/div/footer/button");
	By emp_create_reset = By.xpath("//*[@id=\"userInfoform\"]/fieldset/div[5]/div/footer/a[2]");
	By emp_create_cancel = By.xpath("//*[@id=\"userInfoform\"]/fieldset/div[5]/div/footer/a[1]");
	
	public WebElement add_user_header_title() {
		return driver.findElement(add_user_header_title);
	}

	public WebElement emp_code() {
		return driver.findElement(emp_code);
	}

	public WebElement emp_fname() {
		return driver.findElement(emp_fname);
	}

	public WebElement emp_lname() {
		return driver.findElement(emp_lname);
	}

	public WebElement emp_phone() {
		return driver.findElement(emp_phone);
	}

	public WebElement emp_email() {
		return driver.findElement(emp_email);
	}

	public WebElement emp_local_auth() {
		return driver.findElement(emp_local_auth);
	}

	public WebElement emp_ldap_auth() {
		return driver.findElement(emp_ldap_auth);
	}

	public WebElement emp_oid() {
		return driver.findElement(emp_oid);
	}

	public WebElement emp_mod() {
		return driver.findElement(emp_mod);
	}

	

	public WebElement emp_create_submit() {
		return driver.findElement(emp_create_submit);
	}

	public WebElement emp_create_reset() {
		return driver.findElement(emp_create_reset);
	}

	public WebElement emp_create_cancel() {
		return driver.findElement(emp_create_cancel);
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
	
	
}
