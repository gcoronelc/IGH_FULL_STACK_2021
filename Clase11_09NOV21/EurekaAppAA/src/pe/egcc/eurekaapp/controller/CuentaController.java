package pe.egcc.eurekaapp.controller;

import pe.egcc.eurekaapp.model.Empleado;
import pe.egcc.eurekaapp.service.impl.CuentaService;
import pe.egcc.eurekaapp.util.Session;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronec@gmail.com
 */
public class CuentaController {

  public void procRetiro(String cuenta, double importe, String clave) {
    // El empleado
    Empleado bean = (Empleado) Session.get("usuario");
    // Proceso
    CuentaService service = new CuentaService();
    service.procRetiro(cuenta, importe, clave, bean.getCodigo());
  }
  
}
