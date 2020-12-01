package controllers;

import helpers.DBConnection;
import helpers.Validacao;
import interfaces.IAutomaticallyInsertedController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.City;

public class CityController implements IAutomaticallyInsertedController<City> {

    private ResultSet result;
    private ArrayList<String> helper;

    @Override
    public ArrayList<City> index(String criteria) {
        ArrayList cities = new ArrayList<City>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT "
                    + "	ct.idcity,"
                    + "	ct.name,"
                    + "	ct.state_idstate,"
                    + "	st.abreviation"
                    + "FROM city ct "
                    + "	INNER JOIN state st ON st.idstate = ct.state_idstate ";

            criteria = criteria + "";

            if (!criteria.equals("null")) {
                query += criteria;
            }

            System.out.println(query);

            result = stmt.executeQuery(query);

            while (result.next()) {
                City resultCity = new City();
                resultCity.setIdCity(result.getInt("idcity"));
                resultCity.setName(result.getString("name"));
                resultCity.setState_idState(result.getInt("state_idstate"));

                cities.add(resultCity);

                helper.add(result.getString("abreviation"));
            }
        } catch (SQLException e) {
            Logger.getLogger(CityController.class.getName()).log(Level.WARNING, null, e);
        }

        return cities;
    }

    @Override
    public City show(int id) {
        City city = null;
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM city WHERE idcity = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                city = new City();
                city.setIdCity(result.getInt("idcity"));
                city.setName(result.getString("name"));
                city.setState_idState(result.getInt("state_idstate"));
            }

        } catch (SQLException e) {
            Logger.getLogger(CityController.class.getName()).log(Level.WARNING, null, e);
        }

        return city;
    }

    @Override
    public boolean create(City city) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String queryName = " SELECT name FROM city WHERE name = '" + city.getName() + "'";

            result = stmt.executeQuery(queryName);

            if (result.next()) {
                throw new Error("This city already exists.");
            }

            if (!Validacao.notNull(city.getName())) {
                throw new Error("Invalid Name.");
            }

            String query = " INSERT INTO city (idcity, name, state_idstate) VALUES("
                    + "DEFAULT,"
                    + "\'" + city.getName() + "\'"
                    + "\'" + city.getState_idState() + "\'"
                    + ")";

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(CityController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean update(City city, int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String queryName = " SELECT name FROM city WHERE name = '" + city.getName() + "'";

            result = stmt.executeQuery(queryName);

            if (result.next()) {
                throw new Error("This city is already in use.");
            }

            String query = " UPDATE city SET "
                    + "name = \'" + city.getName() + "\'"
                    + " WHERE idcity = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(CityController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " DELETE FROM city WHERE idcity = " + id;

            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void populateTable(JTable table, String criteria) {
        int size = 3;

        // dados da tabela
        Object[][] dataTable = null;

        // cabecalho da tabela
        Object[] header = new Object[size];
        header[0] = "Código";
        header[1] = "Nome da cidade";
        header[2] = "Estado";

        // cria matriz de acordo com nº de registros da tabela
        ArrayList<City> responseData = this.index(criteria);

        dataTable = new Object[responseData.size()][size];
        System.out.println(responseData.size());

        for (int line = 0; line < responseData.size(); line++) {
            dataTable[line][0] = responseData.get(line).getIdCity();
            dataTable[line][1] = responseData.get(line).getName();
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
