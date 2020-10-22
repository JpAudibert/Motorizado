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

}
