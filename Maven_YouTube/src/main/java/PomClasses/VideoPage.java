package PomClasses;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Waitt.AbstractComponents;

public class VideoPage extends AbstractComponents {

	WebDriver driver;
	Actions act;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	@FindBy(xpath="//yt-formatted-string[contains(@aria-label,'[4K] One Piece「AMV/Edit」(Royalty) by Jemartob')]")
	private WebElement vid;
	//button.yt-spec-button-shape-next
	//yt-button-shape[@id='subscribe-button-shape']/button
	@FindBy(xpath="//yt-button-shape[@id='subscribe-button-shape']/button")
	private List<WebElement> subscribe;
	
	@FindBy(xpath = "//yt-formatted-string[@id='content']")
	private WebElement errorMessage;
	
	@FindBy(xpath ="//ytd-button-renderer[@id ='button']//a")
	private WebElement signInButtonOnErrorMessage;
	
	public VideoPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		wait = new WebDriverWait(driver,20);
		js =(JavascriptExecutor)driver;
	}
	
	public void clickOnVideo() {
		act.moveToElement(vid).click().build().perform();
	}
	
	//*this is not working index is working
//	public void clickOnSubscribeButton() {
//		//wait.until(ExpectedConditions.visibilityOfAllElements(subscribe));
//		for (WebElement subscribeButton : subscribe) {
//		    String ariaLabel = subscribeButton.getAttribute("aria-label");
//		    if (ariaLabel != null && ariaLabel.equalsIgnoreCase("Subscribe to Jemartob.")) { //!= null bec we face java.lang.NullPointerException
//		    	wait.until(ExpectedConditions.and(
//					    ExpectedConditions.visibilityOf(subscribeButton),
//					    ExpectedConditions.elementToBeClickable(subscribeButton)
//					));
//		        subscribeButton.click();
//		        break;
//		    }
//		}
//	}
	
	public void clickOnSubscribeButton() {
	    for (int i = 0; i < subscribe.size(); i++) {
	        WebElement subscribeButton = subscribe.get(i);
	        String ariaLabel = subscribeButton.getAttribute("aria-label");
	        if (ariaLabel != null && ariaLabel.equalsIgnoreCase("Subscribe to Jemartob.")) {
	            //wait.until(ExpectedConditions.and(
	                    //ExpectedConditions.visibilityOf(subscribeButton),
	                    //ExpectedConditions.elementToBeClickable(subscribeButton)
	            //));
	        	waitForElementToAppearAndToClickable(subscribeButton);//**called from AbstractComponents
	            subscribeButton.click();
	            break; // Break the loop after clicking the first matching button
	        }
	    }
	}
	
		
	public String getErrorMessage()
	{
		String errorMg =errorMessage.getText();
		return errorMg;
	}
	
	public void clickOnSignInButtonOnErrorMessage() {
		//js.executeScript("window.scrollIntoView(true);","signInButtonOnErrorMessage");
		js.executeScript("arguments[0].scrollIntoView(true);", signInButtonOnErrorMessage);
		signInButtonOnErrorMessage.click();
	}
	
}
