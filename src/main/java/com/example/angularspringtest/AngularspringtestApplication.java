package com.example.angularspringtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class AngularspringtestApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AngularspringtestApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", 8088));
		app.run(args);
	}

//    @Bean
//    CommandLineRunner init(UserRepository userRepository) {
//        return args -> {
//            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
//                Person user = new Person(name, name, name.toLowerCase()+"@domain.com");
//                userRepository.save(user);
//            });
//            userRepository.findAll().forEach(System.out::println);
//        };
//    }

}
