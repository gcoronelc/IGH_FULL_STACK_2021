package pe.egcc.eurekaapp.util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronec@gmail.com
 */
public final class Mensaje {

  private Mensaje() {
  }
  
  public static void showInfo
        (Component parent, String message){
    JOptionPane.showMessageDialog(parent, message,
            "EUREKA - INFO",
            JOptionPane.INFORMATION_MESSAGE);
  }
        
  public static void showError
        (Component parent, String message){
    JOptionPane.showMessageDialog(parent, message,
            "EUREKA - ERROR",
            JOptionPane.ERROR_MESSAGE);
  }
  
  
  
  
}
