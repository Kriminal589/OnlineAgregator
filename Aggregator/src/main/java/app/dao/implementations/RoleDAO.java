package app.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAO {
    private final Connection connection;

    public RoleDAO(Connection connection) {
        this.connection = connection;
    }

    public ResultSet findByIdUser(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM role WHERE id_user = ?");

            statement.setLong(1, id);
            return statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
