package motorizado;

import controllers.ClientController;
import controllers.EmployeeController;
import helpers.DBConnection;
import helpers.Formatacao;
import helpers.Inserts;
import java.util.ArrayList;
import models.Client;
import models.Employee;
import views.Login;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (DBConnection.getInstance() != null) {
          /*Inserts.insertStates();
            Inserts.insertCities();
            Inserts.insertResponsibilities();
            
            Employee employee = new Employee();
            employee.setName("Pedro Basso Audibert");
            employee.setCpf("18227213006");
            employee.setPhone("54 999742414");
            employee.setBirthday(Formatacao.ajustaDataAMD("16/05/2001"));
            employee.setEmail("joao@audibert.com");
            employee.setPassword("123456789");
            employee.setResponsibility_idresponsibility(2);
            employee.setCity_idcity(2);
            EmployeeController employeeController = new EmployeeController();
            employeeController.create(employee);
*/
            new Login().setVisible(true);
        } else {
            System.out.println("Oops buddy :|");
        }
        
    }
    
}
