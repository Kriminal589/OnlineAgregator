package app.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
@ComponentScan
public interface Mapper<T> {
    T toModel(@NotNull ResultSet resultSet) throws SQLException;
}
