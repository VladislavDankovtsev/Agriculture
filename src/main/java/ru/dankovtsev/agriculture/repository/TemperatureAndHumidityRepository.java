package ru.dankovtsev.agriculture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dankovtsev.agriculture.model.TemperatureAndHumidity;

import java.util.UUID;

@Repository
public interface TemperatureAndHumidityRepository extends JpaRepository<TemperatureAndHumidity, UUID> {
}
