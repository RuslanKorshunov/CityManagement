package by.resliv.citymanagement.dao;

import by.resliv.citymanagement.entity.City;
import by.resliv.citymanagement.exception.DaoException;

public interface CityDaoInterface extends DaoInterface<City> {
    City read(String name) throws DaoException;
}
