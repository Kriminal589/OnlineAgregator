package app.dao.implementations;

import app.dao.interfaces.RomDAO;
import app.mappers.RomMapper;
import app.models.ROM;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RomDAOImpl extends DAOImpl<ROM> implements RomDAO {

    private final Connection connection;
    private final RomMapper mapper;

    public RomDAOImpl(Connection connection) {
        super(ROM::new);
        this.connection = connection;
        this.mapper = new RomMapper();
    }

    @Override
    public ROM findByMemory(@NotNull String memory) {
        try {
            ROM rom = null;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM rom WHERE memory = ?");

            statement.setString(1, memory);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                rom = mapper.toModel(resultSet);
            }

            return rom;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ROM findByType(@NotNull String type) {
        try {
            ROM rom = null;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM rom WHERE type = ?");

            statement.setString(1, type);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                rom = mapper.toModel(resultSet);
            }

            return rom;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
