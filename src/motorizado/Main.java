package motorizado;

import controllers.ClientController;
import helpers.DBConnection;
import helpers.Formatacao;
import java.util.ArrayList;
import models.Client;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (DBConnection.getInstance() != null) {
            Client client = new Client();
            client.setName("Veridiana Sousa");
            client.setCpf("22441676075");
            client.setPhone("54 999566554");
            client.setBirthday(Formatacao.ajustaDataAMD("16/05/2001"));
            client.setEmail("veridiana@adelino.com");
            client.setPassword("0987654321");
            client.setCNH_register("12345678911");
            client.setCNH_mirror("1234567891");

            ClientController clientController = new ClientController();
            clientController.create(client);

            ArrayList<Client> clientIndex = clientController.index();

            for (Client clientShow : clientIndex) {
                System.out.println("CLIENTE ALTERDO\n");
                System.out.println("ID: " + clientShow.getIdClient());
                System.out.println("NAME: " + clientShow.getName());
                System.out.println("CPF: " + clientShow.getCpf());
                System.out.println("PHONE: " + clientShow.getPhone());
                System.out.println("BIRTHDAY: " + clientShow.getBirthday());
                System.out.println("EMAIL: " + clientShow.getEmail());
                System.out.println("PASSWORD: " + clientShow.getPassword());
                System.out.println("CNH_REGISTER: " + clientShow.getCNH_register());
                System.out.println("CNH_MIRROR: " + clientShow.getCNH_mirror());
                System.out.println("CREATED_AT: " + clientShow.getCreated_at());
                System.out.println("UPDATED_AT: " + clientShow.getUpdated_at());
                System.out.println("DELETED_AT: " + clientShow.getDeleted_at());
                System.out.println("");

            }

        } else {
            System.out.println("Oops buddy :|");
        }

    }

}
