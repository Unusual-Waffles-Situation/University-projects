package proyecto_abc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.logging.*;

public class ToSendDatabaseFrame extends javax.swing.JFrame {

    private int id_postulante, option;
    Connection connection;
    
    public ToSendDatabaseFrame(int id_postulante, int option, Connection connection) {
        initComponents();
        Dimension pantalla=Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana=this.getSize();
	this.setLocation(((pantalla.width-ventana.width)/2),((pantalla.height-ventana.height)/2));
        
        this.id_postulante = id_postulante;   
        this.option = option;
        this.connection = connection;    
    }
    
    // Seleccionando la opcion dependiendo del conocimiento que el postulante desea ingresar.
    public void selectOptionDatabase(int option){
    
        switch(option){
            case 0: agregarCertificacionesDatabase();
                    break;
            case 1: agregarHerramientasManejadasDatabase();
                    break;
            case 2: agregarConocimientosGeneralesDatabase();
                    break;
            case 3: agregarExperienciasLaboralesDatabase();
                    break;
        }
    }
    
    // Almacenar en la base de datos las certificaciones del postulante.
    public void agregarCertificacionesDatabase(){
        
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `certificaciones` (`idcertificacion`, `certificacion`, `idpostulante`) VALUES (NULL, ?, ?)");
                
                ps.setString(1, jTextField1.getText());
                ps.setInt(2, id_postulante);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    // Almacenar en la base de datos las herramientas manejadas del postulante.
    public void agregarHerramientasManejadasDatabase(){
    
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `herramientas_manejadas` (`idherramientas`, `herramienta`, `idpostulante`) VALUES (NULL, ?, ?)");
                
                ps.setString(1, jTextField1.getText());
                ps.setInt(2, id_postulante);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    // Almacenar en la base de datos los conocimientos generales del postulante.
    public void agregarConocimientosGeneralesDatabase(){
    
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `conocimientos_generales` (`idconocimientos`, `conocimiento_general`, `idpostulante`) VALUES (NULL, ?, ?)");
                
                ps.setString(1, jTextField1.getText());
                ps.setInt(2, id_postulante);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    // Almacenar en la base de datos las experiencias laborales del postulante.
    public void agregarExperienciasLaboralesDatabase(){
    
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `experiencia_laboral` (`idexperiencia_laboral`, `experiencia`, `idpostulante`) VALUES (NULL, ?, ?)");
                
                ps.setString(1, jTextField1.getText());
                ps.setInt(2, id_postulante);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ingrese un conocimiento:");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!jTextField1.getText().equals("")){
                    selectOptionDatabase(option);
                    dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
