package ru.dankovtsev.agriculture.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dankovtsev.agriculture.model.Agriculture;
import ru.dankovtsev.agriculture.repository.AgriculureRepository;
import ru.dankovtsev.agriculture.service.AgricultureService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agricalture")
public class AgricultureController {
    //@Autowired
    //private AgriculureRepository agriculureRepository;

    @Autowired
    private AgricultureService agricultureService;


    @RequestMapping(path = "/online", method = RequestMethod.GET)
    public Agriculture getAgricultureNow(){

        //List<Agriculture> agricultureList = agriculureRepository.findAll();
        return agricultureService.onlineSystem();
    }

}

