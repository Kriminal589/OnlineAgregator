package app.dao.interfaces;

import app.models.ROM;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface RomDAO {
    List<ROM> findByMemory(@NotNull String memory);
    List<ROM> findByType(@NotNull String type);
}
