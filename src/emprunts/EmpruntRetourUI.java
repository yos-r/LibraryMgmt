/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package emprunts;
import livres.LivresGestion;
import authentication.HomepageRegular;
/**
 *
 * @author yosr barghouthi / maissa dridi l2cs02 
 */
public class EmpruntRetourUI extends javax.swing.JFrame {

    /**
     * Creates new form EmpruntRetourUI
     */
    public EmpruntRetourUI(String isbn, String name, String deadline) {
        initComponents();
        this.isbn.setText(isbn);
        this.titre.setText(name);
        this.deadline.setText(deadline);
        datedujour.setText(EmpruntsGestion.datedujour());
    }   
     private EmpruntRetourUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jLabel1 = new javax.swing.JLabel();
        header = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        isbn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        deadline = new javax.swing.JTextField();
        datedujour = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        titre = new javax.swing.JTextField();
        fullname = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        resultat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Rendre livre ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 32, 167, -1));

        header.setEditable(false);
        header.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                headerActionPerformed(evt);
            }
        });
        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 72, 92, -1));

        jLabel2.setText("Le livre que vous avez emprunt?? est: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 102, 185, -1));

        isbn.setEditable(false);
        isbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isbnActionPerformed(evt);
            }
        });
        getContentPane().add(isbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 126, 51, -1));

        jLabel3.setText("?? rendre avant le:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 166, 84, -1));

        deadline.setEditable(false);
        deadline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deadlineActionPerformed(evt);
            }
        });
        getContentPane().add(deadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 163, 142, -1));

        datedujour.setEditable(false);
        getContentPane().add(datedujour, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 193, 94, -1));

        jButton1.setText("Rendre le livre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 233, -1, -1));

        titre.setEditable(false);
        titre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titreActionPerformed(evt);
            }
        });
        getContentPane().add(titre, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 126, 279, -1));

        fullname.setEditable(false);
        getContentPane().add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 72, 197, -1));

        jButton2.setText("retour");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 11, -1, -1));

        jLabel4.setText("la date du jour est");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 196, -1, -1));
        getContentPane().add(resultat, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 193, 120, 29));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_headerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_headerActionPerformed

    private void isbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isbnActionPerformed

    private void deadlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deadlineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deadlineActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int st=EmpruntsGestion.RendreLivre(header.getText(), isbn.getText(), datedujour.getText()) ;
        if (st>0){
            resultat.setText("livre rendu ");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void titreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titreActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        HomepageRegular ui = new HomepageRegular();
        ui.setHomeUsername(header.getText());
        ui.setFullname(fullname.getText());
        ui.setVisible(true);
        this.setVisible(false);
            // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    public void setHeader(String ch){
        this.header.setText(ch);
    }
    public void setFullname(String ch){
        this.fullname.setText(ch);
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
            java.util.logging.Logger.getLogger(EmpruntRetourUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpruntRetourUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpruntRetourUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpruntRetourUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpruntRetourUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField datedujour;
    private javax.swing.JTextField deadline;
    private javax.swing.JTextField fullname;
    private javax.swing.JTextField header;
    private javax.swing.JTextField isbn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JLabel resultat;
    private javax.swing.JTextField titre;
    // End of variables declaration//GEN-END:variables
}
