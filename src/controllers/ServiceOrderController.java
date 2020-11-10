package controllers;

import helpers.DBConnection;
import helpers.Validacao;
import interfaces.IIncrementedController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.ServiceOrder;

public class ServiceOrderController implements IIncrementedController<ServiceOrder> {

    private ResultSet result;

    @Override
    public ArrayList<ServiceOrder> index(String criteria) {
        ArrayList servicesOrders = new ArrayList<ServiceOrder>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM service_order WHERE deleted_at IS NULL";

            if (Validacao.notNull(criteria)) {
                query += criteria;
            }

            System.out.println(query);

            result = stmt.executeQuery(query);

            while (result.next()) {
                ServiceOrder resultServiceOrder = new ServiceOrder();
                resultServiceOrder.setIdservice_order(result.getInt("idservice_order"));
                resultServiceOrder.setDescription(result.getString("description"));
                resultServiceOrder.setEmission_date(result.getDate("emission_date"));
                resultServiceOrder.setObject_document(result.getString("object_document"));
                resultServiceOrder.setUnitary_value(result.getDouble("unitary_value"));
                resultServiceOrder.setTotal_value(result.getDouble("total_value"));
                resultServiceOrder.setEquipment_purchased(result.getString("equipment_purchased"));

                servicesOrders.add(resultServiceOrder);

            }
        } catch (SQLException e) {
            Logger.getLogger(ServiceOrderController.class.getName()).log(Level.WARNING, null, e);
        }

