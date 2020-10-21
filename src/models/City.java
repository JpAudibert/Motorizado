package models;

public class City {

    private int idCity;
    private String name;
    private int state_idState;

    public City() {
    }

    public City(int idCity, String name, int state_idState) {
        this.idCity = idCity;
        this.name = name;
        this.state_idState = state_idState;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState_idState() {
        return state_idState;
    }

    public void setState_idState(int state_idState) {
        this.state_idState = state_idState;
    }

}
