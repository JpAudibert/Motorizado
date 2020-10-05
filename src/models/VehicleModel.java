package models;

import java.util.Date;

public class VehicleModel {

    private int idvehicle_models;
    private String model_name;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
    private int brand_idbrand;

    public VehicleModel() {
    }

    public VehicleModel(int idvehicle_models, String model_name, Date created_at, Date updated_at, Date deleted_at, int brand_idbrand) {
        this.idvehicle_models = idvehicle_models;
        this.model_name = model_name;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
        this.brand_idbrand = brand_idbrand;
    }

    public int getBrand_idbrand() {
        return brand_idbrand;
    }

    public void setBrand_idbrand(int brand_idbrand) {
        this.brand_idbrand = brand_idbrand;
    }

    public int getIdvehicle_models() {
        return idvehicle_models;
    }

    public void setIdvehicle_models(int idvehicle_models) {
        this.idvehicle_models = idvehicle_models;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
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
