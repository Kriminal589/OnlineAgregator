package app.controller;

import app.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
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

    @PostMapping("/authorize")
    public @ResponseBody String auth(@NotNull HttpServletRequest request,
                                     @RequestParam String email,
                                     @RequestParam String password) {
        return userService.signin(email, password, request.getSession());
    }

    @PostMapping("/logout")
    public @ResponseBody String logout(@NotNull HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("authObject");
        return "Success";
    }

}
