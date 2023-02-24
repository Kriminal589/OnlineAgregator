package app.dao.interfaces;

import app.models.ROM;
import org.jetbrains.annotations.NotNull;

public interface RomDAO {
    ROM findByMemory(@NotNull String memory);
    ROM findByType(@NotNull String type);
}
