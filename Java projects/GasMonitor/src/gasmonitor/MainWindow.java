package gasmonitor;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindow extends javax.swing.JFrame {
    
    private final Archivo a;
   // private static final String INPUT_FILE_NAME     = "input.txt",      //Nombre del archivo de entrada
                               // FILES_DIRECTORY     = "src/gasmonitor/files";         //Directorio donde se encuentran
    
    public MainWindow(final Archivo a) {
        initComponents();
        this.a = a;
        /*a = new Archivo(INPUT_FILE_NAME, FILES_DIRECTORY);
        a.setLabelsBombas(getLblBombasCapacidad());
        a.readFile();*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGas1 = new javax.swing.JPanel();
        pnlBomba1 = new javax.swing.JPanel();
        lblBomba1 = new javax.swing.JLabel();
        lblBomba1Capacidad = new javax.swing.JLabel();
        pnlSurtidor1 = new javax.swing.JPanel();
        lblSurtidor1 = new javax.swing.JLabel();
        lblS1Contador = new javax.swing.JLabel();
        pnlSurtidor2 = new javax.swing.JPanel();
        lblSurtidor2 = new javax.swing.JLabel();
        lblS2Contador = new javax.swing.JLabel();
        pnlGas2 = new javax.swing.JPanel();
        pnlBomba2 = new javax.swing.JPanel();
        lblBomba2 = new javax.swing.JLabel();
        lblBomba2Capacidad = new javax.swing.JLabel();
        pnlSurtidor3 = new javax.swing.JPanel();
        lblSurtidor3 = new javax.swing.JLabel();
        lblS3Contador = new javax.swing.JLabel();
        pnlSurtidor4 = new javax.swing.JPanel();
        lblSurtidor4 = new javax.swing.JLabel();
        lblS4Contador = new javax.swing.JLabel();
        pnlGas3 = new javax.swing.JPanel();
        pnlBomba3 = new javax.swing.JPanel();
        lblBomba3 = new javax.swing.JLabel();
        lblBomba3Capacidad = new javax.swing.JLabel();
        pnlSurtidor5 = new javax.swing.JPanel();
        lblSurtidor5 = new javax.swing.JLabel();
        lblS5Contador = new javax.swing.JLabel();
        pnlSurtidor6 = new javax.swing.JPanel();
        lblSurtidor6 = new javax.swing.JLabel();
        lblS6Contador = new javax.swing.JLabel();
        pnlBorder = new javax.swing.JPanel();
        pnlTanque1 = new javax.swing.JPanel();
        pnlTanqueAzul1 = new javax.swing.JPanel();
        pnlSurtidorTanque1 = new javax.swing.JPanel();
        lblCisterna1 = new javax.swing.JLabel();
        pnlTanque2 = new javax.swing.JPanel();
        pnlTanqueAzul2 = new javax.swing.JPanel();
        pnlSurtidorTanque2 = new javax.swing.JPanel();
        lblCisterna2 = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        pnlLeft = new javax.swing.JPanel();
        lblRestantes = new javax.swing.JLabel();
        pnlCola = new javax.swing.JPanel();
        lblEnCola1 = new javax.swing.JLabel();
        lblEnCola2 = new javax.swing.JLabel();
        lblEnCola3 = new javax.swing.JLabel();
        lblEnCola4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblEnColaCounter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBomba1.setBackground(new java.awt.Color(255, 255, 255));
        pnlBomba1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 3, true));

        lblBomba1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        lblBomba1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBomba1.setText("0");

        lblBomba1Capacidad.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        lblBomba1Capacidad.setForeground(new java.awt.Color(0, 153, 51));
        lblBomba1Capacidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBomba1Capacidad.setText("0");

        javax.swing.GroupLayout pnlBomba1Layout = new javax.swing.GroupLayout(pnlBomba1);
        pnlBomba1.setLayout(pnlBomba1Layout);
        pnlBomba1Layout.setHorizontalGroup(
            pnlBomba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBomba1Capacidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblBomba1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );
        pnlBomba1Layout.setVerticalGroup(
            pnlBomba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBomba1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBomba1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBomba1Capacidad)
                .addContainerGap())
        );

        pnlSurtidor1.setBackground(new java.awt.Color(255, 255, 255));
        pnlSurtidor1.setPreferredSize(new java.awt.Dimension(52, 111));
        pnlSurtidor1.setLayout(new javax.swing.BoxLayout(pnlSurtidor1, javax.swing.BoxLayout.Y_AXIS));

        lblSurtidor1.setVisible(false);
        lblSurtidor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSurtidor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gasmonitor/resources/bike.jpg"))); // NOI18N
        lblSurtidor1.setToolTipText("");
        lblSurtidor1.setAlignmentX(0.5F);
        pnlSurtidor1.add(lblSurtidor1);

        lblS1Contador.setVisible(false);
        lblS1Contador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblS1Contador.setText("1");
        lblS1Contador.setAlignmentX(0.5F);
        pnlSurtidor1.add(lblS1Contador);

        pnlSurtidor2.setBackground(new java.awt.Color(255, 255, 255));
        pnlSurtidor2.setPreferredSize(new java.awt.Dimension(52, 98));
        pnlSurtidor2.setLayout(new javax.swing.BoxLayout(pnlSurtidor2, javax.swing.BoxLayout.Y_AXIS));

        lblSurtidor2.setVisible(false);
        lblSurtidor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSurtidor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gasmonitor/resources/bike.jpg"))); // NOI18N
        lblSurtidor2.setToolTipText("");
        lblSurtidor2.setAlignmentX(0.5F);
        pnlSurtidor2.add(lblSurtidor2);

        lblS2Contador.setVisible(false);
        lblS2Contador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblS2Contador.setText("1");
        lblS2Contador.setAlignmentX(0.5F);
        pnlSurtidor2.add(lblS2Contador);

        javax.swing.GroupLayout pnlGas1Layout = new javax.swing.GroupLayout(pnlGas1);
        pnlGas1.setLayout(pnlGas1Layout);
        pnlGas1Layout.setHorizontalGroup(
            pnlGas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGas1Layout.createSequentialGroup()
                .addComponent(pnlSurtidor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlBomba1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSurtidor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlGas1Layout.setVerticalGroup(
            pnlGas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGas1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlSurtidor1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(pnlSurtidor2, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(pnlBomba1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlBomba2.setBackground(new java.awt.Color(255, 255, 255));
        pnlBomba2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 3, true));

        lblBomba2.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        lblBomba2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBomba2.setText("1");

        lblBomba2Capacidad.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        lblBomba2Capacidad.setForeground(new java.awt.Color(0, 153, 51));
        lblBomba2Capacidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBomba2Capacidad.setText("0");

        javax.swing.GroupLayout pnlBomba2Layout = new javax.swing.GroupLayout(pnlBomba2);
        pnlBomba2.setLayout(pnlBomba2Layout);
        pnlBomba2Layout.setHorizontalGroup(
            pnlBomba2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBomba2Capacidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblBomba2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );
        pnlBomba2Layout.setVerticalGroup(
            pnlBomba2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBomba2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBomba2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(lblBomba2Capacidad)
                .addContainerGap())
        );

        pnlSurtidor3.setBackground(new java.awt.Color(255, 255, 255));
        pnlSurtidor3.setPreferredSize(new java.awt.Dimension(52, 78));
        pnlSurtidor3.setLayout(new javax.swing.BoxLayout(pnlSurtidor3, javax.swing.BoxLayout.Y_AXIS));

        lblSurtidor3.setVisible(false);
        lblSurtidor3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSurtidor3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gasmonitor/resources/bike.jpg"))); // NOI18N
        lblSurtidor3.setAlignmentX(0.5F);
        pnlSurtidor3.add(lblSurtidor3);

        lblS3Contador.setVisible(false);
        lblS3Contador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblS3Contador.setText("jLabel1");
        lblS3Contador.setAlignmentX(0.5F);
        pnlSurtidor3.add(lblS3Contador);

        pnlSurtidor4.setBackground(new java.awt.Color(255, 255, 255));
        pnlSurtidor4.setPreferredSize(new java.awt.Dimension(52, 78));
        pnlSurtidor4.setLayout(new javax.swing.BoxLayout(pnlSurtidor4, javax.swing.BoxLayout.Y_AXIS));

        lblSurtidor4.setVisible(false);
        lblSurtidor4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSurtidor4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gasmonitor/resources/bike.jpg"))); // NOI18N
        lblSurtidor4.setAlignmentX(0.5F);
        pnlSurtidor4.add(lblSurtidor4);

        lblS4Contador.setVisible(false);
        lblS4Contador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblS4Contador.setText("jLabel2");
        lblS4Contador.setAlignmentX(0.5F);
        pnlSurtidor4.add(lblS4Contador);

        javax.swing.GroupLayout pnlGas2Layout = new javax.swing.GroupLayout(pnlGas2);
        pnlGas2.setLayout(pnlGas2Layout);
        pnlGas2Layout.setHorizontalGroup(
            pnlGas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGas2Layout.createSequentialGroup()
                .addComponent(pnlSurtidor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlBomba2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSurtidor4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlGas2Layout.setVerticalGroup(
            pnlGas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGas2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBomba2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSurtidor3, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(pnlSurtidor4, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlBomba3.setBackground(new java.awt.Color(255, 255, 255));
        pnlBomba3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 3, true));

        lblBomba3.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        lblBomba3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBomba3.setText("2");

        lblBomba3Capacidad.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        lblBomba3Capacidad.setForeground(new java.awt.Color(0, 153, 51));
        lblBomba3Capacidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBomba3Capacidad.setText("0");

        javax.swing.GroupLayout pnlBomba3Layout = new javax.swing.GroupLayout(pnlBomba3);
        pnlBomba3.setLayout(pnlBomba3Layout);
        pnlBomba3Layout.setHorizontalGroup(
            pnlBomba3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBomba3Capacidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblBomba3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );
        pnlBomba3Layout.setVerticalGroup(
            pnlBomba3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBomba3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBomba3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(lblBomba3Capacidad)
                .addContainerGap())
        );

        pnlSurtidor5.setBackground(new java.awt.Color(255, 255, 255));
        pnlSurtidor5.setPreferredSize(new java.awt.Dimension(52, 78));
        pnlSurtidor5.setLayout(new javax.swing.BoxLayout(pnlSurtidor5, javax.swing.BoxLayout.Y_AXIS));

        lblSurtidor5.setVisible(false);
        lblSurtidor5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gasmonitor/resources/bike.jpg"))); // NOI18N
        lblSurtidor5.setAlignmentX(0.5F);
        pnlSurtidor5.add(lblSurtidor5);

        lblS5Contador.setVisible(false);
        lblS5Contador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblS5Contador.setText("jLabel3");
        lblS5Contador.setAlignmentX(0.5F);
        pnlSurtidor5.add(lblS5Contador);

        pnlSurtidor6.setBackground(new java.awt.Color(255, 255, 255));
        pnlSurtidor6.setPreferredSize(new java.awt.Dimension(52, 78));
        pnlSurtidor6.setLayout(new javax.swing.BoxLayout(pnlSurtidor6, javax.swing.BoxLayout.Y_AXIS));

        lblSurtidor6.setVisible(false);
        lblSurtidor6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gasmonitor/resources/bike.jpg"))); // NOI18N
        lblSurtidor6.setAlignmentX(0.5F);
        pnlSurtidor6.add(lblSurtidor6);

        lblS6Contador.setVisible(false);
        lblS6Contador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblS6Contador.setText("jLabel4");
        lblS6Contador.setAlignmentX(0.5F);
        pnlSurtidor6.add(lblS6Contador);

        javax.swing.GroupLayout pnlGas3Layout = new javax.swing.GroupLayout(pnlGas3);
        pnlGas3.setLayout(pnlGas3Layout);
        pnlGas3Layout.setHorizontalGroup(
            pnlGas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGas3Layout.createSequentialGroup()
                .addComponent(pnlSurtidor5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlBomba3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSurtidor6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlGas3Layout.setVerticalGroup(
            pnlGas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGas3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBomba3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSurtidor5, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(pnlSurtidor6, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlBorder.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout pnlBorderLayout = new javax.swing.GroupLayout(pnlBorder);
        pnlBorder.setLayout(pnlBorderLayout);
        pnlBorderLayout.setHorizontalGroup(
            pnlBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );
        pnlBorderLayout.setVerticalGroup(
            pnlBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlTanqueAzul1.setBackground(new java.awt.Color(0, 51, 255));
        pnlTanqueAzul1.setPreferredSize(new java.awt.Dimension(244, 32));

        javax.swing.GroupLayout pnlTanqueAzul1Layout = new javax.swing.GroupLayout(pnlTanqueAzul1);
        pnlTanqueAzul1.setLayout(pnlTanqueAzul1Layout);
        pnlTanqueAzul1Layout.setHorizontalGroup(
            pnlTanqueAzul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );
        pnlTanqueAzul1Layout.setVerticalGroup(
            pnlTanqueAzul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        pnlSurtidorTanque1.setBackground(new java.awt.Color(255, 255, 255));

        lblCisterna1.setVisible(false);
        lblCisterna1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCisterna1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gasmonitor/resources/truck.png"))); // NOI18N

        javax.swing.GroupLayout pnlSurtidorTanque1Layout = new javax.swing.GroupLayout(pnlSurtidorTanque1);
        pnlSurtidorTanque1.setLayout(pnlSurtidorTanque1Layout);
        pnlSurtidorTanque1Layout.setHorizontalGroup(
            pnlSurtidorTanque1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnlSurtidorTanque1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlSurtidorTanque1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblCisterna1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlSurtidorTanque1Layout.setVerticalGroup(
            pnlSurtidorTanque1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 74, Short.MAX_VALUE)
            .addGroup(pnlSurtidorTanque1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlSurtidorTanque1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblCisterna1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout pnlTanque1Layout = new javax.swing.GroupLayout(pnlTanque1);
        pnlTanque1.setLayout(pnlTanque1Layout);
        pnlTanque1Layout.setHorizontalGroup(
            pnlTanque1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTanque1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTanque1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTanqueAzul1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSurtidorTanque1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTanque1Layout.setVerticalGroup(
            pnlTanque1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTanque1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(pnlSurtidorTanque1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTanqueAzul1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlTanqueAzul2.setBackground(new java.awt.Color(0, 51, 255));
        pnlTanqueAzul2.setPreferredSize(new java.awt.Dimension(244, 32));

        javax.swing.GroupLayout pnlTanqueAzul2Layout = new javax.swing.GroupLayout(pnlTanqueAzul2);
        pnlTanqueAzul2.setLayout(pnlTanqueAzul2Layout);
        pnlTanqueAzul2Layout.setHorizontalGroup(
            pnlTanqueAzul2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );
        pnlTanqueAzul2Layout.setVerticalGroup(
            pnlTanqueAzul2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        pnlSurtidorTanque2.setBackground(new java.awt.Color(255, 255, 255));

        lblCisterna2.setVisible(false);
        lblCisterna2.setBackground(new java.awt.Color(255, 255, 255));
        lblCisterna2.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        lblCisterna2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCisterna2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gasmonitor/resources/truck.png"))); // NOI18N

        javax.swing.GroupLayout pnlSurtidorTanque2Layout = new javax.swing.GroupLayout(pnlSurtidorTanque2);
        pnlSurtidorTanque2.setLayout(pnlSurtidorTanque2Layout);
        pnlSurtidorTanque2Layout.setHorizontalGroup(
            pnlSurtidorTanque2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
            .addGroup(pnlSurtidorTanque2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlSurtidorTanque2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblCisterna2, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlSurtidorTanque2Layout.setVerticalGroup(
            pnlSurtidorTanque2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
            .addGroup(pnlSurtidorTanque2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlSurtidorTanque2Layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(lblCisterna2, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addGap(2, 2, 2)))
        );

        javax.swing.GroupLayout pnlTanque2Layout = new javax.swing.GroupLayout(pnlTanque2);
        pnlTanque2.setLayout(pnlTanque2Layout);
        pnlTanque2Layout.setHorizontalGroup(
            pnlTanque2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTanque2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTanqueAzul2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlTanque2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlTanque2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlSurtidorTanque2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlTanque2Layout.setVerticalGroup(
            pnlTanque2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTanque2Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(pnlTanqueAzul2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlTanque2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlTanque2Layout.createSequentialGroup()
                    .addComponent(pnlSurtidorTanque2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 49, Short.MAX_VALUE)))
        );

        btnStart.setText("Iniciar");
        btnStart.setFocusPainted(false);
        btnStart.setFocusable(false);
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        lblRestantes.setText("Restantes: ");

        javax.swing.GroupLayout pnlLeftLayout = new javax.swing.GroupLayout(pnlLeft);
        pnlLeft.setLayout(pnlLeftLayout);
        pnlLeftLayout.setHorizontalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRestantes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRestantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlCola.setLayout(new javax.swing.BoxLayout(pnlCola, javax.swing.BoxLayout.Y_AXIS));

        lblEnCola1.setVisible(false);
        lblEnCola1.setAlignmentX(0.5F);
        pnlCola.add(lblEnCola1);

        lblEnCola2.setVisible(false);
        lblEnCola2.setAlignmentX(0.5F);
        pnlCola.add(lblEnCola2);

        lblEnCola3.setAlignmentX(0.5F);
        pnlCola.add(lblEnCola3);

        lblEnCola4.setAlignmentX(0.5F);
        pnlCola.add(lblEnCola4);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
        jPanel1.add(lblEnColaCounter);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlCola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBorder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlGas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pnlGas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(234, 234, 234)
                                .addComponent(btnStart)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlGas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlLeft, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(pnlTanque1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlTanque2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlGas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlGas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlGas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(pnlTanque2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlTanque1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(pnlCola, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        a.start();
    }//GEN-LAST:event_btnStartActionPerformed

    public JLabel getlBlEnColaCounter() {
        return lblEnColaCounter;
    }
    
    public ArrayList<JLabel> getlBlEnCola() {
        ArrayList<JLabel> enCola = new ArrayList<>();
        enCola.add(lblEnCola1);
        enCola.add(lblEnCola2);
        enCola.add(lblEnCola3);
        enCola.add(lblEnCola4);
        return enCola;
    }
    
    public ArrayList<JLabel> getLblBombasCapacidad() {
        ArrayList<JLabel> capacidadBombas = new ArrayList<>();
        capacidadBombas.add(lblBomba1Capacidad);
        capacidadBombas.add(lblBomba2Capacidad);
        capacidadBombas.add(lblBomba3Capacidad);
        return capacidadBombas;
    }
    
    public ArrayList<JLabel> getLblBomba() {
        ArrayList<JLabel> bombas = new ArrayList<>();
        bombas.add(lblBomba1);
        bombas.add(lblBomba2);
        bombas.add(lblBomba3);
        return bombas;
    }
    
    public ArrayList<JLabel> getlblCisterna() {
        ArrayList<JLabel> cisterna  = new ArrayList<>();
        cisterna.add(lblCisterna1);
        cisterna.add(lblCisterna2);
        return cisterna;
    }
    
    public ArrayList<JLabel> getLblSurtidores() {
        ArrayList<JLabel> surtidores  = new ArrayList<>();
        surtidores.add(lblSurtidor1);
        surtidores.add(lblSurtidor2);
        surtidores.add(lblSurtidor3);
        surtidores.add(lblSurtidor4);
        surtidores.add(lblSurtidor5);
        surtidores.add(lblSurtidor6);
        return surtidores;
    }
    
    public JLabel getLblRestantes() {
        return lblRestantes;
    }
    
    public ArrayList<JLabel> getLblSurtidoresCount() {
        ArrayList<JLabel> surtidoresCount  = new ArrayList<>();
        surtidoresCount.add(lblS1Contador);
        surtidoresCount.add(lblS2Contador);
        surtidoresCount.add(lblS3Contador);
        surtidoresCount.add(lblS4Contador);
        surtidoresCount.add(lblS5Contador);
        surtidoresCount.add(lblS6Contador);
        return surtidoresCount;
    }
    
    public ArrayList<JPanel> getPnlSurtidores() {
        ArrayList<JPanel> surtidores = new ArrayList<>();
        surtidores.add(pnlSurtidor1);
        surtidores.add(pnlSurtidor2);
        surtidores.add(pnlSurtidor3);
        surtidores.add(pnlSurtidor4);
        surtidores.add(pnlSurtidor5);
        surtidores.add(pnlSurtidor6);
        return surtidores;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBomba1;
    private javax.swing.JLabel lblBomba1Capacidad;
    private javax.swing.JLabel lblBomba2;
    private javax.swing.JLabel lblBomba2Capacidad;
    private javax.swing.JLabel lblBomba3;
    private javax.swing.JLabel lblBomba3Capacidad;
    private javax.swing.JLabel lblCisterna1;
    private javax.swing.JLabel lblCisterna2;
    private javax.swing.JLabel lblEnCola1;
    private javax.swing.JLabel lblEnCola2;
    private javax.swing.JLabel lblEnCola3;
    private javax.swing.JLabel lblEnCola4;
    private javax.swing.JLabel lblEnColaCounter;
    private javax.swing.JLabel lblRestantes;
    private javax.swing.JLabel lblS1Contador;
    private javax.swing.JLabel lblS2Contador;
    private javax.swing.JLabel lblS3Contador;
    private javax.swing.JLabel lblS4Contador;
    private javax.swing.JLabel lblS5Contador;
    private javax.swing.JLabel lblS6Contador;
    private javax.swing.JLabel lblSurtidor1;
    private javax.swing.JLabel lblSurtidor2;
    private javax.swing.JLabel lblSurtidor3;
    private javax.swing.JLabel lblSurtidor4;
    private javax.swing.JLabel lblSurtidor5;
    private javax.swing.JLabel lblSurtidor6;
    private javax.swing.JPanel pnlBomba1;
    private javax.swing.JPanel pnlBomba2;
    private javax.swing.JPanel pnlBomba3;
    private javax.swing.JPanel pnlBorder;
    private javax.swing.JPanel pnlCola;
    private javax.swing.JPanel pnlGas1;
    private javax.swing.JPanel pnlGas2;
    private javax.swing.JPanel pnlGas3;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlSurtidor1;
    private javax.swing.JPanel pnlSurtidor2;
    private javax.swing.JPanel pnlSurtidor3;
    private javax.swing.JPanel pnlSurtidor4;
    private javax.swing.JPanel pnlSurtidor5;
    private javax.swing.JPanel pnlSurtidor6;
    private javax.swing.JPanel pnlSurtidorTanque1;
    private javax.swing.JPanel pnlSurtidorTanque2;
    private javax.swing.JPanel pnlTanque1;
    private javax.swing.JPanel pnlTanque2;
    private javax.swing.JPanel pnlTanqueAzul1;
    private javax.swing.JPanel pnlTanqueAzul2;
    // End of variables declaration//GEN-END:variables
}
