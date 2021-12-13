package com.dagobah.apimonitoringequipment.model;

public class EquipmentStatus {

    public EquipmentStatus() {}

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    private String clientId;
    private String equipmentId;
    private String equipmentStatus;
    private String since;


    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentStatus() {
        return equipmentStatus;
    }

    public void setEquipmentStatus(String equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
    }

    public String getsince() {
        return since;
    }

    public void setsince(String since) {
        this.since = since;
    }


}