package ObjectRepository;

import org.openqa.selenium.By;

public class DemoQA_Menu {
	public static final By menuItem1=By.xpath("//a[contains(text(),'Main Item 1')]");
	public static final By menuItem2=By.xpath("//a[contains(text(),'Main Item 2')]");
	public static final By menuItem3=By.xpath("//a[contains(text(),'Main Item 3')]");
	public static final By submenuItem1=By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='container playgound-body']/div[@class='row']/div[@class='col-12 mt-4 col-md-6']/div[@class='nav-menu-container']/ul[@id='nav']/li/ul/li[1]/a[1]");
	public static final By submenulist=By.xpath("//a[contains(text(),'SUB SUB LIST »')]");
	public static final By subsubmenuItem1=By.xpath("//a[contains(text(),'Sub Sub Item 2')]");
}
