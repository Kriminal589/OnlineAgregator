package app.controller;

import app.models.User;
import app.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public @ResponseBody String getAll() {
        return userService.findAll();
    }

    @PostMapping("signup")
    public @ResponseBody String signup(
            @NotNull HttpServletRequest request,
            @RequestParam String email,
            @RequestParam String password) {
        return userService.signup(email, password, request.getSession());
    }

    @GetMapping("/getById")
    public @ResponseBody String getById(@RequestParam Long id) {
        return userService.getById(id);
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User auth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        User user = (principal instanceof User) ? (User) principal : null;
        return Objects.nonNull(user) ? this.userService.findByEmail(user.getEmail()) : null;
    }

    @PostMapping("/out")
    public @ResponseBody String logout(@NotNull HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("authObject");
        return "Success";
    }

}
