package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.MainPage;

public class Tests
{
	private WebDriver driver;
	
	@BeforeMethod
	public void SetUp()
	{
        
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("mac"))
		{
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
		}
		else 
		{
			System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		}
		driver = new ChromeDriver();	
	}
	
	@Test
	public void BuscarZapatillas()
	{
		MainPage mainPage = new MainPage(driver);
        driver.navigate().to(mainPage.getWebUrl());
		mainPage.selectCategory();
	}
	

}
