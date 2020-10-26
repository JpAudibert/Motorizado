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
import models.Category;

public class CategoryController implements IBasicController<Category> {

    private ResultSet result;

    @Override
    public ArrayList<Category> index(String criteria) {
        ArrayList categories = new ArrayList<Category>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM category WHERE deleted_at IS NULL ";

            if (Validacao.notNull(criteria)) {
                query += criteria;
            }

            System.out.println(query);

            result = stmt.executeQuery(query);

            while (result.next()) {
                Category resultCategory = new Category();
                resultCategory.setIdCategory(result.getInt("idcategory"));
                resultCategory.setCategory_name(result.getString("category_name"));
                resultCategory.setCreated_at(result.getDate("created_at"));
                resultCategory.setUpdated_at(result.getDate("updated_at"));
                resultCategory.setDeleted_at(result.getDate("deleted_at"));

                categories.add(resultCategory);
            }
        } catch (SQLException e) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.WARNING, null, e);
        }

        return categories;
    }

    @Override
    public ArrayList<Category> indexDeleted() {
        ArrayList categories = new ArrayList<Category>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM category WHERE deleted_at IS NOT NULL ";

            result = stmt.executeQuery(query);

            while (result.next()) {
                Category resultCategory = new Category();
                resultCategory.setIdCategory(result.getInt("idcategory"));
                resultCategory.setCategory_name(result.getString("category_name"));
                resultCategory.setCreated_at(result.getDate("created_at"));
                resultCategory.setUpdated_at(result.getDate("updated_at"));
                resultCategory.setDeleted_at(result.getDate("deleted_at"));

                categories.add(resultCategory);
            }
        } catch (SQLException e) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.WARNING, null, e);
        }

        return categories;
    }

    @Override
    public Category show(int id) {
        Category category = null;
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM category WHERE deleted_at IS NULL idcategory = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                category = new Category();
                category.setIdCategory(result.getInt("idcategory"));
                category.setCategory_name(result.getString("category_name"));
                category.setCreated_at(result.getDate("created_at"));
                category.setUpdated_at(result.getDate("updated_at"));
                category.setDeleted_at(result.getDate("deleted_at"));
            }

        } catch (SQLException e) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.WARNING, null, e);
        }

        return category;
    }

    @Override
    public boolean create(Category category) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String queryCategoryName = " SELECT category_name FROM category WHERE category_name = '" + category.getCategory_name() + "' AND deleted_at IS NULL";

            result = stmt.executeQuery(queryCategoryName);

            if (result.next()) {
                throw new Error("This category already exists.");
            }

            if (!Validacao.notNull(category.getCategory_name())) {
                throw new Error("Invalid Category Name.");
            }

            String query = " INSERT INTO category VALUES("
                    + "DEFAULT,"
                    + "\'" + category.getCategory_name() + "\'"
                    + ")";

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean update(Category category, int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String queryCategoryName = " SELECT category_name FROM category WHERE category_name = '" + category.getCategory_name() + "' AND deleted_at IS NULL";

            result = stmt.executeQuery(queryCategoryName);

            if (result.next()) {
                throw new Error("This category already in use.");
            }

            String query = " UPDATE category SET "
                    + "name = \'" + category.getCategory_name() + "\',"
                    + "updated_at = \'" + new Timestamp(new Date().getTime()) + "\'"
                    + " WHERE idcategory = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE category SET "
                    + " deleted_at = \'" + new Timestamp(new Date().getTime()) + "\' "
                    + " WHERE idcategory = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.WARNING, null, e);
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

            String query = " DELETE FROM category WHERE idcategory = " + id;

            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean undoSoftDelete(int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE category SET "
                    + " deleted_at = NULL "
                    + " WHERE idcategory = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public void populateTable(JTable table, String criteria) {
        int size = 2;
        criteria = " AND category_name ILIKE '%" + criteria + "%'";

        // dados da tabela
        Object[][] dataTable = null;

        // cabecalho da tabela
        Object[] header = new Object[size];
        header[0] = "Código";
        header[1] = "Nome da Categoria";

        // cria matriz de acordo com nº de registros da tabela
        ArrayList<Category> responseData = this.index(criteria);

        dataTable = new Object[responseData.size()][size];
        System.out.println(responseData.size());

        for (int line = 0; line < responseData.size(); line++) {
            dataTable[line][0] = responseData.get(line).getIdCategory();
            dataTable[line][1] = responseData.get(line).getCategory_name();
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
