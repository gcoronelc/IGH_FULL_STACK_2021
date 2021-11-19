package pe.uni.app.specification;

import java.util.List;
import java.util.Map;

public interface CuentaSpecification {
	
	public void procRetiro(String cuenta, Double importe, String clave, String empleado);

	public void procDeposito(String cuenta, Double importe, String empleado);

	public List<Map<String, ?>> conMovimientos(String cuenta);
	
}
