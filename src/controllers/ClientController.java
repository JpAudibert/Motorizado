package controllers;

import helpers.DBConnection;
import helpers.Formatacao;
import helpers.Validacao;
import interfaces.IBasicController;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.Client;

public class ClientController implements IBasicController<Client> {

    private ResultSet result;

    @Override
    public ArrayList<Client> index() {
        ArrayList clients = new ArrayList<Client>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM client WHERE deleted_at IS NULL";

            result = stmt.executeQuery(query);

            while (result.next()) {
                Client resultClient = new Client();
                resultClient.setIdClient(result.getInt("idclient"));
                resultClient.setName(result.getString("name"));
                resultClient.setCpf(result.getString("cpf"));
                resultClient.setPhone(result.getString("phone"));
                resultClient.setBirthday(result.getDate("birthday"));
                resultClient.setEmail(result.getString("email"));
                resultClient.setPassword(result.getString("password"));
                resultClient.setCNH_register(result.getString("cnh_register"));
                resultClient.setCNH_mirror(result.getString("cnh_mirror"));
                resultClient.setCreated_at(result.getDate("created_at"));
                resultClient.setUpdated_at(result.getDate("updated_at"));
                resultClient.setDeleted_at(result.getDate("deleted_at"));

                clients.add(resultClient);
            }
        } catch (SQLException e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.WARNING, null, e);
        }

        return clients;
    }

    @Override
    public Client show(int id) {
        Client client = null;
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT * FROM client WHERE idclient = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                client = new Client();
                client.setIdClient(result.getInt("idclient"));
                client.setName(result.getString("name"));
                client.setCpf(result.getString("cpf"));
                client.setPhone(result.getString("phone"));
                client.setBirthday(result.getDate("birthday"));
                client.setEmail(result.getString("email"));
                client.setPassword(Formatacao.getBase64InString(result.getString("password")));
                client.setCNH_register(result.getString("cnh_register"));
                client.setCNH_mirror(result.getString("cnh_mirror"));
                client.setCreated_at(result.getDate("created_at"));
                client.setUpdated_at(result.getDate("updated_at"));
                client.setDeleted_at(result.getDate("deleted_at"));
            }

        } catch (SQLException e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.WARNING, null, e);
        }

        return client;
    }

    public int showAuth(String email) {
        int clientId = 6;
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT idclient FROM client WHERE email = \'" + email + "\'";

            result = stmt.executeQuery(query);

            if (result.next()) {
                clientId = result.getInt("idclient");
            }

        } catch (SQLException e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.WARNING, null, e);
        }
        return clientId;
    }

    @Override
    public boolean create(Client client) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            if (!Validacao.validarCPF(client.getCpf())) {
                throw new Error("Invalid CPF.");
            }

            String query = " INSERT INTO client VALUES("
                    + "DEFAULT,"
                    + "\'" + client.getName() + "\',"
                    + "\'" + client.getCpf() + "\',"
                    + "\'" + client.getPhone() + "\',"
                    + "\'" + client.getBirthday() + "\',"
                    + "\'" + client.getEmail() + "\',"
                    + "\'" + Formatacao.getStringInBase64(client.getPassword()) + "\',"
                    + "\'" + client.getCNH_register() + "\',"
                    + "\'" + client.getCNH_mirror() + "\'"
                    + ")";

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean update(Client client, int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            if (!Validacao.validarCPF(client.getCpf())) {
                throw new Error("Invalid CPF.");
            }

            String query = " UPDATE client SET "
                    + "name = \'" + client.getName() + "\',"
                    + "cpf = \'" + client.getCpf() + "\',"
                    + "phone = \'" + client.getPhone() + "\',"
                    + "birthday = \'" + client.getBirthday() + "\',"
                    + "email = \'" + client.getEmail() + "\',"
                    + "password = \'" + Formatacao.getStringInBase64(client.getPassword()) + "\',"
                    + "cnh_register = \'" + client.getCNH_register() + "\',"
                    + "cnh_mirror = \'" + client.getCNH_mirror() + "\',"
                    + "updated_at = \'" + new Timestamp(new Date().getTime()) + "\'"
                    + " WHERE idclient = " + id;

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

            String query = " UPDATE client SET "
                    + " deleted_at = \'" + new Timestamp(new Date().getTime()) + "\' "
                    + " WHERE idclient = " + id;

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

            String query = " DELETE FROM client WHERE idclient = " + id;

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

            String query = " UPDATE client SET "
                    + " deleted_at = NULL "
                    + " WHERE idclient = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    /* Popula JTable */
    public void popularTabelaXXX(JTable table, String criteria) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[6];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Email";
        cabecalho[3] = "CPF";
        cabecalho[4] = "CNH";
        cabecalho[5] = "Data de Nascimento";

        // cria matriz de acordo com nº de registros da tabela
        try {
            result = DBConnection.getInstance().getConnection().createStatement().executeQuery(""
                    + " SELECT count(idclient) FROM client WHERE deleted_at IS NULL ");

            result.next();

            dadosTabela = new Object[result.getInt(1)][6];
            System.out.println(result.getInt(1));

        } catch (Exception e) {
            System.out.println("Erro ao consultar name: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            result = DBConnection.getInstance().getConnection().createStatement().executeQuery(""
                    + " SELECT \n"
                    + "	idclient,\n"
                    + "	name,\n"
                    + "	email,\n"
                    + "	cnh_register,\n"
                    + "	birthday,\n"
                    + "	cpf\n"
                    + " FROM\n"
                    + "	client"
                    + " WHERE deleted_at IS NULL ");

            while (result.next()) {

                dadosTabela[lin][0] = result.getInt("idclient");
                dadosTabela[lin][1] = result.getString("name");
                dadosTabela[lin][2] = result.getString("email");
                dadosTabela[lin][3] = result.getString("cpf");
                dadosTabela[lin][4] = result.getString("cnh_register");
                dadosTabela[lin][5] = result.getString("birthday");

                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        table.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
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
