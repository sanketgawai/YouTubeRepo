package PomClasses;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Waitt.AbstractComponents;

public class CreatAccount extends AbstractComponents{
	
	WebDriver driver;
	Actions act;
	JavascriptExecutor js;
	
	@FindBy(xpath="(//div[@class='Xb9hP']/div)[1]")
	private WebElement placeHolderOfNameField;
	
	@FindBy(xpath="//div[@role='combobox']")
	private WebElement languageDropDown;
	
//	@FindBy(css="div[jsname='xl07Ob']")
//	private WebElement scrollDropDown;
	
	@FindBy(xpath="//ul[@role='listbox']//li")
	private List<WebElement> languageSelect;
	
	@FindBy(xpath="//ul[@role='listbox']//li/span/span")
	private List<WebElement> languageList;
	
	@FindBy(css="h1#headingText span")
	private WebElement newLanguage;
	
	public CreatAccount(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		js =(JavascriptExecutor)driver;
	}
	
	public String getTextOfPlaceHolderOfNameField() {
		waitForwebElementToAppear(placeHolderOfNameField);
		String placeHoldertext =placeHolderOfNameField.getText();
		return placeHoldertext;
	}
	
	public void clickOnLanguageDropDown()
	{
		js.executeScript("window.scrollBy(0,500)");
		languageDropDown.click();
		//js.executeScript("arguments[0].scrollTop = 2800;", scrollDropDown);
		//js.executeScript("document.querySelector(scrollDropDown).scrollTop = 2800");
	}
	
	public void selectLanguage(String Mrathi)
	{
		int j =0;
		for(int i=1;i<=languageSelect.size();i++)
		{
			//if(languageList.get(i).getText().equalsIgnoreCase("मराठी"))
			if(languageList.get(i).getText().equalsIgnoreCase(Mrathi))
			{
				languageSelect.get(i).click();
				break;  // Break out of the loop once the language is selected
			}
		}
	}
	
	public String checkNewLanguage()
	{
		String language = newLanguage.getText();
		return language;
	}
	
}
