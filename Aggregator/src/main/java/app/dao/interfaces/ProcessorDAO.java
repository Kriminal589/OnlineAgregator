package app.dao.interfaces;

import app.models.Processor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ProcessorDAO {
    List<Processor> findByCore(@NotNull Integer core);
    List<Processor> findBySocket(@NotNull String socket);
    List<Processor> findBySocketAndCore(@NotNull String socket, @NotNull Integer core);
}
