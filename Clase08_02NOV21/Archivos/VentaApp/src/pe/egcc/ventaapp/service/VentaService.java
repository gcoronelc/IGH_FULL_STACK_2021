package pe.egcc.ventaapp.service;

import java.util.ArrayList;
import java.util.List;
import pe.egcc.ventaapp.dto.ProductoDto;
import pe.egcc.ventaapp.dto.ResumenDto;
import pe.egcc.ventaapp.dto.VentaDto;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class VentaService {
	
	/**
	 * Carga todos los archivos en memoria.
	 */
	public void cargaDeArchivos(){
		ArchivoService service = new ArchivoService();
		service.cargaDeArchivos();
	}

	/**
	 * Retorna las categorias para llenar el combo.
	 * @return 
	 */
   public List<String> getCategorias() {
      return Datos.categorias;
   }

	/**
	 * Retorna los productos según la categoria.
	 * @param categoria
	 * @return 
	 */
   public List<ProductoDto> getProductos(String categoria) {
      // Variable
      List<ProductoDto> lista = new ArrayList<>();
      // Proceso
      for (ProductoDto dto : Datos.productos) {
         if (dto.getCategoria().equals(categoria)) {
            lista.add(dto);
         }
      }
      // Reporte
      return lista;
   }

	/**
	 * Graba una venta.
	 * @param dto Datos de la venta.
	 */
   public void grabarVenta(VentaDto dto) {
      // Calculo del importe
      dto.setImporte(dto.getPrecio() * dto.getCantidad());
      // Registrar la venta en la lista (memoria)
      Datos.ventas.add(dto);
		// Grabar en archivo
		ArchivoService service = new ArchivoService();
		service.registrarVenta(dto);
   }

	/**
	 * Listado de todas las ventas.
	 * @return Retorna una lista.
	 */
   public List<VentaDto> getVentas() {
      return Datos.ventas;
   }

	/**
	 * Retorna las ventas por categoría.
	 * @param categoria La categoria.
	 * @return Retorna una lista.
	 */
   public List<VentaDto> getVentas(String categoria) {
      // Variable
      List<VentaDto> lista = new ArrayList<>();
      // Proceso
      for (VentaDto dto : Datos.ventas) {
         if (dto.getCategoria().equals(categoria)) {
            lista.add(dto);
         }
      }
      // Reporte
      return lista;
   }

	/**
	 * Retorna el resumen por categoria.
	 * @return Retorna una lista.
	 */
   public List<ResumenDto> getResumenCategoria(){
      // Variable
      List<ResumenDto> repo = new ArrayList<>();
      // Datos
      for(String categoria: Datos.categorias){
         repo.add(new ResumenDto(categoria, 0, 0));
      }
      // Proceso
      for(VentaDto venta: Datos.ventas){
         for(ResumenDto resumen: repo){
            if(venta.getCategoria().equals(resumen.getConcepto())){
               resumen.setCantidad(resumen.getCantidad() + venta.getCantidad());
               resumen.setImporte(resumen.getImporte()+ venta.getImporte());
               break;
            }
         }
      }
      // Reporte
      return repo;
   }
   
	/**
	 * Retorna el resumen por producto.
	 * @return Retorna una lista
	 */
   public List<ResumenDto> getResumenProducto(){
      // Variable
      List<ResumenDto> repo = new ArrayList<>();
      // Datos
      for(ProductoDto dto: Datos.productos){
         repo.add(new ResumenDto(dto.getProducto(), 0, 0));
      }
      // Proceso
      for(VentaDto venta: Datos.ventas){
         for(ResumenDto resumen: repo){
            if(venta.getProducto().equals(resumen.getConcepto())){
               resumen.setCantidad(resumen.getCantidad() + venta.getCantidad());
               resumen.setImporte(resumen.getImporte()+ venta.getImporte());
               break;
            }
         }
      }
      // Reporte
      return repo;
   }
   
}
