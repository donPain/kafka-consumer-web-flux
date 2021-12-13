package com.dagobah.apimonitoringequipment.model;


public class Kijo {

    @Override
    public String toString() {
        return "Kijo{" +
                "kijoClientId='" + kijoClientId + '\'' +
                ", kijoEquipmentId='" + kijoEquipmentId + '\'' +
                ", kijoString='" + kijoString + '\'' +
                '}';
    }

    private String kijoClientId;
    private String kijoEquipmentId;
    private String kijoString;

    public Kijo(){};

    public String getKijoClientId() {
        return kijoClientId;
    }

    public void setKijoClientId(String kijoClientId) {
        this.kijoClientId = kijoClientId;
    }

    public String getKijoEquipmentId() {
        return kijoEquipmentId;
    }

    public void setKijoEquipmentId(String kijoEquipmentId) {
        this.kijoEquipmentId = kijoEquipmentId;
    }

    public String getKijoString() {
        return kijoString;
    }

    public void setKijoString(String kijoString) {
        this.kijoString = kijoString;
    }


}
