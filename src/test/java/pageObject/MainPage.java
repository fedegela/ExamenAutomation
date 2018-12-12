package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import herramientas.StructProducto;


public class MainPage 
{

	private WebDriver driver;
	private String webUrl = "http://www.ebay.com/";
	private By buttonCategory  = By.id("gh-shop-a");
	private By buttonCalzado = By.partialLinkText("Calzado");
	
	//private By buttonCalzadoParaHombre = By.partialLinkText("Calzado para hombres");
	private By dropdownOrden = By.cssSelector("[id$=w0-w1_btn]");
	private By buttonPrecioMasBajo = By.xpath("*//span[contains(text(),'bajo')]");
	
	//private By buttonSearch = By.id("gh-btn"); No lo estoy usando por el momento
	private By buttonEnvioGratis = By.partialLinkText("internacional");
	private By buttonTalle10 = By.xpath("*//span[text()='10']");
	private By buttonPuma = By.xpath("*//span[contains(text(),'PUMA')]");
	
	//private By claseCercaDeResultados = By.className("clearfix");
	private By resultados = By.xpath("*//h2[contains(text(),'1 - ')]");
	private int productosAMostrar = 5;
	
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
		System.out.println("Encontro " + cantidadDeResultados() + " resultados.");
		action.moveToElement(driver.findElement(dropdownOrden)).build().perform();
		driver.findElement(buttonPrecioMasBajo).click();
		
		List<WebElement> precios = driver.findElements(By.className("s-item__price"));
		System.out.println(precios.size());
		List<WebElement> titulos = driver.findElements(By.className("s-item__title"));
		System.out.println(titulos.size());
		List<StructProducto> productos = new ArrayList<StructProducto>();
		for(int i=0; i < productosAMostrar; i++)
		{
			StructProducto productoNuevo = new StructProducto(); 
			productoNuevo.setPrecio(precios.get(i).getText());
			productoNuevo.setTitulo(titulos.get(i).getText());
			productos.add(productoNuevo);
			System.out.println("Producto numero: " + (i+1));
			System.out.println("Titulo: " +  productos.get(i).getTitulo());
			System.out.println("Precio " + ": " +  productos.get(i).getPrecio());
		}
		
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
    
    private String cantidadDeResultados()
    {
		String resultado = driver.findElement(resultados).getText();
		resultado = resultado.substring(0, resultado.lastIndexOf(" "));
		return resultado.substring(resultado.lastIndexOf(" ")+1);
    }
}



/*
 * si el resultado aparece en negrita, el numero de resultados esta en un elemento diferente a la palabra resultados.
 * si el resultado NO esta en negrita, la cantidad y la palabra resultados estan en el mismo elemento.
 * 
 * 
 * 
 * 
 */
