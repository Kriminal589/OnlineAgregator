package app.dao.implementations;

import app.dao.interfaces.RamDao;
import app.mappers.RamMapper;
import app.models.RAM;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RamDAOImpl extends DAOImpl<RAM> implements RamDao {

    private final Connection connection;
    private final RamMapper mapper;
    private final List<RAM> all;

    public RamDAOImpl(Connection connection) {
        super(RAM::new);
        this.connection = connection;
        this.mapper = new RamMapper();
        this.all = new ArrayList<>();
    }

    @Override
    public List<RAM> findByMemory(@NotNull String memory) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ram WHERE memory = ?");

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
    public List<RAM> findByType(@NotNull String type) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ram WHERE type = ?");

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
    public List<RAM> findByFrequencyAndType(@NotNull String frequency, @NotNull String type) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ram WHERE " +
                    "(type = ?) AND (frequency = ?)");

            statement.setString(1, type);
            statement.setString(2, frequency);
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
    public List<RAM> findByFrequencyAndMemory(@NotNull String frequency, @NotNull String memory) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ram WHERE " +
                    "(memory = ?) AND (frequency = ?)");

            statement.setString(1, memory);
            statement.setString(2, frequency);
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
    public List<RAM> findByTypeAndMemory(@NotNull String type, @NotNull String memory) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ram WHERE " +
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

    @Override
    public List<RAM> search(@NotNull String frequency, @NotNull String type, @NotNull String memory) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ram WHERE " +
                    "(type = ?) AND (memory = ?) AND (frequency = ?)");

            statement.setString(1, type);
            statement.setString(2, memory);
            statement.setString(3, frequency);
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
    public List<RAM> findByFrequency(@NotNull String frequency) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ram WHERE frequency = ?");

            statement.setString(1, frequency);
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
