package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainPage 
{

	private WebDriver driver;
	private String webUrl = "http://www.ebay.com/";
	private By buttonCategory  = By.id("gh-shop-a");
	private By buttonCalzado = By.partialLinkText("Calzado");
	
	//private By buttonCalzadoParaHombre = By.partialLinkText("Calzado para hombres");
	private By buttonCalzadoParaHombre = By.partialLinkText("Calzado");
	//private By dropdownOrden = By.id("w5-w0-w1_btn"); NO
	//private By buttonPrecioMasBajo = By.xpath("*//span[contains(text(),'Precio más bajo + Envío')]");NO?
	
	//private By buttonSearch = By.id("gh-btn"); No lo estoy usando por el momento
	private By buttonEnvioGratis = By.partialLinkText("Envío internacional");
	private By buttonTalle10 = By.xpath("*//span[text()='10']");
	private By buttonPuma = By.xpath("*//span[contains(text(),'PUMA')]");
	
	public MainPage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void selectCategory()
	{
		driver.findElement(buttonCategory).click();	
		driver.findElement(buttonCalzado).click();
		driver.findElement(buttonCalzadoParaHombre).click();
		driver.findElement(buttonTalle10).click();
		driver.findElement(buttonEnvioGratis).click();
		driver.findElement(buttonPuma).click();
	//	driver.findElement(dropdownOrden).getAttribute(name)
	//	driver.findElement(buttonPrecioMasBajo).click();
	}

    public String getWebUrl()
    {
        return webUrl;
    }


}
