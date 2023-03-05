package app.service;

import app.config.Components;
import app.dao.implementations.UserDAO;
import app.models.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
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

    public @NotNull String signin(@NotNull String email, @NotNull String password, @NotNull HttpSession session) {
        User user = userDAO.findByEmailAndPassword(email, password);

        if (user != null) {
            session.setAttribute("authObject", "AUTHENTICATED");
        }
        return Components.gson().toJson(user);
    }
}
