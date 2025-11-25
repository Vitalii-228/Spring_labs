package com.example.rest;

import com.example.model.Person;
import com.example.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonRestController {

    private final PersonService service;

    public PersonRestController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public List<Person> getPeople() {
        return service.getPeople();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id) {
        Person person = service.getPerson(id);
        if (person == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(person);
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        service.addPerson(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable int id, @RequestBody Person person) {
        if (id < 0 || id >= service.getPeople().size()) {
            return ResponseEntity.notFound().build();
        }
        service.setPerson(id, person);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable int id) {
        if (id < 0 || id >= service.getPeople().size()) {
            return ResponseEntity.notFound().build();
        }
        service.removePerson(id);
        return ResponseEntity.ok().build();
    }
}
