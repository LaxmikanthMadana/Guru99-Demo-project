package com.miniProj.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties props;
	
	public ReadConfig()
	{
		
		File src = new File("./Configuration/config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			props = new Properties();
			props.load(fis);
		}catch(Exception e)
		{
			System.out.println("Exception message is: "+ e.getMessage());
		}
		
	}
	
	public String getApplicationURL()
	{
		String url = props.getProperty("baseURL");
		return url;
	}
	
	public String getUserID()
	{
		String userId = props.getProperty("userID");
		return userId;
	}
	
	public String getPassword()
	{
		String pwd = props.getProperty("password");
		return pwd;
	}
	
	
	public String getChromePath()
	{
		String chromePath = props.getProperty("chromepath");
		return chromePath;
	}
	
	public String getIEPath()
	{
		String IEPath = props.getProperty("IEpath");
		return IEPath;
	}
	
	public String getFirefoxPath()
	{
		String FirefoxPath = props.getProperty("firefoxpath");
		return FirefoxPath;
	}
	
}
