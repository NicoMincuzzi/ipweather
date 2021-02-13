package com.nmincuzzi.ipweather.java.controller;

import com.nmincuzzi.ipweather.java.model.LocaleModel;
import com.nmincuzzi.ipweather.model.WeatherModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
class LocaleController {

    @GetMapping("/book_java")
    public void bookJava(@RequestParam(value = "author") String name) {
        WeatherModel bookModel = new WeatherModel(UUID.randomUUID().toString(), "Il visconte dimezzato", "Italo Calvini", 1935);
        System.out.println("Book " + bookModel.getId() + " with name " + bookModel.getTitle());

        LocaleModel localeModel = new LocaleModel("1", "Nicola");
        System.out.println("User" + localeModel.getId() + " with name " + localeModel.getName());
    }
}