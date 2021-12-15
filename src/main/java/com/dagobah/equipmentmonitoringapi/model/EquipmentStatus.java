package com.dagobah.equipmentmonitoringapi.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table
public class EquipmentStatus {

    public EquipmentStatus() {}

    @javax.persistence.Id
    private String equipmentStatusKey;

    @Column(name ="owner",nullable = false)
    private String owner;

    @Column(name ="equipment",nullable = false)
    private String equipment;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "since", nullable = false)
    private String since;

    public String getEquipmentStatusKey() {
        return equipmentStatusKey;
    }

    public void setEquipmentStatusKey(String equipmentStatusKey) {
        this.equipmentStatusKey = equipmentStatusKey;
    }

    public String getEquipment() { return equipment; }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String clientId) {
        this.owner = clientId;
    }

    public void setEquipmentId(String equipment) {
        this.equipment = equipment;
    }

    public String getEquipmentStatus() {
        return status;
    }

    public void setEquipmentStatus(String equipmentStatus) {
        this.status = equipmentStatus;
    }
    public String getSince() {return since;}

    public void setSince(String since) {this.since = since;}


}