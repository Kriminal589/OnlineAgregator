package app.dao.implementations;

import app.config.ApplicationConfiguration;
import app.dao.interfaces.Dao;
import app.config.Mapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class DAOImpl<T> implements Dao<T> {
    private T obj;
    private final List<T> all;
    private final ConfigurableApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

    public DAOImpl(@NotNull Supplier<? extends T> supplier) {
        obj = supplier.get();
        all = new ArrayList<>();
    }

    @Override
    public T findById(@NotNull Connection connection, @NotNull String dbName, @NotNull Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + dbName + " WHERE id = ?");

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Mapper<?> mapper = applicationContext.getBean(obj.getClass().getSimpleName(), Mapper.class);
                obj = (T) mapper.toModel(resultSet);
            }

            return obj;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T findByName(@NotNull Connection connection, @NotNull String dbName, @NotNull String name) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + dbName + " WHERE name = ?");

            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Mapper<?> mapper = applicationContext.getBean(obj.getClass().getSimpleName(), Mapper.class);
                obj = (T) mapper.toModel(resultSet);
            }

            return obj;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> findByCost(@NotNull Connection connection,
                        @NotNull String dbName,
                        @NotNull Double min,
                        @NotNull Double max) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + dbName + " WHERE " +
                    "(cost >= ?) AND (cost <= ?)");

            statement.setDouble(1, min);
            statement.setDouble(2, max);
            ResultSet resultSet = statement.executeQuery();
            Mapper<?> mapper = applicationContext.getBean(obj.getClass().getSimpleName(), Mapper.class);

            while (resultSet.next()) {
                all.add((T) mapper.toModel(resultSet));
            }

            return all;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> findAll(@NotNull Connection connection, @NotNull String dbName) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + dbName);
            ResultSet resultSet = statement.executeQuery();
            Mapper<?> mapper = applicationContext.getBean(obj.getClass().getSimpleName(), Mapper.class);

            while (resultSet.next()) {
                all.add((T) mapper.toModel(resultSet));
            }

            return all;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
