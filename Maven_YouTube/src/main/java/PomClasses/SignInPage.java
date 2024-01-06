package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	WebDriver driver;
	Actions act;
	@FindBy(xpath ="//div[@id='logo']")
	private WebElement titl; 
	
	@FindBy(xpath ="//div[@jsname='WjL7X']//button")
	private WebElement creatNewAccount;
	
	@FindBy(xpath="//li[@jsname='iAUJgf']")
	private WebElement creatAccountForWork; 
	
	
	public SignInPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}


	public String getTitle() {
		String title =driver.getTitle();
		return title;
	}
	public void clickOnCreatNewAccount() {
//		act.moveToElement(creatNewAccount).click().build().perform();
		creatNewAccount.click();
	}
	
	public void clickOncreatAccountForWork() {
		creatAccountForWork.click();
		//CreatAccount creatAccount = new CreatAccount(driver);
		//return creatAccount;
	}
	
}
	