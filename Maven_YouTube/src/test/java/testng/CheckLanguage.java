package testng;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PomClasses.CreatAccount;
import PomClasses.HomePage;
import PomClasses.SignInPage;
import PomClasses.VideoPage;

public class CheckLanguage {

	WebDriver driver;
	
	HomePage homePage;
	VideoPage videoPage;
	SignInPage signInPage;
	CreatAccount creatAccount;
	@BeforeTest
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver","E:\\software testing\\selenium\\new browser chromium chrome driver\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.setBinary("E:\\software testing\\selenium\\new browser for testing chromium\\chrome-win64\\chrome.exe");
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void creatPomObject()
	{
		homePage = new HomePage(driver);
		videoPage = homePage.clickOnSearchBoxButton();
		signInPage = new SignInPage(driver);
		creatAccount = new CreatAccount(driver); 
	}
	
	@BeforeMethod
	public void openApplication()
	{
		driver.get("https://www.youtube.com/");
		homePage.sendNameinSearchBox("one piece amv");
		homePage.clickOnSearchBoxButton();
	}
	
	@Test
	public void subscribeWithoutLogin()
	{
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
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}
	
	@AfterClass
	public void beforeClass()
	{
		System.out.println("Before Class");
		
		homePage = null;
		videoPage = null;
		signInPage = null;
		creatAccount = null;
	}
	
	@AfterTest
	public void afterClass()
	{
		System.out.println("After Class");
		
		System.gc();
		System.out.println("After Class");
        if (driver != null) {
            driver.quit();
        }
	}
}
