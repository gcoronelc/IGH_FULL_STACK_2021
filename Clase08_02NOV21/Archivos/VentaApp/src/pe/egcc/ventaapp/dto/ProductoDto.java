package pe.egcc.ventaapp.dto;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class ProductoDto {

   private String categoria;
   private String producto;
   private Integer precio;

   public ProductoDto() {
   }

   public ProductoDto(String categoria, String producto, Integer precio) {
      this.categoria = categoria;
      this.producto = producto;
      this.precio = precio;
   }

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

   @Override
   public String toString() {
      return this.producto;
   }

   
}
