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
import models.State;

public class StateController implements IAutomaticallyInsertedController<State> {

    private ResultSet result;

    @Override
    public ArrayList<State> index(String criteria) {
        ArrayList states = new ArrayList<State>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM state ";

            if (Validacao.notNull(criteria)) {
                query += criteria;
            }

            System.out.println(query);

            result = stmt.executeQuery(query);

            while (result.next()) {
                State resultState = new State();
                resultState.setIdState(result.getInt("idstate"));
                resultState.setName(result.getString("name"));
                resultState.setAbreviation(result.getString("abreviation"));

                states.add(resultState);
            }
        } catch (SQLException e) {
            Logger.getLogger(StateController.class.getName()).log(Level.WARNING, null, e);
        }

        return states;
    }

    @Override
    public State show(int id) {
        State state = null;
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM state WHERE idstate = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                state = new State();
                state.setIdState(result.getInt("idstate"));
                state.setName(result.getString("name"));
                state.setAbreviation(result.getString("abreviation"));
            }

        } catch (SQLException e) {
            Logger.getLogger(StateController.class.getName()).log(Level.WARNING, null, e);
        }

        return state;
    }

    @Override
    public boolean create(State state) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String queryName = " SELECT name FROM state WHERE name = '" + state.getName() + "'";

            result = stmt.executeQuery(queryName);

            if (result.next()) {
                throw new Error("This state is already exists.");
            }

            if (!Validacao.notNull(state.getName())) {
                throw new Error("Invalid Name.");
            }

            String query = " INSERT INTO state VALUES("
                    + "DEFAULT,"
                    + "\'" + state.getName() + "\'"
                    + ")";

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(StateController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean update(State state, int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String queryName = " SELECT name FROM state WHERE name = '" + state.getName() + "'";

            result = stmt.executeQuery(queryName);

            if (result.next()) {
                throw new Error("This state is already in use.");
            }

            String query = " UPDATE state SET "
                    + "name = \'" + state.getName() + "\'"
                    + " WHERE idstate = " + id;

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

            String query = " DELETE FROM state WHERE idstate = " + id;

            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void populateTable(JTable table, String criteria) {
        int size = 3;
        criteria = " WHERE name ILIKE '%" + criteria + "%'";

        // dados da tabela
        Object[][] dataTable = null;

        // cabecalho da tabela
        Object[] header = new Object[size];
        header[0] = "Código";
        header[1] = "Nome do Estado";
        header[2] = "Sigla";

        // cria matriz de acordo com nº de registros da tabela
        ArrayList<State> responseData = this.index(criteria);

        dataTable = new Object[responseData.size()][size];
        System.out.println(responseData.size());

        for (int line = 0; line < responseData.size(); line++) {
            dataTable[line][0] = responseData.get(line).getIdState();
            dataTable[line][1] = responseData.get(line).getName();
            dataTable[line][2] = responseData.get(line).getAbreviation();
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
