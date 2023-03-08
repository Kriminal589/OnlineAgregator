package app.controller;

import app.models.Processor;
import app.service.ProcessorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
@RequestMapping("/processor")
public class ProcessorController extends AbstractControllerModels<Processor> {

    private final ProcessorService service;

    public ProcessorController(ProcessorService service) {
        super(service);
        this.service = service;
    }

    @RequestMapping("/search")
    public @ResponseBody String search(@RequestParam(required = false) Integer core,
                                       @RequestParam(required = false) String socket) throws SQLException {
        return service.search(core, socket, dbName);
    }
}
