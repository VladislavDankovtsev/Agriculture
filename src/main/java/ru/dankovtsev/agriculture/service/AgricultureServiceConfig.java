package ru.dankovtsev.agriculture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.dankovtsev.agriculture.model.Agriculture;
import ru.dankovtsev.agriculture.model.SoilMoisture;
import ru.dankovtsev.agriculture.model.TemperatureAndHumidity;
import ru.dankovtsev.agriculture.repository.AgriculureRepository;
import ru.dankovtsev.agriculture.repository.SoilMoistureRepository;
import ru.dankovtsev.agriculture.repository.TemperatureAndHumidityRepository;

@Configuration
@EnableScheduling
public class AgricultureServiceConfig {
    public static Agriculture agriculture;

    @Autowired
    private AgricultureService agricultureService;

    @Autowired
    private AgriculureRepository agriculureRepository;
    @Autowired
    private SoilMoistureRepository soilMoistureRepository;
    @Autowired
    private TemperatureAndHumidityRepository temperatureAndHumidityRepository;

    @Scheduled(fixedDelay = 10000)
    public void scheduleFixinformationinBD() {
        try{
        agriculture = agricultureService.onlineSystem();
        SoilMoisture soilMoisture = agriculture.getSoilMoisture();
        TemperatureAndHumidity temperatureAndHumidity = agriculture.getTemperatureAndHumidity();
        if (soilMoisture!=null){
            soilMoistureRepository.save(soilMoisture);
        }
        if (temperatureAndHumidity!=null){
            temperatureAndHumidityRepository.save(temperatureAndHumidity);
        }
        if (agriculture!=null){
            agriculureRepository.save(agriculture);
        }
        System.out.println("SAVE");}
        catch (Exception e){
            System.out.println("нет соединения с arduino");
        }
    }

    public Agriculture getAgriculture(){
        return agriculture;
    }

}
