package motorizado;

import controllers.ClientController;
import helpers.DBConnection;
import helpers.Formatacao;
import java.util.ArrayList;
import models.Client;
import views.Login;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (DBConnection.getInstance() != null) {
            
            new Login().setVisible(true);
        } else {
            System.out.println("Oops buddy :|");
        }

    }

}
