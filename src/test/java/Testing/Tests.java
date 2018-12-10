package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testeo 
{
	private WebDriver driver;
	
	@BeforeMethod
	public void SetUp()
	{
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
		driver = new ChromeDriver();	
	}
	
	@Test
	public void BuscarZapatillas()
	{
		MainPage mainPage = new MainPage(driver);
        driver.navigate().to(mainPage.getWebUrl);
		mainPage.selectCategory();
	}
	

}
