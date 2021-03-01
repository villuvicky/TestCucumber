package com.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
/**
 * for getting properties
 * returns properties
 */

	private  Properties prop;
	private FileInputStream ip;

	public Properties init_prop() 
	{

		prop= new Properties();
		try {
			ip= new FileInputStream("C:\\Users\\villu\\eclipse-workspace\\TestCucumeber\\src\\test\\resources\\ConfigFiles\\config.properties");
			prop.load(ip);
		}

		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return prop;
	}

}
