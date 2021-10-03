package com.example.angularspringtest.repositories;

import com.example.angularspringtest.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface MongoRepo extends MongoRepository<Employee, UUID> {
}
