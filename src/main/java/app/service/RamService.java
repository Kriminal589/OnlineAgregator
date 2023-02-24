package app.service;

import app.config.Components;
import app.dao.implementations.RamDAOImpl;
import app.models.RAM;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class RamService extends ServiceModule<RAM> {
    private final RamDAOImpl ramDAO;

    public RamService() throws SQLException {
        super(RAM::new);
        ramDAO = (RamDAOImpl) Components.ramDao();
    }

    @NotNull
    public String search(String frequency,
                         String type,
                         String memory,
                         @NotNull String dbName) {
        return "";
    }
}
