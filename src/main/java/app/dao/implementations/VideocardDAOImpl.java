package app.dao.implementations;

import app.dao.interfaces.VideocardDAO;
import app.mappers.VideocardMapper;
import app.models.RAM;
import app.models.Videocard;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VideocardDAOImpl extends DAOImpl<Videocard> implements VideocardDAO {

    private final Connection connection;
    private final VideocardMapper mapper;

    public VideocardDAOImpl(Connection connection) {
        super(Videocard::new);
        this.connection = connection;
        this.mapper = new VideocardMapper();
    }

    @Override
    public Videocard findByMemory(@NotNull String memory) {
        try {
            Videocard videocard = null;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM videocard WHERE memory = ?");

            statement.setString(1, memory);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                videocard = mapper.toModel(resultSet);
            }

            return videocard;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
