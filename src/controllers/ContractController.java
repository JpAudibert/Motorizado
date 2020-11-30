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
import models.Client;
import models.Contract;

public class ContractController implements IIncrementedController<Contract> {

    private ResultSet result;

    @Override
    public ArrayList<Contract> index(String criteria) {
        ArrayList contracts = new ArrayList<Contract>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM contract WHERE deleted_at IS NULL ";

            criteria = criteria + "";

            if (!criteria.equals("null")) {
                query += criteria;
            }

            System.out.println(query);

            result = stmt.executeQuery(query);

            while (result.next()) {
                Contract resultContract = new Contract();
                resultContract.setIdContract(result.getInt("idcontract"));
                resultContract.setContract_date(result.getDate("contract_date"));
                resultContract.setContract_cancel_date(result.getDate("contract_cancel_date"));
                resultContract.setPenalty(result.getInt("penalty"));
                resultContract.setPayment_type(result.getString("payment_type"));
                resultContract.setContract_value(result.getDouble("contract_value"));
                resultContract.setCreated_at(result.getDate("created_at"));
                resultContract.setUpdated_at(result.getDate("updated_at"));
                resultContract.setDeleted_at(result.getDate("deleted_at"));

                contracts.add(resultContract);
            }
        } catch (SQLException e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.WARNING, null, e);
        }

        return contracts;
    }

    @Override
    public ArrayList<Contract> indexLazy(String criteria, int skip, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Contract> indexDeleted() {
        ArrayList contracts = new ArrayList<Contract>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM contract WHERE deleted_at IS NOT NULL ";

            result = stmt.executeQuery(query);

            while (result.next()) {
                Contract resultContract = new Contract();
                resultContract.setIdContract(result.getInt("idcontract"));
                resultContract.setContract_date(result.getDate("contract_date"));
                resultContract.setContract_cancel_date(result.getDate("contract_cancel_date"));
                resultContract.setPenalty(result.getInt("penalty"));
                resultContract.setPayment_type(result.getString("payment_type"));
                resultContract.setContract_value(result.getDouble("contract_value"));
                resultContract.setCreated_at(result.getDate("created_at"));
                resultContract.setUpdated_at(result.getDate("updated_at"));
                resultContract.setDeleted_at(result.getDate("deleted_at"));

                contracts.add(resultContract);
            }
        } catch (SQLException e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.WARNING, null, e);
        }

        return contracts;
    }

    @Override
    public Contract show(int id) {
        Contract contract = null;
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM contract WHERE deleted_at IS NULL AND idcontract = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                contract = new Contract();
                contract.setIdContract(result.getInt("idcontract"));
                contract.setContract_date(result.getDate("contract_date"));
                contract.setContract_cancel_date(result.getDate("contract_cancel_date"));
                contract.setPenalty(result.getInt("penalty"));
                contract.setPayment_type(result.getString("payment_type"));
                contract.setContract_value(result.getDouble("contract_value"));
                contract.setCreated_at(result.getDate("created_at"));
                contract.setUpdated_at(result.getDate("updated_at"));
                contract.setDeleted_at(result.getDate("deleted_at"));
            }

        } catch (SQLException e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.WARNING, null, e);
        }

        return contract;
    }

    @Override
    public boolean create(Contract contract) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            // Fazer validacoes de data no aruivo de validacao
//            if (!Validacao.(client.getCpf())) {
//                throw new Error("Invalid CPF.");
//            }
            String query = " INSERT INTO contract VALUES("
                    + "DEFAULT,"
                    + "\'" + contract.getContract_date() + "\',"
                    + "\'" + contract.getContract_cancel_date() + "\',"
                    + "\'" + contract.getPenalty() + "\',"
                    + "\'" + contract.getPayment_type() + "\',"
                    + "\'" + contract.getContract_value() + "\'"
                    + ")";

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean update(Contract contract, int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

//            if (!Validacao.validarCPF(client.getCpf())) {
//                throw new Error("Invalid CPF.");
//            }
            String query = " UPDATE contract SET "
                    + "contract_date = \'" + contract.getContract_date()+ "\',"
                    + "contract_cancel_date = \'" + contract.getContract_cancel_date()+ "\',"
                    + "penalty = \'" + contract.getPenalty()+ "\',"
                    + "payment_type = \'" + contract.getPayment_type()+ "\',"
                    + "contract_value = \'" + contract.getContract_value()+ "\',"
                    + "updated_at = \'" + new Timestamp(new Date().getTime()) + "\'"
                    + " WHERE idcontract = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE contract SET "
                    + " deleted_at = \'" + new Timestamp(new Date().getTime()) + "\' "
                    + " WHERE idcontract = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.WARNING, null, e);
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

            String query = " DELETE FROM contract WHERE idcontract = " + id;

            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean undoSoftDelete(int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE contract SET "
                    + " deleted_at = NULL "
                    + " WHERE idcontract = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public void populateTable(JTable table, String criteria) {
        int size = 6;

        // dados da tabela
        Object[][] dataTable = null;

        // cabecalho da tabela
        Object[] header = new Object[size];
        header[0] = "Código";
        header[1] = "Data do Contrato";
        header[2] = "Data de Expiração";
        header[3] = "Multa";
        header[4] = "Tipo de Pagamentos";
        header[5] = "Valor do Contrato";

        // cria matriz de acordo com nº de registros da tabela
        ArrayList<Contract> responseData = this.index(criteria);

        dataTable = new Object[responseData.size()][size];
        System.out.println(responseData.size());

        for (int line = 0; line < responseData.size(); line++) {
            dataTable[line][0] = responseData.get(line).getIdContract();
            dataTable[line][1] = responseData.get(line).getContract_date();
            dataTable[line][2] = responseData.get(line).getContract_cancel_date();
            dataTable[line][3] = responseData.get(line).getPenalty();
            dataTable[line][4] = responseData.get(line).getPayment_type();
            dataTable[line][5] = responseData.get(line).getContract_value();
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
