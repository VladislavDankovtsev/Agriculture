package ru.dankovtsev.agriculture.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.dankovtsev.agriculture.model.Agriculture;
import ru.dankovtsev.agriculture.model.CheckConnection;
import ru.dankovtsev.agriculture.service.AgricultureServiceConfig;

@RestController
@RequestMapping("/agricalture")
public class AgricultureController {

    @Autowired
    private AgricultureServiceConfig agricultureServiceConfig;


    @RequestMapping(path = "/online", method = RequestMethod.GET)
    public Agriculture getAgricultureNow(){

        return agricultureServiceConfig.getAgriculture();
    }

    @RequestMapping(path = "/check", method = RequestMethod.GET)
    public CheckConnection getAgricultureConnection(){
        CheckConnection checkConnection = new CheckConnection();
        checkConnection.setCheck("work");
        return checkConnection;
    }

}

