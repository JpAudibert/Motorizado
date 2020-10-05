package models;

import java.util.Date;

public class Maintenance {

    private int idmaintenance;
    private String maintenance_type;
    private String changed_parts;
    private double service_value;
    private boolean isexternal; //if not external got to have an employee attatched
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
    private int employees_idemployees;
    private int service_order_idservice_order;
    private int service_order_employees_employees_idemployees;
    private int vehicle_idvehicle;

    public Maintenance() {
    }

    public Maintenance(int idmaintenance, String maintenance_type, String changed_parts, double service_value, boolean isexternal, Date created_at, Date updated_at, Date deleted_at, int employees_idemployees, int service_order_idservice_order, int service_order_employees_employees_idemployees, int vehicle_idvehicle) {
        this.idmaintenance = idmaintenance;
        this.maintenance_type = maintenance_type;
        this.changed_parts = changed_parts;
        this.service_value = service_value;
        this.isexternal = isexternal;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
        this.employees_idemployees = employees_idemployees;
        this.service_order_idservice_order = service_order_idservice_order;
        this.service_order_employees_employees_idemployees = service_order_employees_employees_idemployees;
        this.vehicle_idvehicle = vehicle_idvehicle;
    }

    public int getVehicle_idvehicle() {
        return vehicle_idvehicle;
    }

    public void setVehicle_idvehicle(int vehicle_idvehicle) {
        this.vehicle_idvehicle = vehicle_idvehicle;
    }

    public int getIdmaintenance() {
        return idmaintenance;
    }

    public void setIdmaintenance(int idmaintenance) {
        this.idmaintenance = idmaintenance;
    }

    public String getMaintenance_type() {
        return maintenance_type;
    }

    public void setMaintenance_type(String maintenance_type) {
        this.maintenance_type = maintenance_type;
    }

    public String getChanged_parts() {
        return changed_parts;
    }

    public void setChanged_parts(String changed_parts) {
        this.changed_parts = changed_parts;
    }

    public double getService_value() {
        return service_value;
    }

    public void setService_value(double service_value) {
        this.service_value = service_value;
    }

    public boolean isIsexternal() {
        return isexternal;
    }

    public void setIsexternal(boolean isexternal) {
        this.isexternal = isexternal;
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

    public int getService_order_idservice_order() {
        return service_order_idservice_order;
    }

    public void setService_order_idservice_order(int service_order_idservice_order) {
        this.service_order_idservice_order = service_order_idservice_order;
    }

    public int getService_order_employees_employees_idemployees() {
        return service_order_employees_employees_idemployees;
    }

    public void setService_order_employees_employees_idemployees(int service_order_employees_employees_idemployees) {
        this.service_order_employees_employees_idemployees = service_order_employees_employees_idemployees;
    }

}