        return servicesOrders;
    }

    @Override
    public ArrayList<ServiceOrder> indexLazy(String criteria, int skip, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ServiceOrder> indexDeleted() {
        ArrayList servicesOrders = new ArrayList<ServiceOrder>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM service_order WHERE deleted_at IS NOT NULL";

            System.out.println(query);

            result = stmt.executeQuery(query);

            while (result.next()) {
                ServiceOrder resultServiceOrder = new ServiceOrder();
                resultServiceOrder.setIdservice_order(result.getInt("idservice_order"));
                resultServiceOrder.setDescription(result.getString("description"));
                resultServiceOrder.setEmission_date(result.getDate("emission_date"));
                resultServiceOrder.setObject_document(result.getString("object_document"));
                resultServiceOrder.setUnitary_value(result.getDouble("unitary_value"));
                resultServiceOrder.setTotal_value(result.getDouble("total_value"));
                resultServiceOrder.setEquipment_purchased(result.getString("equipment_purchased"));

                servicesOrders.add(resultServiceOrder);

            }
        } catch (SQLException e) {
            Logger.getLogger(ServiceOrderController.class.getName()).log(Level.WARNING, null, e);
        }

        return servicesOrders;
    }

    @Override
    public ServiceOrder show(int id) {
        ServiceOrder serviceOrder = null;
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM service_order WHERE deleted_at IS NULL AND idservice_order = " + id;

            System.out.println(query);

            result = stmt.executeQuery(query);

            if (result.next()) {
                serviceOrder = new ServiceOrder();
                serviceOrder.setIdservice_order(result.getInt("idservice_order"));
                serviceOrder.setDescription(result.getString("description"));
                serviceOrder.setEmission_date(result.getDate("emission_date"));
                serviceOrder.setObject_document(result.getString("object_document"));
                serviceOrder.setUnitary_value(result.getDouble("unitary_value"));
                serviceOrder.setTotal_value(result.getDouble("total_value"));
                serviceOrder.setEquipment_purchased(result.getString("equipment_purchased"));

            }
        } catch (SQLException e) {
            Logger.getLogger(ServiceOrderController.class.getName()).log(Level.WARNING, null, e);
        }

        return serviceOrder;
    }

    @Override
    public boolean create(ServiceOrder serviceOrder) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " INSERT INTO service_order "
                    + " (idservice_order, description, emission_date, object_document, unitary_value, "
                    + " total_value, equipment_purchased, employees_idemployees, contract_idcontract) VALUES("
                    + "DEFAULT,"
                    + "\'" + serviceOrder.getDescription() + "\',"
                    + "\'" + serviceOrder.getEmission_date() + "\',"
                    + "\'" + serviceOrder.getObject_document() + "\',"
                    + "\'" + serviceOrder.getUnitary_value() + "\',"
                    + "\'" + serviceOrder.getTotal_value() + "\',"
                    + "\'" + serviceOrder.getEquipment_purchased() + "\',"
                    + "\'" + serviceOrder.getEmployees_idemployees() + "\',"
                    + "\'" + serviceOrder.getContract_idcontract() + "\'"
                    + ")";

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(ServiceOrderController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean update(ServiceOrder serviceOrder, int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE serviceOrder SET "
                    + "description = \'" + serviceOrder.getDescription() + "\',"
                    + "emission_date = \'" + serviceOrder.getEmission_date() + "\',"
                    + "object_document = \'" + serviceOrder.getObject_document() + "\',"
                    + "unitary_value = \'" + serviceOrder.getUnitary_value() + "\',"
                    + "total_value = \'" + serviceOrder.getTotal_value() + "\',"
                    + "equipment_purchased = \'" + serviceOrder.getEquipment_purchased() + "\',"
                    + "employees_idemployees = \'" + serviceOrder.getEmployees_idemployees() + "\',"
                    + "contract_idcontract = \'" + serviceOrder.getContract_idcontract() + "\',"
                    + "updated_at = \'" + new Timestamp(new Date().getTime()) + "\'"
                    + " WHERE idservice_order = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(ServiceOrderController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE service_order SET "
                    + " deleted_at = \'" + new Timestamp(new Date().getTime()) + "\' "
                    + " WHERE idservice_order = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(ServiceOrderController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean hardDelete(int id) {
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " DELETE FROM service_order WHERE idservice_order = " + id;

            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean undoSoftDelete(int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE service_order SET "
                    + " deleted_at = NULL "
                    + " WHERE idservice_order = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(ServiceOrderController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public void populateTable(JTable table, String criteria) {
        int size = 7;

        // dados da tabela
        Object[][] dataTable = null;

        // cabecalho da tabela
        Object[] header = new Object[size];
        header[0] = "Código";
        header[1] = "Descrição";
        header[2] = "Data de Emissão";
        header[3] = "Documento";
        header[4] = "Valor Unitário";
        header[5] = "Valor Total";
        header[6] = "Equipamento Comprado";

        // cria matriz de acordo com nº de registros da tabela
        ArrayList<ServiceOrder> responseData = this.index(criteria);

        dataTable = new Object[responseData.size()][size];
        System.out.println(responseData.size());

        for (int line = 0; line < responseData.size(); line++) {
            dataTable[line][0] = responseData.get(line).getIdservice_order();
            dataTable[line][1] = responseData.get(line).getDescription();
            dataTable[line][2] = responseData.get(line).getEmission_date();
            dataTable[line][3] = responseData.get(line).getObject_document();
            dataTable[line][4] = responseData.get(line).getUnitary_value();
            dataTable[line][5] = responseData.get(line).getTotal_value();
            dataTable[line][6] = responseData.get(line).getEquipment_purchased();
        }

        // configuracoes adicionais no componente tabela
        table.setModel(new DefaultTableModel(dataTable, header) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
                /*  
                 if (column == 3) {  // apenas a coluna 3 sera editavel
                 return true;
                 } else {
                 return false;
                 }
                 */
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
//                    return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        table.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
//                case 2:
//                    column.setPreferredWidth(14);
//                    break;
            }
        }
        // renderizacao das linhas da tabela = mudar a cor
//        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                    boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected,
//                        hasFocus, row, column);
//                if (row % 2 == 0) {
//                    table.setBackground(Color.WHITE);
//                    table.setForeground(Color.DARK_GRAY);
//                } else {
//                    table.setBackground(Color.LIGHT_GRAY);
//                    table.setForeground(Color.BLACK);
//                }
//                return this;
//            }
//        });
    }

    @Override
    public void populateTableLazy(JTable table, String criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}