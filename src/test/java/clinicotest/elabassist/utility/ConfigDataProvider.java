package clinicotest.elabassist.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;
	
	public ConfigDataProvider() {
		File src = new File("./Configuration/config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("unable to load config file "+e.getMessage());
			
		}
		
	}
	public String getDataFromConfig(String keyToSearch) {
		return prop.getProperty(keyToSearch);

	}
	public String getBrowser() {
		return prop.getProperty("Browser");
		
	}
	public String GetAppUrl() {
		return prop.getProperty("qaURL");
		
	}

}
