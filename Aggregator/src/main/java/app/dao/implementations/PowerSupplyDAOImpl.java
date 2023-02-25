package app.dao.implementations;

import app.dao.interfaces.PowerSupplyDAO;
import app.mappers.PowerSupplyMapper;
import app.models.PowerSupply;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PowerSupplyDAOImpl extends DAOImpl<PowerSupply> implements PowerSupplyDAO {

    private final Connection connection;
    private final PowerSupplyMapper mapper;
    private final List<PowerSupply> all;

    public PowerSupplyDAOImpl(Connection connection) {
        super(PowerSupply::new);
        this.connection = connection;
        this.mapper = new PowerSupplyMapper();
        this.all = new ArrayList<>();
    }

    @Override
    public List<PowerSupply> findByPower(@NotNull String power) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM power_supply WHERE power = ?");

            statement.setString(1, power);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                all.add(mapper.toModel(resultSet));
            }

            return all;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
