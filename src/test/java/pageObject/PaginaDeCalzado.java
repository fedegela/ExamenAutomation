package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import herramientas.StructProducto;

public class PaginaDeCalzado 
{
	
	private WebDriver driver;
	private By botonPrecioMasBajo = By.xpath("*//span[contains(text(),'bajo')]");
	private By botonEnvioGratis = By.partialLinkText("internacional");
	private By botonTalle10 = By.xpath("*//span[text()='10']");
	private By botonPuma = By.xpath("*//span[contains(text(),'PUMA')]");
	private By dropdownOrden = By.cssSelector("[id$=w0-w1_btn]");
	private By resultados = By.xpath("*//h2[contains(text(),'1 - ')]");
	
	public PaginaDeCalzado(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void checkTalle10()
	{
		driver.findElement(botonTalle10).click();
		return;
	}
	
	public void checkEnvioGratis()
	{
		driver.findElement(botonEnvioGratis).click();
		return;
	}
	
	public void checkMarcaPuma()
	{
		driver.findElement(botonPuma).click();
		return;
	}
	
	 public String resultadosEncontrados()
    {
		String resultado = driver.findElement(resultados).getText();
		resultado = resultado.substring(0, resultado.lastIndexOf(" "));
		return resultado.substring(resultado.lastIndexOf(" ")+1);
    }

	public void ordenarPorPrecioAscendente()
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(dropdownOrden)).build().perform();
		driver.findElement(botonPrecioMasBajo).click();
		return;
	}
	
    public List<StructProducto> generarListaDeProductos(int tamanoLista)
    {
    	List<WebElement> precios = driver.findElements(By.className("s-item__price"));
		List<WebElement> titulos = driver.findElements(By.className("s-item__title"));
		List<StructProducto> productos = new ArrayList<StructProducto>();
		for(int i=0; i < tamanoLista; i++)
		{
			StructProducto productoNuevo = new StructProducto(); 
			productoNuevo.setPrecio(precios.get(i).getText());
			productoNuevo.setTitulo(titulos.get(i).getText());
			productos.add(productoNuevo);
		}
		return productos;
    }
}
