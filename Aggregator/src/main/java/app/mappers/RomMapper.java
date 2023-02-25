package app.mappers;

import app.config.Mapper;
import app.models.ROM;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RomMapper implements Mapper<ROM> {
    @Override
    @Bean(name = "ROM")
    public ROM toModel(@NotNull ResultSet resultSet) throws SQLException {
        ROM rom = new ROM();

        rom.setId(resultSet.getLong("id"));
        rom.setName(resultSet.getString("name"));
        rom.setCost(resultSet.getDouble("cost"));
        rom.setUrl(resultSet.getString("url"));
        rom.setType(resultSet.getString("type"));
        rom.setMemory(resultSet.getString("memory"));

        return rom;
    }
}
