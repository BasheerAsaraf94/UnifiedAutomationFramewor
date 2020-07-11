package BaseDriver;
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
import ObjectRepository.DemoQA_Buttons;
import ObjectRepository.DemoQA_CheckBox;
import ObjectRepository.DemoQA_DynamicProperties;
import ObjectRepository.DemoQA_Files;
import ObjectRepository.DemoQA_Links;
import ObjectRepository.DemoQA_RadioBtn;
import ObjectRepository.DemoQA_TextBox;
   
public class FrameworkDriver extends BrowserConfig 
{
 
	

	public static WebDriver driver;	

	
	public static void main(String[] args) throws InterruptedException, IOException  
	{
			
	driver= setBrowser("https://demoqa.com/books", "Firefox");

	// Text Box
	UF.Click(DemoQA.tabElements);
	UF.Click(DemoQA.tabTextBox);
	UF.TextBox(DemoQA_TextBox.txtboxFullName, "Basheer");
	UF.TextBox(DemoQA_TextBox.txtboxEmail, "basheera@maveric-systems.com");
	UF.TextBox(DemoQA_TextBox.txtboxCurrentAddress1, "Chennai");
	UF.TextBox(DemoQA_TextBox.txtboxCurrentAddress2, "Tamil Nadu");
	UF.SendKeysEnter(DemoQA_TextBox.btnSubmit);
	
	//Checkbox
	UF.Click(DemoQA.tabCheckBox);
	UF.Click(DemoQA_CheckBox.chkboxHome);
	UF.Click(DemoQA_CheckBox.chklstbtn);
	UF.Click(DemoQA_CheckBox.chkboxDesktop);
	
	//Radiobutton
	UF.Click(DemoQA.tabRadioBtn);
	UF.Click(DemoQA_RadioBtn.rdbtnYes);	
	UF.Click(DemoQA_RadioBtn.rdbImpressive);
	UF.Click(DemoQA_RadioBtn.rdbtnNo);
	
	//WebTables 

	//Button
	UF.Click(DemoQA.tabButtons);
	UF.Click(DemoQA_Buttons.btnClick);
	UF.RightClick(DemoQA_Buttons.btnRightCLick); 
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
	}
}
