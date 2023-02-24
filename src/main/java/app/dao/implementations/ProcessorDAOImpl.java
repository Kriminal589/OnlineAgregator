package app.dao.implementations;

import app.dao.interfaces.ProcessorDAO;
import app.mappers.ProcessorMapper;
import app.models.Processor;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcessorDAOImpl extends DAOImpl<Processor> implements ProcessorDAO {

    private final Connection connection;
    private final ProcessorMapper mapper;
    private final List<Processor> all;

    public ProcessorDAOImpl(Connection connection) {
        super(Processor::new);
        this.connection = connection;
        this.mapper = new ProcessorMapper();
        this.all = new ArrayList<>();
    }

    @Override
    public List<Processor> findByCore(@NotNull Integer core) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM processor WHERE core = ?");

            statement.setInt(1, core);
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
    public List<Processor> findBySocket(@NotNull String socket) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM processor WHERE socket = ?");

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
}
