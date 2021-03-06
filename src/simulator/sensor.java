/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author Franklin
 */
public class sensor extends javax.swing.JFrame {

    /**
     * Creates new form sensor
     */
    private Timer timer;
    int l = 1;
    Process p = new Process();

    public sensor() {
        initComponents();
        this.setTitle("Simulador - Sensor de temperatura");
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                Random r = new Random();
                if (l == 0) {
                    lblLed.setForeground(Color.DARK_GRAY);
                    l = 1;
                } else {
                    lblLed.setForeground(Color.GREEN);
                    l = 0;
                    int valor = r.nextInt((100 - 1) + 1);
                    try {
                        p.runShellCommand("---url de proyecto firebase/sensor.json", "{\"tipo\":1,\"valor\":" + valor + "}");
                    } catch (IOException ex) {
                        Logger.getLogger(sensor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTexto = new javax.swing.JLabel();
        rbtEncendido = new javax.swing.JRadioButton();
        lblLed = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTexto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTexto.setForeground(new java.awt.Color(255, 255, 255));
        lblTexto.setText("Encender Arduino");
        getContentPane().add(lblTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));

        rbtEncendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtEncendidoActionPerformed(evt);
            }
        });
        getContentPane().add(rbtEncendido, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, -1));

        lblLed.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblLed.setText("•");
        getContentPane().add(lblLed, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 410, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simulator/arduino.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtEncendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtEncendidoActionPerformed

        if (rbtEncendido.isSelected()) {
            lblTexto.setText("Apagar arduino");
            timer.start();
        } else {
            lblTexto.setText("Encender arduino");
            lblLed.setForeground(Color.DARK_GRAY);
            timer.stop();
        }
    }//GEN-LAST:event_rbtEncendidoActionPerformed

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
            java.util.logging.Logger.getLogger(sensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sensor().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblLed;
    private javax.swing.JLabel lblTexto;
    private javax.swing.JRadioButton rbtEncendido;
    // End of variables declaration//GEN-END:variables
}
