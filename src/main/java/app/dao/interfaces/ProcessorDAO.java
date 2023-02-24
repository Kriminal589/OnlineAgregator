package app.dao.interfaces;

import app.models.Processor;
import org.jetbrains.annotations.NotNull;

public interface ProcessorDAO {
    Processor findByCore(@NotNull Integer core);
    Processor findBySocket(@NotNull String socket);
}
