package app.service;

import app.config.Components;
import app.config.ComponentsDAO;
import app.config.ConfigDB;
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
        romDAO = (RomDAOImpl) ComponentsDAO.romDAO();
    }

    @NotNull
    public String search(String type, String memory, @NotNull String dbName) throws SQLException {
        if (type == null && memory == null) {
            return Components.gson().toJson(romDAO.findAll(ConfigDB.connection(), dbName));
        } else if (type == null) {
            return Components.gson().toJson(romDAO.findByMemory(memory));
        } else if (memory == null) {
            return Components.gson().toJson(romDAO.findByType(type));
        } else {
            return Components.gson().toJson(romDAO.findByMemoryAndType(type, memory));
        }
    }
}
