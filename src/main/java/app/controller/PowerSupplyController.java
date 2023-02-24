package app.controller;

import app.App;
import app.models.PowerSupply;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/powerSupply")
public class PowerSupplyController extends AbstractControllerModels<PowerSupply> {
    @RequestMapping("/search")
    public @ResponseBody String search(@RequestParam(required = false) String power) {
        return App.gson.toJson("");
    }
}
