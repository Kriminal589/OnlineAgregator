package app.controller;

import app.App;
import app.models.Motherboard;
import app.models.ROM;
import app.service.RomService;
import app.service.ServiceModule;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rom")
public class RomController extends AbstractControllerModels<ROM> {

    private final RomService service;

    public RomController(RomService service) {
        super(service);
        this.service = service;
    }

    @RequestMapping("/search")
    public @ResponseBody String search(@RequestParam(required = false) String type,
                                       @RequestParam(required = false) String memory) {
        return service.search(type, memory, dbName);
    }
}
