package motorizado;

import helpers.DBConnection;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (DBConnection.getInstance() != null) {
            System.out.println("alright");
        } else {
            System.out.println("Oops buddy :|");
        }
    }
    
}
