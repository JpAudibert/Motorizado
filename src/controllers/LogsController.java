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
import models.Logs;
import models.State;

public class LogsController implements IAutomaticallyInsertedController<Logs> {

    private ResultSet result;
    
    @Override
    public ArrayList<Logs> index(String criteria) {
        ArrayList logs = new ArrayList<State>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM logs ";

            if (Validacao.notNull(criteria)) {
                query += criteria;
            }

            System.out.println(query);

            result = stmt.executeQuery(query);

            while (result.next()) {
                Logs resultLogs = new Logs();
                resultLogs.setIdLogs(result.getInt("idlogs"));
                resultLogs.setLogType(result.getString("log_type"));
                resultLogs.setOrigin(result.getString("origin"));
                resultLogs.setDescription(result.getString("description"));
                resultLogs.setIdFromOrigin(result.getInt("id_from_origin"));

                logs.add(resultLogs);
            }
        } catch (SQLException e) {
            Logger.getLogger(StateController.class.getName()).log(Level.WARNING, null, e);
        }

        return logs;
    }

    @Override
    public Logs show(int id) {
        Logs logs = null;
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM logs WHERE idlogs = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                logs = new Logs();
                logs.setIdLogs(result.getInt("idlogs"));
                logs.setLogType(result.getString("log_type"));
                logs.setOrigin(result.getString("origin"));
                logs.setDescription(result.getString("description"));
                logs.setIdFromOrigin(result.getInt("id_from_origin"));
            }

        } catch (SQLException e) {
            Logger.getLogger(StateController.class.getName()).log(Level.WARNING, null, e);
        }

        return logs;
    }

    @Override
    public boolean create(Logs logs) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " INSERT INTO logs VALUES("
                    + "DEFAULT,"
                    + "\'" + logs.getLogType()+ "\',"
                    + "\'" + logs.getOrigin()+ "\',"
                    + "\'" + logs.getDescription()+ "\',"
                    + "\'" + logs.getIdFromOrigin()+ "\'"
                    + ")";

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(StateController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean update(Logs logs, int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE logs SET "
                    + "log_type = \'" + logs.getLogType()+ "\',"
                    + "origin = \'" + logs.getOrigin()+ "\',"
                    + "description = \'" + logs.getDescription()+ "\',"
                    + "id_from_origin = \'" + logs.getIdFromOrigin()+ "\'"
                    + " WHERE idlogsw = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(StateController.class.getName()).log(Level.WARNING, null, e);
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

            String query = " DELETE FROM logs WHERE idlogs = " + id;

            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
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
        header[1] = "Tipo do Log";
        header[2] = "Origem";
        header[3] = "Descrição";
        header[4] = "Id da origem";

        // cria matriz de acordo com nº de registros da tabela
        ArrayList<Logs> responseData = this.index(criteria);

        dataTable = new Object[responseData.size()][size];
        System.out.println(responseData.size());

        for (int line = 0; line < responseData.size(); line++) {
            dataTable[line][0] = responseData.get(line).getIdLogs();
            dataTable[line][1] = responseData.get(line).getLogType();
            dataTable[line][2] = responseData.get(line).getOrigin();
            dataTable[line][3] = responseData.get(line).getDescription();
            dataTable[line][4] = responseData.get(line).getIdFromOrigin();
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
