package app.dao.implementations;

import app.mappers.UserMapper;
import app.models.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {
    private final Connection connection;
    private final UserMapper userMapper;
    private List<User> all;

    public UserDAO(Connection connection) {
        this.connection = connection;
        this.userMapper = new UserMapper();
        this.all = null;
    }

    public @NotNull List<User> findAll() {
        all = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user");
            ResultSet resultSetUser = statement.executeQuery();

            while (resultSetUser.next()) {
                all.add(userMapper.toUser(resultSetUser));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return all;
    }

    public @NotNull User findById(Long id) {
        User user = new User();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE id = ?");

            statement.setLong(1, id);

            ResultSet resultSetUser = statement.executeQuery();

            while (resultSetUser.next()) {
                user = userMapper.toUser(resultSetUser);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    public User findByEmailAndPassword(@NotNull String email, @NotNull String password) {
        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user " +
                    "WHERE (email = ? AND password = ?)");

            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = userMapper.toUser(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    public User findByEmail(@NotNull String email) {
        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user " +
                    "WHERE email = ?");

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = userMapper.toUser(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    public int add(@NotNull String email, @NotNull String password) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO user(email, password) " +
                    "VALUES (?, ?)");

            statement.setString(1, email);
            statement.setString(2, password);

            statement.executeUpdate();

            User user = findByEmail(email);
            statement = connection.prepareStatement("INSERT INTO role(id_user, status) VALUES (?, ?)");

            statement.setLong(1, user.getId());
            statement.setString(2, "USER");

            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
