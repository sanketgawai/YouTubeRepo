package Waitt;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	

	public void waitForElementToAppearAndToClickable(WebElement k) 
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.and(
	    ExpectedConditions.visibilityOf(k),
	    ExpectedConditions.elementToBeClickable(k)
	));
	}
	public void waitForElementToAppear(By findBy)//findBy is  variable
	{					
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));//sare locater pom class me dec karege
	}
	
	public void watiForElementToDisappear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);//sare locater pom class me dec karege
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
												//****driver. hai to argu->WebElement,driver ka return type
		wait.until(ExpectedConditions.invisibilityOf(ele));
	
	}
	
	
	public void waitForwebElementToAppear(WebElement findBy)//findBy is  variable
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(findBy));//visibility of WebElement
	}
	
	public void waitForwebElementToDisppear(WebElement findBy)//findBy is  variable
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.invisibilityOf(findBy));//visibility of WebElement
	}
}
