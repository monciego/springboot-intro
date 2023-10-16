package com.monciego;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public GreetingResponse greet() {
        GreetingResponse response = new GreetingResponse(
            "Hello",
            List.of("Golang", "Rust", "C++", "TypeScript"),
            new Person("Jericho", "jerichobantiquete@gmail.com", 23)
        );
        return response;
    }

    record Person (String name, String email, int age) {}

    record GreetingResponse(
        String greet,
        List<String> favProgrammingLanguages,
        Person person
    ){}
}
