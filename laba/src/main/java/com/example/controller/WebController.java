package com.example.controller;

import com.example.model.Person;
import com.example.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    private final PersonService service;

    public WebController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String listPeople(Model model) {
        model.addAttribute("people", service.getPeople());
        return "people";
    }

    @GetMapping("/person/{id}")
    public String personDetails(@PathVariable int id, Model model) {
        Person p = service.getPerson(id);
        model.addAttribute("person", p);
        return "person";
    }

    @GetMapping("/add")
    public String addPersonForm(Model model) {
        model.addAttribute("person", new Person());
        return "add";
    }

    @PostMapping("/add")
    public String addPersonSubmit(@ModelAttribute Person person) {
        service.addPerson(person);
        return "redirect:/";
    }
}
