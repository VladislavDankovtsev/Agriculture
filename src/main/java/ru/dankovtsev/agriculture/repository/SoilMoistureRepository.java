package ru.dankovtsev.agriculture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dankovtsev.agriculture.model.SoilMoisture;

import java.util.UUID;

public interface SoilMoistureRepository extends JpaRepository<SoilMoisture, UUID> {
}
