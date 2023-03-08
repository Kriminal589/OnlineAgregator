package app.controller;

import app.models.PowerSupply;
import app.service.PowerSupplyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/powerSupply")
public class PowerSupplyController extends AbstractControllerModels<PowerSupply> {

    private final PowerSupplyService service;

    public PowerSupplyController(PowerSupplyService service) {
        super(service);
        this.service = service;
    }

    @RequestMapping("/search")
    public @ResponseBody String search(@RequestParam(required = false) String power) {
        return service.search(power, dbName);
    }
}
