/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.VehicleController;
import helpers.ComboItem;
import helpers.CombosDAO;
import helpers.Formatacao;
import helpers.Validacao;
import javax.swing.JOptionPane;
import models.Vehicle;

/**
 *
 * @author lucas
 */
public class VehicleCRUDView extends javax.swing.JFrame {

    /**
     * Creates new form VeihcleCRUDView
     */
    int vehicleID;
    
    public VehicleCRUDView() {
        initComponents();
        Formatacao.formatarDataAno(jTXTAnoFab);
        Formatacao.formatarDataAno(jTXTAnoFabEditar);
        Formatacao.formatarDataAno(jTXTAnoFabProcurar);
        
        
        CombosDAO cdao = new CombosDAO();

        cdao.popularCombo("Category", jComboBoxCat);
        cdao.popularCombo("Vehicle_models", jComboBoxModel);
        cdao.popularCombo("category", jComboCategoriaEditar);
        cdao.popularCombo("category", jComboCategoriaPesquisar);
        cdao.popularCombo("vehicle_models", jComboModeloEditar);
        cdao.popularCombo("Vehicle_models", jComboModeloPesquisar);
        

        jComboBoxCombustivel.removeAllItems();

        ComboItem[] item = new ComboItem[5];
        item[0] = new ComboItem();
        item[0].setCodigo(0);
        item[0].setDescricao("Selecione");
        item[1] = new ComboItem();
        item[1].setCodigo(1);
        item[1].setDescricao("Gasolina");
        item[2] = new ComboItem();
        item[2].setCodigo(2);
        item[2].setDescricao("Diesel");
        item[3] = new ComboItem();
        item[3].setCodigo(3);
        item[3].setDescricao("Alcool");
        item[4] = new ComboItem();
        item[4].setCodigo(4);
        item[4].setDescricao("Flex");
        
        
        jComboBoxCombustivel.addItem(item[0].getDescricao());
        jComboBoxCombustivel.addItem(item[1].getDescricao());
        jComboBoxCombustivel.addItem(item[2].getDescricao());
        jComboBoxCombustivel.addItem(item[3].getDescricao());
        jComboBoxCombustivel.addItem(item[4].getDescricao());
        comboCombustivelEditar.addItem(item[0].getDescricao());
        comboCombustivelEditar.addItem(item[1].getDescricao());
        comboCombustivelEditar.addItem(item[2].getDescricao());
        comboCombustivelEditar.addItem(item[3].getDescricao());
        comboCombustivelEditar.addItem(item[4].getDescricao());
        

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTXTPlaca = new javax.swing.JTextField();
        jTXTChassi = new javax.swing.JTextField();
        jTXTPower = new javax.swing.JTextField();
        jComboBoxCat = new javax.swing.JComboBox<>();
        jComboBoxModel = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jTXTAnoFab = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jComboBoxCombustivel = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboCategoriaPesquisar = new javax.swing.JComboBox<>();
        jComboModeloPesquisar = new javax.swing.JComboBox<>();
        jTXTPlacaProcurar = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jTXTAnoFabProcurar = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jComboModeloEditar = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        Editar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        comboCombustivelEditar = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTXTPlacaEditar = new javax.swing.JTextField();
        jTXTChassiEditar = new javax.swing.JTextField();
        jTXTPowerEditar = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jComboCategoriaEditar = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jTXTAnoFabEditar = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Ano de Fabricação:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(63, 31, 150, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Placa:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(63, 78, 46, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Chassi:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(63, 120, 56, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Potência:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(63, 162, 72, 22);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Categoria:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(486, 31, 80, 22);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Modelo:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(486, 78, 63, 22);
        jPanel1.add(jTXTPlaca);
        jTXTPlaca.setBounds(251, 82, 112, 20);
        jPanel1.add(jTXTChassi);
        jTXTChassi.setBounds(251, 124, 112, 20);
        jPanel1.add(jTXTPower);
        jTXTPower.setBounds(251, 166, 112, 20);

        jComboBoxCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBoxCat);
        jComboBoxCat.setBounds(576, 35, 108, 20);

        jComboBoxModel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBoxModel);
        jComboBoxModel.setBounds(576, 82, 108, 20);

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(576, 165, 108, 23);

        jButton2.setText("Cacelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(576, 209, 108, 23);

        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\lucas\\Desktop\\PROJETO INTEGRADOR\\Motorizado\\src\\IMG\\Carro.png")); // NOI18N
        jPanel1.add(jLabel19);
        jLabel19.setBounds(250, 260, 420, 100);
        jPanel1.add(jTXTAnoFab);
        jTXTAnoFab.setBounds(250, 30, 109, 20);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Tipo de combustivel:");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(60, 210, 165, 22);

        jComboBoxCombustivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBoxCombustivel);
        jComboBoxCombustivel.setBounds(250, 210, 112, 20);

        jTabbedPane1.addTab("Cadastrar", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Ano de fabricação:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Placa:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Modelo:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Categoria:");

        jComboCategoriaPesquisar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboModeloPesquisar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Remover");

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
        jScrollPane1.setViewportView(jTable1);

        jButton5.setText("Pesquisar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTXTPlacaProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTXTAnoFabProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboCategoriaPesquisar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboModeloPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11)
                            .addComponent(jComboCategoriaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTXTAnoFabProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jComboModeloPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTXTPlacaProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Pesquisar /  Remover", jPanel2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jComboModeloEditar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Chassi:");

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Potência:");

        jButton6.setText("Cacelar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Tipo de combustivel:");

        comboCombustivelEditar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Categoria:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Modelo:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Ano de Fabricação:");

        jComboCategoriaEditar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Placa:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTXTPlacaEditar)
                    .addComponent(jTXTChassiEditar)
                    .addComponent(jTXTPowerEditar)
                    .addComponent(comboCombustivelEditar, 0, 112, Short.MAX_VALUE)
                    .addComponent(jTXTAnoFabEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboCategoriaEditar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboModeloEditar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                .addGap(62, 62, 62))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15)
                    .addComponent(jComboCategoriaEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTXTAnoFabEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel16)
                    .addComponent(jTXTPlacaEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboModeloEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTXTChassiEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTXTPowerEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Editar))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jButton6)
                    .addComponent(comboCombustivelEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Editar", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Vehicle vehicle = new Vehicle();
        
        
        
        if (Validacao.notNull(this.jTXTAnoFab.getText())){
            vehicle.setManufaturing_year(Integer.parseInt(this.jTXTAnoFab.getText()));
            if (Validacao.notNull(this.jTXTPlaca.getText())){
                vehicle.setTransit_board(this.jTXTPlaca.getText());
                if (Validacao.notNull(jTXTChassi.getText())){
                    vehicle.setChassis_id(jTXTChassi.getText());
                    if(Validacao.notNull(this.jTXTPower.getText())){
                        vehicle.setVehicle_power(this.jTXTPower.getText());
                        int selectedIndex = this.jComboBoxCombustivel.getSelectedIndex();
                        System.out.println(selectedIndex);
                        switch (selectedIndex) {
                            case 0:
                                vehicle.setFuel_type("Gasolina");
                            case 1:
                                vehicle.setFuel_type("Gasolina");
                                break;
                            case 2:
                                vehicle.setFuel_type("Diesel");
                                break;
                            case 3:
                                vehicle.setFuel_type("Alcool");
                                break;
                            case 4:
                                vehicle.setFuel_type("Flex");
                                break;
                            default:
                                break;
                        }
                        
                        
                        
                        int selectedIndex1 = jComboBoxCat.getSelectedIndex();
                        vehicle.setCategory_idcategory(selectedIndex1);
                        
                        int selectedIndex2 = jComboBoxModel.getSelectedIndex();
                        vehicle.setVehicle_models_idvehicle_models(selectedIndex2);
                        

                        
                        
                        VehicleController controller = new VehicleController();
                        controller.create(vehicle);
                   
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Entre com a potencia do veiculo!");
                        this.jTXTPower.requestFocus();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Entre com o chassi do veiculo!");
                    this.jTXTChassi.requestFocus();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Entre com a placa do veiculo!");
                this.jTXTPlaca.requestFocus();
            } 
        }
        else{
            JOptionPane.showMessageDialog(null, "Entre com o ano de fabricação do veiculo!");
            this.jTXTAnoFab.requestFocus();
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        // TODO add your handling code here:
        Vehicle vehicle = new Vehicle();
        
        
        
        if (Validacao.notNull(this.jTXTAnoFabEditar.getText())){
            vehicle.setManufaturing_year(Integer.parseInt(this.jTXTAnoFabEditar.getText()));
            if (Validacao.notNull(this.jTXTPlacaEditar.getText())){
                vehicle.setTransit_board(this.jTXTPlacaEditar.getText());
                if (Validacao.notNull(jTXTChassiEditar.getText())){
                    vehicle.setChassis_id(jTXTChassiEditar.getText());
                    if(Validacao.notNull(this.jTXTPowerEditar.getText())){
                        vehicle.setVehicle_power(this.jTXTPowerEditar.getText());
                        int selectedIndex = this.comboCombustivelEditar.getSelectedIndex();
                        System.out.println(selectedIndex);
                        switch (selectedIndex) {
                            case 0:
                                vehicle.setFuel_type("Gasolina");
                            case 1:
                                vehicle.setFuel_type("Gasolina");
                                break;
                            case 2:
                                vehicle.setFuel_type("Diesel");
                                break;
                            case 3:
                                vehicle.setFuel_type("Alcool");
                                break;
                            case 4:
                                vehicle.setFuel_type("Flex");
                                break;
                            default:
                                break;
                        }
                        
                        
                        
                        int selectedIndex1 = this.jComboCategoriaEditar.getSelectedIndex();
                        vehicle.setCategory_idcategory(selectedIndex1);
                        
                        int selectedIndex2 = this.jComboModeloEditar.getSelectedIndex();
                        vehicle.setVehicle_models_idvehicle_models(selectedIndex2);
                        

                        
                        
                        VehicleController controller = new VehicleController();
                        controller.update(vehicle, this.vehicleID);
                   
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Entre com a potencia do veiculo!");
                        this.jTXTPower.requestFocus();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Entre com o chassi do veiculo!");
                    this.jTXTChassi.requestFocus();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Entre com a placa do veiculo!");
                this.jTXTPlaca.requestFocus();
            } 
        }
        else{
            JOptionPane.showMessageDialog(null, "Entre com o ano de fabricação do veiculo!");
            this.jTXTAnoFab.requestFocus();
        }
        
    }//GEN-LAST:event_EditarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String criteria = "";

        if (Validacao.notNull(this.jTXTAnoFabProcurar.getText())) {
            criteria += " AND manufaturing_year LIKE \'%" + this.jTXTAnoFabProcurar.getText() + "%\'";
        }

        if (Validacao.notNull(this.jTXTPlacaProcurar.getText())) {
            criteria += " AND transit_board LIKE \'%" + this.jTXTPlacaProcurar.getText() + "%\'";
        }

        if (Validacao.notNull(this.jComboCategoriaPesquisar.getSelectedIndex()+"")) {
            criteria += " AND category_idcategory LIKE \'%" + this.jComboCategoriaPesquisar.getSelectedIndex() + "%\'";
        }

        if (Validacao.notNull(this.jComboModeloPesquisar.getSelectedIndex()+"")) {
            criteria += " AND vehicle_models_idvehicle_models LIKE \'%" + this.jComboModeloPesquisar.getSelectedIndex() + "%\'";
        }
        
        VehicleController controller = new VehicleController();
        controller.populateTable(jTable1, criteria);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.vehicleID = Integer.parseInt(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
        this.jTXTAnoFabEditar.setText(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 1)));
        this.jTXTPlacaEditar.setText(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 2)));
        this.jTXTChassiEditar.setText(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 3)));
        this.jTXTPowerEditar.setText(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 4)));
        String comb = (String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 5)));
        int CombustivelID = Integer.parseInt(comb);
        this.comboCombustivelEditar.setSelectedIndex(CombustivelID);
        this.jComboCategoriaEditar.setSelectedIndex(Integer.parseInt((String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 6)))));
        this.jComboModeloEditar.setSelectedIndex(Integer.parseInt((String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 7)))));
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VehicleCRUDView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VehicleCRUDView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VehicleCRUDView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VehicleCRUDView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VehicleCRUDView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Editar;
    private javax.swing.JComboBox<String> comboCombustivelEditar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBoxCat;
    private javax.swing.JComboBox<String> jComboBoxCombustivel;
    private javax.swing.JComboBox<String> jComboBoxModel;
    private javax.swing.JComboBox<String> jComboCategoriaEditar;
    private javax.swing.JComboBox<String> jComboCategoriaPesquisar;
    private javax.swing.JComboBox<String> jComboModeloEditar;
    private javax.swing.JComboBox<String> jComboModeloPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jTXTAnoFab;
    private javax.swing.JFormattedTextField jTXTAnoFabEditar;
    private javax.swing.JFormattedTextField jTXTAnoFabProcurar;
    private javax.swing.JTextField jTXTChassi;
    private javax.swing.JTextField jTXTChassiEditar;
    private javax.swing.JTextField jTXTPlaca;
    private javax.swing.JTextField jTXTPlacaEditar;
    private javax.swing.JTextField jTXTPlacaProcurar;
    private javax.swing.JTextField jTXTPower;
    private javax.swing.JTextField jTXTPowerEditar;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
