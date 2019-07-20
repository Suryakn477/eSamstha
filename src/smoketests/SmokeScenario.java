/*******************************************************************************
 * © Copyright (C) 2018 Selenium Project @Harish.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package smoketests;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Properties;

import org.testng.annotations.Test;

import objectRepository.DashboardPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import utilities.PropertiesFileReader;
import utilities.BaseTest;

public class SmokeScenario extends BaseTest{	
	public static Properties commonproperties =null;
	
	static{
		commonproperties =PropertiesFileReader.getInstance().readProperties("common.properties");
	}
	//---------------------------Login-------------------------------------------------------------
		

}
