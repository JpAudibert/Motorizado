package controllers;

import helpers.DBConnection;
import interfaces.IBasicController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client show(int id) {
        Client client = null;
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = "SELECT * FROM client WHERE idclient = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                client = new Client();
                client.setIdClient(result.getInt("idclient"));
                client.setName(result.getString("name"));
                client.setCpf(result.getString("cpf"));
                client.setPhone(result.getString("phone"));
                client.setBirthday(result.getDate("birthday"));
                client.setEmail(result.getString("email"));
                client.setPassword(result.getString("password"));
                client.setCNH_register(result.getString("cnh_register"));
                client.setCNH_mirror(result.getString("cnh_mirror"));
                client.setCreated_at(result.getDate("created_at"));
                client.setUpdated_at(result.getDate("updated_at"));
                client.setDeleted_at(result.getDate("deleted_at"));
            }

        } catch (SQLException err) {
            Logger.getLogger(ClientController.class.getName()).log(Level.WARNING, null, err);
        }

        return client;
    }

    @Override
    public boolean store(Client client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Client client, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
