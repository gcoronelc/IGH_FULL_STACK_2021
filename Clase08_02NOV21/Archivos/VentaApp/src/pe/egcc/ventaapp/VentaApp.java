package pe.egcc.ventaapp;

import pe.egcc.ventaapp.controller.VentaController;
import pe.egcc.ventaapp.view.RegistrarVenta;

/**
 *
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
public class VentaApp {

    public static void main(String[] args) {
		 VentaController controller = new VentaController();
		 controller.cargaDeArchivos();
       RegistrarVenta.main(args);
    }

}
