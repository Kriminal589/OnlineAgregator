package app.dao.implementations;

import app.dao.interfaces.VideocardDAO;
import app.mappers.VideocardMapper;
import app.models.Videocard;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideocardDAOImpl extends DAOImpl<Videocard> implements VideocardDAO {

    private final Connection connection;
    private final VideocardMapper mapper;
    private final List<Videocard> all;

    public VideocardDAOImpl(Connection connection) {
        super(Videocard::new);
        this.connection = connection;
        this.mapper = new VideocardMapper();
        this.all = new ArrayList<>();
    }

    @Override
    public List<Videocard> findByMemory(@NotNull String memory) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM videocard WHERE memory = ?");

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
}
