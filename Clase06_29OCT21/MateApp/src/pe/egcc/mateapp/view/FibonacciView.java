/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.mateapp.view;

import pe.egcc.mateapp.controller.MateController;

/**
 *
 * @author Gustavo Coronel
 */
public class FibonacciView extends javax.swing.JInternalFrame {

  /**
   * Creates new form FibonacciView
   */
  public FibonacciView() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    txtNum = new javax.swing.JTextField();
    btnProcesar = new javax.swing.JButton();
    jScrollPane2 = new javax.swing.JScrollPane();
    txtRepo = new javax.swing.JTextArea();

    setClosable(true);
    setMaximizable(true);
    setResizable(true);
    setTitle("FIBONACCI");

    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
    jLabel1.setText("Cantidad Elementos");

    txtNum.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

    btnProcesar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btnProcesar.setText("Procesar");
    btnProcesar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnProcesarActionPerformed(evt);
      }
    });

    txtRepo.setColumns(20);
    txtRepo.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
    txtRepo.setLineWrap(true);
    txtRepo.setRows(5);
    jScrollPane2.setViewportView(txtRepo);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(64, 64, 64)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jScrollPane2)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(67, 67, 67)
            .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(111, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(40, 40, 40)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(btnProcesar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(68, 68, 68)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(101, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
    // Dato
    int num = Integer.parseInt(txtNum.getText());
    
    // Proceso
    MateController control = new MateController();
    int[] serie = control.fibonacci(num);
    
    // Reporte
    String repo = "";
    for (int ele : serie) {
      repo += ele + "\t";
    }
    txtRepo.setText(repo);
  }//GEN-LAST:event_btnProcesarActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnProcesar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTextField txtNum;
  private javax.swing.JTextArea txtRepo;
  // End of variables declaration//GEN-END:variables
}
