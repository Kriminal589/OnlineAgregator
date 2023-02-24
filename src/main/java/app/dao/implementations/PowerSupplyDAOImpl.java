package app.dao.implementations;

import app.dao.interfaces.PowerSupplyDAO;
import app.mappers.PowerSupplyMapper;
import app.models.PowerSupply;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PowerSupplyDAOImpl extends DAOImpl<PowerSupply> implements PowerSupplyDAO {

    private final Connection connection;
    private final PowerSupplyMapper mapper;

    public PowerSupplyDAOImpl(Connection connection) {
        super(PowerSupply::new);
        this.connection = connection;
        this.mapper = new PowerSupplyMapper();
    }

    @Override
    public PowerSupply findByPower(@NotNull String power) {
        try {
            PowerSupply powerSupply = null;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM power_supply WHERE power = ?");

            statement.setString(1, power);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                powerSupply = mapper.toModel(resultSet);
            }

            return powerSupply;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
