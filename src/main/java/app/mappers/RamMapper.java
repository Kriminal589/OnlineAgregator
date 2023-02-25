package app.mappers;

import app.config.Mapper;
import app.models.RAM;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RamMapper implements Mapper<RAM> {
    @Override
    public RAM toModel(@NotNull ResultSet resultSet) throws SQLException {
        RAM ram = new RAM();

        ram.setId(resultSet.getLong("id"));
        ram.setName(resultSet.getString("name"));
        ram.setCost(resultSet.getDouble("cost"));
        ram.setUrl(resultSet.getString("url"));
        ram.setType(resultSet.getString("type"));
        ram.setFrequency(resultSet.getString("frequency"));
        ram.setMemory(resultSet.getString("memory"));

        return ram;
    }
}
