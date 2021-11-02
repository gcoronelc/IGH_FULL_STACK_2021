package pe.egcc.ventaapp.controller;

import java.util.List;
import pe.egcc.ventaapp.dto.ProductoDto;
import pe.egcc.ventaapp.dto.ResumenDto;
import pe.egcc.ventaapp.dto.VentaDto;
import pe.egcc.ventaapp.service.ArchivoService;
import pe.egcc.ventaapp.service.VentaService;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class VentaController {

	private final VentaService ventaService;

	public VentaController() {
		ventaService = new VentaService();
	}

	public void cargaDeArchivos() {
		ventaService.cargaDeArchivos();
	}

	public List<String> getCategorias() {
		return ventaService.getCategorias();
	}

	public List<ProductoDto> getProductos(String categoria) {
		return ventaService.getProductos(categoria);
	}

	public void registrarVenta(VentaDto ventaDto) {
		ventaService.grabarVenta(ventaDto);
	}

	public List<VentaDto> getVentas(String categoria) {
		return ventaService.getVentas(categoria);
	}

	public List<ResumenDto> getResumenCategoria() {
		return ventaService.getResumenCategoria();
	}

	public List<ResumenDto> getResumenProducto() {
		return ventaService.getResumenProducto();
	}

}
