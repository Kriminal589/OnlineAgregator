package app.mappers;

import app.config.Mapper;
import app.models.Videocard;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VideocardMapper implements Mapper<Videocard> {
    @Override
    public Videocard toModel(@NotNull ResultSet resultSet) throws SQLException {
        Videocard videocard = new Videocard();

        videocard.setId(resultSet.getLong("id"));
        videocard.setName(resultSet.getString("name"));
        videocard.setCost(resultSet.getDouble("cost"));
        videocard.setUrl(resultSet.getString("url"));
        videocard.setMemory(resultSet.getString("memory"));
        videocard.setFrequency(resultSet.getString("frequency"));

        return videocard;
    }
}
