package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MainPage 
{

	private WebDriver driver;
	private String webUrl = "http://www.ebay.com/";
	private By buttonCategory  = By.id("gh-shop-a");
	private By buttonCalzado = By.partialLinkText("Calzado");
	
	//private By buttonCalzadoParaHombre = By.partialLinkText("Calzado para hombres");
	private By dropdownOrden = By.id("w7-w0-w1_btn");
	private By buttonPrecioMasBajo = By.xpath("*//span[contains(text(),'Precio más bajo')]");
	
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
		getCalzadoParaHombre().click();
		driver.findElement(buttonTalle10).click();
		driver.findElement(buttonEnvioGratis).click();
		driver.findElement(buttonPuma).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(dropdownOrden)).build().perform();
		driver.findElement(buttonPrecioMasBajo).click();
	}

    public String getWebUrl()
    {
        return webUrl;
    }
    
    private WebElement getCalzadoParaHombre()
    {
    	By botonEspanol = By.partialLinkText("Calzado");
    	By buttonEnglish = By.partialLinkText("Mens");
    	if (driver.findElement(botonEspanol).isEnabled())
    		return driver.findElement(botonEspanol);
    	else 
    		return driver.findElement(buttonEnglish);
    }


}
