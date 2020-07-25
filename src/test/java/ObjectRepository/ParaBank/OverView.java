package ObjectRepository.ParaBank;

import org.openqa.selenium.By;

public class OverView {
	
	public static final By lblAccntOverview=By.xpath("//b[contains(text(),'Welcome')]");
	public static final By lblOpenNewAccount=By.xpath("//a[contains(text(),'Open New Account')]");
	public static final By lstAccntType=By.xpath("//select[@id='type']");
	public static final By lstAccntId=By.xpath("//select[@id='fromAccountId']");
	public static final By btnOpenNewAcnt=By.xpath("//input[@class='button']");
	public static final By lblCheck=By.xpath("//p[contains(text(),'Congratulations, your account is now open.')]");
}
