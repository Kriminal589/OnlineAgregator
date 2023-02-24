package app.controller;

import app.App;
import app.models.Model;
import app.models.PowerSupply;
import app.service.ServiceModule;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

public abstract class AbstractControllerModels<T> {

    protected final ServiceModule<T> service;
    protected final String dbName;

    public AbstractControllerModels(@NotNull ServiceModule<T> service) {
        this.service = service;

        String param = service.getParamOfClass().getSimpleName();
        dbName = param.equals("PowerSupply")
                ? "power_supply"
                : param.toLowerCase();
    }

    @RequestMapping("/getById")
    public @ResponseBody String getById(@RequestParam("id") Long id) throws SQLException {
        return service.findById(id, dbName);
    }

    @RequestMapping("/getByPrice")
    public @ResponseBody String getByPrice(@RequestParam(value = "min", defaultValue = "0") Double min,
                                           @RequestParam(value = "max", defaultValue = "0") Double max) throws SQLException {
        return service.findByPrice(min, max, dbName);
    }

    @RequestMapping("/getByName")
    public @ResponseBody String getByName(@RequestParam("name") String name) throws SQLException {
        return service.findByName(name, dbName);
    }

    @RequestMapping("/get")
    public @ResponseBody String get() throws SQLException {
        return service.findAll(dbName);
    }

}
