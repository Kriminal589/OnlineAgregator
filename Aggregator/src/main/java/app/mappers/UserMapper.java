package app.mappers;

import app.models.User;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserMapper {
    public @NotNull User toUser(@NotNull ResultSet resultSetUser) throws SQLException {
        User user = toModel(resultSetUser);

        return user;
    }

    private @NotNull User toModel(@NotNull ResultSet resultSetUser) throws SQLException {
        User user = new User();

        user.setId(resultSetUser.getLong("id"));
        user.setEmail(resultSetUser.getString("email"));
        user.setPassword(resultSetUser.getString("password"));

        return user;
    }
}
