package models;

import java.util.Date;

public class Client {

    private int idClient;
    private String name;
    private String cpf;
    private String phone;
    private Date birthday;
    private String email;
    private String password;
    private String CNH_register;
    private String CNH_mirror;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    public Client() {
    }

    public Client(int idClient, String name, String cpf, String phone, Date birthday, String email, String password, String CNH_register, String CNH_mirror, Date created_at, Date updated_at, Date deleted_at) {
        this.idClient = idClient;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.CNH_register = CNH_register;
        this.CNH_mirror = CNH_mirror;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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
        this.password = password;
    }

    public String getCNH_register() {
        return CNH_register;
    }

    public void setCNH_register(String CNH_register) {
        this.CNH_register = CNH_register;
    }

    public String getCNH_mirror() {
        return CNH_mirror;
    }

    public void setCNH_mirror(String CNH_mirror) {
        this.CNH_mirror = CNH_mirror;
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

}
