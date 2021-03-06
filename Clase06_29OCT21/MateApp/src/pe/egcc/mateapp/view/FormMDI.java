package pe.egcc.mateapp.view;

import javax.swing.JInternalFrame;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class FormMDI extends javax.swing.JFrame {

	/**
	 * Creates new form FormMDI
	 */
	public FormMDI() {
		initComponents();
		this.setExtendedState(MAXIMIZED_BOTH);
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      desktopPane = new javax.swing.JDesktopPane();
      menuBar = new javax.swing.JMenuBar();
      menuArchivo = new javax.swing.JMenu();
      menuArchivoSalir = new javax.swing.JMenuItem();
      menuMate = new javax.swing.JMenu();
      menuMateFactorial = new javax.swing.JMenuItem();
      menuMateMcdMcm = new javax.swing.JMenuItem();
      menuMateFibonacci = new javax.swing.JMenuItem();
      menuMatePrimo = new javax.swing.JMenuItem();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("MATEMATICAS APP");

      menuArchivo.setText("Archivo");

      menuArchivoSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
      menuArchivoSalir.setText("Salir");
      menuArchivoSalir.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            menuArchivoSalirActionPerformed(evt);
         }
      });
      menuArchivo.add(menuArchivoSalir);

      menuBar.add(menuArchivo);

      menuMate.setText("Matemáticas");

      menuMateFactorial.setText("Factorial");
      menuMateFactorial.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            menuMateFactorialActionPerformed(evt);
         }
      });
      menuMate.add(menuMateFactorial);

      menuMateMcdMcm.setText("MCD y MCM");
      menuMateMcdMcm.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            menuMateMcdMcmActionPerformed(evt);
         }
      });
      menuMate.add(menuMateMcdMcm);

      menuMateFibonacci.setText("Fibonacci");
      menuMateFibonacci.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            menuMateFibonacciActionPerformed(evt);
         }
      });
      menuMate.add(menuMateFibonacci);

      menuMatePrimo.setText("Primo");
      menuMatePrimo.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            menuMatePrimoActionPerformed(evt);
         }
      });
      menuMate.add(menuMatePrimo);

      menuBar.add(menuMate);

      setJMenuBar(menuBar);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

  private void menuArchivoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArchivoSalirActionPerformed
	  System.exit(0);
  }//GEN-LAST:event_menuArchivoSalirActionPerformed

  private void menuMateFactorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMateFactorialActionPerformed
	  mostrarForm(FactorialView.class);
  }//GEN-LAST:event_menuMateFactorialActionPerformed

  private void menuMateMcdMcmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMateMcdMcmActionPerformed
	  mostrarForm(McdMcmView.class);
  }//GEN-LAST:event_menuMateMcdMcmActionPerformed

  private void menuMateFibonacciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMateFibonacciActionPerformed
	  mostrarForm(FibonacciView.class);
  }//GEN-LAST:event_menuMateFibonacciActionPerformed

  private void menuMatePrimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMatePrimoActionPerformed
	  mostrarForm(PrimoView.class);
  }//GEN-LAST:event_menuMatePrimoActionPerformed

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
			java.util.logging.Logger.getLogger(FormMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FormMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FormMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FormMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FormMDI().setVisible(true);
			}
		});
	}

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JDesktopPane desktopPane;
   private javax.swing.JMenu menuArchivo;
   private javax.swing.JMenuItem menuArchivoSalir;
   private javax.swing.JMenuBar menuBar;
   private javax.swing.JMenu menuMate;
   private javax.swing.JMenuItem menuMateFactorial;
   private javax.swing.JMenuItem menuMateFibonacci;
   private javax.swing.JMenuItem menuMateMcdMcm;
   private javax.swing.JMenuItem menuMatePrimo;
   // End of variables declaration//GEN-END:variables

	private void mostrarForm(Class<?> aClass) {

		try {

			// Variable de control
			JInternalFrame view = null;

			// Buscar instancia
			for (JInternalFrame form : desktopPane.getAllFrames()) {
				if (aClass.isInstance(form)) {
					view = form;
					break;
				}
			}

			// Crear instancia
			if (view == null) {
				//view = (JInternalFrame) Class.forName(aClass.getName()).newInstance();
				view = (JInternalFrame) aClass.getConstructor().newInstance();
				desktopPane.add(view);
				view.setVisible(true);
			}
			view.setSelected(true);

		} catch (Exception e) {
		}

	}

}
