package pe.egcc.eurekaapp.view;

import javax.swing.JInternalFrame;
import pe.egcc.eurekaapp.model.Empleado;
import pe.egcc.eurekaapp.util.Session;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronec@gmail.com
 */
public class MainView extends javax.swing.JFrame {

  /**
   * Creates new form MainView
   */
  public MainView() {
    initComponents();
    establecerTitulo();
    this.setExtendedState(MAXIMIZED_BOTH);
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    toolBar = new javax.swing.JToolBar();
    btnRetiro = new javax.swing.JButton();
    btnDeposito = new javax.swing.JButton();
    btnTransferencia = new javax.swing.JButton();
    jSeparator2 = new javax.swing.JToolBar.Separator();
    btnClientes = new javax.swing.JButton();
    btnSucursales = new javax.swing.JButton();
    btnEmpleados = new javax.swing.JButton();
    jSeparator3 = new javax.swing.JToolBar.Separator();
    btnSalir = new javax.swing.JButton();
    desktopPane = new javax.swing.JDesktopPane();
    menuBar = new javax.swing.JMenuBar();
    menuArchivo = new javax.swing.JMenu();
    menuArchivoSalir = new javax.swing.JMenuItem();
    menuProceso = new javax.swing.JMenu();
    menuProcesoRetiro = new javax.swing.JMenuItem();
    menuProcesoDeposito = new javax.swing.JMenuItem();
    menuProcesoTransferncia = new javax.swing.JMenuItem();
    jSeparator1 = new javax.swing.JPopupMenu.Separator();
    menuProcesoApertura = new javax.swing.JMenuItem();
    menuProcesoCierre = new javax.swing.JMenuItem();
    menuTabla = new javax.swing.JMenu();
    menuTablaClientes = new javax.swing.JMenuItem();
    menuTablaSucursales = new javax.swing.JMenuItem();
    menuTablaEmpleados = new javax.swing.JMenuItem();
    menuConsulta = new javax.swing.JMenu();
    menuReporte = new javax.swing.JMenu();
    menuUtil = new javax.swing.JMenu();
    menuAyuda = new javax.swing.JMenu();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    toolBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    toolBar.setRollover(true);

    btnRetiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/egcc/eurekaapp/img/money.png"))); // NOI18N
    btnRetiro.setToolTipText("Registrar retiro.");
    btnRetiro.setFocusable(false);
    btnRetiro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnRetiro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btnRetiro.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnRetiroActionPerformed(evt);
      }
    });
    toolBar.add(btnRetiro);

    btnDeposito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/egcc/eurekaapp/img/money-bag.png"))); // NOI18N
    btnDeposito.setToolTipText("Registrar depósito.");
    btnDeposito.setFocusable(false);
    btnDeposito.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnDeposito.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolBar.add(btnDeposito);

    btnTransferencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/egcc/eurekaapp/img/transfer.png"))); // NOI18N
    btnTransferencia.setToolTipText("Registrar transferencia.");
    btnTransferencia.setFocusable(false);
    btnTransferencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnTransferencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolBar.add(btnTransferencia);
    toolBar.add(jSeparator2);

    btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/egcc/eurekaapp/img/cliente.png"))); // NOI18N
    btnClientes.setToolTipText("Mantenimiento de clientes.");
    btnClientes.setFocusable(false);
    btnClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btnClientes.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnClientesActionPerformed(evt);
      }
    });
    toolBar.add(btnClientes);

    btnSucursales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/egcc/eurekaapp/img/sucursal.png"))); // NOI18N
    btnSucursales.setToolTipText("Mantenimiento de sucursales.");
    btnSucursales.setFocusable(false);
    btnSucursales.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnSucursales.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolBar.add(btnSucursales);

    btnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/egcc/eurekaapp/img/empleado.png"))); // NOI18N
    btnEmpleados.setToolTipText("Mantenimiento de empleados.");
    btnEmpleados.setFocusable(false);
    btnEmpleados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnEmpleados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    toolBar.add(btnEmpleados);
    toolBar.add(jSeparator3);

    btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/egcc/eurekaapp/img/salir.png"))); // NOI18N
    btnSalir.setToolTipText("Salir del sistema.");
    btnSalir.setFocusable(false);
    btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btnSalir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSalirActionPerformed(evt);
      }
    });
    toolBar.add(btnSalir);

    menuArchivo.setText("Archivo");

    menuArchivoSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
    menuArchivoSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/egcc/eurekaapp/img/salir.png"))); // NOI18N
    menuArchivoSalir.setText("Salir");
    menuArchivoSalir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuArchivoSalirActionPerformed(evt);
      }
    });
    menuArchivo.add(menuArchivoSalir);

    menuBar.add(menuArchivo);

    menuProceso.setText("Proceso");

    menuProcesoRetiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/egcc/eurekaapp/img/money.png"))); // NOI18N
    menuProcesoRetiro.setText("Retiro");
    menuProcesoRetiro.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuProcesoRetiroActionPerformed(evt);
      }
    });
    menuProceso.add(menuProcesoRetiro);

    menuProcesoDeposito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/egcc/eurekaapp/img/money-bag.png"))); // NOI18N
    menuProcesoDeposito.setText("Depósito");
    menuProceso.add(menuProcesoDeposito);

    menuProcesoTransferncia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/egcc/eurekaapp/img/transfer.png"))); // NOI18N
    menuProcesoTransferncia.setText("Transferencia");
    menuProceso.add(menuProcesoTransferncia);
    menuProceso.add(jSeparator1);

    menuProcesoApertura.setText("Apertura Cuenta");
    menuProceso.add(menuProcesoApertura);

    menuProcesoCierre.setText("Cierre de Cuenta");
    menuProceso.add(menuProcesoCierre);

    menuBar.add(menuProceso);

    menuTabla.setText("Tabla");

    menuTablaClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/egcc/eurekaapp/img/cliente.png"))); // NOI18N
    menuTablaClientes.setText("Clientes");
    menuTablaClientes.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuTablaClientesActionPerformed(evt);
      }
    });
    menuTabla.add(menuTablaClientes);

    menuTablaSucursales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/egcc/eurekaapp/img/sucursal.png"))); // NOI18N
    menuTablaSucursales.setText("Sucursales");
    menuTabla.add(menuTablaSucursales);

    menuTablaEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/egcc/eurekaapp/img/empleado.png"))); // NOI18N
    menuTablaEmpleados.setText("Empleados");
    menuTabla.add(menuTablaEmpleados);

    menuBar.add(menuTabla);

    menuConsulta.setText("Consulta");
    menuBar.add(menuConsulta);

    menuReporte.setText("Reporte");
    menuBar.add(menuReporte);

    menuUtil.setText("Util");
    menuBar.add(menuUtil);

    menuAyuda.setText("Ayuda");
    menuBar.add(menuAyuda);

    setJMenuBar(menuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
      .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void menuArchivoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArchivoSalirActionPerformed
    System.exit(0);
  }//GEN-LAST:event_menuArchivoSalirActionPerformed

  private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    System.exit(0);
  }//GEN-LAST:event_btnSalirActionPerformed

  private void btnRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroActionPerformed
    cargarFormInterno(ProcRetiroView.class);
  }//GEN-LAST:event_btnRetiroActionPerformed

  private void menuProcesoRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProcesoRetiroActionPerformed
    cargarFormInterno(ProcRetiroView.class);
  }//GEN-LAST:event_menuProcesoRetiroActionPerformed

  private void menuTablaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTablaClientesActionPerformed
    cargarFormInterno(MantClientesView.class);
  }//GEN-LAST:event_menuTablaClientesActionPerformed

  private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
    cargarFormInterno(MantClientesView.class);
  }//GEN-LAST:event_btnClientesActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
        //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new MainView().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnClientes;
  private javax.swing.JButton btnDeposito;
  private javax.swing.JButton btnEmpleados;
  private javax.swing.JButton btnRetiro;
  private javax.swing.JButton btnSalir;
  private javax.swing.JButton btnSucursales;
  private javax.swing.JButton btnTransferencia;
  private javax.swing.JDesktopPane desktopPane;
  private javax.swing.JPopupMenu.Separator jSeparator1;
  private javax.swing.JToolBar.Separator jSeparator2;
  private javax.swing.JToolBar.Separator jSeparator3;
  private javax.swing.JMenu menuArchivo;
  private javax.swing.JMenuItem menuArchivoSalir;
  private javax.swing.JMenu menuAyuda;
  private javax.swing.JMenuBar menuBar;
  private javax.swing.JMenu menuConsulta;
  private javax.swing.JMenu menuProceso;
  private javax.swing.JMenuItem menuProcesoApertura;
  private javax.swing.JMenuItem menuProcesoCierre;
  private javax.swing.JMenuItem menuProcesoDeposito;
  private javax.swing.JMenuItem menuProcesoRetiro;
  private javax.swing.JMenuItem menuProcesoTransferncia;
  private javax.swing.JMenu menuReporte;
  private javax.swing.JMenu menuTabla;
  private javax.swing.JMenuItem menuTablaClientes;
  private javax.swing.JMenuItem menuTablaEmpleados;
  private javax.swing.JMenuItem menuTablaSucursales;
  private javax.swing.JMenu menuUtil;
  private javax.swing.JToolBar toolBar;
  // End of variables declaration//GEN-END:variables

  private void establecerTitulo() {
    Empleado bean = (Empleado) Session.get("usuario");
    String titulo = "EUREKA APP [Usuario:" + bean.getUsuario() + "]";
    this.setTitle(titulo);
  }
  
  private void cargarFormInterno(Class<?> aClass) {
    try {
      // Variable de control
      JInternalFrame view = null;
      // Buscar objeto en desktopPane
      for(JInternalFrame form: desktopPane.getAllFrames()){
        if(aClass.isInstance(form)){
          view = form;
          break;
        }
      }
      // Crear instancia
      if(view == null){
        view = (JInternalFrame) Class.forName(aClass.getName()).newInstance();
        desktopPane.add(view);
        view.setVisible(true);
      }
      // Activar formulario
      view.setSelected(true);
      view.setMaximum(true);
    } catch (Exception e) {
    }
  }


}
