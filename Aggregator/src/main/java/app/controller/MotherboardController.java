package app.controller;

import app.App;
import app.models.Motherboard;
import app.service.MotherboardService;
import app.service.ServiceModule;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
@RequestMapping("/motherboard")
public class MotherboardController extends AbstractControllerModels<Motherboard> {

    private final MotherboardService service;

    public MotherboardController(MotherboardService service) {
        super(service);
        this.service = service;
    }

    @RequestMapping("/search")
    public @ResponseBody String search(@RequestParam(required = false) String socket,
                                       @RequestParam(required = false) String size) throws SQLException {
        return service.search(socket, size, dbName);
    }
}
