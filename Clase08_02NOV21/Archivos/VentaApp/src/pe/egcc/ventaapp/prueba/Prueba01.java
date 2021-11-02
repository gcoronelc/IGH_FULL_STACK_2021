package pe.egcc.ventaapp.prueba;

import java.util.List;
import pe.egcc.ventaapp.service.VentaService;

/**
 *
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
public class Prueba01 {

   
   public static void main(String[] args) {
      
      // Proceso
      VentaService service = new VentaService();
      List<String> categorias = service.getCategorias();
      
      // Reporte
      for (String categoria : categorias) {
         System.out.println(categoria);
      }
      
   }
   
}
