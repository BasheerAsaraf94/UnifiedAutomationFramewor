package BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import Libraries.BrowserConfig;
import Libraries.UF;
import ObjectRepository.DemoQA;
import ObjectRepository.DemoQA_CheckBox;
import ObjectRepository.DemoQA_RadioBtn;
import ObjectRepository.DemoQA_TextBox;
   
public class FrameworkDriver extends BrowserConfig 
{
 
	public static WebDriver driver;

	public static void main(String[] args)  
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
	System.out.println(UF.IsSelected(DemoQA_CheckBox.chkboxHome));
	UF.Click(DemoQA_CheckBox.chklstbtn);
	UF.Click(DemoQA_CheckBox.chkboxDesktop);
	UF.IsDisplayed(DemoQA_CheckBox.chkboxDocuments);
	UF.IsEnabled(DemoQA_CheckBox.chkboxDocuments);
	
	//Radiobutton
	UF.Click(DemoQA.tabRadioBtn);
	System.out.println(UF.IsSelected(DemoQA_RadioBtn.rdbtnYes));
	System.out.println(UF.IsDisplayed(DemoQA_RadioBtn.rdbtnYes));
	System.out.println(UF.IsEnabled(DemoQA_RadioBtn.rdbtnYes));
	UF.Click(DemoQA_RadioBtn.rdbtnYes);
	System.out.println(UF.IsSelected(DemoQA_RadioBtn.rdbtnYes));
	
	UF.Click(DemoQA_RadioBtn.rdbImpressive);
	
	System.out.println(UF.IsSelected(DemoQA_RadioBtn.rdbtnNo));
	System.out.println(UF.IsDisplayed(DemoQA_RadioBtn.rdbtnNo));
	System.out.println(UF.IsEnabled(DemoQA_RadioBtn.rdbtnNo));
	UF.Click(DemoQA_RadioBtn.rdbtnNo);
	System.out.println(UF.IsSelected(DemoQA_RadioBtn.rdbtnNo));
	
	//Tablse
	UF.Click(DemoQA.tabWebTables);
	
	
	
	
	
	
	
	
	}
}
