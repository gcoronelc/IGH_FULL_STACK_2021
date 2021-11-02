package pe.egcc.ventaapp.prueba;

import java.util.List;
import pe.egcc.ventaapp.dto.ResumenDto;
import pe.egcc.ventaapp.service.VentaService;

/**
 *
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
public class Prueba05 {

   public static void main(String[] args) {
      // Variable
      List<ResumenDto> repo;
      // Datos
      VentaService ventaService = new VentaService();
      repo = ventaService.getResumenProducto();
      // Mostrar Resumen
      for (ResumenDto dto : repo) {
         System.out.println(dto.getConcepto() + " - " + dto.getCantidad() + " - " + dto.getImporte());
      }
   }
}
