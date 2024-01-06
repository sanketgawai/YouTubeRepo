package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	Actions act;
	
	@FindBy(xpath="//input[@id='search']")
	private WebElement searchBox;
	
	@FindBy(css="button#search-icon-legacy")
	private WebElement searchBoxButton;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}
	
	public void sendNameinSearchBox(String name)
	{
		act.moveToElement(searchBox).click().sendKeys(name).build().perform();
	}
	public VideoPage clickOnSearchBoxButton()
	{
		act.moveToElement(searchBoxButton).click().build().perform();
		VideoPage videoPage  = new VideoPage(driver);
		return videoPage;
	}
}
