package BaseDriver;
import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

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
   
public class FrameworkDriver extends BrowserConfig 
{
 
	

	public static WebDriver driver;	

	
	public static void main(String[] args) throws InterruptedException, IOException, AWTException  
	{
			
	driver= setBrowser("https://demoqa.com/books", "Chrome");

	
	/*
	 
	// Text Box
	UF.Click(DemoQA.tabElements);
	UF.Click(DemoQA.tabTextBox);
	Thread.sleep(2000);
	UF.TextBox(DemoQA_TextBox.txtboxFullName, "Basheer");
	Thread.sleep(2000);
	UF.TextBox(DemoQA_TextBox.txtboxEmail, "basheera@maveric-systems.com");
	Thread.sleep(2000);
	UF.TextBox(DemoQA_TextBox.txtboxCurrentAddress1, "Chennai");
	Thread.sleep(2000);
	UF.TextBox(DemoQA_TextBox.txtboxCurrentAddress2, "Tamil Nadu");
	Thread.sleep(2000);
	UF.SendKeysEnter(DemoQA_TextBox.btnSubmit);
	
	//Checkbox
	UF.Click(DemoQA.tabCheckBox);
	Thread.sleep(2000);
	UF.Click(DemoQA_CheckBox.chkboxHome);
	Thread.sleep(2000);
	UF.Click(DemoQA_CheckBox.chklstbtn);
	Thread.sleep(2000);
	UF.Click(DemoQA_CheckBox.chkboxDesktop);
	
	//Radiobutton
	UF.Click(DemoQA.tabRadioBtn);
	Thread.sleep(2000);
	UF.Click(DemoQA_RadioBtn.rdbtnYes);	
	Thread.sleep(2000);
	UF.Click(DemoQA_RadioBtn.rdbImpressive);
	Thread.sleep(2000);
	UF.Click(DemoQA_RadioBtn.rdbtnNo);
	
	//WebTables 

	//Button
	UF.Click(DemoQA.tabButtons);
	Thread.sleep(2000);
	UF.Click(DemoQA_Buttons.btnClick);
	Thread.sleep(2000);
	UF.RightClick(DemoQA_Buttons.btnRightCLick); 
	Thread.sleep(2000);
	UF.DoubleCLick(DemoQA_Buttons.btnDoubleClick); 
	
	
	//Links
	UF.jsScrollIntoView(DemoQA.tabLinks);
	UF.Click(DemoQA.tabLinks);	
	String CurrentTab = UF.GetCurrentTab();	
	UF.Click(DemoQA_Links.lnkHome); 	
	Thread.sleep(4000);
	UF.SwitchTab(CurrentTab);
	
	List<WebElement> links = driver.findElements(By.tagName("a"));
	Iterator<WebElement> i = links.iterator();
	
	System.out.println(links.size());
	
	while(i.hasNext()) {
        WebElement anchor = i.next();
        if(anchor.getAttribute("href").contains("javascript:void(0)")) {
        	System.out.println(anchor.getText());
            anchor.click();
        }
	  }
	
	
   //Files
    UF.jsScrollIntoView(DemoQA.tabUpldDwnld);
    UF.Click(DemoQA.tabUpldDwnld);
    //UF.UploadBySendKeys(DemoQA_Files.btnUpload,"C:\\Users\\PREDATOR\\Downloads\\sampleFile.jpeg");
    UF.Click(DemoQA_Files.btnUpload1);
    Thread.sleep(5000);
    UF.AutoITscript("C:\\Users\\PREDATOR\\Documents\\FileUpload.exe"); 
    UF.Click(DemoQA_Files.btnDownload);
    
    
    //Dynamic Properties
    UF.jsScrollIntoView(DemoQA.tabDynamicprop);
    UF.Click(DemoQA.tabDynamicprop);
    System.out.println(Color.fromString(UF.GetCSSValue(DemoQA_DynamicProperties.btnColorchange,"Color")).asHex());
    System.out.println(UF.GetProperty(DemoQA_DynamicProperties.lblRandomId,"id"));
    UF.WaitUntillVisible(DemoQA_DynamicProperties.btnvisibleafter5sec);
    UF.Click(DemoQA_DynamicProperties.btnvisibleafter5sec);
    UF.WaitUntillEnable(DemoQA_DynamicProperties.btnEnableafter5sec);
    UF.Click(DemoQA_DynamicProperties.btnEnableafter5sec);
    System.out.println(Color.fromString(UF.GetCSSValue(DemoQA_DynamicProperties.btnColorchange,"Color")).asHex());
    
   
    UF.jsScrollIntoView(DemoQA.tabAlertsFrameswindows);
    UF.Click(DemoQA.tabAlertsFrameswindows);
    
  
    //Browser Windows
    UF.jsScrollIntoView(DemoQA.tabBrowserwindows);
	UF.Click(DemoQA.tabBrowserwindows);	
	String CurrentTab1 = UF.GetCurrentTab();	
	UF.Click(DemoQA_BrowserWindows.btnNewTab); 	
	Thread.sleep(4000);
	UF.SwitchTab(CurrentTab1);
	
	UF.Click(DemoQA_BrowserWindows.btnNewWindow);
	Thread.sleep(4000);
	UF.SwitchTab(CurrentTab1);
	
	UF.Click(DemoQA_BrowserWindows.btnNewMessage);
	Thread.sleep(4000);
	UF.SwitchTab(CurrentTab1);
	
	
	
	//Alerts
	UF.jsScrollIntoView(DemoQA.tabAlerts);
	UF.Click(DemoQA.tabAlerts);	
	UF.Click(DemoQA_Alerts.btnAlert);
	Thread.sleep(1000);
	UF.AlertAccept(0);
	UF.Click(DemoQA_Alerts.btnAlert5Sec);
	Thread.sleep(1000);
	UF.AlertAccept(0);
	UF.Click(DemoQA_Alerts.btnConfirmBox);
	Thread.sleep(1000);
	UF.AlertAccept(0);
	UF.Click(DemoQA_Alerts.btnConfirmBox);
	Thread.sleep(1000);
	UF.AlertDismiss();
	UF.Click(DemoQA_Alerts.btnpromptBox);
	Thread.sleep(1000);
	UF.AlertSendtext("Basheer");
	Thread.sleep(1000);
	UF.AlertAccept(0);
	UF.Click(DemoQA_Alerts.btnpromptBox);
	Thread.sleep(1000);
	UF.AlertSendtext("Basheer");
	Thread.sleep(1000);
	UF.AlertDismiss();

	
	
	//Frames
	//UF.jsScrollDownVertical(1000);
	UF.jsScrollIntoView(DemoQA.tabFrames);
	UF.Click(DemoQA.tabFrames);	
	UF.SwitchToFrame("frame1");
	System.out.println(UF.GetText(DemoQA_Frames.lblHeader));
	UF.SwitchToDefaultFrame();
	System.out.println(UF.GetText(DemoQA_Frames.lblMainheader));
	UF.SwitchToFrame("frame2");
	UF.jsScrollDownVertical(1000);
	UF.SwitchToDefaultFrame(); 
	
	//Modal
	UF.jsScrollIntoView(DemoQA.tabModalDialogs);
	UF.Click(DemoQA.tabModalDialogs);
	UF.Click(DemoQA_Modal.btnShowSmallModal); 
	UF.Click(DemoQA_Modal.btnCloseSmallModal);
	UF.Click(DemoQA_Modal.btnShowLargeModal);
	UF.Click(DemoQA_Modal.btnCloseLargeModal);
	
	
	
	//Widgets
	UF.jsScrollIntoView(DemoQA.tabWidgets);
	UF.Click(DemoQA.tabWidgets);
	
	
	
	//Accordian
	UF.jsScrollIntoView(DemoQA.tabAccordian);
	UF.Click(DemoQA.tabAccordian);
	UF.Click(DemoQA_Accordian.Accord1);
	UF.Click(DemoQA_Accordian.Accord2);
	UF.jsScrollIntoView(DemoQA_Accordian.Accord3);
	UF.Click(DemoQA_Accordian.Accord3);
	UF.jsScrollIntoView(DemoQA_Accordian.Accord3);
	
	/*
	//AutoComplete is not working
	UF.jsScrollIntoView(DemoQA.tabAutoComplete);
	UF.Click(DemoQA.tabAutoComplete);
	Thread.sleep(2000);
	UF.TextBox(DemoQA_AutoComplete.lstMultipleColorName,"B" );
	UF.selectOptionWithIndex(DemoQA_AutoComplete.lstMultipleColorNamelist,1);
	Thread.sleep(2000);
	UF.TextBox(DemoQA_AutoComplete.lstSingleColorName,"B" );
	Thread.sleep(2000);
	UF.selectOptionWithText(DemoQA_AutoComplete.lstSingleColorName, "Black");
	*/
	
	
	
	//Date picker
	
	//slider
	UF.jsScrollIntoView(DemoQA.tabSlider);
	UF.Click(DemoQA.tabSlider);
	//UF.Click(DemoQA_slider.slider);
	//UF.DragandDrop(DemoQA_slider.slider, 40, 0);
	//Thread.sleep(2000);
	UF.ClickandHold(DemoQA_slider.slider, 300, 0);
	
	
    /*
	//ProgressBar is not working
	UF.jsScrollIntoView(DemoQA.tabProgressBar);
	UF.Click(DemoQA.tabProgressBar);
	UF.Click(DemoQA_ProgressBar.btnstart);
	Thread.sleep(2000);
	UF.Click(DemoQA_ProgressBar.progressbar);
	UF.GetProgressBarWidth(DemoQA_ProgressBar.progressbar);
	*/
	
	
	//Tab
	UF.jsScrollIntoView(DemoQA.tabTabs);
	UF.Click(DemoQA.tabTabs);
	UF.Click(DemoQA_Tabs.tabOrigin);
	UF.Click(DemoQA_Tabs.tabWhat);
	UF.Click(DemoQA_Tabs.tabUse);
	
	
	//Mouse Hover
	UF.jsScrollIntoView(DemoQA.tabToolTips);
	UF.Click(DemoQA.tabToolTips);
	//UF.Click(DemoQa_ToolTips.btnHover);
	Thread.sleep(3000);
	UF.MouseOver(DemoQa_ToolTips.btnHover);
	Thread.sleep(3000);
	//UF.Click(DemoQa_ToolTips.txtHover);
	UF.MouseOver(DemoQa_ToolTips.txtHover);
	
	
	
	
	//Main Menu
	UF.jsScrollIntoView(DemoQA.tabMenu);
	UF.Click(DemoQA.tabMenu);
	
	Thread.sleep(2000);
	UF.MouseOver(DemoQA_Menu.menuItem1);
	
	Thread.sleep(2000);
	UF.MouseOver(DemoQA_Menu.menuItem3);
	
	Thread.sleep(2000);
	UF.MouseOver(DemoQA_Menu.menuItem2);
	
	Thread.sleep(2000);
	UF.MouseOver(DemoQA_Menu.submenulist);
	
	Thread.sleep(2000);
	UF.MouseOver(DemoQA_Menu.subsubmenuItem1);
	

	
	//Select Menu
	UF.jsScrollIntoView(DemoQA.tabSelectMenu);
	UF.Click(DemoQA.tabSelectMenu);
	
	//UF.SelectByValue(DemoQA_Select.selectvalue1, "1");
	
	
	
	//List<WebElement> oSelect = driver.findElements(By.className(" css-1wa3eu0-placeholder"));
	//List <WebElement> elementCount = oSelect.getOptions();
	//System.out.println(elementCount.size());
	
	//UF.SelectByIndex(DemoQA_Select.selectvalue2, 1);
	UF.SelectByVisibleText(DemoQA_Select.selectvale3, "Blue");
	
		
	*/
	
	
	
	
	
	
	
	
	
	
	
    
	
	
	}
}
