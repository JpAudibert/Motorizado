/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author lucas
 */
public class MaintenanceCRUDView extends javax.swing.JFrame {

    /**
     * Creates new form MaintenanceCRUDView
     */
    public MaintenanceCRUDView() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTXTTipoManutençao = new javax.swing.JTextField();
        jTXTFuncionario = new javax.swing.JTextField();
        jTXTVeiculo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTXTPecas = new javax.swing.JTextPane();
        jTXTValor = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTXTFuncionarioConsultar = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTXTVeiculoConsutar = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jCheckBox3 = new javax.swing.JCheckBox();
        jTXTValorConsultar = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jTXTTipoManutençaoEditar = new javax.swing.JTextField();
        jTXTFuncionarioEditar = new javax.swing.JTextField();
        jTXTVeiculoEditar = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTXTPecasEditar = new javax.swing.JTextPane();
        jTXTValorEditar = new javax.swing.JFormattedTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tipo de manutenção:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(47, 33, 168, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Valor:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(558, 33, 46, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Peças trocadas:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(47, 94, 122, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Funcionario responsavel:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(47, 265, 207, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Veiculo:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(47, 311, 62, 22);

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox1.setText("Funcionario tercerizado");
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(47, 216, 207, 31);
        jPanel1.add(jTXTTipoManutençao);
        jTXTTipoManutençao.setBounds(253, 33, 213, 28);
        jPanel1.add(jTXTFuncionario);
        jTXTFuncionario.setBounds(258, 265, 35, 28);
        jPanel1.add(jTXTVeiculo);
        jTXTVeiculo.setBounds(260, 311, 33, 28);

        jButton1.setText("Buscar");
        jPanel1.add(jButton1);
        jButton1.setBounds(342, 265, 96, 28);

        jButton2.setText("Buscar");
        jPanel1.add(jButton2);
        jButton2.setBounds(342, 311, 96, 28);

        jScrollPane1.setViewportView(jTXTPecas);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(253, 94, 213, 90);
        jPanel1.add(jTXTValor);
        jTXTValor.setBounds(614, 33, 128, 28);

        jButton3.setText("Registrar");
        jPanel1.add(jButton3);
        jButton3.setBounds(680, 300, 92, 28);

        jButton4.setText("Cancelar");
        jPanel1.add(jButton4);
        jButton4.setBounds(560, 300, 75, 28);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Maintenance.png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(550, 50, 260, 240);

        jTabbedPane1.addTab("Registrar", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Funcionario responsavel:");

        jButton9.setText("Buscar");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Veiculo:");

        jButton10.setText("Buscar");

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox3.setText("Funcionario tercerizado");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Valor:");

        jButton11.setText("Editar");

        jButton12.setText("Remover");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jTXTFuncionarioConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(151, 151, 151)
                        .addComponent(jTXTVeiculoConsutar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(10, 10, 10)
                        .addComponent(jTXTValorConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
            .addComponent(jScrollPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTXTFuncionarioConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox3)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTXTVeiculoConsutar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTXTValorConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultar/Remover", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Tipo de manutenção:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(47, 33, 168, 22);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Valor:");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(558, 33, 46, 22);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Peças trocadas:");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(47, 94, 122, 22);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Funcionario responsavel:");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(47, 265, 207, 22);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Veiculo:");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(47, 311, 62, 22);

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox2.setText("Funcionario tercerizado");
        jPanel3.add(jCheckBox2);
        jCheckBox2.setBounds(47, 216, 207, 31);
        jPanel3.add(jTXTTipoManutençaoEditar);
        jTXTTipoManutençaoEditar.setBounds(253, 33, 213, 28);
        jPanel3.add(jTXTFuncionarioEditar);
        jTXTFuncionarioEditar.setBounds(258, 265, 35, 28);
        jPanel3.add(jTXTVeiculoEditar);
        jTXTVeiculoEditar.setBounds(260, 310, 33, 28);

        jButton5.setText("Buscar");
        jPanel3.add(jButton5);
        jButton5.setBounds(342, 265, 96, 28);

        jButton6.setText("Buscar");
        jPanel3.add(jButton6);
        jButton6.setBounds(342, 311, 96, 28);

        jScrollPane2.setViewportView(jTXTPecasEditar);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(253, 94, 213, 90);
        jPanel3.add(jTXTValorEditar);
        jTXTValorEditar.setBounds(614, 33, 128, 28);

        jButton7.setText("Registrar");
        jPanel3.add(jButton7);
        jButton7.setBounds(679, 288, 92, 28);

        jButton8.setText("Cancelar");
        jPanel3.add(jButton8);
        jButton8.setBounds(558, 288, 75, 28);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Maintenance.png"))); // NOI18N
        jPanel3.add(jLabel12);
        jLabel12.setBounds(550, 50, 260, 240);

        jTabbedPane1.addTab("Editar", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MaintenanceCRUDView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaintenanceCRUDView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaintenanceCRUDView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaintenanceCRUDView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaintenanceCRUDView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTXTFuncionario;
    private javax.swing.JTextField jTXTFuncionarioConsultar;
    private javax.swing.JTextField jTXTFuncionarioEditar;
    private javax.swing.JTextPane jTXTPecas;
    private javax.swing.JTextPane jTXTPecasEditar;
    private javax.swing.JTextField jTXTTipoManutençao;
    private javax.swing.JTextField jTXTTipoManutençaoEditar;
    private javax.swing.JFormattedTextField jTXTValor;
    private javax.swing.JFormattedTextField jTXTValorConsultar;
    private javax.swing.JFormattedTextField jTXTValorEditar;
    private javax.swing.JTextField jTXTVeiculo;
    private javax.swing.JTextField jTXTVeiculoConsutar;
    private javax.swing.JTextField jTXTVeiculoEditar;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}