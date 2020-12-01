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
import models.Brand;

public class BrandController implements IBasicController<Brand> {

    private ResultSet result;

    @Override
    public ArrayList<Brand> index(String criteria) {
        ArrayList brands = new ArrayList<Brand>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM brand WHERE deleted_at IS NULL ";

            criteria = criteria + "";

            if (!criteria.equals("null")) {
                query += criteria;
            }

            System.out.println(query);

            result = stmt.executeQuery(query);

            while (result.next()) {
                Brand resultBrand = new Brand();
                resultBrand.setIdBrand(result.getInt("idbrand"));
                resultBrand.setName(result.getString("name"));
                resultBrand.setCreated_at(result.getDate("created_at"));
                resultBrand.setUpdated_at(result.getDate("updated_at"));
                resultBrand.setDeleted_at(result.getDate("deleted_at"));

                brands.add(resultBrand);
            }
        } catch (SQLException e) {
            Logger.getLogger(BrandController.class.getName()).log(Level.WARNING, null, e);
        }

        return brands;
    }

    @Override
    public ArrayList<Brand> indexDeleted() {
        ArrayList brands = new ArrayList<Brand>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM brand WHERE deleted_at IS NOT NULL ";

            result = stmt.executeQuery(query);

            while (result.next()) {
                Brand resultBrand = new Brand();
                resultBrand.setIdBrand(result.getInt("idbrand"));
                resultBrand.setName(result.getString("name"));
                resultBrand.setCreated_at(result.getDate("created_at"));
                resultBrand.setUpdated_at(result.getDate("updated_at"));
                resultBrand.setDeleted_at(result.getDate("deleted_at"));

                brands.add(resultBrand);
            }
        } catch (SQLException e) {
            Logger.getLogger(BrandController.class.getName()).log(Level.WARNING, null, e);
        }

        return brands;
    }

    @Override
    public Brand show(int id) {
        Brand brand = null;
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM brand WHERE deleted_at IS NULL idbrand = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                brand = new Brand();
                brand.setIdBrand(result.getInt("idbrand"));
                brand.setName(result.getString("name"));
                brand.setCreated_at(result.getDate("created_at"));
                brand.setUpdated_at(result.getDate("updated_at"));
                brand.setDeleted_at(result.getDate("deleted_at"));
            }

        } catch (SQLException e) {
            Logger.getLogger(BrandController.class.getName()).log(Level.WARNING, null, e);
        }

        return brand;
    }

    @Override
    public boolean create(Brand brand) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String queryName = " SELECT name FROM brand WHERE name = '" + brand.getName() + "' AND deleted_at IS NULL";

            result = stmt.executeQuery(queryName);

            if (result.next()) {
                throw new Error("This brand already exists.");
            }

            if (!Validacao.notNull(brand.getName())) {
                throw new Error("Invalid Name.");
            }

            String query = " INSERT INTO brand (idbrand, name) VALUES("
                    + "DEFAULT,"
                    + "\'" + brand.getName() + "\'"
                    + ")";

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(BrandController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean update(Brand brand, int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String queryName = " SELECT name FROM brand WHERE name = '" + brand.getName() + "' AND deleted_at IS NULL";

            result = stmt.executeQuery(queryName);

            if (result.next()) {
                throw new Error("This brand is already in use.");
            }

            String query = " UPDATE brand SET "
                    + "name = \'" + brand.getName() + "\',"
                    + "updated_at = \'" + new Timestamp(new Date().getTime()) + "\'"
                    + " WHERE idbrand = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(BrandController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE brand SET "
                    + " deleted_at = \'" + new Timestamp(new Date().getTime()) + "\' "
                    + " WHERE idbrand = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(BrandController.class.getName()).log(Level.WARNING, null, e);
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

            String query = " DELETE FROM brand WHERE idbrand = " + id;

            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BrandController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean undoSoftDelete(int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE brand SET "
                    + " deleted_at = NULL "
                    + " WHERE idbrand = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(BrandController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public void populateTable(JTable table, String criteria) {
        int size = 2;

        // dados da tabela
        Object[][] dataTable = null;

        // cabecalho da tabela
        Object[] header = new Object[size];
        header[0] = "Código";
        header[1] = "Nome";

        // cria matriz de acordo com nº de registros da tabela
        ArrayList<Brand> responseData = this.index(criteria);

        dataTable = new Object[responseData.size()][size];
        System.out.println(responseData.size());

        for (int line = 0; line < responseData.size(); line++) {
            dataTable[line][0] = responseData.get(line).getIdBrand();
            dataTable[line][1] = responseData.get(line).getName();
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
