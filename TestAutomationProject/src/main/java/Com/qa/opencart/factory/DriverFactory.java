package Com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManeger om;

	/**
	 * this method id initializing the driver on the basis of browser name and it
	 * return the driver
	 * 
	 * @param browserName
	 * @return
	 */
	public WebDriver initDriver(Properties prop) {
		
		om=new OptionsManeger(prop);
		
		String browserName = prop.getProperty("browser").trim();

		System.out.println("Browser Name is = "+browserName);

		if (browserName.trim().equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver(om.getChromeOption());
		}
		else if (browserName.trim().equalsIgnoreCase("fireFox")) {

			driver = new FirefoxDriver(om.getFireFoxOption());
		}
		else if (browserName.trim().equalsIgnoreCase("edge")) {

			driver = new EdgeDriver(om.getEdgeOption());
		} else {
			System.out.println("Please pass the right driver-" + browserName);
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
		// driver session is same untill driver.quite() work
	}

	public Properties initProp() {

		prop = new Properties();
		// create the object of fileinputstream class- it is used to interact with java
		// files,
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");// pass here the
																										// path
			prop.load(ip);																						// of properties
																										// file which is
																										// in
																										// config folder
			// (./) means go to the direct project directly

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
			{

			}

		}
		return prop;

	}
}
