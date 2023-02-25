package app.service;

import app.config.Components;
import app.dao.implementations.PowerSupplyDAOImpl;
import app.models.PowerSupply;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class PowerSupplyService extends ServiceModule<PowerSupply> {
    private final PowerSupplyDAOImpl powerSupplyDAO;

    public PowerSupplyService() throws SQLException {
        super(PowerSupply::new);
        powerSupplyDAO = (PowerSupplyDAOImpl) Components.powerSupplyDAO();
    }

    @NotNull
    public String search(String power, @NotNull String dbName) {
        return Components.gson().toJson(powerSupplyDAO.findByPower(power));
    }

}
