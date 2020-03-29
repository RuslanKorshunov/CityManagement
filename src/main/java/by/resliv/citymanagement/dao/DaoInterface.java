package by.resliv.citymanagement.dao;

import by.resliv.citymanagement.exception.DaoException;

public interface DaoInterface<T> {
    T read(long id) throws DaoException;

    T delete(long id) throws DaoException;
}
