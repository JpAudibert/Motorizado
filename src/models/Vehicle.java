package models;

import java.util.Date;

public class Vehicle {

    private int idvehicle;
    private int manufaturing_year;
    private String transit_board;
    private String chassis_id;
    private String vehicle_power;
    private String fuel_type;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
    private int vehicle_models_idvehicle_models;
    private int category_idcategory;

    public Vehicle() {
    }

    public Vehicle(int idvehicle, int manufaturing_year, String transit_board, String chassis_id, String vehicle_power, String fuel_type, Date created_at, Date updated_at, Date deleted_at, int vehicle_models_idvehicle_models, int category_idcategory) {
        this.idvehicle = idvehicle;
        this.manufaturing_year = manufaturing_year;
        this.transit_board = transit_board;
        this.chassis_id = chassis_id;
        this.vehicle_power = vehicle_power;
        this.fuel_type = fuel_type;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
        this.vehicle_models_idvehicle_models = vehicle_models_idvehicle_models;
        this.category_idcategory = category_idcategory;
    }

    public int getCategory_idcategory() {
        return category_idcategory;
    }

    public void setCategory_idcategory(int category_idcategory) {
        this.category_idcategory = category_idcategory;
    }

    public int getIdvehicle() {
        return idvehicle;
    }

    public void setIdvehicle(int idvehicle) {
        this.idvehicle = idvehicle;
    }

    public int getManufaturing_year() {
        return manufaturing_year;
    }

    public void setManufaturing_year(int manufaturing_year) {
        this.manufaturing_year = manufaturing_year;
    }

    public String getTransit_board() {
        return transit_board;
    }

    public void setTransit_board(String transit_board) {
        this.transit_board = transit_board;
    }

    public String getChassis_id() {
        return chassis_id;
    }

    public void setChassis_id(String chassis_id) {
        this.chassis_id = chassis_id;
    }

    public String getVehicle_power() {
        return vehicle_power;
    }

    public void setVehicle_power(String vehicle_power) {
        this.vehicle_power = vehicle_power;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
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

    public int getVehicle_models_idvehicle_models() {
        return vehicle_models_idvehicle_models;
    }

    public void setVehicle_models_idvehicle_models(int vehicle_models_idvehicle_models) {
        this.vehicle_models_idvehicle_models = vehicle_models_idvehicle_models;
    }

    
}
