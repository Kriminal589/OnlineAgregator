package app.service;

import app.config.Components;
import app.config.ConfigDB;
import app.dao.implementations.ProcessorDAOImpl;
import app.models.Processor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ProcessorService extends ServiceModule<Processor> {
    private final ProcessorDAOImpl processorDAO;

    public ProcessorService() throws SQLException {
        super(Processor::new);
        processorDAO = (ProcessorDAOImpl) Components.processorDAO();
    }

    @NotNull
    public String search(Integer core, String socket, @NotNull String dbName) throws SQLException {
        if (core == null && socket == null) {
            return Components.gson().toJson(processorDAO.findAll(ConfigDB.connection(), dbName));
        } else if (core == null) {
            return Components.gson().toJson(processorDAO.findBySocket(socket));
        } else if (socket == null) {
            return Components.gson().toJson(processorDAO.findByCore(core));
        }
    }
}
