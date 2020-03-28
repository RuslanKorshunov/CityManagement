package by.resliv.citymanagement.service.city;

import by.resliv.citymanagement.entity.City;
import by.resliv.citymanagement.exception.ServiceException;

public interface CityServiceInterface extends ServiceInterface<City> {
    City read(String name) throws ServiceException;
}
