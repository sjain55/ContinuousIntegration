package org.mmt.utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			fr = new FileReader("C:\\Users\\mmt7543\\git\\ContinuousIntegration\\mmt\\config.properties");
			prop.load(fr);
			result = prop.getProperty(property);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	/**
	 * <pre>to connect to mysqldb
	 */
	private Statement connectToMysql() {
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn	= DriverManager.getConnection("jdbc:mysql://localhost:3306/primeserviceqa","primeserviceqa","primeserviceqa");
			stmt =  conn.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
		return stmt;
	}
	
	/**
	 * <pre>to return sql resultset
	 */
	private ResultSet executeSql(String query) {
		ResultSet resultset = null;
		try {
			resultset= this.connectToMysql().executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultset;
	}



}
