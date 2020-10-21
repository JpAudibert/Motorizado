package motorizado;

import controllers.ClientController;
import helpers.DBConnection;
import helpers.Formatacao;
import helpers.Inserts;
import java.util.ArrayList;
import models.Client;
import views.Login;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (DBConnection.getInstance() != null) {
//            Client client = new Client();
//            client.setName("Veridiana Silva");
//            client.setCpf("18227213006");
//            client.setPhone("54 999742414");
//            client.setBirthday(Formatacao.ajustaDataAMD("28/02/1954"));
//            client.setEmail("veridiana@adelino.com");
//            client.setCNH_register("02345678911");
//            client.setCNH_mirror("1987654321");
            
//            ClientController clientController = new ClientController();
//            clientController.create(client);
            new Login().setVisible(true);
        } else {
            System.out.println("Oops buddy :|");
        }

    }

}
