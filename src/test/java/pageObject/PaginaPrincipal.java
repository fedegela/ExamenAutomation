package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PaginaPrincipal 
{
	private WebDriver driver;
	private String webUrl = "http://www.ebay.com/";
	private By botonCategory  = By.id("gh-shop-a");
	private By botonCalzado = By.partialLinkText("Calzado");
	
	public PaginaPrincipal (WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void seleccionarCategoria()
	{
		driver.findElement(botonCategory).click();	
		driver.findElement(botonCalzado).click();
		getCalzadoParaHombre().click();
	}
	
    public String getWebUrl()
    {
        return webUrl;
    }
	
    private WebElement getCalzadoParaHombre()
    {
    	By botonEspanol = By.partialLinkText("Calzado");
    	By buttonEnglish = By.partialLinkText("Men's");
    	if (driver.findElement(botonEspanol).isEnabled())
    		return driver.findElement(botonEspanol);
    	else 
    		return driver.findElement(buttonEnglish);
    }
}

