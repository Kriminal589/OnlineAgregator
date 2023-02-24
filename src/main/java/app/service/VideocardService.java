package app.service;

import app.config.Components;
import app.dao.implementations.ProcessorDAOImpl;
import app.models.Videocard;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class VideocardService extends ServiceModule<Videocard> {
    private final ProcessorDAOImpl processorDAO;

    public VideocardService() throws SQLException {
        super(Videocard::new);
        processorDAO = (ProcessorDAOImpl) Components.processorDAO();
    }

    @NotNull
    public String search(String core, String socket, @NotNull String dbName) {
        return "";
    }
}
