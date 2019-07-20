/*******************************************************************************
 * © Copyright (C) 2018 Selenium Project @Surya.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package objectRepository;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	
	
	
}
