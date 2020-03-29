package by.resliv.citymanagement.controller;

import org.springframework.http.ResponseEntity;

public interface ControllerInterface<T> {
    String PRODUCES = "application/json";
    String CONSUMES = PRODUCES;

    ResponseEntity<T> read(String name);
}
