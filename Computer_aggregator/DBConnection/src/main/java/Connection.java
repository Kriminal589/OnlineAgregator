import org.flywaydb.core.Flyway;

public final class Connection {
    public static void initDB() {
        final DBInfo CREDS = new DBInfo();
        final Flyway flyway = Flyway
                .configure()
                .dataSource(
                        CREDS.url(),
                        CREDS.login(),
                        CREDS.password()
                )
                .locations("migrations")
                .load();
        flyway.migrate();
    }
}
