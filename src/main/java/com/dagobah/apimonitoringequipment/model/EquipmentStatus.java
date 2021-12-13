package com.dagobah.apimonitoringequipment.model;

public class EquipmentStatus {



    private String clientId;
    private String equipmentId;
    private String equipmentStatus;
    private String since;

    public EquipmentStatus() {}

    public String getEquipmentId() { return equipmentId; }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
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