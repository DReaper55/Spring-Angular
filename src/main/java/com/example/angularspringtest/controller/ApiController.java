package com.example.angularspringtest.controller;

import com.example.angularspringtest.models.Employee;
import com.example.angularspringtest.repositories.MongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private MongoRepo mongoRepo;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody Employee employee){
        Employee newEmployee = new Employee(UUID.randomUUID(), employee.getUsername(), employee.getPassword(), employee.getEmail());
        mongoRepo.save(newEmployee);
        return ResponseEntity.ok().body(newEmployee);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Employee> findUserById(@PathVariable(value = "id") UUID id){
        Optional<Employee> employee = mongoRepo.findById(id);
        return ResponseEntity.ok().body(employee.orElse(null));
    }

    @GetMapping("/users")
    public ResponseEntity<List<Employee>> getAllUsers(){
        List<Employee> employees = mongoRepo.findAll();
        return ResponseEntity.ok().body(employees);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Employee> updateUserByUsername(@PathVariable("id") UUID id, @RequestBody Employee newEmployee){
        Employee employee = mongoRepo.findById(id).get();
        mongoRepo.delete(employee);

        Employee recreate = new Employee(id, newEmployee.getUsername(), newEmployee.getPassword(), newEmployee.getEmail());
        mongoRepo.save(recreate);
        return ResponseEntity.ok().body(recreate);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") UUID id){
        Optional<Employee> employee = mongoRepo.findById(id);
        mongoRepo.delete(employee.get());
        return "Successfully deleted";
    }
}
