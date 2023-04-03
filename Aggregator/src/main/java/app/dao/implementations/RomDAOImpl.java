package app.dao.implementations;

import app.dao.interfaces.RomDAO;
import app.mappers.RomMapper;
import app.models.ROM;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RomDAOImpl extends DAOImpl<ROM> implements RomDAO {

    private final Connection connection;
    private final RomMapper mapper;
    private final List<ROM> all;

    public RomDAOImpl(Connection connection) {
        super(ROM::new);
        this.connection = connection;
        this.mapper = new RomMapper();
        this.all = new ArrayList<>();
    }

    @Override
    public List<ROM> findByMemory(@NotNull String memory) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM rom WHERE memory = ?");

            statement.setString(1, memory);
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

    @Override
    public List<ROM> findByType(@NotNull String type) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM rom WHERE type = ?");

            statement.setString(1, type);
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

    @Override
    public List<ROM> findByMemoryAndType(@NotNull String type, @NotNull String memory) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM rom WHERE " +
                    "(type = ?) AND (memory = ?)");

            statement.setString(1, type);
            statement.setString(2, memory);
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
