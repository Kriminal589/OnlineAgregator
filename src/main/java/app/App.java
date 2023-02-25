package app;

import app.config.InitializationDB;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        InitializationDB.init();
        SpringApplication.run(App.class, args);
    }
}
