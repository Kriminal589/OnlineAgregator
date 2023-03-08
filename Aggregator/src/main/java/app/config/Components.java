package app.config;

import app.dao.implementations.*;
import app.dao.interfaces.*;
import app.mappers.*;
import app.service.UserService;
import app.token.JwtTokenRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static app.config.ConfigDB.connection;

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
    @Bean("JwtTokenRepository")
    @Scope("prototype")
    public static @NotNull JwtTokenRepository jwtTokenRepository() {
        return new JwtTokenRepository();
    }

    @Contract(" -> new")
    @Bean("VideocardMapper")
    @Scope("prototype")
    public static @NotNull VideocardMapper videocardMapper() {
        return new VideocardMapper();
    }
}