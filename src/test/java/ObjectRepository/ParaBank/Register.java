package ObjectRepository.ParaBank;

import org.openqa.selenium.By;

public class Register {
	
	public static final By txtFirstName=By.xpath("//input[@id='customer.firstName']");
	public static final By txtLastName=By.xpath("//input[@id='customer.lastName']");
	public static final By txtAddress=By.xpath("//input[@id='customer.address.street']");
	public static final By txtCity=By.xpath("//input[@id='customer.address.city']");
	public static final By txtState=By.xpath("//input[@id='customer.address.state']");
	public static final By txtZip=By.xpath("//input[@id='customer.address.zipCode']");
	public static final By txtPhone=By.xpath("//input[@id='customer.phoneNumber']");
	public static final By txtSSN=By.xpath("//input[@id='customer.ssn']");
	public static final By txtUserName=By.xpath("//input[@id='customer.username']");
	public static final By txtPwd=By.xpath("//input[@id='customer.password']");
	public static final By txtConfirm=By.xpath("//input[@id='repeatedPassword']");
	public static final By btnRegister=By.xpath("//table[@class='form2']//input[@class='button']");
	public static final By lblRegisterConfirmation=By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]");
}
