package Libraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserConfig 
{
	
	 public static WebDriver driver;
	public static WebDriver setBrowser(String url, String caselevel)
	{
		switch(caselevel)
		{
		case "Chrome":
			System.setProperty("webdriver.chrome.driver","C:\\Users\\PREDATOR\\Documents\\chromedriver.exe"); 
			 driver=new ChromeDriver();
			 break;
			 
		case "Edge":
			System.setProperty("webdriver.edge.driver","C:\\Users\\PREDATOR\\Downloads\\msedgedriver.exe"); 
			 driver=new EdgeDriver();
			 break;
			 
		case "Firefox":
			System.setProperty("webdriver.gecko.driver","C:\\Users\\PREDATOR\\Documents\\geckodriver.exe"); 
			driver=new FirefoxDriver();
			break;
			}
		
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		 driver.manage().deleteAllCookies();
		 driver.get(url);
		 return driver;
	}

}
