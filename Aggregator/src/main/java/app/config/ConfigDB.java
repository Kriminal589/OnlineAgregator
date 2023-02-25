package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static app.DBConstants.*;

@Configuration
public class ConfigDB {

    @Bean
    @Scope("singleton")
    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://" + DB_HOST + ":" + PORT + "/" + DB_NAME,
                USER,
                PASSWORD
        );
    }
}
