package models;

public class State {

    private int idState;
    private String name;
    private String abreviation;

    public State() {
    }

    public State(int idState, String name, String abreviation) {
        this.idState = idState;
        this.name = name;
        this.abreviation = abreviation;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

}
