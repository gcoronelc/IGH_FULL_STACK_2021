package pe.egcc.ventaapp.dto;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class VentaDto {

   // Variables
   private String categoria;
   private String producto;
   private Integer precio;
   private Integer cantidad;
   private Integer importe;

   // Constructores
   public VentaDto() {
   }

   public VentaDto(String categoria, String producto, Integer precio, Integer cantidad) {
      this.categoria = categoria;
      this.producto = producto;
      this.precio = precio;
      this.cantidad = cantidad;
   }

   public VentaDto(String categoria, String producto, Integer precio, Integer cantidad, Integer importe) {
      this.categoria = categoria;
      this.producto = producto;
      this.precio = precio;
      this.cantidad = cantidad;
      this.importe = importe;
   }

   // getters y setters
   public String getCategoria() {
      return categoria;
   }

   public void setCategoria(String categoria) {
      this.categoria = categoria;
   }

   public String getProducto() {
      return producto;
   }

   public void setProducto(String producto) {
      this.producto = producto;
   }

   public Integer getPrecio() {
      return precio;
   }

   public void setPrecio(Integer precio) {
      this.precio = precio;
   }

   public Integer getCantidad() {
      return cantidad;
   }

   public void setCantidad(Integer cantidad) {
      this.cantidad = cantidad;
   }

   public Integer getImporte() {
      return importe;
   }

   public void setImporte(Integer importe) {
      this.importe = importe;
   }

	@Override
	public String toString() {
		String fila = categoria + ";" + producto + ";" + precio + ";" + cantidad + ";" + importe;
		return fila;
	}

	
}
