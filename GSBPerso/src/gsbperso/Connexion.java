
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gsbperso;

import com.mysql.jdbc.Connection;
import com.sun.org.apache.xpath.internal.axes.SelfIteratorNoPredicate;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author nc
 */
public class Connexion extends javax.swing.JDialog {
    private InterfaceGraphique fenetre;
    /**
     * Creates new form Connexion
     */
    public Connexion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //positionnement au milieu de la fenetre parente
        this.setLocationRelativeTo(parent);
        //modal==true signifie que l'on ne peut pas revenir 
        //sur la precedente fenêtre dans fermer connexion
        this.setModal(true);
        //on stocke dans this.fenetre la référence vers la fenetre parente
        this.fenetre=(InterfaceGraphique)parent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jButtonConnecter = new javax.swing.JButton();
        jPassMDP = new javax.swing.JPasswordField();
        jLabelMDP = new javax.swing.JLabel();
        jLabelIdentifiant = new javax.swing.JLabel();
        jTextFieldIdentifiant = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        org.jdesktop.layout.GroupLayout jDialog1Layout = new org.jdesktop.layout.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("connexion");
        setModal(true);
        setResizable(false);

        jButtonConnecter.setText("Se connecter");
        jButtonConnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnecterActionPerformed(evt);
            }
        });

        jLabelMDP.setText("Mot de passe");

        jLabelIdentifiant.setText("Identifiant");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Saisissez vos informations");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jButtonConnecter)
                        .add(123, 123, 123))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabelIdentifiant)
                                    .add(jLabelMDP))
                                .add(18, 18, 18)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jTextFieldIdentifiant)
                                    .add(jPassMDP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))))
                        .add(59, 59, 59))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelIdentifiant)
                    .add(jTextFieldIdentifiant, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jPassMDP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabelMDP))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 13, Short.MAX_VALUE)
                .add(jButtonConnecter)
                .add(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConnecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnecterActionPerformed
        // TODO add your handling code here:
        /**
         * Code ici qui va interroger la base de données
         */
        //Vérification des saisies
        if (jTextFieldIdentifiant.getText().length()==0 || jPassMDP.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Erreur de saisie, les deux champs doivent être renseignés.");
            
            this.fenetre.deconnecte();
        }else{
            
            try {
                //interrogation de la BD pour savoir si l'identifiant/mot de passe est correct
                //instanciation de la classe Driver du paquetage jdbc de mysql
                Class.forName("com.mysql.jdbc.Driver");
                //Chaine de connexion (prise dans l'onglet services)
                String connexionUrl="jdbc:mysql://localhost:3333/gsbperso?user=gsbperso&password=ppe3";
               
                //etablissement de la connexion
                Connection maConnexion=(Connection)DriverManager.getConnection(connexionUrl);
                
                //requete
                Statement requete=maConnexion.createStatement();
                String identifiant=jTextFieldIdentifiant.getText();
                String mdp=jPassMDP.getText();
                
            
                //application du cryptage md5 au mdp
                // ici on appelle md5 membre static de la classe outils
                mdp=Outils.md5(mdp);
                System.out.println(mdp);
                ResultSet lignesRetournees=requete.executeQuery("select * from utilisateurs where identifiant='"+identifiant+"' and mot_de_passe='"+mdp+"'");
                if (lignesRetournees.next()){
                    String nom=lignesRetournees.getString("nom");
                    Integer position = lignesRetournees.getInt("position");
                    ResultSet strPosition =requete.executeQuery("select * from cv_positions where id_position="+position);
                    if(strPosition.next()){
                    String laPosition = strPosition.getString("libelle_position");
                    
                    this.fenetre.connecte(nom,laPosition);
                    }
                    this.setVisible(false);
                    this.fenetre.majConnexion();
                    
                }else{
                    JOptionPane.showMessageDialog(rootPane, "identifiant ou mot de passe incorrect");
                };
                
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(rootPane, "Classe de connexion mysql non trouvee..."+ex.toString());
            }
             catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "SQL exception ... "+ex.toString());
            }
            catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_jButtonConnecterActionPerformed

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
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Connexion dialog = new Connexion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConnecter;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelIdentifiant;
    private javax.swing.JLabel jLabelMDP;
    private javax.swing.JPasswordField jPassMDP;
    private javax.swing.JTextField jTextFieldIdentifiant;
    // End of variables declaration//GEN-END:variables
}
