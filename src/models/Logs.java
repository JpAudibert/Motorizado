package models;

public class Logs {

    private int idLogs;
    private String logType;
    private String origin;
    private String description;
    private int idFromOrigin;

    public Logs() {
    }

    public Logs(int idLogs, String logType, String origin, String description, int idFromOrigin) {
        this.idLogs = idLogs;
        this.logType = logType;
        this.origin = origin;
        this.description = description;
        this.idFromOrigin = idFromOrigin;
    }

    public int getIdLogs() {
        return idLogs;
    }

    public void setIdLogs(int idLogs) {
        this.idLogs = idLogs;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdFromOrigin() {
        return idFromOrigin;
    }

    public void setIdFromOrigin(int idFromOrigin) {
        this.idFromOrigin = idFromOrigin;
    }

}
