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
import models.Vehicle;

public class VehicleController implements IIncrementedController<Vehicle> {

    private ResultSet result;
    private ArrayList<String> helperCategory;
    private ArrayList<String> helperModel;
    private ArrayList<String> helperBrand;

    @Override
    public ArrayList<Vehicle> index(String criteria) {
        ArrayList vehicles = new ArrayList<Vehicle>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT "
                    + "	ve.*,"
                    + "	ca.category_name,"
                    + "	vm.model_name,"
                    + "	br.name AS brand_name "
                    + " FROM "
                    + "	vehicle ve "
                    + "		INNER JOIN category ca ON ca.idcategory = ve.category_idcategory "
                    + "		INNER JOIN vehicle_models vm ON vm.idvehicle_models = ve.vehicle_models_idvehicle_models "
                    + "		INNER JOIN brand br ON br.idbrand = vm.brand_idbrand"
                    + " WHERE "
                    + "	ve.deleted_at IS NULL AND "
                    + "	ca.deleted_at IS NULL AND "
                    + "	vm.deleted_at IS NULL AND "
                    + "	br.deleted_at IS NULL";

            criteria = criteria + "";

            if (!criteria.equals("null")) {
                query += criteria;
            }

            System.out.println(query);

            result = stmt.executeQuery(query);

            while (result.next()) {
                Vehicle resultVehicle = new Vehicle();
                resultVehicle.setIdvehicle(result.getInt("idvehicle"));
                resultVehicle.setManufaturing_year(result.getInt("manufaturing_year"));
                resultVehicle.setTransit_board(result.getString("transit_board"));
                resultVehicle.setChassis_id(result.getString("chassis_id"));
                resultVehicle.setVehicle_power(result.getString("vehicle_power"));
                resultVehicle.setFuel_type(result.getString("fuel_type"));
                resultVehicle.setCreated_at(result.getDate("created_at"));
                resultVehicle.setUpdated_at(result.getDate("updated_at"));
                resultVehicle.setDeleted_at(result.getDate("deleted_at"));
                resultVehicle.setVehicle_models_idvehicle_models(result.getInt("vehicle_models_idvehicle_models"));
                resultVehicle.setCategory_idcategory(result.getInt("category_idcategory"));

                vehicles.add(resultVehicle);

                helperCategory.add(result.getString("category_name"));
                helperCategory.add(result.getString("model_name"));
                helperCategory.add(result.getString("brand_name"));
            }
        } catch (SQLException e) {
            Logger.getLogger(VehicleModelController.class.getName()).log(Level.WARNING, null, e);
        }

