package test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import PomClasses.CreatAccount;
import PomClasses.HomePage;
import PomClasses.SignInPage;
import PomClasses.VideoPage;

public class temp2 {

	public static void main(String[] args) throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver","E:\\software testing\\selenium\\new browser chromium chrome driver\\chromedriver-win64\\chromedriver.exe");
		
		ChromeOptions co = new ChromeOptions();
		co.setBinary("E:\\software testing\\selenium\\new browser for testing chromium\\chrome-win64\\chrome.exe");
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.youtube.com/");
		HomePage homePage = new HomePage(driver);
		homePage.sendNameinSearchBox("one piece amv");
		homePage.clickOnSearchBoxButton();
		//VideoPage videoPage = new VideoPage(driver);//instead of this we can use following line
		VideoPage videoPage = homePage.clickOnSearchBoxButton(); 
		
		videoPage.clickOnVideo();
		videoPage.clickOnSubscribeButton();
		String actualMessage = videoPage.getErrorMessage();
		System.out.println(actualMessage);
		String expectedMessage = "Sign in to subscribe to this channel.";
		Assert.assertEquals(expectedMessage, actualMessage);
		if(actualMessage.equalsIgnoreCase(expectedMessage)) {
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
		
		videoPage.clickOnSignInButtonOnErrorMessage();
		SignInPage signInPage = new SignInPage(driver);
		String expectedTitleOfSignInPage =signInPage.getTitle();
		System.out.println(expectedTitleOfSignInPage);
		String actualTitleOfSignInPage = "YouTube";
		assertEquals(actualTitleOfSignInPage, expectedTitleOfSignInPage);
		if(actualTitleOfSignInPage.equalsIgnoreCase(expectedTitleOfSignInPage)){
			System.out.println("true"+" "+"->"+" "+"title is correct");
		}
		else {
			System.out.println("false"+" "+"->"+" "+"title is correct");
		}
		
		signInPage.clickOnCreatNewAccount();
		signInPage.clickOncreatAccountForWork();
		
		//CreatAccount creatAccount = signInPage.clickOncreatAccountForWork();
		//in this method we click on workAccount and return the obj of new class it was not working so we remove return class obj
		
		CreatAccount creatAccount = new CreatAccount(driver); 
		String actualPlaceHolder = creatAccount.getTextOfPlaceHolderOfNameField();
		System.out.println(actualPlaceHolder);
		String expectPlaceHolder = "First name";
		//assertEquals(actualPlaceHolder, expectedTitleOfSignInPage);
		assertEquals(actualPlaceHolder, expectPlaceHolder);
		if(actualPlaceHolder.equalsIgnoreCase(expectPlaceHolder)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		creatAccount.clickOnLanguageDropDown();
		creatAccount.selectLanguage("मराठी");
		
		//test case : verify that language can be change
		
		String actualLanguage = creatAccount.checkNewLanguage();
		String expectedLanguage = "एखादे Google खाते तयार करा";
		Assert.assertEquals(expectedLanguage, actualLanguage);
		if(actualLanguage.equalsIgnoreCase(expectedLanguage)) {
			System.out.println("Language has been changed :"+" "+"true");
		}
		else
		{
			System.out.println("Language not has been changed :"+" "+"false");
		}
		
	}
}
