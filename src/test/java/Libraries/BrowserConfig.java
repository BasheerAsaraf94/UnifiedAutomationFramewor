package Libraries;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserConfig 
{
	
	 public static WebDriver driver;
	 public static WebDriver wait;
	 
	public static WebDriver setBrowser(String url, String caselevel) throws InterruptedException
	{
		switch(caselevel)
		{
		case "Chrome":
			
			 WebDriverManager.chromedriver().setup(); // Introduction to Webdriver Manager        
			driver= new ChromeDriver();
					 
			 break;
			 
		case "Edge":
			System.setProperty("webdriver.edge.driver","C:\\Users\\PREDATOR\\Downloads\\msedgedriver.exe"); 
			 driver=new EdgeDriver();
			 break;
			 
		case "Firefox":
			
			System.setProperty("webdriver.gecko.driver","C:\\Users\\PREDATOR\\Documents\\geckodriver.exe"); 
			
			FirefoxOptions options = new FirefoxOptions();			

			String path = "C:\\Users\\PREDATOR\\Documents\\";
			options.addPreference("browser.download.folderList", 2);
			options.addPreference("browser.download.dir", path);
			options.addPreference("browser.download.manager.alertOnEXEOpen", false);
			options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword, application/csv, application/ris, text/csv, image/JPEG, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");
			options.addPreference("browser.download.manager.showWhenStarting", false);
			options.addPreference("browser.download.manager.focusWhenStarting", false);  
			options.addPreference("browser.download.useDownloadDir", true);
			options.addPreference("browser.helperApps.alwaysAsk.force", false);
			options.addPreference("browser.download.manager.alertOnEXEOpen", false);
			options.addPreference("browser.download.manager.closeWhenDone", true);
			options.addPreference("browser.download.manager.showAlertOnComplete", false);
			options.addPreference("browser.download.manager.useWindow", false);
			options.addPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
			options.addPreference("pdfjs.disabled", true);
			
			driver= new FirefoxDriver(options);
			break;
			}	
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		 driver.manage().deleteAllCookies();
		 driver.get(url);
		 return driver;
	}
	


}
