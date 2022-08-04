package com.example.demo2.controller;

import com.example.demo2.model.City;
import com.example.demo2.model.Person;
import com.example.demo2.repository.CityRepository;
import com.example.demo2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    CityRepository cityRepository;

    @GetMapping("people")
    String people(Model model) {
        List<Person> people = personRepository.findAll();
        model.addAttribute("people", people);
        return "people";
    }

    @GetMapping("delete-person")
    String delete(int id) {
        personRepository.deleteById(id);
        return "redirect:people";
    }

    @GetMapping("create-person")
    String create(Model model) {
        List<City> cities = cityRepository.findAll();
        model.addAttribute("cities", cities);
        return "create-person";
    }

    @PostMapping("create-person")
    String create(Person person) {
        personRepository.save(person);
        return "redirect:people";
    }

    @GetMapping("update-person")
    String update(Model model, int id) {
        Person person = personRepository.findById(id).get();
        model.addAttribute("person", person);

        List<City> cities = cityRepository.findAll();
        model.addAttribute("cities", cities);
        return "update-person";
    }

    @PostMapping("update-person")
    String update(Person person) {
        personRepository.save(person);
        return "redirect:people";
    }
}