package app.service;

import app.config.Components;
import app.config.ConfigDB;
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
    public String search(String frequency, String type, String memory, @NotNull String dbName) throws SQLException {
        String result;

        if (frequency == null) {
            if (type == null) {
                if (memory == null) {
                    result = Components.gson().toJson(ramDAO.findAll(ConfigDB.connection(), dbName));
                } else {
                    result = Components.gson().toJson(ramDAO.findByMemory(memory));
                }
            } else {
                if (memory == null) {
                    result = Components.gson().toJson(ramDAO.findByType(type));
                } else {
                    result = Components.gson().toJson(ramDAO.findByTypeAndMemory(type, memory));
                }
            }
        } else {
            if (type == null) {
                if (memory == null) {
                    result = Components.gson().toJson(ramDAO.findByFrequency(frequency));
                } else {
                    result = Components.gson().toJson(ramDAO.findByFrequencyAndMemory(frequency, memory));
                }
            } else {
                if (memory == null) {
                    result = Components.gson().toJson(ramDAO.findByFrequencyAndType(frequency, type));
                } else {
                    result = Components.gson().toJson(ramDAO.search(frequency, type, memory));
                }
            }
        }

        return result;
    }
}
