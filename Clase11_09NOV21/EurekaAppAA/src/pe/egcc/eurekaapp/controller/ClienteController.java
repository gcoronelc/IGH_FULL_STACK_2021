package pe.egcc.eurekaapp.controller;

import java.util.List;
import pe.egcc.eurekaapp.model.Cliente;
import pe.egcc.eurekaapp.service.espec.ClienteServiceEspec;
import pe.egcc.eurekaapp.service.impl.ClienteServiceImpl;
import pe.egcc.eurekaapp.util.Eureka;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronec@gmail.com
 */
public class ClienteController {
  
  private ClienteServiceEspec service;

  public ClienteController() {
    service = new ClienteServiceImpl();
  }
  
  public List<Cliente> traerVarios(Cliente bean){
    return service.traerVarios(bean);
  }

  public void procesar(String estado, Cliente bean) {
    switch(estado){
      case Eureka.CRUD_NUEVO:
        service.crear(bean);
        break;
      case Eureka.CRUD_EDITAR:
        service.actualizar(bean);
        break;
      case Eureka.CRUD_ELIMINAR:
        service.eliminar(bean.getCodigo());
        break;        
    }
  
  }
  
}
