package models;

import java.util.Date;

public class ServiceOrder {

    private int idservice_order;
    private String description;
    private Date emission_date;
    private String object_document;
    private double unitary_value;
    private double total_value;
    private String equipment_purchased;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
    private int employees_idemployees;
    private int contract_idcontract;

    public ServiceOrder() {
    }

    public ServiceOrder(int idservice_order, String description, Date emission_date, String object_document, double unitary_value, double total_value, String equipment_purchased, Date created_at, Date updated_at, Date deleted_at, int employees_idemployees, int contract_idcontract) {
        this.idservice_order = idservice_order;
        this.description = description;
        this.emission_date = emission_date;
        this.object_document = object_document;
        this.unitary_value = unitary_value;
        this.total_value = total_value;
        this.equipment_purchased = equipment_purchased;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
        this.employees_idemployees = employees_idemployees;
        this.contract_idcontract = contract_idcontract;
    }

    public int getContract_idcontract() {
        return contract_idcontract;
    }

    public void setContract_idcontract(int contract_idcontract) {
        this.contract_idcontract = contract_idcontract;
    }

    public int getIdservice_order() {
        return idservice_order;
    }

    public void setIdservice_order(int idservice_order) {
        this.idservice_order = idservice_order;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEmission_date() {
        return emission_date;
    }

    public void setEmission_date(Date emission_date) {
        this.emission_date = emission_date;
    }

    public String getObject_document() {
        return object_document;
    }

    public void setObject_document(String object_document) {
        this.object_document = object_document;
    }

    public double getUnitary_value() {
        return unitary_value;
    }

    public void setUnitary_value(double unitary_value) {
        this.unitary_value = unitary_value;
    }

    public double getTotal_value() {
        return total_value;
    }

    public void setTotal_value(double total_value) {
        this.total_value = total_value;
    }

    public String getEquipment_purchased() {
        return equipment_purchased;
    }

    public void setEquipment_purchased(String equipment_purchased) {
        this.equipment_purchased = equipment_purchased;
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

    public int getEmployees_idemployees() {
        return employees_idemployees;
    }

    public void setEmployees_idemployees(int employees_idemployees) {
        this.employees_idemployees = employees_idemployees;
    }

}
