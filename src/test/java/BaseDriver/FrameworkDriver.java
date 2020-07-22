package BaseDriver;
import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Libraries.BrowserConfig;
import Libraries.UF;
import ObjectRepository.DemoQA;
import ObjectRepository.DemoQA_Accordian;
import ObjectRepository.DemoQA_Alerts;
import ObjectRepository.DemoQA_AutoComplete;
import ObjectRepository.DemoQA_BrowserWindows;
import ObjectRepository.DemoQA_Buttons;
import ObjectRepository.DemoQA_CheckBox;
import ObjectRepository.DemoQA_DynamicProperties;
import ObjectRepository.DemoQA_Files;
import ObjectRepository.DemoQA_Frames;
import ObjectRepository.DemoQA_Links;
import ObjectRepository.DemoQA_Menu;
import ObjectRepository.DemoQA_Modal;
import ObjectRepository.DemoQA_ProgressBar;
import ObjectRepository.DemoQA_RadioBtn;
import ObjectRepository.DemoQA_Select;
import ObjectRepository.DemoQA_Tabs;
import ObjectRepository.DemoQA_TextBox;
import ObjectRepository.DemoQA_slider;
import ObjectRepository.DemoQa_ToolTips;
import sun.awt.SunHints.Value;
   
public class FrameworkDriver extends BrowserConfig 
{
	public static WebDriver driver;	
	
	public static Properties prop = new Properties();
	
	//public static void main(String[] args) throws InterruptedException, IOException, AWTException  
	//{
	public static void readproperty()
	{
		File file = new File("C:\\Users\\PREDATOR\\eclipse-workspace\\BasheerTestFramework\\DataProperties\\dataFile.Properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
			} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			}
							
							try {
								prop.load(fileInput);
							} catch (IOException e) {
								e.printStackTrace();
							}

					//		Enumeration KeyValues = prop.keys();
					//		while (KeyValues.hasMoreElements()) {
					//			String key = (String) KeyValues.nextElement();
					//			String value = prop.getProperty(key);
					//			System.out.println(key + ":- " + value);
					//		}
	
	}
	
	public static void Browser_Trigger()
	{
		try {
			driver= setBrowser("https://parabank.parasoft.com/parabank/index.htm","Chrome");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	
	public static WebDriver getdriver()
	{
		return driver;
	}

}	
//}
