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

}
