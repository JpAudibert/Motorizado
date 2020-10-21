package models;

import java.util.Base64;
import java.util.Date;

public class Employee {

    private int idemployees;
    private String name;
    private String cpf;
    private String phone;
    private Date birthday;
    private String email;
    private String password;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
    private int responsibility_idresponsibility;
    private int city_idcity;

    public Employee() {
    }

    public Employee(int idemployees, String name, String cpf, String phone, Date birthday, String email, String password, Date created_at, Date updated_at, Date deleted_at, int responsibility_idresponsibility, int city_idcity) {
        this.idemployees = idemployees;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
        this.responsibility_idresponsibility = responsibility_idresponsibility;
        this.city_idcity = city_idcity;
    }

    public int getResponsibility_idresponsibility() {
        return responsibility_idresponsibility;
    }

    public void setResponsibility_idresponsibility(int responsibility_idresponsibility) {
        this.responsibility_idresponsibility = responsibility_idresponsibility;
    }

    public int getIdemployees() {
        return idemployees;
    }

    public void setIdemployees(int idemployees) {
        this.idemployees = idemployees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Base64.Encoder encoder = Base64.getEncoder();
        password = encoder.encodeToString(password.getBytes());
        this.password = password;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }

    public int getCity_idCity() {
        return city_idcity;
    }

    public void setCity_idCity(int city_idCity) {
        this.city_idcity = city_idCity;
    }

}
