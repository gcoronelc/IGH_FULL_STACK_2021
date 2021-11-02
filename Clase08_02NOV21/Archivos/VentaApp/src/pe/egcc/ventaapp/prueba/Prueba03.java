package pe.egcc.ventaapp.prueba;

import java.util.List;
import pe.egcc.ventaapp.dto.ProductoDto;
import pe.egcc.ventaapp.dto.VentaDto;
import pe.egcc.ventaapp.service.VentaService;

/**
 *
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
public class Prueba03 {

   public static void main(String[] args) {
      // Datos
      VentaDto venta = new VentaDto();
      ProductoDto prod1 = null;
      // Proceso
      VentaService service = new VentaService();
      // Producto 1
      prod1 = service.getProductos(service.getCategorias().get(0)).get(0);
      venta.setCategoria(prod1.getCategoria());
      venta.setProducto(prod1.getProducto());
      venta.setPrecio(prod1.getPrecio());
      venta.setCantidad(10);
      service.grabarVenta(venta);
      // Producto 2
      prod1 = service.getProductos(service.getCategorias().get(1)).get(0);
      venta = new VentaDto();
      venta.setCategoria(prod1.getCategoria());
      venta.setProducto(prod1.getProducto());
      venta.setPrecio(prod1.getPrecio());
      venta.setCantidad(10);
      service.grabarVenta(venta);
      // Reporte
      List<VentaDto> repo = service.getVentas();
      for (VentaDto dto : repo) {
         System.out.println(dto.getCategoria() + " - " + dto.getProducto() + " - " 
                 + dto.getPrecio() + " - " + dto.getImporte());
      }
   }
}
