package Libraries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseDriver.FrameworkDriver;

public class UF {
	//public static WebDriver driver;
	public static WebDriverWait wait = new WebDriverWait(FrameworkDriver.driver,20);
	
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
	public static void WaitUntillVisible(By ObjRep) 
	{	
		@SuppressWarnings("unused")
		WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(ObjRep));
	}
	public static void WaitUntillEnable(By ObjRep) 
	{	
		
		@SuppressWarnings("unused")
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(ObjRep));
	}
	public static String GetCSSValue(By ObjRep,String Property) 
	{	
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		return ele.getCssValue(Property);
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
		Actions action = new Actions(FrameworkDriver.driver);
		action.doubleClick(ele).build().perform();
	}	

	public static void RightClick(By ObjRep) 
	{	
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		Actions action = new Actions(FrameworkDriver.driver).contextClick(ele);
		action.build().perform();
	}
	
	public static void jsScrollIntoView(By ObjRep) 
	{	
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		JavascriptExecutor executor = (JavascriptExecutor)FrameworkDriver.driver;
		executor.executeScript("arguments[0].scrollIntoView()", ele);
	}
	
	public static String GetCurrentTab()
	{
		String  currentTab = FrameworkDriver.driver.getWindowHandle();
		return currentTab;
	}
	
	public static void SwitchTab(String CurrentTab)
	{
		ArrayList<String> tabs = new ArrayList<String>(FrameworkDriver.driver.getWindowHandles());
		for (String S:tabs) {
		 if(!S.equals(CurrentTab)) {
			 FrameworkDriver.driver.switchTo().window(CurrentTab);
		 }
		}
	}
	
	public static void UploadBySendKeys(By ObjRep,String FilePath)
	{
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		ele.sendKeys(FilePath);
	}

	public static void AutoITscript(String FilePath) {
	
		try {
			Runtime.getRuntime().exec(FilePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static String GetProperty(By ObjRep,String tagname) {
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		return ele.getAttribute(tagname);
		
	}
	

}
