package app.config;

import app.dao.implementations.*;
import app.dao.interfaces.*;
import app.mappers.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

import static app.config.ConfigDB.connection;

@Component
public class Components {

    @Contract(" -> new")
    @Bean("MotherboardService")
    @Scope("prototype")
    public static @NotNull MotherboardDAO motherboardDAO() throws SQLException {
        return new MotherboardDAOImpl(connection());
    }

    @Contract(" -> new")
    @Bean("PowerSupplyService")
    @Scope("prototype")
    public static @NotNull PowerSupplyDAO powerSupplyDAO() throws SQLException {
        return new PowerSupplyDAOImpl(connection());
    }

    @Contract(" -> new")
    @Bean("ProcessorService")
    @Scope("prototype")
    public static @NotNull ProcessorDAO processorDAO() throws SQLException {
        return new ProcessorDAOImpl(connection());
    }

    @Contract(" -> new")
    @Bean("RAMService")
    @Scope("prototype")
    public static @NotNull RamDao ramDao() throws SQLException {
        return new RamDAOImpl(connection());
    }

    @Contract(" -> new")
    @Bean("ROMService")
    @Scope("prototype")
    public static @NotNull RomDAO romDAO() throws SQLException {
        return new RomDAOImpl(connection());
    }

    @Contract(" -> new")
    @Bean("VideocardService")
    @Scope("prototype")
    public static @NotNull VideocardDAO videocardDAO() throws SQLException {
        return new VideocardDAOImpl(connection());
    }

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
    @Bean("VideocardMapper")
    @Scope("prototype")
    public static @NotNull VideocardMapper videocardMapper() {
        return new VideocardMapper();
    }
}