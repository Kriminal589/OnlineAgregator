package app.dao.interfaces;

import app.models.RAM;
import org.jetbrains.annotations.NotNull;

public interface RamDao {
    RAM findByMemory(@NotNull String memory);
    RAM findByType(@NotNull String type);
}