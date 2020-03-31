package ru.dankovtsev.agriculture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dankovtsev.agriculture.model.SoilMoisture;

import java.util.UUID;

@Repository
public interface SoilMoistureRepository extends JpaRepository<SoilMoisture, UUID> {
}
