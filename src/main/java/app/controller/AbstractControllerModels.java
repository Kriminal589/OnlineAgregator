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

    private final ServiceModule<T> service;
    private final String dbName;

    public AbstractControllerModels(ServiceModule<T> service) {
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
    public @ResponseBody String getByPrice(@RequestParam("cost") Long cost) {
        return  App.gson.toJson("");
    }

    @RequestMapping("/getByName")
    public @ResponseBody String getById(@RequestParam("name") String name) {
        return App.gson.toJson("");
    }

    @RequestMapping("/get")
    public @ResponseBody String get() {
        return App.gson.toJson("");
    }

}
