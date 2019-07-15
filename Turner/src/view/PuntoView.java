/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import model.Advisers;
import model.Punts;
import model.PuntsServices;
import model.Service;

/**
 *
 * @author ANDRES
 */
public class PuntoView extends javax.swing.JFrame {

    /**
     * Creates new form PuntoView
     */
    Punts punts = new Punts();
    PuntsServices puntsServices = new PuntsServices();

    public PuntoView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPunto = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblServices = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAdviser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAdviserName = new javax.swing.JTextField();
        cheqActivo = new javax.swing.JCheckBox();
        btnInsertS = new javax.swing.JButton();
        btnInserP = new javax.swing.JButton();
        btnEditP = new javax.swing.JButton();
        btnDeleteP = new javax.swing.JButton();
        btnSaveP = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        txtResultado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnDeleteS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblPunto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblPunto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPuntoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPunto);

        tblServices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblServices);

        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdKeyReleased(evt);
            }
        });

        jLabel1.setText("Id");

        jLabel2.setText("Asesor");

        txtAdviser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdviserKeyReleased(evt);
            }
        });

        jLabel3.setText("Nombre");

        txtAdviserName.setEditable(false);
        txtAdviserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdviserNameKeyReleased(evt);
            }
        });

        cheqActivo.setText("Activo");

        btnInsertS.setText("+");
        btnInsertS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertSActionPerformed(evt);
            }
        });

        btnInserP.setText("+");
        btnInserP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserPActionPerformed(evt);
            }
        });

        btnEditP.setText("^");
        btnEditP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPActionPerformed(evt);
            }
        });

        btnDeleteP.setText("-");
        btnDeleteP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePActionPerformed(evt);
            }
        });

        btnSaveP.setText("Guardar");
        btnSaveP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        txtResultado.setEditable(false);

        jLabel4.setText("Buscar");

        btnDeleteS.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInserP, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditP, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteP)
                        .addGap(5, 5, 5)
                        .addComponent(btnSaveP))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAdviserName)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtAdviser, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cheqActivo)
                                        .addGap(54, 54, 54))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtResultado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInsertS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteS)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtAdviser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cheqActivo)
                            .addComponent(btnBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtAdviserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnInserP)
                        .addComponent(btnEditP)
                        .addComponent(btnDeleteP)
                        .addComponent(btnSaveP)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDeleteS)
                        .addComponent(btnInsertS)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserPActionPerformed
        // TODO add your handling code here:
        txtId.setText("");
        txtAdviser.setText("");
        cheqActivo.setSelected(rootPaneCheckingEnabled);
        txtAdviserName.setText("");
        txtId.requestFocus();
    }//GEN-LAST:event_btnInserPActionPerformed

    private void btnSavePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePActionPerformed
        // TODO add your handling code here:
        punts.InsertPunto(txtId.getText(), txtAdviser.getText(), cheqActivo.isSelected(), txtAdviserName.getText());
        TableView();
    }//GEN-LAST:event_btnSavePActionPerformed

    private void tblPuntoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPuntoMouseClicked
        // TODO add your handling code here:
        MostrarTxt();
    }//GEN-LAST:event_tblPuntoMouseClicked

    private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased
        // TODO add your handling code here:
        txtId.setText(txtId.getText().toUpperCase());
    }//GEN-LAST:event_txtIdKeyReleased

    private void txtAdviserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdviserKeyReleased
        // TODO add your handling code here:
        txtAdviser.setText(txtAdviser.getText().toUpperCase());
    }//GEN-LAST:event_txtAdviserKeyReleased

    private void txtAdviserNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdviserNameKeyReleased
        // TODO add your handling code here:
        txtAdviserName.setText(txtAdviserName.getText().toUpperCase());
    }//GEN-LAST:event_txtAdviserNameKeyReleased

    private void btnEditPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPActionPerformed
        // TODO add your handling code here:
        Punts punts = new Punts();
        punts.UpdatePunto(txtId.getText(), txtAdviser.getText(), cheqActivo.isSelected(), txtAdviserName.getText());
        TableView();
    }//GEN-LAST:event_btnEditPActionPerformed

    private void btnDeletePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePActionPerformed
        // TODO add your handling code here:
        punts.DeletePunto(txtId.getText());
        TableView();
    }//GEN-LAST:event_btnDeletePActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        Advisers advisers = new Advisers();
        txtAdviserName.setText(advisers.ConsultaAdviser(txtAdviser.getText()).getName());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        txtBuscar.setText(txtBuscar.getText().toUpperCase());
        Service service = new Service();
        txtResultado.setText(service.ConsultaServiceL(txtBuscar.getText()).getName());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnInsertSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertSActionPerformed
        // TODO add your handling code here:
        Service service = new Service();
        String idservi = service.ConsultaServiceL(txtBuscar.getText()).getId();
        String servicename = service.ConsultaServiceL(txtBuscar.getText()).getName();
        if (tblServices.getRowCount() < 4) {
            puntsServices.InsertPuntoservices(txtId.getText(), idservi, servicename);
            puntsServices.LlenarPuntoservices(tblServices, txtId.getText());
        }else{
            JOptionPane.showMessageDialog(null, "No se pueden configurar mas de 3 servicios por punto de atención");
        }
        
    }//GEN-LAST:event_btnInsertSActionPerformed

    public void TableView() {
        punts.LlenarPunto(tblPunto, "");
    }

    public void MostrarTxt() {
        int sel = tblPunto.getSelectedRow();
        txtId.setText(tblPunto.getValueAt(sel, 0) + "");
        txtAdviser.setText(tblPunto.getValueAt(sel, 1) + "");
        if (tblPunto.getValueAt(sel, 2) == "true") {
            cheqActivo.setSelected(rootPaneCheckingEnabled);
        } else {
            cheqActivo.setSelected(rootPaneCheckingEnabled);
        }
        txtAdviserName.setText(tblPunto.getValueAt(sel, 3) + "");
        puntsServices.LlenarPuntoservices(tblServices, txtId.getText());
    }

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
            java.util.logging.Logger.getLogger(PuntoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PuntoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PuntoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PuntoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PuntoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDeleteP;
    private javax.swing.JButton btnDeleteS;
    private javax.swing.JButton btnEditP;
    private javax.swing.JButton btnInserP;
    private javax.swing.JButton btnInsertS;
    private javax.swing.JButton btnSaveP;
    private javax.swing.JCheckBox cheqActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tblPunto;
    public javax.swing.JTable tblServices;
    private javax.swing.JTextField txtAdviser;
    private javax.swing.JTextField txtAdviserName;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtResultado;
    // End of variables declaration//GEN-END:variables
}