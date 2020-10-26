package controllers;

import helpers.DBConnection;
import helpers.Validacao;
import interfaces.IBasicController;
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
import models.VehicleModel;

public class VehicleModelController implements IBasicController<VehicleModel> {

    private ResultSet result;
    private ArrayList<String> helper;

    @Override
    public ArrayList<VehicleModel> index(String criteria) {
        ArrayList vehiclesModel = new ArrayList<VehicleModel>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT "
                    + "	vm.*, "
                    + "	br.name"
                    + " FROM"
                    + "	vehicle_models vm"
                    + "		INNER JOIN brand br ON br.idbrand = vm.brand_idbrand"
                    + " WHERE vm.deleted_at IS NULL AND br.deleted_at IS NULL";

            if (Validacao.notNull(criteria)) {
                query += criteria;
            }

            System.out.println(query);

            result = stmt.executeQuery(query);

            while (result.next()) {
                VehicleModel resultVehicleModel = new VehicleModel();
                resultVehicleModel.setIdvehicle_models(result.getInt("idvehicle_models"));
                resultVehicleModel.setModel_name(result.getString("model_name"));
                resultVehicleModel.setCreated_at(result.getDate("created_at"));
                resultVehicleModel.setUpdated_at(result.getDate("updated_at"));
                resultVehicleModel.setDeleted_at(result.getDate("deleted_at"));
                resultVehicleModel.setBrand_idbrand(result.getInt("brand_idbrand"));

                vehiclesModel.add(resultVehicleModel);

                helper.add(result.getString("name"));
            }
        } catch (SQLException e) {
            Logger.getLogger(VehicleModelController.class.getName()).log(Level.WARNING, null, e);
        }

        return vehiclesModel;
    }

    @Override
    public ArrayList<VehicleModel> indexDeleted() {
        ArrayList vehiclesModel = new ArrayList<VehicleModel>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT "
                    + "	vm.*, "
                    + "	br.name"
                    + " FROM"
                    + "	vehicle_models vm"
                    + "		INNER JOIN brand br ON br.idbrand = vm.brand_idbrand"
                    + " WHERE vm.deleted_at IS NULL AND br.deleted_at IS NOT NULL";

            System.out.println(query);

            result = stmt.executeQuery(query);

            while (result.next()) {
                VehicleModel resultVehicleModel = new VehicleModel();
                resultVehicleModel.setIdvehicle_models(result.getInt("idvehicle_models"));
                resultVehicleModel.setModel_name(result.getString("model_name"));
                resultVehicleModel.setCreated_at(result.getDate("created_at"));
                resultVehicleModel.setUpdated_at(result.getDate("updated_at"));
                resultVehicleModel.setDeleted_at(result.getDate("deleted_at"));
                resultVehicleModel.setBrand_idbrand(result.getInt("brand_idbrand"));

                vehiclesModel.add(resultVehicleModel);

                helper.add(result.getString("name"));
            }
        } catch (SQLException e) {
            Logger.getLogger(VehicleModelController.class.getName()).log(Level.WARNING, null, e);
        }

        return vehiclesModel;
    }

    @Override
    public VehicleModel show(int id) {
        VehicleModel vehicleModel = null;
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM vehicle_models WHERE deleted_at IS NULL idvehicle_models = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                vehicleModel = new VehicleModel();
                vehicleModel.setIdvehicle_models(result.getInt("idvehicle_models"));
                vehicleModel.setModel_name(result.getString("model_name"));
                vehicleModel.setCreated_at(result.getDate("created_at"));
                vehicleModel.setUpdated_at(result.getDate("updated_at"));
                vehicleModel.setDeleted_at(result.getDate("deleted_at"));
                vehicleModel.setBrand_idbrand(result.getInt("brand_idbrand"));
            }

        } catch (SQLException e) {
            Logger.getLogger(VehicleModelController.class.getName()).log(Level.WARNING, null, e);
        }

        return vehicleModel;
    }

    @Override
    public boolean create(VehicleModel vehicleModel) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String queryCategoryName = " SELECT model_name FROM vehicle_models WHERE model_name = '" + vehicleModel.getModel_name()+ "' AND deleted_at IS NULL";

            result = stmt.executeQuery(queryCategoryName);

            if (result.next()) {
                throw new Error("This model already exists.");
            }

            if (!Validacao.notNull(vehicleModel.getModel_name())) {
                throw new Error("Invalid Model Name.");
            }

            String query = " INSERT INTO vehicle_models VALUES("
                    + "DEFAULT,"
                    + "\'" + vehicleModel.getModel_name()+ "\',"
                    + "\'" + vehicleModel.getBrand_idbrand()+ "\'"
                    + ")";

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(VehicleModelController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean update(VehicleModel vehicleModel, int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String queryCategoryName = " SELECT model_name FROM vehicle_models WHERE model_name = '" + vehicleModel.getModel_name()+ "' AND deleted_at IS NULL";

            result = stmt.executeQuery(queryCategoryName);

            if (result.next()) {
                throw new Error("This model already in use.");
            }

            String query = " UPDATE vehicle_models SET "
                    + "model_name = \'" + vehicleModel.getModel_name()+ "\',"
                    + "updated_at = \'" + new Timestamp(new Date().getTime()) + "\'"
                    + " WHERE idvehicle_models = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(VehicleModelController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE vehicle_models SET "
                    + " deleted_at = \'" + new Timestamp(new Date().getTime()) + "\' "
                    + " WHERE idvehicle_models = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(VehicleModelController.class.getName()).log(Level.WARNING, null, e);
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

            String query = " DELETE FROM vehicle_models WHERE idvehicle_models = " + id;

            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VehicleModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean undoSoftDelete(int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE vehicle_models SET "
                    + " deleted_at = NULL "
                    + " WHERE idvehicle_models = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(VehicleModelController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public void populateTable(JTable table, String criteria) {
        int size = 3;
        criteria = " AND model_name ILIKE '%" + criteria + "%'";

        // dados da tabela
        Object[][] dataTable = null;

        // cabecalho da tabela
        Object[] header = new Object[size];
        header[0] = "Código";
        header[1] = "Nome do modelo";
        header[2] = "Marca";

        // cria matriz de acordo com nº de registros da tabela
        ArrayList<VehicleModel> responseData = this.index(criteria);

        dataTable = new Object[responseData.size()][size];
        System.out.println(responseData.size());

        for (int line = 0; line < responseData.size(); line++) {
            dataTable[line][0] = responseData.get(line).getIdvehicle_models();
            dataTable[line][1] = responseData.get(line).getModel_name();
            dataTable[line][2] = helper.get(line);
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

}
