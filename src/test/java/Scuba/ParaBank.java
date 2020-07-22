package Scuba;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseDriver.FrameworkDriver;
import Libraries.ExcelUtils;
import Libraries.UF;
import ObjectRepository.ParaBank.HomePage;

public class ParaBank {
	
  public static WebDriver driver;	
  
@DataProvider
public Object[][] Authentication() throws Exception{

       Object[][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\PREDATOR\\eclipse-workspace\\BasheerTestFramework\\Test Data\\ParaBank.xlsx","Sheet1");
       return (testObjArray);
       }

static ExtentTest test;
static ExtentReports report;

@BeforeMethod
  public void OpenBrowser() {
	System.out.println("TriggerBroswser");
	FrameworkDriver.Browser_Trigger();  
	report = new ExtentReports("C:\\Users\\PREDATOR\\eclipse-workspace\\BasheerTestFramework\\ExtentReport\\ExtentReportResults.html");
  }

@AfterTest
public static void endTest()
{
report.endTest(test);
report.flush();
FrameworkDriver.driver.close();
FrameworkDriver.driver.quit();
}
  
@Test(dataProvider = "Authentication")
  public void Register(String FirstName,String SecondName,String Address,String City,String State,String ZipCode,String Phone,String SSN,String Username,String Password,String Confirm) throws IOException {
	  test = report.startTest("Register");
	  UF.Click(HomePage.Register);
	  UF.TextBox(ObjectRepository.ParaBank.Register.txtFirstName, FirstName);
	  UF.TextBox(ObjectRepository.ParaBank.Register.txtLastName, SecondName);
	  UF.TextBox(ObjectRepository.ParaBank.Register.txtAddress, Address);
	  UF.TextBox(ObjectRepository.ParaBank.Register.txtCity, City);
	  UF.TextBox(ObjectRepository.ParaBank.Register.txtState, State);
	  UF.TextBox(ObjectRepository.ParaBank.Register.txtZip, ZipCode);
	  UF.TextBox(ObjectRepository.ParaBank.Register.txtPhone, Phone);
	  UF.TextBox(ObjectRepository.ParaBank.Register.txtSSN, SSN);
	  UF.TextBox(ObjectRepository.ParaBank.Register.txtUserName, Username);
	  UF.TextBox(ObjectRepository.ParaBank.Register.txtPwd, Password);
	  UF.TextBox(ObjectRepository.ParaBank.Register.txtConfirm, Confirm);
	  test.log(LogStatus.PASS, "Details Entered Successfully");
	  UF.Click(ObjectRepository.ParaBank.Register.btnRegister);
	  Assert.assertEquals("Your account was created successfully. You are now logged in.", UF.GetText(ObjectRepository.ParaBank.Register.lblRegisterConfirmation));
	  test.log(LogStatus.PASS, "Successfully Registered");
	   }
}
