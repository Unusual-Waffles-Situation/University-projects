package proyecto_abc;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ToSendDatabaseEmpleoFrame extends javax.swing.JFrame {

    private int id_ofertaempleo, option;
    Connection connection;
 
    public ToSendDatabaseEmpleoFrame(int id_ofertaempleo, int option, Connection connection) {
        initComponents();
        
          Dimension pantalla=Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana=this.getSize();
	this.setLocation(((pantalla.width-ventana.width)/2),((pantalla.height-ventana.height)/2));
        
        this.id_ofertaempleo = id_ofertaempleo;   
        this.option = option;
        this.connection = connection; 
    }
    
     
    // Seleccionando la opcion dependiendo del conocimiento que el postulante desea ingresar.
    public void selectOptionDatabase(int option){
    
        switch(option){
            case 1: agregarHerramientasOfertaEmpleoDatabase();
                    break;
            case 2: agregarCertificacionesOfertaEmpleoDatabase();
                    break;
        }
    }
    
       // Almacenar en la base de datos las herramientas oferta empleo del postulante.
    public void agregarHerramientasOfertaEmpleoDatabase(){
        
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `herramientas_ofertaempleo` (`idherramienta_oferta`, `herramienta`, `idoferta_empleo`) VALUES (NULL, ?, ?)");
                
                ps.setString(1, jTextField1.getText());
                ps.setInt(2, id_ofertaempleo);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
        // Almacenar en la base de datos las certificaciones de oferta empleo del postulante.
    public void agregarCertificacionesOfertaEmpleoDatabase(){
        
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `certificaciones_ofertaempleo` (`idcertificacion_ofertaempleo`, `certificacion`, `idoferta_empleo`) VALUES (NULL, ?, ?)");
                
                ps.setString(1, jTextField1.getText());
                ps.setInt(2, id_ofertaempleo);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        texto = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        texto.setText("Ingrese Conocimiento:");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(texto)
                        .addGap(134, 134, 134))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))))
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jButton1)
                .addGap(63, 63, 63)
                .addComponent(jButton2)
                .addGap(0, 93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(texto)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          if(!jTextField1.getText().equals("")){
                    selectOptionDatabase(option);
                    dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel texto;
    // End of variables declaration//GEN-END:variables
}
