package app.dao.implementations;

import app.dao.interfaces.MotherboardDAO;
import app.mappers.MotherboardMapper;
import app.models.Motherboard;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotherboardDAOImpl extends DAOImpl<Motherboard> implements MotherboardDAO {

    private final Connection connection;
    private final MotherboardMapper mapper;
    private final List<Motherboard> all;

    public MotherboardDAOImpl(Connection connection) {
        super(Motherboard::new);
        this.connection = connection;
        this.mapper = new MotherboardMapper();
        this.all = new ArrayList<>();
    }

    @Override
    public List<Motherboard> findBySocket(@NotNull String socket) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM motherboard WHERE socket = ?");

            statement.setString(1, socket);

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
    public List<Motherboard> findBySize(@NotNull String size) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM motherboard WHERE size_form = ?");

            statement.setString(1, size);

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
    public List<Motherboard> findBySizeAndSocket(@NotNull String socket, @NotNull String size) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM motherboard WHERE " +
                    "(size = ?) AND (socket = ?)");

            statement.setString(1, size);
            statement.setString(2, socket);

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
