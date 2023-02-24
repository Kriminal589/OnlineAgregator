package app.dao.implementations;

import app.dao.interfaces.RamDao;
import app.mappers.RamMapper;
import app.models.RAM;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RamDAOImpl extends DAOImpl<RAM> implements RamDao {

    private final Connection connection;
    private final RamMapper mapper;

    public RamDAOImpl(Connection connection) {
        super(RAM::new);
        this.connection = connection;
        this.mapper = new RamMapper();
    }

    @Override
    public RAM findByMemory(@NotNull String memory) {
        try {
            RAM ram = null;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ram WHERE memory = ?");

            statement.setString(1, memory);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ram = mapper.toModel(resultSet);
            }

            return ram;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public RAM findByType(@NotNull String type) {
        try {
            RAM ram = null;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ram WHERE type = ?");

            statement.setString(1, type);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ram = mapper.toModel(resultSet);
            }

            return ram;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
