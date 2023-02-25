package app.controller;

import app.App;
import app.models.Motherboard;
import app.models.RAM;
import app.service.RamService;
import app.service.ServiceModule;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
@RequestMapping("/ram")
public class RamController extends AbstractControllerModels<RAM> {

    private final RamService service;

    public RamController(RamService service) {
        super(service);
        this.service = service;
    }

    @RequestMapping("/search")
    public @ResponseBody String search(@RequestParam(required = false) String frequency,
                                       @RequestParam(required = false) String type,
                                       @RequestParam(required = false) String memory) throws SQLException {
        return service.search(frequency, type, memory, dbName);
    }
}
