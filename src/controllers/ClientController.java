package controllers;

import helpers.DBConnection;
import helpers.Formatacao;
import helpers.Validacao;
import interfaces.IIncrementedController;
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

public class ClientController implements IIncrementedController<Client> {

    private ResultSet result;
    private ArrayList helper = new ArrayList<String>();

    @Override
    public ArrayList<Client> index(String criteria) {
        ArrayList clients = new ArrayList<Client>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT "
                    + "	cl.idclient AS idclient, "
                    + "	cl.name AS name, "
                    + "	cl.cpf AS cpf, "
                    + "	cl.phone AS phone, "
                    + "	cl.birthday AS birthday, "
                    + "	cl.email AS email, "
                    + "	cl.cnh_register AS cnh_register, "
                    + "	cl.cnh_mirror AS cnh_mirror, "
                    + "	CONCAT(ct.name, '/', st.abreviation) AS city "
                    + " FROM "
                    + "	client cl "
                    + "		INNER JOIN city ct ON ct.idcity = cl.city_idcity "
                    + "		INNER JOIN state st ON st.idstate = ct.state_idstate "
                    + " WHERE"
                    + "	cl.deleted_at IS NULL ";

            criteria = criteria + "";

            if (!criteria.equals("null")) {
                query += criteria;
            }

            System.out.println(query);

            result = stmt.executeQuery(query);

            while (result.next()) {
                Client resultClient = new Client();
                resultClient.setIdClient(result.getInt("idclient"));
                resultClient.setName(result.getString("name"));
                resultClient.setCpf(result.getString("cpf"));
                resultClient.setPhone(result.getString("phone"));
                resultClient.setBirthday(result.getDate("birthday"));
                resultClient.setEmail(result.getString("email"));
                resultClient.setCNH_register(result.getString("cnh_register"));
                resultClient.setCNH_mirror(result.getString("cnh_mirror"));

                clients.add(resultClient);

                helper.add(result.getString("city"));
            }
        } catch (SQLException e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.WARNING, null, e);
        }

        return clients;
    }

    @Override
    public ArrayList<Client> indexLazy(String criteria, int skip, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Client> indexDeleted() {
        ArrayList clients = new ArrayList<Client>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT "
                    + "	cl.idclient AS idclient, "
                    + "	cl.name AS name, "
                    + "	cl.cpf AS cpf, "
                    + "	cl.phone AS phone, "
                    + "	cl.birthday AS birthday, "
                    + "	cl.email AS email, "
                    + "	cl.cnh_register AS cnh_register, "
                    + "	cl.cnh_mirror AS cnh_mirror "
                    + "	cl.created_at AS created_at "
                    + "	cl.updated_at AS updated_at "
                    + "	cl.deleted_at AS deleted_at "
                    + "	CONCAT(ct.name, '/', st.abreviation) AS city "
                    + " FROM "
                    + "	client cl "
                    + "		INNER JOIN city ct ON ct.idcity = cl.city_idcity "
                    + "		INNER JOIN state st ON st.idstate = ct.state_idstate "
                    + " WHERE"
                    + "	cl.deleted_at IS NOT NULL ";

            result = stmt.executeQuery(query);

            while (result.next()) {
                Client resultClient = new Client();
                resultClient.setIdClient(result.getInt("idclient"));
                resultClient.setName(result.getString("name"));
                resultClient.setCpf(result.getString("cpf"));
                resultClient.setPhone(result.getString("phone"));
                resultClient.setBirthday(result.getDate("birthday"));
                resultClient.setEmail(result.getString("email"));
                resultClient.setCNH_register(result.getString("cnh_register"));
                resultClient.setCNH_mirror(result.getString("cnh_mirror"));
                resultClient.setCreated_at(result.getDate("created_at"));
                resultClient.setUpdated_at(result.getDate("updated_at"));
                resultClient.setDeleted_at(result.getDate("deleted_at"));
                resultClient.setCity_idcity(result.getInt("city_idcity"));

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

            String query = " SELECT "
                    + "	cl.idclient AS idclient, "
                    + "	cl.name AS name, "
                    + "	cl.cpf AS cpf, "
                    + "	cl.phone AS phone, "
                    + "	cl.birthday AS birthday, "
                    + "	cl.email AS email, "
                    + "	cl.cnh_register AS cnh_register, "
                    + "	cl.cnh_mirror AS cnh_mirror "
                    + "	cl.created_at AS created_at "
                    + "	cl.updated_at AS updated_at "
                    + "	cl.deleted_at AS deleted_at "
                    + "	CONCAT(ct.name, '/', st.abreviation) AS city "
                    + " FROM "
                    + "	client cl "
                    + "		INNER JOIN city ct ON ct.idcity = cl.city_idcity "
                    + "		INNER JOIN state st ON st.idstate = ct.state_idstate "
                    + " WHERE"
                    + "	cl.deleted_at IS NULL "
                    + "    cl.idclient = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                client = new Client();
                client.setIdClient(result.getInt("idclient"));
                client.setName(result.getString("name"));
                client.setCpf(result.getString("cpf"));
                client.setPhone(result.getString("phone"));
                client.setBirthday(result.getDate("birthday"));
                client.setEmail(result.getString("email"));
                client.setCNH_register(result.getString("cnh_register"));
                client.setCNH_mirror(result.getString("cnh_mirror"));
                client.setCreated_at(result.getDate("created_at"));
                client.setUpdated_at(result.getDate("updated_at"));
                client.setDeleted_at(result.getDate("deleted_at"));
                client.setCity_idcity(result.getInt("city_idcity"));
            }

        } catch (SQLException e) {
            Logger.getLogger(ClientController.class.getName()).log(Level.WARNING, null, e);
        }

        return client;
    }

    @Override
    public boolean create(Client client) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String queryEmail = " SELECT email FROM client WHERE email = '" + client.getEmail() + "' AND deleted_at IS NULL";

            result = stmt.executeQuery(queryEmail);

            if (result.next()) {
                throw new Error("This email is already in use.");
            }

            if (!Validacao.validarCPF(client.getCpf())) {
                throw new Error("Invalid CPF.");
            }

            String query = " INSERT INTO client (idclient, name, email, cpf, phone, birthday, email, cnh_register, cnh_mirror, city_idcity) VALUES("
                    + "DEFAULT,"
                    + "\'" + client.getName() + "\',"
                    + "\'" + client.getCpf() + "\',"
                    + "\'" + client.getPhone() + "\',"
                    + "\'" + client.getBirthday() + "\',"
                    + "\'" + client.getEmail() + "\',"
                    + "\'" + client.getCNH_register() + "\',"
                    + "\'" + client.getCNH_mirror() + "\',"
                    + "\'" + client.getCity_idcity() + "\'"
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

            String queryEmail = " SELECT email FROM client WHERE email = '" + client.getEmail() + "' AND deleted_at IS NULL";

            result = stmt.executeQuery(queryEmail);

            if (result.next()) {
                throw new Error("This is email is already in use.");
            }

            if (!Validacao.validarCPF(client.getCpf())) {
                throw new Error("Invalid CPF.");
            }

            String query = " UPDATE client SET "
                    + "name = \'" + client.getName() + "\',"
                    + "cpf = \'" + client.getCpf() + "\',"
                    + "phone = \'" + client.getPhone() + "\',"
                    + "birthday = \'" + client.getBirthday() + "\',"
                    + "email = \'" + client.getEmail() + "\',"
                    + "cnh_register = \'" + client.getCNH_register() + "\',"
                    + "cnh_mirror = \'" + client.getCNH_mirror() + "\',"
                    + "city_idcity = \'" + client.getCity_idcity() + "\',"
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

    @Override
    public void populateTable(JTable table, String criteria) {
        int size = 8;

        // dados da tabela
        Object[][] dataTable = null;

        // cabecalho da tabela
        Object[] header = new Object[size];
        header[0] = "Código";
        header[1] = "Nome";
        header[2] = "Email";
        header[3] = "CPF";
        header[4] = "Data de Nascimento";
        header[5] = "CNH";
        header[6] = "Espelho CNH";
        header[7] = "Cidade/UF";

        // cria matriz de acordo com nº de registros da tabela
        ArrayList<Client> responseData = this.index(criteria);

        dataTable = new Object[responseData.size()][size];
        System.out.println(responseData.size());

        for (int line = 0; line < responseData.size(); line++) {
            dataTable[line][0] = responseData.get(line).getIdClient();
            dataTable[line][1] = responseData.get(line).getName();
            dataTable[line][2] = responseData.get(line).getEmail();
            dataTable[line][3] = responseData.get(line).getCpf();
            dataTable[line][4] = responseData.get(line).getBirthday();
            dataTable[line][5] = responseData.get(line).getCNH_register();
            dataTable[line][6] = responseData.get(line).getCNH_mirror();
            dataTable[line][7] = helper.get(line);
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
