package testing;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import herramientas.PropiedadesListas;
import herramientas.StructProducto;
import pageObject.PaginaDeCalzado;
import pageObject.PaginaPrincipal;

public class BusquedaDeCalzado 
{
	private WebDriver driver;
	private int cantidadProductos = 5;
	
	@BeforeMethod
	public void setUp()
	{
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("mac")) 
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
		else
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();	
	}
	
	@Test
	public void buscarZapatillas()
	{
		PaginaPrincipal paginaPrincipal = new PaginaPrincipal(driver);
        driver.navigate().to(paginaPrincipal.getWebUrl());
		paginaPrincipal.seleccionarCategoria();
		PaginaDeCalzado paginaCalzado = new PaginaDeCalzado(driver);
		paginaCalzado.checkMarcaPuma();
		paginaCalzado.checkTalle10();
		paginaCalzado.checkEnvioGratis();
		System.out.println("Encontro " + paginaCalzado.resultadosEncontrados() + " resultados.");
		paginaCalzado.ordenarPorPrecioAscendente();
		List<StructProducto> lista = paginaCalzado.generarListaDeProductos(cantidadProductos);
		PropiedadesListas propiedadesListas = new PropiedadesListas();
		Assert.assertTrue(propiedadesListas.esPrecioAscendente(lista));
		//System.out.println("Paso por el assert");
		propiedadesListas.impirimirProductos(lista);
		//System.out.println("Imprimio Lista");
		lista = propiedadesListas.ordenarProductosPorNombreAscendente(lista);
		propiedadesListas.impirimirProductos(lista);
		//System.out.println("Imprimio Lista por nombre");
		propiedadesListas.impirimirProductos(propiedadesListas.ordenarProductosPorPrecioDescendente(lista));
		//System.out.println("Imprimio Lista por precio invertido");
	}
	
	@AfterMethod
	public void after()
	{
		driver.close();
		driver.quit();
	}
}
