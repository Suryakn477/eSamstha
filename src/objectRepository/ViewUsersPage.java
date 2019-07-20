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

public class ViewUsersPage {

	WebElement driver;

	public ViewUsersPage(WebElement driver) {
		this.driver = driver;
	}
	
	//Users List - elements
	By view_user_header_title = By.xpath("//*[@id=\"widget-grid\"]/div/article/div/header/h2");
	By search_user = By.xpath("//*[@id=\"search-box\"]");
	By uname_sort_asc_desc =  By.xpath("//*[@id=\"dt_basic\"]/thead/tr/th[1]");
	By fname_sort_asc_desc = By.xpath("//*[@id=\"dt_basic\"]/thead/tr/th[2]");
	By lname_sort_asc_desc = By.xpath("//*[@id=\"dt_basic\"]/thead/tr/th[3]");
	By phone_sort_asc_desc =  By.xpath("//*[@id=\"dt_basic\"]/thead/tr/th[4]");
	By email_sort_asc_desc = By.xpath("//*[@id=\"dt_basic\"]/thead/tr/th[5]");
	By actions_sort_asc_desc = By.xpath("//*[@id=\"dt_basic\"]/thead/tr/th[6]");
	By data_table_info = By.xpath("//*[@id=\"dt_basic_info\"]/span");
	
	By add_user = By.xpath("//*[@id=\"widget-grid\"]/div/article/div/div/div[3]/div[2]/div[3]/div/a");
	
	By prev_link = By.xpath("//*[@id=\"dt_basic_previous\"]/a");
	By next_link = By.xpath("//*[@id=\"dt_basic_next\"]/a");
	
	public WebElement view_user_header_title() {
		return driver.findElement(view_user_header_title);
	}

	public WebElement search_user() {
		return driver.findElement(search_user);
	}
	public WebElement uname_sort_asc_desc() {
		return driver.findElement(uname_sort_asc_desc);
	}
	public WebElement fname_sort_asc_desc() {
		return driver.findElement(fname_sort_asc_desc);
	}
	public WebElement lname_sort_asc_desc() {
		return driver.findElement(lname_sort_asc_desc);
	}

	public WebElement phone_sort_asc_desc() {
		return driver.findElement(phone_sort_asc_desc);
	}

	public WebElement email_sort_asc_desc() {
		return driver.findElement(email_sort_asc_desc);
	}
	
	public WebElement actions_sort_asc_desc() {
		return driver.findElement(actions_sort_asc_desc);
	}
	
	public WebElement data_table_info() {
		return driver.findElement(data_table_info);
	}
	
	public WebElement add_user() {
		return driver.findElement(add_user);
	}
	
	public WebElement prev_link() {
		return driver.findElement(prev_link);
	}
	public WebElement next_link() {
		return driver.findElement(next_link);
	}
		
}
