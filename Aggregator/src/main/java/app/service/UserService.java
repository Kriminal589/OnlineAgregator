package app.service;

import app.config.Components;
import app.dao.implementations.UserDAO;
import app.models.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Service
public class UserService implements UserDetailsService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public @NotNull String findAll() {
        return Components.gson().toJson(userDAO.findAll());
    }

    public @NotNull String signup(@NotNull String email, @NotNull String password, @NotNull HttpSession session) {

        User user = userDAO.findByEmail(email);

        if (!Objects.equals(user, null)) {
            return "Пользователь с такой почтой уже существует";
        }

        userDAO.add(email, password);
        session.setAttribute("authObject", "AUTHENTICATED");

        return Components.gson().toJson(userDAO.findByEmail(email));
    }

    public @NotNull String getById(@NotNull Long id) {
        return Components.gson().toJson(userDAO.findById(id));
    }

    public @NotNull User findByEmail(@NotNull String email) {
        return userDAO.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDAO.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Collection<? extends GrantedAuthority> authorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
