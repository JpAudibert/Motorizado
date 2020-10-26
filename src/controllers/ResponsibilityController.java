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
import models.Responsibility;

public class ResponsibilityController implements IBasicController<Responsibility> {

    private ResultSet result;

    @Override
    public ArrayList<Responsibility> index(String criteria) {
        ArrayList responsibilities = new ArrayList<Responsibility>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM responsibility WHERE deleted_at IS NULL ";

            if (Validacao.notNull(criteria)) {
                query += criteria;
            }

            System.out.println(query);

            result = stmt.executeQuery(query);

            while (result.next()) {
                Responsibility resultResponsibility = new Responsibility();
                resultResponsibility.setIdresponsibility(result.getInt("idresponsibility"));
                resultResponsibility.setSector(result.getString("sector"));
                resultResponsibility.setCreated_at(result.getDate("created_at"));
                resultResponsibility.setUpdated_at(result.getDate("updated_at"));
                resultResponsibility.setDeleted_at(result.getDate("deleted_at"));

                responsibilities.add(resultResponsibility);
            }
        } catch (SQLException e) {
            Logger.getLogger(ResponsibilityController.class.getName()).log(Level.WARNING, null, e);
        }

        return responsibilities;
    }

    @Override
    public ArrayList<Responsibility> indexDeleted() {
        ArrayList responsibilities = new ArrayList<Responsibility>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM responsibility WHERE deleted_at IS NOT NULL ";

            System.out.println(query);

            result = stmt.executeQuery(query);

            while (result.next()) {
                Responsibility resultResponsibility = new Responsibility();
                resultResponsibility.setIdresponsibility(result.getInt("idresponsibility"));
                resultResponsibility.setSector(result.getString("sector"));
                resultResponsibility.setCreated_at(result.getDate("created_at"));
                resultResponsibility.setUpdated_at(result.getDate("updated_at"));
                resultResponsibility.setDeleted_at(result.getDate("deleted_at"));

                responsibilities.add(resultResponsibility);
            }
        } catch (SQLException e) {
            Logger.getLogger(ResponsibilityController.class.getName()).log(Level.WARNING, null, e);
        }

        return responsibilities;
    }

    @Override
    public Responsibility show(int id) {
        Responsibility responsibility = null;
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM responsibility WHERE deleted_at IS NULL idresponsibility = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                responsibility = new Responsibility();
                responsibility.setIdresponsibility(result.getInt("idresponsibility"));
                responsibility.setSector(result.getString("sector"));
                responsibility.setCreated_at(result.getDate("created_at"));
                responsibility.setUpdated_at(result.getDate("updated_at"));
                responsibility.setDeleted_at(result.getDate("deleted_at"));
            }

        } catch (SQLException e) {
            Logger.getLogger(ResponsibilityController.class.getName()).log(Level.WARNING, null, e);
        }

        return responsibility;
    }

    @Override
    public boolean create(Responsibility responsibility) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String querySectorName = " SELECT sector FROM responsibility WHERE sector = '" + responsibility.getSector()+ "' AND deleted_at IS NULL";

            result = stmt.executeQuery(querySectorName);

            if (result.next()) {
                throw new Error("This sector already exists.");
            }

            if (!Validacao.notNull(responsibility.getSector())) {
                throw new Error("Invalid Sector Name.");
            }

            String query = " INSERT INTO category VALUES("
                    + "DEFAULT,"
                    + "\'" + responsibility.getSector()+ "\'"
                    + ")";

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(ResponsibilityController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean update(Responsibility responsibility, int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String querySectorName = " SELECT sector FROM responsibility WHERE sector = '" + responsibility.getSector()+ "' AND deleted_at IS NULL";

            result = stmt.executeQuery(querySectorName);

            if (result.next()) {
                throw new Error("This sector already in use.");
            }

            String query = " UPDATE responsibility SET "
                    + "sector = \'" + responsibility.getSector()+ "\',"
                    + "updated_at = \'" + new Timestamp(new Date().getTime()) + "\'"
                    + " WHERE idresponsibility = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(ResponsibilityController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE responsibility SET "
                    + " deleted_at = \'" + new Timestamp(new Date().getTime()) + "\' "
                    + " WHERE idresponsibility = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(ResponsibilityController.class.getName()).log(Level.WARNING, null, e);
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

            String query = " DELETE FROM responsibility WHERE idresponsibility = " + id;

            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ResponsibilityController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean undoSoftDelete(int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE responsibility SET "
                    + " deleted_at = NULL "
                    + " WHERE idresponsibility = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(ResponsibilityController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public void populateTable(JTable table, String criteria) {
        int size = 2;
        criteria = " AND sector ILIKE '%" + criteria + "%'";

        // dados da tabela
        Object[][] dataTable = null;

        // cabecalho da tabela
        Object[] header = new Object[size];
        header[0] = "Código";
        header[1] = "Nome do Setor";

        // cria matriz de acordo com nº de registros da tabela
        ArrayList<Responsibility> responseData = this.index(criteria);

        dataTable = new Object[responseData.size()][size];
        System.out.println(responseData.size());

        for (int line = 0; line < responseData.size(); line++) {
            dataTable[line][0] = responseData.get(line).getIdresponsibility();
            dataTable[line][1] = responseData.get(line).getSector();
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
