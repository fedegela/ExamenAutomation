package herramientas;

import java.util.Comparator;
import java.util.List;


public class PropiedadesListas
{
	public void impirimirProductos(List<StructProducto> lista)
	{
		for(int i=0; i<lista.size(); i++)
		{
			System.out.println("Producto numero: " + (i+1));
			System.out.println("Titulo: " +  lista.get(i).getTitulo());
			System.out.println("Precio: " +  lista.get(i).getPrecio());
		}
	}
	
	public List<StructProducto> ordenarProductosPorNombreAscendente(List<StructProducto> lista)
	{
		lista.sort(new Comparator<StructProducto>()
		{
			@Override
			public int compare(StructProducto o1, StructProducto o2)
			{
				return o1.getTitulo().compareTo(o2.getTitulo());
			}			
		});
		return lista;
	}
	
	public List<StructProducto> ordenarProductosPorPrecioDescendente(List<StructProducto> lista)
	{
		lista.sort(new Comparator<StructProducto>()
		{
			@Override
			public int compare(StructProducto o1, StructProducto o2)
			{
				return o2.getPrecio().compareTo(o1.getPrecio());
			}			
		});
		return lista;
	}
	
	public boolean esPrecioAscendente(List<StructProducto> lista)
	{
		boolean ordenado = true;
		for(int i=0; i<(lista.size()-1); i++)
		{
			if(lista.get(i).getPrecio().compareTo(lista.get(i+1).getPrecio()) > 0)
				ordenado = false;
		}
		return ordenado;
	}
}
