package app.service;

import app.config.Components;
import app.dao.implementations.RomDAOImpl;
import app.models.ROM;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class RomService extends ServiceModule<ROM> {
    private final RomDAOImpl romDAO;

    public RomService() throws SQLException {
        super(ROM::new);
        romDAO = (RomDAOImpl) Components.romDAO();
    }

    @NotNull
    public String search(String type, String memory, @NotNull String dbName) {
        return "";
    }
}
