package Libraries;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	public static void AlertAccept(int flag) throws AWTException 
	{	
		 wait.until(ExpectedConditions.alertIsPresent());
		Alert a = FrameworkDriver.driver.switchTo().alert();
		if (flag == 1) {
		 Robot robot = new Robot();
		 robot.delay(5000);
		 for (int i = 1; i <= 2; i++) {
			 
		     robot.keyPress(KeyEvent.VK_TAB);
		 }
	     robot.keyPress(KeyEvent.VK_SPACE);
		}
		a.accept();
	}	
	public static void AlertDismiss() 
	{	
		 wait.until(ExpectedConditions.alertIsPresent());
		Alert a = FrameworkDriver.driver.switchTo().alert();
		a.dismiss();
		 
	}
	
	public static void AlertSendtext(String value) 
	{	
		 wait.until(ExpectedConditions.alertIsPresent());
		Alert a = FrameworkDriver.driver.switchTo().alert();
		a.sendKeys(value);
	}
	public static void SwitchToActiveElement() 
	{	
		 wait.until(ExpectedConditions.alertIsPresent());
		FrameworkDriver.driver.switchTo().activeElement();
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
	
	public static void jsScrollDownVertical(int pixel)
	{
		JavascriptExecutor js = (JavascriptExecutor) FrameworkDriver.driver;
		 js.executeScript("window.scrollBy(0,"+pixel+")");
		
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
	
	public static void SwitchToFrame(String FrameID) {
		FrameworkDriver.driver.switchTo().frame(FrameID);
		}
	
	public static void SwitchToWindow(String WindowID) {
		FrameworkDriver.driver.switchTo().window(WindowID);
		}
	
public static void selectOptionWithIndex(By ObjRep,int indexToSelect) {
		
		try {
			WebElement autoOptions=FrameworkDriver.driver.findElement(ObjRep);
			wait.until(ExpectedConditions.visibilityOf(autoOptions));

			List<WebElement> optionsToSelect = FrameworkDriver.driver.findElements(By.className("auto-complete__value-container auto-complete__value-container--is-multi css-1hwfws3"));;
		        if(indexToSelect<=optionsToSelect.size()) {
		        	System.out.println("Trying to select based on index: "+indexToSelect);
		           optionsToSelect.get(indexToSelect).click();
		      }
		   } 		
		catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

public static void selectOptionWithText(By ObjRep,String textToSelect) {
	try {
		WebElement autoOptions=FrameworkDriver.driver.findElement(ObjRep);
		wait.until(ExpectedConditions.visibilityOf(autoOptions));

		List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
		for(WebElement option : optionsToSelect){
	        if(option.getText().equals(textToSelect)) {
	        	System.out.println("Trying to select: "+textToSelect);
	            option.click();
	            break;
	        }
	    }
		
	} catch (NoSuchElementException e) {
		System.out.println(e.getStackTrace());
	}
	catch (Exception e) {
		System.out.println(e.getStackTrace());
	}
}
	
	
	public static void SwitchToDefaultFrame() {
		FrameworkDriver.driver.switchTo().defaultContent();
		}
	

	public static String GetText(By ObjRep) {
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		return ele.getText();
		}
	
	public static void DragandDrop(By ObjRep,int xaxis,int yaxis) {
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		Actions action = new Actions(FrameworkDriver.driver);
		action.dragAndDropBy(ele, xaxis,yaxis).build().perform();
	  // action.moveToElement(slider).clickAndHold().moveByOffset(20,0).release().perform();
		}
	
	public static void ClickandHold(By ObjRep,int xaxis,int yaxis) {
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		Actions action = new Actions(FrameworkDriver.driver);
		Dimension sliderSize = ele.getSize();
		int sliderWidth = sliderSize.getWidth();
		int xCoord = ele.getLocation().getX();
		System.out.println(sliderWidth);
		System.out.println(xCoord);
		//action.dragAndDropBy(ele, xaxis,yaxis).build().perform();
		action.moveToElement(ele).clickAndHold().moveByOffset(xaxis,yaxis).release().perform();
		}
	
	public static void GetProgressBarWidth(By ObjRep) {
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		Dimension sliderSize = ele.getSize();
		int sliderWidth = sliderSize.getWidth();
		int xCoord = ele.getLocation().getX();
		}
	
	public static void MouseOver(By ObjRep) {
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		Actions action = new Actions(FrameworkDriver.driver);
		action.moveToElement(ele).perform();		
		}
	
	
	public static void SelectByVisibleText(By ObjRep, String VisibleText) {
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		Select selObj=new Select(ele);
		selObj.selectByVisibleText(VisibleText);		
		}
	
	public static void SelectByIndex(By ObjRep, int Indexvalue) {
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		Select selObj=new Select(ele);
		selObj.selectByIndex(Indexvalue);		
		}
	
	public static void SelectByValue(By ObjRep, String Value) {
		WebElement ele=FrameworkDriver.driver.findElement(ObjRep);
		Select selObj=new Select(ele);
		selObj.selectByValue(Value);		
		}
	
	

}
