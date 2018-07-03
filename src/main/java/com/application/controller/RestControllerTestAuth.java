package com.application.controller;

import com.application.map.Figure;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestControllerTestAuth {

    @RequestMapping("/showdata")
    public List<Figure> getFigures(){

        List<Figure> figures = new ArrayList<>();
        figures.add(new Figure("Kwadrat"));
        figures.add(new Figure("Koło"));
        figures.add(new Figure("Prostokat"));
        figures.add(new Figure("Trójkąt"));
        figures.add(new Figure("Trapez"));

        return figures;
    }

}
