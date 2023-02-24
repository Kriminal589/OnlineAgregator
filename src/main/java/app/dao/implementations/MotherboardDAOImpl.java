package app.dao.implementations;

import app.dao.interfaces.MotherboardDAO;
import app.mappers.MotherboardMapper;
import app.models.Motherboard;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Supplier;

public class MotherboardDAOImpl extends DAOImpl<Motherboard> implements MotherboardDAO {

    private final Connection connection;
    private final MotherboardMapper mapper;

    public MotherboardDAOImpl(Connection connection) {
        super(Motherboard::new);
        this.connection = connection;
        this.mapper = new MotherboardMapper();
    }

    @Override
    public Motherboard findBySocket(@NotNull String socket) {
        try {
            Motherboard motherboard = null;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM motherboard WHERE socket = ?");

            statement.setString(1, socket);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                motherboard = mapper.toModel(resultSet);
            }

            return motherboard;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Motherboard findBySize(@NotNull String size) {
        try {
            Motherboard motherboard = null;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM motherboard WHERE size = ?");

            statement.setString(1, size);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                motherboard = mapper.toModel(resultSet);
            }

            return motherboard;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
