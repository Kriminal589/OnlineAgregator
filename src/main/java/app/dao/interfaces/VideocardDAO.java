package app.dao.interfaces;

import app.models.Videocard;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface VideocardDAO {
    List<Videocard> findByMemory(@NotNull String memory);
    List<Videocard> findByFrequency(@NotNull String frequency);
    List<Videocard> findByMemoryAndFrequency(@NotNull String memory, @NotNull String frequency);
}
