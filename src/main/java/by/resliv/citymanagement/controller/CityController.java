package by.resliv.citymanagement.controller;

import by.resliv.citymanagement.entity.City;
import by.resliv.citymanagement.exception.ServiceException;
import by.resliv.citymanagement.service.city.CityServiceInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/city")
public class CityController implements Controller<City> {
    private static final Logger logger;

    static {
        logger = LogManager.getLogger();
    }

    @Autowired
    private CityServiceInterface service;

    @Override
    @GetMapping(value = "/{name}",
            produces = PRODUCES,
            consumes = CONSUMES)
    public ResponseEntity<City> read(@PathVariable("name") String name) {
        HttpStatus status = HttpStatus.OK;
        City city;
        try {
            city = service.read(name);
        } catch (ServiceException e) {
            logger.error(e);
            status = HttpStatus.BAD_REQUEST;
            city = new City();
        }
        return new ResponseEntity<>(city, status);
    }
}
