package de.tobi.springbootlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLearningApplication.class, args);
    }

}

//Simple Controller to return a String
//After starting the application, you can access it via http://localhost:8080/hello
@RestController
class HelloController {
    @GetMapping("/hello")
    String hello() {
        return "Hello Spring Boot!";
    }
}
