package by.resliv.citymanagement.dao;

import by.resliv.citymanagement.entity.City;
import by.resliv.citymanagement.exception.DaoException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class CityDao implements DaoInterface<City> {
    private static final String NAME;
    private static final String ID;
    private static final String INFORMATION;
    private static final String INSERT_QUERY;
    private static final String SELECT_QUERY_BY_NAME;
    private static final String SELECT_QUERY_BY_ID;
    private static final String UPDATE_QUERY;
    private static final String DELETE_QUERY;

    static {
        NAME = "name";
        ID = "id";
        INFORMATION = "information";
        INSERT_QUERY = "INSERT INTO City (name, information) VALUES (:name, :information)";
        SELECT_QUERY_BY_NAME = "SELECT c FROM City c WHERE c.name=:name";
        SELECT_QUERY_BY_ID = "SELECT c FROM City c WHERE c.id=:id";
        UPDATE_QUERY = "UPDATE City SET name=:name, information=:information WHERE id=:id";
        DELETE_QUERY = "DELETE FROM City c WHERE c.id=:id";
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            rollbackFor = DaoException.class)
    @Modifying
    public City create(City city) throws DaoException {
        City result;
        try {
            entityManager.createNativeQuery(INSERT_QUERY).
                    setParameter(NAME, city.getName()).
                    setParameter(INFORMATION, city.getInformation()).
                    executeUpdate();
            result = read(SELECT_QUERY_BY_NAME, NAME, city.getName());
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    public City read(String name) throws DaoException {
        return read(SELECT_QUERY_BY_NAME, NAME, name);
    }

    @Override
    public City read(long id) throws DaoException {
        return read(SELECT_QUERY_BY_ID, ID, id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            rollbackFor = DaoException.class)
    @Modifying
    public City update(City city) throws DaoException {
        City result;
        try {
            entityManager.createNativeQuery(UPDATE_QUERY).
                    setParameter(NAME, city.getName()).
                    setParameter(INFORMATION, city.getInformation()).
                    setParameter(ID, city.getId()).
                    executeUpdate();
            city = read(SELECT_QUERY_BY_ID, ID, city.getId());
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return city;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            rollbackFor = DaoException.class)
    @Modifying
    public City delete(long id) throws DaoException {
        City city = read(SELECT_QUERY_BY_ID, ID, id);
        try {
            entityManager.createNativeQuery(DELETE_QUERY).
                    setParameter(ID, id).
                    executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return city;
    }

    private City read(String query, String parameter, Object value) throws DaoException {
        City city;
        try {
            Query q = entityManager.
                    createQuery(query).
                    setParameter(parameter, value);
            city = (City) q.getSingleResult();
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return city;
    }
}
