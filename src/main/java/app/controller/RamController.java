package app.controller;

import app.App;
import app.models.RAM;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ram")
public class RamController extends AbstractControllerModels<RAM> {
    @RequestMapping("/search")
    public @ResponseBody String search(@RequestParam(required = false) String frequency,
                                       @RequestParam(required = false) String type,
                                       @RequestParam(required = false) String memory) {
        return App.gson.toJson("");
    }
}
