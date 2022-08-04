package com.example.demo2.controller;

import com.example.demo2.model.City;
import com.example.demo2.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CityController {
    @Autowired
    CityRepository cityRepository;

    @GetMapping
    String cities(Model model) {
        List<City> cities = cityRepository.findAll();
        model.addAttribute("cities", cities);
        return "cities";
    }

    @GetMapping("delete-city")
    String delete(int id) {
        cityRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("create-city")
    String create() {

        return "create-city";
    }

    @PostMapping("create-city")
    String create(City city) {
        cityRepository.save(city);
        return "redirect:/";
    }

    @GetMapping("update-city")
    String update(Model model, int id) {
        City city = cityRepository.findById(id).get();
        model.addAttribute("city", city);
        return "update-city";
    }

    @PostMapping("update-city")
    String update(City city) {
        cityRepository.save(city);
        return "redirect:/";
    }
}