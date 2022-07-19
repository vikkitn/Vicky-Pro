package org.yantra.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	Properties properties;
/**
 * This method is used to initialize the Property file
 * @param filePath
 */
	public void initializePropertyFile(String filePath) {
		FileInputStream fis;
			try {
				fis = new FileInputStream(filePath);
				properties = new Properties();
				properties.load(fis);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
		
	/**
	 * This method is used to get the data from Property file
	 * @param key
	 * @return 
	 */
	public String getDataFromPropertyFile(String key)
	{
		return properties.getProperty(key).trim();
	}
}
