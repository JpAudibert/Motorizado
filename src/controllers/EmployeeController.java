package controllers;

import helpers.DBConnection;
import helpers.Validacao;
import interfaces.IIncrementedController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.Employee;

public class EmployeeController implements IIncrementedController<Employee> {

    private ResultSet result;
    private ArrayList helperCity = new ArrayList<String>();
    private ArrayList helperResponsibility = new ArrayList<String>();

    @Override
    public ArrayList<Employee> index(String criteria) {
        ArrayList employees = new ArrayList<Employee>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT "
                    + "	em.idemployees AS idemployees, "
                    + "	em.name AS name, "
                    + "	em.cpf AS cpf, "
                    + "	em.phone AS phone, "
                    + "	em.email AS email, "
                    + "	em.hiring_date AS hiring_date, "
                    + "	res.sector AS sector, "
                    + "	CONCAT(ct.name, '/', st.abreviation) AS city "
                    + " FROM "
                    + "	employees em "
                    + "		INNER JOIN city ct ON ct.idcity = em.city_idcity  "
                    + "		INNER JOIN state st ON st.idstate = ct.state_idstate  "
                    + "		INNER JOIN responsibility res ON res.idresponsibility = em.responsibility_idresponsibility "
                    + " WHERE"
                    + "	em.deleted_at IS NULL";

            criteria = criteria + "";

            if (!criteria.equals("null")) {
                query += criteria;
            }

            System.out.println(query);

            result = stmt.executeQuery(query);
            while (result.next()) {
                Employee resultEmployee = new Employee();
                resultEmployee.setIdemployees(result.getInt("idemployees"));
                resultEmployee.setName(result.getString("name"));
                resultEmployee.setCpf(result.getString("cpf"));
                resultEmployee.setPhone(result.getString("phone"));
                resultEmployee.setEmail(result.getString("email"));
                resultEmployee.setHiring_date(result.getDate("hiring_date"));

                employees.add(resultEmployee);

                helperCity.add(result.getString("city"));

                helperResponsibility.add(result.getString("sector"));

            }
        } catch (SQLException e) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.WARNING, null, e);
        }

        return employees;
    }

    @Override
    public ArrayList<Employee> indexLazy(String criteria, int skip, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Employee> indexDeleted() {
        ArrayList employees = new ArrayList<Employee>();
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT "
                    + "	em.idemployees AS idemployees, "
                    + "	em.name AS name, "
                    + "	em.cpf AS cpf, "
                    + "	em.phone AS phone, "
                    + "	em.email AS email, "
                    + "	em.hiring_date AS hiring_date, "
                    + "	res.sector AS sector, "
                    + "	CONCAT(ct.name, '/', st.abreviation) AS city "
                    + " FROM "
                    + "	employees em "
                    + "		INNER JOIN city ct ON ct.idcity = em.city_idcity  "
                    + "		INNER JOIN state st ON st.idstate = ct.state_idstate  "
                    + "		INNER JOIN responsibility res ON res.idresponsibility = em.responsibility_idresponsibility "
                    + " WHERE"
                    + "	em.deleted_at IS NOT NULL";

            System.out.println(query);

            result = stmt.executeQuery(query);

            while (result.next()) {
                Employee resultEmployee = new Employee();
                resultEmployee.setIdemployees(result.getInt("idemployees"));
                resultEmployee.setName(result.getString("name"));
                resultEmployee.setCpf(result.getString("cpf"));
                resultEmployee.setPhone(result.getString("phone"));
                resultEmployee.setEmail(result.getString("email"));
                resultEmployee.setHiring_date(result.getDate("hiring_date"));

                employees.add(resultEmployee);

                helperCity.add(result.getString("city"));
                helperResponsibility.add(result.getString("sector"));
            }
        } catch (SQLException e) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.WARNING, null, e);
        }

        return employees;
    }

    @Override
    public Employee show(int id) {
        Employee employee = null;
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT "
                    + "	em.idemployees AS idemployees, "
                    + "	em.name AS name, "
                    + "	em.cpf AS cpf, "
                    + "	em.phone AS phone, "
                    + "	em.email AS email, "
                    + "	em.hiring_date AS hiring_date, "
                    + "	res.sector AS sector, "
                    + "	CONCAT(ct.name, '/', st.abreviation) AS city "
                    + "FROM "
                    + "	employees em "
                    + "		INNER JOIN city ct ON ct.idcity = em.city_idcity  "
                    + "		INNER JOIN state st ON st.idstate = ct.state_idstate  "
                    + "		INNER JOIN responsibility res ON res.idresponsibility = em.responsibility_idresponsibility "
                    + " WHERE"
                    + "	em.deleted_at IS NULL"
                    + " AND idemployees = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                employee = new Employee();
                employee.setIdemployees(result.getInt("idemployees"));
                employee.setName(result.getString("name"));
                employee.setCpf(result.getString("cpf"));
                employee.setPhone(result.getString("phone"));
                employee.setBirthday(result.getDate("birthday"));
                employee.setEmail(result.getString("email"));
                employee.setHiring_date(result.getDate("hiring_date"));
            }

        } catch (SQLException e) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.WARNING, null, e);
        }

        return employee;
    }

    @Override
    public boolean create(Employee employee) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String queryEmail = " SELECT email FROM employees WHERE email = '" + employee.getEmail() + "' AND deleted_at IS NULL";

            result = stmt.executeQuery(queryEmail);

            if (result.next()) {
                throw new Error("This email is already in use.");
            }

           // if (!Validacao.validarCPF(employee.getCpf())) {
           //     throw new Error("Invalid CPF.");
           // }

            String query = " INSERT INTO employees "
                    + "(idemployees, name, cpf, phone, birthday, email, password, responsibility_idresponsibility, city_idcity) VALUES("
                    + "DEFAULT,"
                    + "\'" + employee.getName() + "\',"
                    + "\'" + employee.getCpf() + "\',"
                    + "\'" + employee.getPhone() + "\',"
                    + "\'" + employee.getBirthday() + "\',"
                    + "\'" + employee.getEmail() + "\',"
                    + "\'" + employee.getPassword() + "\',"
                    + "" + employee.getResponsibility_idresponsibility() + ","
                    + "" + employee.getCity_idcity() + ""
                    + ")";

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    public int showAuth(String email) {
        int employeeId = 0;
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " SELECT idemployees FROM employees WHERE email = \'" + email + "\' AND deleted_at IS NULL";

            result = stmt.executeQuery(query);

            if (result.next()) {
                employeeId = result.getInt("idemployees");
            }

        } catch (SQLException e) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.WARNING, null, e);
        }
        return employeeId;
    }

    @Override
    public boolean update(Employee employees, int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String queryEmail = " SELECT email FROM employees WHERE email = '" + employees.getEmail() + "' AND deleted_at IS NULL";

            result = stmt.executeQuery(queryEmail);

            if (result.next()) {
                throw new Error("This is email is already in use.");
            }

            if (!Validacao.validarCPF(employees.getCpf())) {
                throw new Error("Invalid CPF.");
            }

            String query = " UPDATE employees SET "
                    + "name = \'" + employees.getName() + "\',"
                    + "cpf = \'" + employees.getCpf() + "\',"
                    + "phone = \'" + employees.getPhone() + "\',"
                    + "birthday = \'" + employees.getBirthday() + "\',"
                    + "email = \'" + employees.getEmail() + "\',"
                    + "password = \'" + employees.getPassword() + "\',"
                    + "hiring_date = \'" + employees.getHiring_date() + "\',"
                    + "firing_date = \'" + employees.getFiring_date() + "\',"
                    + "responsibility_idresponsibility = \'" + employees.getResponsibility_idresponsibility() + "\',"
                    + "city_idcity = \'" + employees.getCity_idcity() + "\',"
                    + "updated_at = \'" + new Timestamp(new Date().getTime()) + "\'"
                    + " WHERE idemployees = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.WARNING, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE employees SET "
                    + " deleted_at = \'" + new Timestamp(new Date().getTime()) + "\' "
                    + " WHERE idemployees = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.WARNING, null, e);
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

            String query = " DELETE FROM employees WHERE idemployees = " + id;

            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean undoSoftDelete(int id) {
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();

            String query = " UPDATE employees SET "
                    + " deleted_at = NULL "
                    + " WHERE idemployees = " + id;

            System.out.println(query);

            return stmt.execute(query);

        } catch (SQLException e) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.WARNING, null, e);
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
        header[2] = "CPF";
        header[3] = "Phone";
        header[4] = "Email";
        header[5] = "Data de Contratação";
        header[6] = "Setor";
        header[7] = "Cidade/UF";

        // cria matriz de acordo com nº de registros da tabela
        ArrayList<Employee> responseData = this.index(criteria);

        dataTable = new Object[responseData.size()][size];
        System.out.println(responseData.size());

        for (int line = 0; line < responseData.size(); line++) {
            dataTable[line][0] = responseData.get(line).getIdemployees();
            dataTable[line][1] = responseData.get(line).getName();
            dataTable[line][2] = responseData.get(line).getCpf();
            dataTable[line][3] = responseData.get(line).getPhone();
            dataTable[line][4] = responseData.get(line).getEmail();
            dataTable[line][5] = responseData.get(line).getHiring_date();
            dataTable[line][6] = helperResponsibility.get(line);
            dataTable[line][7] = helperCity.get(line);
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
