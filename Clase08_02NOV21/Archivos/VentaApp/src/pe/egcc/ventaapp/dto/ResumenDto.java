package pe.egcc.ventaapp.dto;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class ResumenDto {

   private String concepto;
   private Integer cantidad;
   private Integer importe;

   public ResumenDto() {
   }

   public ResumenDto(String concepto, Integer cantidad, Integer importe) {
      this.concepto = concepto;
      this.cantidad = cantidad;
      this.importe = importe;
   }

   public String getConcepto() {
      return concepto;
   }

   public void setConcepto(String concepto) {
      this.concepto = concepto;
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

}
