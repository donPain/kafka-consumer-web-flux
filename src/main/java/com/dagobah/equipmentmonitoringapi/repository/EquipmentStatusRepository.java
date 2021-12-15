package com.dagobah.equipmentmonitoringapi.repository;

import com.dagobah.equipmentmonitoringapi.model.EquipmentStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EquipmentStatusRepository extends JpaRepository<EquipmentStatus, String> {

    @Query("SELECT EquipmentStatus FROM EquipmentStatus EquipmentStatus where EquipmentStatus.owner = :owner")
    List<EquipmentStatus> findByClientId(@Param("owner") String owner);

}
