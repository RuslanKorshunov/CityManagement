package by.resliv.citymanagement.dao;

import by.resliv.citymanagement.entity.City;
import by.resliv.citymanagement.exception.DaoException;

public interface CityDaoInterface extends DaoInterface<City> {
    City readByName(String name) throws DaoException;
}
