package app.mappers;

import app.config.Mapper;
import app.models.Processor;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;

/* TODO
вынести реализацию сеттеров на id, name, cost, url в отдельный класс
 */

public class ProcessorMapper implements Mapper<Processor> {
    @Override
    public Processor toModel(@NotNull ResultSet resultSet) throws SQLException {
        Processor processor = new Processor();

        processor.setId(resultSet.getLong("id"));
        processor.setName(resultSet.getString("name"));
        processor.setCost(resultSet.getDouble("cost"));
        processor.setUrl(resultSet.getString("url"));
        processor.setSocket(resultSet.getString("socket"));
        processor.setCore(resultSet.getInt("core"));

        return processor;
    }
}
