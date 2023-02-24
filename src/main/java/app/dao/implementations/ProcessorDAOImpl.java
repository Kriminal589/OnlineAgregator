package app.dao.implementations;

import app.dao.interfaces.ProcessorDAO;
import app.mappers.ProcessorMapper;
import app.models.Processor;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcessorDAOImpl extends DAOImpl<Processor> implements ProcessorDAO {

    private final Connection connection;
    private final ProcessorMapper mapper;

    public ProcessorDAOImpl(Connection connection) {
        super(Processor::new);
        this.connection = connection;
        this.mapper = new ProcessorMapper();
    }

    @Override
    public Processor findByCore(@NotNull Integer core) {
        try {
            Processor processor = null;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM processor WHERE core = ?");

            statement.setInt(1, core);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                processor = mapper.toModel(resultSet);
            }

            return processor;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Processor findBySocket(@NotNull String socket) {
        try {
            Processor processor = null;
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM processor WHERE socket = ?");

            statement.setString(1, socket);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                processor = mapper.toModel(resultSet);
            }

            return processor;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
