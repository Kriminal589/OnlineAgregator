package app.dao.interfaces;

import app.models.RAM;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface RamDao {
    List<RAM> findByMemory(@NotNull String memory);
    List<RAM> findByType(@NotNull String type);
}