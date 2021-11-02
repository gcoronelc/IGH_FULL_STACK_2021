package pe.egcc.ventaapp.service;

import java.util.ArrayList;
import java.util.List;
import pe.egcc.ventaapp.dto.ProductoDto;
import pe.egcc.ventaapp.dto.VentaDto;

/**
 *
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
class Datos {

   private Datos() {
   }
	   
   // Variables
   static List<String> categorias;
   static List<ProductoDto> productos;
   static List<VentaDto> ventas;
   
   
   // Inicializar las variables
   static {
      // Categorias
      categorias = new ArrayList<>();
      categorias.add("CATEGORIA 01");
      categorias.add("CATEGORIA 02");
      categorias.add("CATEGORIA 03");
      // Productos
      productos = new ArrayList<>();
      productos.add(new ProductoDto("CATEGORIA 01", "PRODUCTO 01 - 01", 456));
      productos.add(new ProductoDto("CATEGORIA 01", "PRODUCTO 01 - 02", 650));
      productos.add(new ProductoDto("CATEGORIA 01", "PRODUCTO 01 - 03", 234));
      productos.add(new ProductoDto("CATEGORIA 02", "PRODUCTO 02 - 01", 789));
      productos.add(new ProductoDto("CATEGORIA 02", "PRODUCTO 02 - 02", 123));
      productos.add(new ProductoDto("CATEGORIA 02", "PRODUCTO 02 - 03", 410));
      productos.add(new ProductoDto("CATEGORIA 03", "PRODUCTO 03 - 01", 412));
      productos.add(new ProductoDto("CATEGORIA 03", "PRODUCTO 03 - 02", 915));
      productos.add(new ProductoDto("CATEGORIA 03", "PRODUCTO 03 - 03", 480));
      // Ventas
      ventas = new ArrayList<>();
   }
   
}
