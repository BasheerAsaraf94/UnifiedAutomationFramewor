package BaseDriver;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Libraries.BrowserConfig;
import Libraries.UF;
import ObjectRepository.DemoQA;
import ObjectRepository.DemoQA_Buttons;
import ObjectRepository.DemoQA_CheckBox;
import ObjectRepository.DemoQA_Links;
import ObjectRepository.DemoQA_RadioBtn;
import ObjectRepository.DemoQA_TextBox;
   
public class FrameworkDriver extends BrowserConfig 
{
 
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException  
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
	//UF.Click(DemoQA.tabButtons);
	//UF.Click(DemoQA_Buttons.btnClick);
	//UF.RightClick(DemoQA_Buttons.btnRightCLick); //Not Working
	//UF.DoubleCLick(DemoQA_Buttons.btnDoubleClick); //Not Working
	
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
	
	
	
	
	
	 
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	}
}
