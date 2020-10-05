package models;

import java.util.Date;

public class Contract {

    private int idcontract;
    private Date contract_date;
    private Date contract_cancel_date;
    private int penalty;
    private String payment_type;
    private double contract_value;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    public Contract() {
    }

    public Contract(int idcontract, Date contract_date, Date contract_cancel_date, int penalty, String payment_type, double contract_value, Date created_at, Date updated_at, Date deleted_at) {
        this.idcontract = idcontract;
        this.contract_date = contract_date;
        this.contract_cancel_date = contract_cancel_date;
        this.penalty = penalty;
        this.payment_type = payment_type;
        this.contract_value = contract_value;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }

    public int getIdcontract() {
        return idcontract;
    }

    public void setIdcontract(int idcontract) {
        this.idcontract = idcontract;
    }

    public Date getContract_date() {
        return contract_date;
    }

    public void setContract_date(Date contract_date) {
        this.contract_date = contract_date;
    }

    public Date getContract_cancel_date() {
        return contract_cancel_date;
    }

    public void setContract_cancel_date(Date contract_cancel_date) {
        this.contract_cancel_date = contract_cancel_date;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public double getContract_value() {
        return contract_value;
    }

    public void setContract_value(double contract_value) {
        this.contract_value = contract_value;
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
