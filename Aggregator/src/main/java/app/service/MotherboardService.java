package app.service;

import app.config.Components;
import app.config.ComponentsDAO;
import app.config.ConfigDB;
import app.dao.implementations.MotherboardDAOImpl;
import app.models.Motherboard;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MotherboardService extends ServiceModule<Motherboard> {
    private final MotherboardDAOImpl motherboardDAO;

    public MotherboardService() throws SQLException {
        super(Motherboard::new);
        motherboardDAO = (MotherboardDAOImpl) ComponentsDAO.motherboardDAO();
    }

    public String search(String socket, String size, @NotNull String dbName) throws SQLException {
        if (socket == null && size == null) {
            return Components.gson().toJson(motherboardDAO.findAll(ConfigDB.connection(), dbName));
        } else if (socket == null) {
            return Components.gson().toJson(motherboardDAO.findBySize(size));
        } else if (size == null) {
            return Components.gson().toJson(motherboardDAO.findBySocket(socket));
        } else {
            return Components.gson().toJson(motherboardDAO.findBySizeAndSocket(socket, size));
        }
    }
}
