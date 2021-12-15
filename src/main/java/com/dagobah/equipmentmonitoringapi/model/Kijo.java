package com.dagobah.equipmentmonitoringapi.model;


public class Kijo {

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getKijo() {
        return kijo;
    }

    public void setKijo(String kijo) {
        this.kijo = kijo;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    private String owner;
    private String equipment;
    private String kijo;
    private String timeStamp;


    public Kijo(){};


}
