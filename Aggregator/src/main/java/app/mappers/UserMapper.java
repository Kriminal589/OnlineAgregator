package app.mappers;

import app.models.User;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserMapper {
    public @NotNull User simpleUser(@NotNull ResultSet resultSetUser) throws SQLException {
        return toModel(resultSetUser);
    }

    public @NotNull User toUser(@NotNull ResultSet resultSetUser, @NotNull ResultSet resultSetRoles) throws SQLException {
        User user = toModel(resultSetUser);

        user.setRole(getRoles(resultSetRoles));

        return user;
    }

    private @NotNull User toModel(@NotNull ResultSet resultSetUser) throws SQLException {
        User user = new User();

        user.setId(resultSetUser.getLong("id"));
        user.setEmail(resultSetUser.getString("email"));
        user.setPassword(resultSetUser.getString("password"));

        return user;
    }

    private @NotNull Set<String> getRoles(@NotNull ResultSet resultSetRoles) throws SQLException {
        Set<String> roles = new HashSet<>();

        while (resultSetRoles.next()) {
            roles.add(resultSetRoles.getString("status"));
        }

        return roles;
    }
}