        return vehicles;
    }

    @Override
    public ArrayList<Vehicle> indexLazy(String criteria, int skip, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Vehicle> indexDeleted() {
        ArrayList vehicles = new ArrayList<Vehicle>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT "
                    + "	ve.*,"
                    + "	ca.category_name,"
                    + "	vm.model_name,"
                    + "	br.name AS brand_name "
                    + " FROM "
                    + "	vehicle ve "
                    + "		INNER JOIN category ca ON ca.idcategory = ve.category_idcategory "
                    + "		INNER JOIN vehicle_models vm ON vm.idvehicle_models = ve.vehicle_models_idvehicle_models "
                    + "		INNER JOIN brand br ON br.idbrand = vm.brand_idbrand"
                    + " WHERE "
                    + "	ve.deleted_at IS NOT NULL AND "
                    + "	ca.deleted_at IS NOT NULL AND "
                    + "	vm.deleted_at IS NOT NULL AND "
                    + "	br.deleted_at IS NOT NULL";

            System.out.println(query);

            result = stmt.executeQuery(query);

            while (result.next()) {
                Vehicle resultVehicle = new Vehicle();
                resultVehicle.setIdvehicle(result.getInt("idvehicle"));
                resultVehicle.setManufaturing_year(result.getInt("manufaturing_year"));
                resultVehicle.setTransit_board(result.getString("transit_board"));
                resultVehicle.setChassis_id(result.getString("chassis_id"));
                resultVehicle.setVehicle_power(result.getString("vehicle_power"));
                resultVehicle.setFuel_type(result.getString("fuel_type"));
                resultVehicle.setCreated_at(result.getDate("created_at"));
                resultVehicle.setUpdated_at(result.getDate("updated_at"));
                resultVehicle.setDeleted_at(result.getDate("deleted_at"));
                resultVehicle.setVehicle_models_idvehicle_models(result.getInt("vehicle_models_idvehicle_models"));
                resultVehicle.setCategory_idcategory(result.getInt("category_idcategory"));

                vehicles.add(resultVehicle);

                helperCategory.add(result.getString("category_name"));
                helperCategory.add(result.getString("model_name"));
                helperCategory.add(result.getString("brand_name"));
            }
        } catch (SQLException e) {
            Logger.getLogger(VehicleModelController.class.getName()).log(Level.WARNING, null, e);
        }

        return vehicles;
    }

    @Override
    public Vehicle show(int id) {
        Vehicle vehicle = null;
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM vehicle WHERE deleted_at IS NULL AND idvehicle = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                vehicle = new Vehicle();
                vehicle.setIdvehicle(result.getInt("idvehicle"));
                vehicle.setManufaturing_year(result.getInt("manufaturing_year"));
                vehicle.setTransit_board(result.getString("transit_board"));
                vehicle.setChassis_id(result.getString("chassis_id"));
                vehicle.setVehicle_power(result.getString("vehicle_power"));
                vehicle.setFuel_type(result.getString("fuel_type"));
                vehicle.setCreated_at(result.getDate("created_at"));
                vehicle.setUpdated_at(result.getDate("updated_at"));
                vehicle.setDeleted_at(result.getDate("deleted_at"));
                vehicle.setVehicle_models_idvehicle_models(result.getInt("vehicle_models_idvehicle_models"));
                vehicle.setCategory_idcategory(result.getInt("category_idcategory"));
            }

        } catch (SQLException e) {
            Logger.getLogger(VehicleModelController.class.getName()).log(Level.WARNING, null, e);
        }

        return vehicle;
    }

    @Override
    public boolean create(Vehicle vehicle) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String queryTransitBorad  = " SELECT transit_board FROM vehicle WHERE transit_board = '" + vehicle.getTransit_board()+ "' AND deleted_at IS NULL";

            result = stmt.executeQuery(queryTransitBorad);

            if (result.next()) {
                throw new Error("This vehicle already exists.");
            }

            if (!Validacao.notNull(vehicle.getTransit_board())) {
                throw new Error("Invalid Vehicle Name.");
            }

            String query = " INSERT INTO vehicle "
                    + " (idvehicle, manufaturing_year, transit_board, chassis_id, vehicle_power, fuel_type, vehicle_models_idvehicle_models, category_idcategory) "
                    + " VALUES("
                    + "DEFAULT,"
                    + "\'" + vehicle.getManufaturing_year()+ "\',"
                    + "\'" + vehicle.getTransit_board()+ "\',"
                    + "\'" + vehicle.getChassis_id()+ "\',"
                    + "\'" + vehicle.getVehicle_power()+ "\',"
                    + "\'" + vehicle.getFuel_type()+ "\',"
                    + "\'" + vehicle.getVehicle_models_idvehicle_models()+ "\',"
                    + "\'" + vehicle.getCategory_idcategory()+ "\'"
                    + ")";

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(VehicleModelController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean update(Vehicle vehicle, int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String queryTransitBorad  = " SELECT transit_board FROM vehicle WHERE transit_board = '" + vehicle.getTransit_board()+ "' AND deleted_at IS NULL";

            result = stmt.executeQuery(queryTransitBorad);

            if (result.next()) {
                throw new Error("This vehicle already in use.");
            }

            String query = " UPDATE vehicle SET "
                    + " manufacturing_year  = \'" + vehicle.getManufaturing_year()+ "\',"
                    + " transit_board  = \'" + vehicle.getTransit_board()+ "\',"
                    + " chassis_id  = \'" + vehicle.getChassis_id()+ "\',"
                    + " vehicle_power = \'" + vehicle.getVehicle_power()+ "\',"
                    + " fuel_type = \'" + vehicle.getFuel_type()+ "\',"
                    + " fuel_type = \'" + vehicle.getFuel_type()+ "\',"
                    + " vehicle_models_idvehicle_models = \'" + vehicle.getVehicle_models_idvehicle_models()+ "\',"
                    + " category_idcategory = \'" + vehicle.getCategory_idcategory()+ "\',"
                    + " updated_at = \'" + new Timestamp(new Date().getTime()) + "\'"
                    + " WHERE idvehicle = " + id;

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

            String query = " UPDATE vehicle SET "
                    + " deleted_at = \'" + new Timestamp(new Date().getTime()) + "\' "
                    + " WHERE idvehicle = " + id;

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

            String query = " DELETE FROM vehicle WHERE idvehicle = " + id;

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

            String query = " UPDATE vehicle SET "
                    + " deleted_at = NULL "
                    + " WHERE idvehicle = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(VehicleModelController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public void populateTable(JTable table, String criteria) {
        int size = 9;

        // dados da tabela
        Object[][] dataTable = null;

        // cabecalho da tabela
        Object[] header = new Object[size];
        header[0] = "Código";
        header[1] = "Ano de Fabricação";
        header[2] = "Placa de Trânsito";
        header[3] = "Número do Chassi";
        header[4] = "Potência";
        header[5] = "Combustível";
        header[6] = "Categoria";
        header[7] = "Modelo";
        header[8] = "Marca";

        // cria matriz de acordo com nº de registros da tabela
        ArrayList<Vehicle> responseData = this.index(criteria);

        dataTable = new Object[responseData.size()][size];
        System.out.println(responseData.size());

        for (int line = 0; line < responseData.size(); line++) {
            dataTable[line][0] = responseData.get(line).getIdvehicle();
            dataTable[line][1] = responseData.get(line).getManufaturing_year();
            dataTable[line][2] = responseData.get(line).getTransit_board();
            dataTable[line][3] = responseData.get(line).getChassis_id();
            dataTable[line][4] = responseData.get(line).getVehicle_power();
            dataTable[line][5] = responseData.get(line).getFuel_type();
            dataTable[line][6] = helperCategory.get(line);
            dataTable[line][7] = helperModel.get(line);
            dataTable[line][8] = helperBrand.get(line);
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
