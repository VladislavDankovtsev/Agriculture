package ru.dankovtsev.agriculture.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.dankovtsev.agriculture.model.SoilMoisture;
import ru.dankovtsev.agriculture.model.TemperatureAndHumidity;
import ru.dankovtsev.agriculture.uuid.UUIDRandom;

import java.time.LocalDateTime;

import static ru.dankovtsev.agriculture.other.UrlSmartCityModule.URL_SOIL_MOISTURE_ONLINE;
import static ru.dankovtsev.agriculture.other.UrlSmartCityModule.URL_TEMPERATURE_AND_HUMIDITY_ONLINE;

@Service
public class AgricultureClientForArduino {
    @Autowired
    UUIDRandom uuidRandom;

    public SoilMoisture onlineSoilMoisture() {
        //HttpEntity<Agriculture> entity = new HttpEntity<Agriculture>();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SoilMoisture> responseEntity = restTemplate.getForEntity(URL_SOIL_MOISTURE_ONLINE,
                SoilMoisture.class);
        responseEntity.getBody().setId(uuidRandom.randomkey());
        responseEntity.getBody().setTime(LocalDateTime.now());
        System.out.println(responseEntity.getBody().toString());
        return responseEntity.getBody();
    }

    public TemperatureAndHumidity onlineTemperatureAndHumidity() {
        //HttpEntity<Agriculture> entity = new HttpEntity<Agriculture>();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TemperatureAndHumidity> responseEntity = restTemplate.getForEntity(URL_TEMPERATURE_AND_HUMIDITY_ONLINE,
                TemperatureAndHumidity.class);
        responseEntity.getBody().setId(uuidRandom.randomkey());
        responseEntity.getBody().setTime(LocalDateTime.now());
        System.out.println(responseEntity.getBody().toString());
        return responseEntity.getBody();
    }
}
