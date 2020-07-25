package Scuba;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;

import BaseDriver.FrameworkDriver;
import Libraries.ExcelUtils;
import Libraries.UF;
import ObjectRepository.ParaBank.HomePage;
import ObjectRepository.ParaBank.OverView;

public class ParaBank {
	
  public static WebDriver driver;	
  
@DataProvider
public Object[][] Authentication() throws Exception{

       Object[][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\PREDATOR\\eclipse-workspace\\BasheerTestFramework\\Test Data\\ParaBank.xlsx","Sheet1");
       return (testObjArray);
       }

public static ExtentTest test;
public static ExtentReports report;

@BeforeSuite
public void extentreport(){
	report = new ExtentReports("C:\\Users\\PREDATOR\\eclipse-workspace\\BasheerTestFramework\\ExtentReport\\ExtentReportResults.html");
}


@BeforeMethod
  public void OpenBrowser() {
	System.out.println("TriggerBroswser");
	FrameworkDriver.Browser_Trigger();  
}

@AfterMethod
public static void endTest()
{
report.endTest(test);
report.flush();
FrameworkDriver.driver.close();
}
  
@Test(dataProvider = "Authentication",priority=0)
  public void Register(String TestcaseName, String FirstName,String SecondName,String Address,String City,String State,String ZipCode,String Phone,String SSN,String Username,String Password,String Confirm) throws IOException, InterruptedException {   
	
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
	  UF.Click(ObjectRepository.ParaBank.Register.btnRegister);
	  Assert.assertEquals("Your account was created successfully. You are now logged in.", UF.GetText(ObjectRepository.ParaBank.Register.lblRegisterConfirmation));
	  test.log(LogStatus.PASS, "Successfully Registered");
	  }

@Test(dataProvider = "Authentication",priority=1)
public void Login(String TestcaseName, String FirstName,String SecondName,String Address,String City,String State,String ZipCode,String Phone,String SSN,String Username,String Password,String Confirm) throws IOException, InterruptedException {   
	
	  test = report.startTest("Login");
	  UF.TextBox(HomePage.txtUsername, Username);
	  UF.TextBox(HomePage.txtPwd,Password);
	  UF.Click(HomePage.btnSignIn);
	  Assert.assertEquals("Welcome", UF.GetText(OverView.lblAccntOverview));
	  test.log(LogStatus.PASS, "Successfully LoggedIN");
	  }

@Test(dataProvider = "Authentication",priority=2)
public void OpenSavingAccount(String TestcaseName, String FirstName,String SecondName,String Address,String City,String State,String ZipCode,String Phone,String SSN,String Username,String Password,String Confirm) throws IOException, InterruptedException {   
	
	  test = report.startTest("OpenSavingAccount");
	  
	  UF.TextBox(HomePage.txtUsername, Username);
	  UF.TextBox(HomePage.txtPwd,Password);
	  UF.Click(HomePage.btnSignIn);
	  Assert.assertEquals("Welcome", UF.GetText(OverView.lblAccntOverview));
	  test.log(LogStatus.PASS, "Successfully LoggedIN");
	  UF.Click(OverView.lblOpenNewAccount);
	  UF.SelectByVisibleText(OverView.lstAccntType, "CHECKING");
	  UF.Click(OverView.btnOpenNewAcnt);
	  }
}
