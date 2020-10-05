package models;

import java.util.Date;

public class Responsibility {

    private int idresponsibility;
    private String sector;
    private Date hiring_date;
    private Date firing_date;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    public Responsibility() {
    }

    public Responsibility(int idresponsibility, String sector, Date hiring_date, Date firing_date, Date created_at, Date updated_at, Date deleted_at) {
        this.idresponsibility = idresponsibility;
        this.sector = sector;
        this.hiring_date = hiring_date;
        this.firing_date = firing_date;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }

    public int getIdresponsibility() {
        return idresponsibility;
    }

    public void setIdresponsibility(int idresponsibility) {
        this.idresponsibility = idresponsibility;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Date getHiring_date() {
        return hiring_date;
    }

    public void setHiring_date(Date hiring_date) {
        this.hiring_date = hiring_date;
    }

    public Date getFiring_date() {
        return firing_date;
    }

    public void setFiring_date(Date firing_date) {
        this.firing_date = firing_date;
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
