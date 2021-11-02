package pe.egcc.ventaapp.prueba;

import java.util.List;
import pe.egcc.ventaapp.dto.ProductoDto;
import pe.egcc.ventaapp.service.VentaService;

/**
 *
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
public class Prueba02 {

   public static void main(String[] args) {
      // Dato
      String categoria = "CATEGORIA 01";
      // Proceso
      List<ProductoDto> lista = null;
      VentaService service = new VentaService();
      lista = service.getProductos(categoria);
      // Reporte
      for (ProductoDto dto : lista) {
         System.out.println(dto.getCategoria() + " - " + dto.getProducto() + " - " + dto.getPrecio());
      }
   }
   
}
