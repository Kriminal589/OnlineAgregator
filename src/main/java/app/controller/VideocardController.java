package app.controller;

import app.App;
import app.models.Motherboard;
import app.models.Videocard;
import app.service.ServiceModule;
import app.service.VideocardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/videocard")
public class VideocardController extends AbstractControllerModels<Videocard> {

    private final VideocardService service;

    public VideocardController(VideocardService service) {
        super(service);
        this.service = service;
    }

    @RequestMapping("/search")
    public @ResponseBody String search(@RequestParam(required = false) String frequency,
                                       @RequestParam(required = false) String memory) {
        return service.search(frequency, memory, dbName);
    }
}
