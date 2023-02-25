package app.service;

import app.config.Components;
import app.config.ConfigDB;
import app.dao.implementations.ProcessorDAOImpl;
import app.dao.implementations.VideocardDAOImpl;
import app.models.Videocard;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class VideocardService extends ServiceModule<Videocard> {
    private final VideocardDAOImpl videocardDAO;

    public VideocardService() throws SQLException {
        super(Videocard::new);
        videocardDAO = (VideocardDAOImpl) Components.videocardDAO();
    }

    @NotNull
    public String search(String frequency, String memory, @NotNull String dbName) throws SQLException {
        if (frequency == null && memory == null) {
            return Components.gson().toJson(videocardDAO.findAll(ConfigDB.connection(), dbName));
        } else if (frequency == null) {
            return Components.gson().toJson(videocardDAO.findByMemory(memory));
        } else if (memory == null) {
            return Components.gson().toJson(videocardDAO.findByFrequency(frequency));
        } else {
            return Components.gson().toJson(videocardDAO.findByMemoryAndFrequency(memory, frequency));
        }
    }
}
