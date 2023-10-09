package proyecto_abc;

import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;

public class Formulario_Empleo_Conocimientos extends javax.swing.JFrame {
    
    Connection connection;
    private String correoTrabajo;
    private int id_ofertaempleo;
    private ArrayList<String> nivelesAcademicos = new ArrayList<String>();
    private ArrayList<String> especialidades = new ArrayList<String>();

    public Formulario_Empleo_Conocimientos(String correoTrabajo, Connection connection) {
        initComponents();
        
        Dimension pantalla=Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana=this.getSize();
	this.setLocation(((pantalla.width-ventana.width)/2),((pantalla.height-ventana.height)/2));
        
        this.correoTrabajo = correoTrabajo;
        this.connection = connection;
        
        this.id_ofertaempleo = getIdOfertaTrabajoDatabase(correoTrabajo);
        
        System.out.println("ID oferta de empleo: " + this.id_ofertaempleo);
        
        System.out.println(correoTrabajo);
    }
    
         // Obtiene el id del postulante durante la aplicacion desde la base de datos.
          private int getIdOfertaTrabajoDatabase(String correoTrabajo){
        
             int id_ofertatrabajo = 0;
              
             try {
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM oferta_empleo WHERE correo = ?");
                
                ps.setString(1, correoTrabajo);
                
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    id_ofertatrabajo = Integer.parseInt(rs.getString(1));
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
             
          return id_ofertatrabajo;
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        bachiller = new javax.swing.JCheckBox();
        licenciado = new javax.swing.JCheckBox();
        ingeniero = new javax.swing.JCheckBox();
        tsu = new javax.swing.JCheckBox();
        magister = new javax.swing.JCheckBox();
        doctor = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        backend = new javax.swing.JRadioButton();
        frontend = new javax.swing.JRadioButton();
        database = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        agregarProyectos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        computacion = new javax.swing.JCheckBox();
        informatica = new javax.swing.JCheckBox();
        sistemas = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        AgregarHerramientas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        agregarCertificaciones = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nivel Academico del Postulante");

        bachiller.setText("Bachiller");

        licenciado.setText("Licenciado");

        ingeniero.setText("Ingeniero");

        tsu.setText("Tecnico Superior");

        magister.setText("Magister");

        doctor.setText("Doctor");

        jLabel2.setText("Tipo de Proyecto");

        backend.setText("Backend");

        frontend.setText("Frontend");

        database.setText("Database");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        agregarProyectos.setText("Agregar");

        jLabel3.setText("Especialidad");

        computacion.setText("Computacion");

        informatica.setText("Informatica");

        sistemas.setText("Sistemas");

        jLabel4.setText("Herramientas de programacion a usar");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        AgregarHerramientas.setText("Agregar");
        AgregarHerramientas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarHerramientasActionPerformed(evt);
            }
        });

        jLabel5.setText("Certificaciones Extras");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        agregarCertificaciones.setText("Agregar");
        agregarCertificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCertificacionesActionPerformed(evt);
            }
        });

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(magister)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tsu)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(109, 109, 109)
                                        .addComponent(jLabel3)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bachiller)
                                    .addComponent(licenciado)
                                    .addComponent(ingeniero))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sistemas)
                                    .addComponent(informatica)
                                    .addComponent(computacion))
                                .addGap(74, 74, 74))
                            .addComponent(doctor)
                            .addComponent(jLabel2)
                            .addComponent(backend))
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(frontend)
                            .addComponent(database))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AgregarHerramientas)
                        .addGap(104, 104, 104))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(agregarProyectos)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jLabel5)
                                .addGap(0, 78, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(62, 62, 62))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(agregarCertificaciones)
                                        .addGap(105, 105, 105))))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jButton2)
                .addGap(38, 38, 38)
                .addComponent(cancelar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bachiller)
                    .addComponent(computacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(licenciado)
                    .addComponent(informatica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ingeniero)
                    .addComponent(sistemas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tsu)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(magister)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(doctor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(backend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(frontend, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(database))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AgregarHerramientas)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agregarProyectos))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agregarCertificaciones)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        // Niveles Academicos.
        if(bachiller.isSelected()) nivelesAcademicos.add("Bachiller");
        if(licenciado.isSelected()) nivelesAcademicos.add("Licenciado");
        if(ingeniero.isSelected()) nivelesAcademicos.add("Ingeniero");
        if(tsu.isSelected()) nivelesAcademicos.add("Tecnico Superior");
        if(magister.isSelected()) nivelesAcademicos.add("Magister");
        if(doctor.isSelected()) nivelesAcademicos.add("Doctor");
        
        //Especialidades.
        if(computacion.isSelected()) especialidades.add("Computacion");
        if(informatica.isSelected()) especialidades.add("Informatica");
        if(sistemas.isSelected()) especialidades.add("Sistemas");
        
        if(nivelesAcademicos.isEmpty() || especialidades.isEmpty()){
            JOptionPane.showMessageDialog (null, "Registro de Informacion Personal Postulante", "Ha Ocurrido un Error", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
        
        agregarNivelesAcademicos_OfertaEmpleo();
        agregarEspecialidades_OfertaEmpleo();
        
		if(evt.getSource().equals(agregarProyectos)) {
                    
		    ToSendDatabaseEmpleoFrame tsdf = new ToSendDatabaseEmpleoFrame(id_ofertaempleo, 0, connection);
                    tsdf.setVisible(true);
		}
		if(evt.getSource().equals(cancelar)) {
                    Menu_Principal mp = new Menu_Principal(connection);
                    mp.setVisible(true);
                    dispose();
		}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void AgregarHerramientasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarHerramientasActionPerformed
        // TODO add your handling code here:
        ToSendDatabaseEmpleoFrame tsdf = new ToSendDatabaseEmpleoFrame(id_ofertaempleo, 1, connection);
        tsdf.setVisible(true);
    }//GEN-LAST:event_AgregarHerramientasActionPerformed

    private void agregarCertificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCertificacionesActionPerformed
        // TODO add your handling code here:
        ToSendDatabaseEmpleoFrame tsdf = new ToSendDatabaseEmpleoFrame(id_ofertaempleo, 2, connection);
        tsdf.setVisible(true);
    }//GEN-LAST:event_agregarCertificacionesActionPerformed

      public void agregarNivelesAcademicos_OfertaEmpleo(){
    
        for(int counter = 0; counter < nivelesAcademicos.size(); counter++){
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `nivelacademico_ofertaempleo` (`idnc_ofertaempleo`, `titulo`, `idoferta_empleo`) VALUES (NULL, ?, ?)");
                
                ps.setString(1, nivelesAcademicos.get(counter));
                ps.setInt(2, id_ofertaempleo);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      
     public void agregarEspecialidades_OfertaEmpleo(){
    
        for(int counter = 0; counter < especialidades.size(); counter++){
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `especialidades_ofertaempleo` (`id_especialidadoe`, `especialidad`, `idoferta_empleo`) VALUES (NULL, ?, ?)");
                
                ps.setString(1, especialidades.get(counter));
                ps.setInt(2, id_ofertaempleo);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarHerramientas;
    private javax.swing.JButton agregarCertificaciones;
    private javax.swing.JButton agregarProyectos;
    private javax.swing.JCheckBox bachiller;
    private javax.swing.JRadioButton backend;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelar;
    private javax.swing.JCheckBox computacion;
    private javax.swing.JRadioButton database;
    private javax.swing.JCheckBox doctor;
    private javax.swing.JRadioButton frontend;
    private javax.swing.JCheckBox informatica;
    private javax.swing.JCheckBox ingeniero;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JCheckBox licenciado;
    private javax.swing.JCheckBox magister;
    private javax.swing.JCheckBox sistemas;
    private javax.swing.JCheckBox tsu;
    // End of variables declaration//GEN-END:variables
}