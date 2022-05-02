package com.eBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File(System.getProperty("user.dir") + File.separator + "Configuration" + File.separator
				+ "config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is : " + e.getMessage());
		}
	}

	public String getApplicationURL() {
		return pro.getProperty("baseURL");
	}

	public String getUserName() {
		return pro.getProperty("userName");
	}

	public String getPassword() {
		return pro.getProperty("password");
	}

}
