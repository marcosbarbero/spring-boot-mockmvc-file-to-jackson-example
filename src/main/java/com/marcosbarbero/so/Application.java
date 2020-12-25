package com.marcosbarbero.so;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    public static class PersonController {

        private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

        @PostMapping("/person")
        public ResponseEntity<Person> post(@RequestBody Person person) {
            logger.info("Person first-name: {}, last-name: {}, things: {}", person.getFirstName(), person.getLastName(), person.getThings());
            return ResponseEntity.ok(person);
        }
    }

    public static class Person {

        private String firstName;
        private String lastName;
        private List<String> things;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public List<String> getThings() {
            return things;
        }

        public void setThings(List<String> things) {
            this.things = things;
        }
    }
}
