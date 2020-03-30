package ru.dankovtsev.agriculture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dankovtsev.agriculture.client.AgricultureClientForArduino;
import ru.dankovtsev.agriculture.model.Agriculture;
import ru.dankovtsev.agriculture.model.SoilMoisture;
import ru.dankovtsev.agriculture.model.TemperatureAndHumidity;
import ru.dankovtsev.agriculture.uuid.UUIDRandom;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class AgricultureService {

    @Autowired
    UUIDRandom uuidRandom;
    @Autowired
    AgricultureClientForArduino agricultureClientForArduino;

    public Agriculture onlineSystem(){
        Agriculture agriculture = new Agriculture();
        agriculture.setId(uuidRandom.randomkey());
        agriculture.setTime(LocalDateTime.now());
        SoilMoisture soilMoisture = new SoilMoisture();
        soilMoisture = agricultureClientForArduino.onlineSoilMoisture();
        agriculture.setSoilMoisture(soilMoisture);
        TemperatureAndHumidity temperatureAndHumidity =new TemperatureAndHumidity();
        temperatureAndHumidity = agricultureClientForArduino.onlineTemperatureAndHumidity();
        agriculture.setTemperatureAndHumidity(temperatureAndHumidity);
        return agriculture;
    }


}
