package app.service;

import app.config.Components;
import app.config.ConfigDB;
import app.dao.implementations.DAOImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Supplier;

public class ServiceModule<T> {
    private T obj = null;
    private List<T> all;
    private ApplicationContext applicationContext;

    public Class<?> getParamOfClass() {
        return obj.getClass();
    }

    public ServiceModule(@NotNull Supplier<? extends T> supplier) {
        obj = supplier.get();
    }

    public String findById(@NotNull Long id, @NotNull String dbName) throws SQLException {
        DAOImpl<?> dao = applicationContext.getBean(obj.getClass().getSimpleName(), DAOImpl.class);
        return Components.gson().toJson(dao.findById(ConfigDB.connection(), dbName, id));
    }

    public String findByName(@NotNull String name, @NotNull String dbName) throws SQLException {
        DAOImpl<?> dao = applicationContext.getBean(obj.getClass().getSimpleName(), DAOImpl.class);
        return Components.gson().toJson(dao.findByName(ConfigDB.connection(), dbName, name));
    }

    public String findByPrice(@NotNull Double min, @NotNull Double max, @NotNull String dbName) throws SQLException {
        DAOImpl<?> dao = applicationContext.getBean(obj.getClass().getSimpleName(), DAOImpl.class);
        return Components.gson().toJson(dao.findByCost(ConfigDB.connection(), dbName, min, max));
    }

    public String findAll(@NotNull String dbName) throws SQLException {
        DAOImpl<?> dao = applicationContext.getBean(obj.getClass().getSimpleName(), DAOImpl.class);
        return Components.gson().toJson(dao.findAll(ConfigDB.connection(), dbName));
    }
}
