package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainPage 
{

	private WebDriver driver;
	private String webUrl = "http://www.ebay.com/";
	private By buttonCategory  = By.id("gh-shop-a"); //"_sacat"
	private By buttonSearch = By.id("gh-btn");
	private String shoes; // Completar el value o name de shoes y llamar selectCategory con ese string
	
	public MainPage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void selectCategory()
	{
		driver.findElement(buttonCategory).click();
		driver.findElement(By.partialLinkText("Calzado")).click();
		driver.findElement(By.partialLinkText("Calzado para hombres")).click();
		driver.findElement(By.xpath("*//span[text()='10']"));
	//	driver.findElement(By.xpath("//span[contains(text(),'10.5')]/preceding-sibling::span")).click();
		driver.findElement(By.xpath("*//span[contains(text(),'PUMA')]")).click();
	}
	
	public void selectBrand(String opcion)
	{
		
	}
	
    public String getWebUrl()
    {
        return webUrl;
    }


}
