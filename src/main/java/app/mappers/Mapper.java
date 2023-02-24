package app.mappers;

import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<T> {
    T toModel(@NotNull ResultSet resultSet) throws SQLException;
}
