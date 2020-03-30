package ru.dankovtsev.agriculture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dankovtsev.agriculture.model.TemperatureAndHumidity;

import java.util.UUID;

public interface TemperatureAndHumidityRepository extends JpaRepository<TemperatureAndHumidity, UUID> {
}
