package app.controller;

import app.App;
import app.models.Motherboard;
import app.service.ServiceModule;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/motherboard")
public class MotherboardController extends AbstractControllerModels<Motherboard> {

    public MotherboardController(ServiceModule<Motherboard> service) {
        super(service);
    }

    @RequestMapping("/search")
    public @ResponseBody String search(@RequestParam(required = false) String socket,
                                       @RequestParam(required = false) String size) {
        return App.gson.toJson("");
    }
}
