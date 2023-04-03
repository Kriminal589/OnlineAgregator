package app.config;

import app.dao.implementations.*;
import app.mappers.*;
import app.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class Components {
    @Contract(" -> new")
    @Bean
    @Scope("singleton")
    public static @NotNull Gson gson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Contract(" -> new")
    @Bean("MotherboardMapper")
    @Scope("prototype")
    public static @NotNull MotherboardMapper motherboardMapper() {
        return new MotherboardMapper();
    }

    @Contract(" -> new")
    @Bean("PowerSupplyMapper")
    @Scope("prototype")
    public static @NotNull PowerSupplyMapper powerSupplyMapper() {
        return new PowerSupplyMapper();
    }

    @Contract(" -> new")
    @Bean("ProcessorMapper")
    @Scope("prototype")
    public static @NotNull ProcessorMapper processorMapper() {
        return new ProcessorMapper();
    }

    @Contract(" -> new")
    @Bean("RAMMapper")
    @Scope("prototype")
    public static @NotNull RamMapper ramMapper() {
        return new RamMapper();
    }

    @Contract(" -> new")
    @Bean("ROMMapper")
    @Scope("prototype")
    public static @NotNull RomMapper romMapper() {
        return new RomMapper();
    }

    @Contract(" -> new")
    @Bean("UserService")
    @Scope("prototype")
    public static @NotNull UserService userService() throws SQLException {
        return new UserService(new UserDAO(ConfigDB.connection()));
    }
    @Contract(" -> new")
    @Bean("VideocardMapper")
    @Scope("prototype")
    public static @NotNull VideocardMapper videocardMapper() {
        return new VideocardMapper();
    }
}