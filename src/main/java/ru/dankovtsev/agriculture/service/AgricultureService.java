package ru.dankovtsev.agriculture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public Agriculture onlineSystem(){
        SoilMoisture soilMoisture = new SoilMoisture();
        soilMoisture.setId(uuidRandom.randomkey());
        soilMoisture.setTime(LocalDateTime.now());
        String humidity = String.valueOf((int) Math.random()*100);
        soilMoisture.setHumidity(humidity);
        soilMoisture.setWater(false);

        TemperatureAndHumidity temperatureAndHumidity = new TemperatureAndHumidity();
        temperatureAndHumidity.setId(uuidRandom.randomkey());
        temperatureAndHumidity.setTime(LocalDateTime.now());
        temperatureAndHumidity.setFan(false);
        temperatureAndHumidity.setHeatingElement(false);
        temperatureAndHumidity.setHumidity(humidity);
        String temp = String.valueOf((int) Math.random()*30);
        temperatureAndHumidity.setTemperature(temp);

        Agriculture agriculture = new Agriculture();
        agriculture.setId(uuidRandom.randomkey());
        agriculture.setTime(LocalDateTime.now());
        agriculture.setSoilMoisture(soilMoisture);
        agriculture.setTemperatureAndHumidity(temperatureAndHumidity);
        return agriculture;
    }


}
