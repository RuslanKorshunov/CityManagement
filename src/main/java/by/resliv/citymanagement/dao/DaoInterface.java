package by.resliv.citymanagement.dao;

import by.resliv.citymanagement.exception.DaoException;

public interface DaoInterface<T> {
    T create(T t) throws DaoException;

    T read(long id) throws DaoException;

    T update(T t) throws DaoException;

    T delete(long id) throws DaoException;
}
