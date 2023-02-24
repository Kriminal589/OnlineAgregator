package app.dao.interfaces;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

@Repository
public interface Dao<T> {
    T findById(@NotNull Connection connection, @NotNull String dbName, @NotNull Long id);
    T findByName(@NotNull Connection connection, @NotNull String dbName, @NotNull String name);
    T findByCost(@NotNull Connection connection, @NotNull String dbName, @NotNull Double min, @NotNull Double max);

    List<T> findAll(@NotNull Connection connection, @NotNull String dbName);
}