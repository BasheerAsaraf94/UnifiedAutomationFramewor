package ObjectRepository.ParaBank;

import org.openqa.selenium.By;

public class HomePage {
	
	public static final By Register=By.xpath("//a[contains(text(),'Register')]");
	public static final By txtUsername=By.xpath("//input[@name='username']");
	public static final By txtPwd=By.xpath("//input[@name='password']");
	public static final By btnSignIn=By.xpath("//input[@class='button']");
}
