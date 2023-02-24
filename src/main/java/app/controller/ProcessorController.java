package app.controller;

import app.App;
import app.models.Processor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/processor")
public class ProcessorController extends AbstractControllerModels<Processor> {
    @RequestMapping("/search")
    public @ResponseBody String search(@RequestParam(required = false) String core,
                                       @RequestParam(required = false) String socket) {
        return App.gson.toJson("");
    }
}
