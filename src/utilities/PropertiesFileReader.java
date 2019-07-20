/*******************************************************************************
 * © Copyright (C) 2018 Selenium Project @Surya.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package utilities;

/**
 * Properties file reading Implementation
 * 
 *by Surya
 * 
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileReader {

	private static PropertiesFileReader INSTANCE = null;
	static Properties properties = new Properties();

	private PropertiesFileReader() {

	}

	public static synchronized PropertiesFileReader getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PropertiesFileReader();
		}
		return INSTANCE;
	}

	public Properties readProperties(String name) {

		InputStream in = null;

		try {
			if (null != name) {
				in = this.getClass().getResourceAsStream("/resources/" + name);

				properties.load(in);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public static String getKeyValue(String key) {
		String value = null;
		if (null != key && !"".equalsIgnoreCase(key)) {
			value = (String) properties.get(key);
		}
		return value;
	}

}
