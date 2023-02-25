package app.dao.interfaces;

import app.models.RAM;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface RamDao {
    List<RAM> findByMemory(@NotNull String memory);
    List<RAM> findByType(@NotNull String type);
    List<RAM> findByFrequencyAndType(@NotNull String frequency, @NotNull String type);
    List<RAM> findByFrequencyAndMemory(@NotNull String frequency, @NotNull String memory);
    List<RAM> findByTypeAndMemory(@NotNull String type, @NotNull String memory);
    List<RAM> search(@NotNull String frequency, @NotNull String type, @NotNull String memory);
    List<RAM> findByFrequency(@NotNull String frequency);
}