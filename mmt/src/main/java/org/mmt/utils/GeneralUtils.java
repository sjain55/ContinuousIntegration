package org.mmt.utils;

import java.io.FileReader;
import java.util.Properties;



public class GeneralUtils {
	Properties prop;
	FileReader fr;
	public GeneralUtils(){
		prop = new Properties();
	}
	
	public String getProperty(String property){
		String result=null;
		try {
			prop = new Properties();
			fr = new FileReader("E:\\Eclipse-Photon\\mmt\\config.properties");
			prop.load(fr);
			result = prop.getProperty(property);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
}
