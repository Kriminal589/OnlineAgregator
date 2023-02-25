package app.mappers;

import app.config.Mapper;
import app.models.Motherboard;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MotherboardMapper implements Mapper<Motherboard> {
    @Override
    public Motherboard toModel(@NotNull ResultSet resultSet) throws SQLException {
        Motherboard motherboard = new Motherboard();

        motherboard.setId(resultSet.getLong("id"));
        motherboard.setSize(resultSet.getString("size"));
        motherboard.setName(resultSet.getString("name"));
        motherboard.setSocket(resultSet.getString("socket"));
        motherboard.setCost(resultSet.getDouble("cost"));
        motherboard.setUrl(resultSet.getString("url"));

        return motherboard;
    }
}
