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
import models.Maintenance;

public class MaintenanceController implements IIncrementedController<Maintenance> {

    private ResultSet result;

    @Override
    public ArrayList<Maintenance> index(String criteria) {
        ArrayList maintenances = new ArrayList<Maintenance>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM maintenance WHERE deleted_at IS NULL";

            criteria = criteria + "";

            if (!criteria.equals("null")) {
                query += criteria;
            }

            System.out.println(query);

            result = stmt.executeQuery(query);

            while (result.next()) {
                Maintenance resultMaintenance = new Maintenance();
                resultMaintenance.setIdmaintenance(result.getInt("idmaintenance"));
                resultMaintenance.setMaintenance_type(result.getString("maintenance_type"));
                resultMaintenance.setChanged_parts(result.getString("changed_parts"));
                resultMaintenance.setService_value(result.getInt("service_value"));
                resultMaintenance.setIsexternal(result.getBoolean("Isexternal"));

                maintenances.add(resultMaintenance);

            }
        } catch (SQLException e) {
            Logger.getLogger(MaintenanceController.class.getName()).log(Level.WARNING, null, e);
        }

        return maintenances;
    }

    @Override
    public ArrayList<Maintenance> indexLazy(String criteria, int skip, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Maintenance> indexDeleted() {
        ArrayList maintenances = new ArrayList<Maintenance>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM maintenance WHERE deleted_at IS NOT NULL";

            System.out.println(query);

            result = stmt.executeQuery(query);

            while (result.next()) {
                Maintenance resultMaintenance = new Maintenance();
                resultMaintenance.setIdmaintenance(result.getInt("idmaintenance"));
                resultMaintenance.setMaintenance_type(result.getString("maintenance_type"));
                resultMaintenance.setChanged_parts(result.getString("changed_parts"));
                resultMaintenance.setService_value(result.getInt("service_value"));
                resultMaintenance.setIsexternal(result.getBoolean("isexternal"));

                maintenances.add(resultMaintenance);

            }
        } catch (SQLException e) {
            Logger.getLogger(MaintenanceController.class.getName()).log(Level.WARNING, null, e);
        }

        return maintenances;
    }

    @Override
    public Maintenance show(int id) {
        Maintenance maintenance = null;
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM maintenance WHERE deleted_at IS NULL AND idmaintenance = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                maintenance = new Maintenance();
                maintenance.setIdmaintenance(result.getInt("idmaintenance"));
                maintenance.setMaintenance_type(result.getString("maintenance_type"));
                maintenance.setChanged_parts(result.getString("changed_parts"));
                maintenance.setService_value(result.getInt("service_value"));
                maintenance.setIsexternal(result.getBoolean("isexternal"));
            }

        } catch (SQLException e) {
            Logger.getLogger(MaintenanceController.class.getName()).log(Level.WARNING, null, e);
        }

        return maintenance;
    }

    @Override
    public boolean create(Maintenance maintenance) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " INSERT INTO maintenance "
                    + " (idmaintenance, maintenance_type, changed_parts, service_value, isexternal, "
                    + " employees_idemployees, service_order_idservice_order"
                    + " service_order_employees_employees_idemployees, vehicle_idvehicle) VALUES("
                    + "DEFAULT,"
                    + "\'" + maintenance.getMaintenance_type() + "\',"
                    + "\'" + maintenance.getChanged_parts() + "\',"
                    + "\'" + maintenance.getService_value() + "\',"
                    + "\'" + maintenance.isIsexternal() + "\',"
                    + "\'" + maintenance.getEmployees_idemployees() + "\',"
                    + "\'" + maintenance.getService_order_idservice_order() + "\',"
                    + "\'" + maintenance.getService_order_employees_employees_idemployees() + "\',"
                    + "\'" + maintenance.getVehicle_idvehicle() + "\'"
                    + ")";

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(MaintenanceController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean update(Maintenance maintenance, int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE maintenance SET "
                    + "maintenance_type = \'" + maintenance.getMaintenance_type() + "\',"
                    + "changed_parts = \'" + maintenance.getChanged_parts() + "\',"
                    + "service_value = \'" + maintenance.getService_value() + "\',"
                    + "isexternal = \'" + maintenance.isIsexternal() + "\',"
                    + "employees_idemployees = \'" + maintenance.getEmployees_idemployees() + "\',"
                    + "service_order_idservice_order = \'" + maintenance.getService_order_idservice_order() + "\',"
                    + "service_order_employees_employees_idemployees = \'" + maintenance.getService_order_employees_employees_idemployees() + "\',"
                    + "vehicle_idvehicle = \'" + maintenance.getVehicle_idvehicle() + "\',"
                    + "updated_at = \'" + new Timestamp(new Date().getTime()) + "\'"
                    + " WHERE idmaintenance = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(MaintenanceController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE maintenance SET "
                    + " deleted_at = \'" + new Timestamp(new Date().getTime()) + "\' "
                    + " WHERE idmaintenance = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(MaintenanceController.class.getName()).log(Level.WARNING, null, e);
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

            String query = " DELETE FROM maintenance WHERE idmaintenance = " + id;

            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MaintenanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean undoSoftDelete(int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE maintenance SET "
                    + " deleted_at = NULL "
                    + " WHERE idmaintenance = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(MaintenanceController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public void populateTable(JTable table, String criteria) {
        int size = 5;

        // dados da tabela
        Object[][] dataTable = null;

        // cabecalho da tabela
        Object[] header = new Object[size];
        header[0] = "Código";
        header[1] = "Tipo";
        header[2] = "Partes trocadas";
        header[3] = "Valor";
        header[4] = "Externa?";

        // cria matriz de acordo com nº de registros da tabela
        ArrayList<Maintenance> responseData = this.index(criteria);

        dataTable = new Object[responseData.size()][size];
        System.out.println(responseData.size());

        for (int line = 0; line < responseData.size(); line++) {
            dataTable[line][0] = responseData.get(line).getIdmaintenance();
            dataTable[line][1] = responseData.get(line).getMaintenance_type();
            dataTable[line][2] = responseData.get(line).getChanged_parts();
            dataTable[line][3] = responseData.get(line).getService_value();
            dataTable[line][4] = responseData.get(line).isIsexternal();
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