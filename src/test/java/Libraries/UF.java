package Libraries;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BaseDriver.FrameworkDriver;

public class UF {
	static WebDriver driver;
	public static void TextBox(By ObjRep , String Keyvalue) 
	{	
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		ele.sendKeys(Keyvalue);
	}
	public static void Click(By ObjRep) 
	{	
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		ele.click();
	}
	public static void Submit(By ObjRep) 
	{	
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		ele.submit();
	}
	public static void SendKeysEnter(By ObjRep) 
	{	
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		ele.sendKeys(Keys.ENTER);
	}
	public static boolean IsSelected(By ObjRep) 
	{	
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		return ele.isSelected();
	        
	}
	public static boolean IsEnabled(By ObjRep) 
	{	
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		return ele.isEnabled();
	}
	public static boolean IsDisplayed(By ObjRep) 
	{	
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		return ele.isDisplayed();
	}
	public static void DoubleCLick(By ObjRep) 
	{	
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		Actions action = new Actions(driver);
		action.doubleClick(ele).build().perform();
	}	

	public static void RightClick(By ObjRep) 
	{	
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		Actions action = new Actions(driver).contextClick(ele);
		action.build().perform();
	}
	

}
