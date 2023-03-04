package app.mappers;

import app.config.Mapper;
import app.models.PowerSupply;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PowerSupplyMapper implements Mapper<PowerSupply> {
    @Override
    public PowerSupply toModel(@NotNull ResultSet resultSet) throws SQLException {
        PowerSupply powerSupply = new PowerSupply();

        powerSupply.setId(resultSet.getLong("id"));
        powerSupply.setName(resultSet.getString("name"));
        powerSupply.setCost(resultSet.getDouble("cost"));
        powerSupply.setUrl(resultSet.getString("url"));
        powerSupply.setPower(resultSet.getString("power"));

        return powerSupply;
    }
}
