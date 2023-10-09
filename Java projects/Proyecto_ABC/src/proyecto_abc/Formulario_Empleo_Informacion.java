package proyecto_abc;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.JOptionPane;

public class Formulario_Empleo_Informacion extends javax.swing.JFrame {

    Connection connection;
    
    public Formulario_Empleo_Informacion(Connection connection) {
        initComponents();
         carga_edades();
        
        Dimension pantalla=Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana=this.getSize();
	this.setLocation(((pantalla.width-ventana.width)/2),((pantalla.height-ventana.height)/2));
        
        this.connection = connection;
    }
    
    private void carga_edades() {
		
	for(int counter = 18; counter <= 60; counter++){
	    edadmin.addItem(String.valueOf(counter));
            edadmax.addItem(String.valueOf(counter));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        masculino = new javax.swing.JRadioButton();
        femenino = new javax.swing.JRadioButton();
        edadmin = new javax.swing.JComboBox<>();
        edadmax = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        descripcionTrabajo = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        nacionalidad = new javax.swing.JTextField();
        indefinido = new javax.swing.JRadioButton();
        domNacional = new javax.swing.JCheckBox();
        domInternacional = new javax.swing.JCheckBox();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        correotrabajo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Sexo:");

        masculino.setText("Masculino");

        femenino.setText("Femenino");

        jLabel4.setText("Edad:");

        jLabel5.setText("Domicilio del Postulante:");

        jLabel9.setText("Descripcion General del Trabajo:");

        descripcionTrabajo.setColumns(20);
        descripcionTrabajo.setRows(5);
        jScrollPane4.setViewportView(descripcionTrabajo);

        jLabel10.setText("Nacionalidad:");

        indefinido.setText("Indefinido");

        domNacional.setText("Nacional");

        domInternacional.setText("Internacional");

        jButton4.setText("Siguiente");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cancelar");

        jLabel1.setText("Correo Trabajo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(masculino)
                            .addComponent(femenino)
                            .addComponent(indefinido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edadmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edadmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel10))
                                .addGap(24, 24, 24)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(domNacional)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(domInternacional)))
                        .addGap(18, 18, 18))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jButton4)
                        .addGap(41, 41, 41)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(correotrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(edadmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edadmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(masculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(femenino)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(indefinido)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(domNacional)
                        .addComponent(domInternacional))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(correotrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        String sexo = "";
        String domicilio = "";
        
        if(masculino.isSelected()) sexo = "Masculino";  
        if(femenino.isSelected()) sexo = "Femenino";  
        if(indefinido.isSelected()) sexo = "Indefinido"; 
        
        if(domNacional.isSelected()) domicilio = "Nacional";
        if(domInternacional.isSelected()) domicilio = "Internacional";
        
        agregarOfertaEmpleoDatabase(sexo, domicilio);
        
        Formulario_Empleo_Conocimientos fec = new Formulario_Empleo_Conocimientos(correotrabajo.getText(), connection);
        
        fec.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    public void agregarOfertaEmpleoDatabase(String sexo, String domicilio){
    
         try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `oferta_empleo` (`idoferta_empleo`, `sexo`, `edadmin`, `edadmax`, `domicilio`, `nacionalidad`, `descripcion`, `correo`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)");
                
                ps.setString(1, sexo);
                ps.setInt(2, Integer.parseInt(edadmin.getSelectedItem().toString()));
                ps.setInt(3, Integer.parseInt(edadmax.getSelectedItem().toString()));
                ps.setString(4, domicilio);
                ps.setString(5, nacionalidad.getText());
                ps.setString(6, descripcionTrabajo.getText());
                ps.setString(7, correotrabajo.getText());
                
                ps.executeUpdate();
                JOptionPane.showMessageDialog (null, "Registro de Informacion Oferta Empleo", "Oferta Empleo Personal Cargada Correctamente", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (SQLException ex) {
                
                Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog (null, "Registro de Informacion Personal Postulante", "Ha Ocurrido un Error", JOptionPane.ERROR_MESSAGE);
            }
    
    
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField correotrabajo;
    private javax.swing.JTextArea descripcionTrabajo;
    private javax.swing.JCheckBox domInternacional;
    private javax.swing.JCheckBox domNacional;
    private javax.swing.JComboBox<String> edadmax;
    private javax.swing.JComboBox<String> edadmin;
    private javax.swing.JRadioButton femenino;
    private javax.swing.JRadioButton indefinido;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton masculino;
    private javax.swing.JTextField nacionalidad;
    // End of variables declaration//GEN-END:variables
}
