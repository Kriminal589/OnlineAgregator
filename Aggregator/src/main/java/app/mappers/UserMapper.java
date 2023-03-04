package app.mappers;

import app.models.ROM;
import app.models.User;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserMapper {
    public User toModel(@NotNull ResultSet resultSetUser, @NotNull ResultSet resultSetRoles) throws SQLException {
        User user = new User();

        user.setName(resultSetUser.getString("name"));
        user.setId(resultSetUser.getLong("id"));
        user.setEmail(resultSetUser.getString("email"));
        user.setPassword(resultSetUser.getString("password"));
        user.setRole(getRoles(resultSetRoles));

        return user;
    }

    private @NotNull Set<String> getRoles(@NotNull ResultSet resultSetRoles) throws SQLException {
        Set<String> roles = new HashSet<>();

        while (resultSetRoles.next()) {
            roles.add(resultSetRoles.getString("role"));
        }

        return roles;
    }
}
