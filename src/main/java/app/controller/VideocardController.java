package app.controller;

import app.App;
import app.models.Videocard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/videocard")
public class VideocardController extends AbstractControllerModels<Videocard> {
    @RequestMapping("/search")
    public @ResponseBody String search(@RequestParam(required = false) String frequency,
                                       @RequestParam(required = false) String memory) {
        return App.gson.toJson("");
    }
}
