package models;

import java.util.Date;

public class VehicleBooking {

    private int idvehicle_booking;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
    private int vehicle_idvehicle;
    private int client_idclient;
    private int contract_idcontract;

    public VehicleBooking() {
    }

    public VehicleBooking(int idvehicle_booking, Date created_at, Date updated_at, Date deleted_at, int vehicle_idvehicle, int client_idclient, int contract_idcontract) {
        this.idvehicle_booking = idvehicle_booking;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
        this.vehicle_idvehicle = vehicle_idvehicle;
        this.client_idclient = client_idclient;
        this.contract_idcontract = contract_idcontract;
    }

    public int getContract_idcontract() {
        return contract_idcontract;
    }

    public void setContract_idcontract(int contract_idcontract) {
        this.contract_idcontract = contract_idcontract;
    }

    public int getIdvehicle_booking() {
        return idvehicle_booking;
    }

    public void setIdvehicle_booking(int idvehicle_booking) {
        this.idvehicle_booking = idvehicle_booking;
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

    public int getVehicle_idvehicle() {
        return vehicle_idvehicle;
    }

    public void setVehicle_idvehicle(int vehicle_idvehicle) {
        this.vehicle_idvehicle = vehicle_idvehicle;
    }

    public int getClient_idclient() {
        return client_idclient;
    }

    public void setClient_idclient(int client_idclient) {
        this.client_idclient = client_idclient;
    }

}
