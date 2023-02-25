package app.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Configuration;

import static app.DBConstants.*;


@Configuration
public class InitializationDB {
    public static void init() {
        final Flyway flyway = Flyway.configure()
                .dataSource(
                        "jdbc:mysql://" + DB_HOST + ":" + PORT + "/" + DB_NAME,
                        USER,
                        PASSWORD
                )
                .locations("db")
                .load();
        flyway.migrate();
    }
}

