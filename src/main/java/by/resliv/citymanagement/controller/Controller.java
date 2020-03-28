package by.resliv.citymanagement.controller;

import org.springframework.http.ResponseEntity;

public interface Controller<T> {
    String PRODUCES = "application/json";
    String CONSUMES = PRODUCES;

    ResponseEntity<T> read(String name);
}
