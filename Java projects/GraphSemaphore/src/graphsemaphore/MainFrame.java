package graphsemaphore;

import javax.swing.JFrame;

public class MainFrame extends javax.swing.JFrame {
    
    private static GraphSemaphore g;
    private static Archivo archivo;
    private final static String INPUT_FILE_NAME     = "input.txt",      //Nombre del archivo de entrada
                                 FILES_DIRECTORY     = "src/graphsemaphore/files";         //Directorio donde se encuentran
    
    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlStartButton = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 690));
        setSize(new java.awt.Dimension(1024, 690));

        pnlStartButton.setLayout(new javax.swing.BoxLayout(pnlStartButton, javax.swing.BoxLayout.Y_AXIS));
        try {
            archivo = new Archivo(INPUT_FILE_NAME, FILES_DIRECTORY);
            archivo.readFile();
        }
        catch (Exception ex) {ex.printStackTrace();}
        g = new GraphSemaphore(archivo);

        btnStart.setText("Iniciar");
        btnStart.setAlignmentX(0.5F);
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        pnlStartButton.add(btnStart);

        getContentPane().add(pnlStartButton, java.awt.BorderLayout.NORTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        archivo.start(g.getGraph(), g.getArr());
    }//GEN-LAST:event_btnStartActionPerformed

    public static void main(String args[]) throws Exception {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame mainWindow = new MainFrame();
                mainWindow.getContentPane().add(g.getGraphComponent());
                mainWindow.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JPanel pnlStartButton;
    // End of variables declaration//GEN-END:variables
}
