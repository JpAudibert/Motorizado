package controllers;

import helpers.DBConnection;
import helpers.Formatacao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {

    private ResultSet result;

    public boolean authenticate(String email, String password) {
        boolean auth = false;

        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT idemployees, password FROM employees WHERE email = '" + email + "'";

            result = stmt.executeQuery(query);

            if (result.next()) {
                String passwordEncoded = Formatacao.getStringInBase64(password);
                if (passwordEncoded.equals(result.getString("password"))) {
                    auth = true;
                }
            }
            return auth;
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return auth;
    }
}