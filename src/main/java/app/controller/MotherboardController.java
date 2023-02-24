package app.controller;

import app.App;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/motherboard")
public class MotherboardController {
    @GetMapping("/get")
    public @ResponseBody String get(@RequestParam Long id) {
        return App.gson.toJson("");
    }
}
