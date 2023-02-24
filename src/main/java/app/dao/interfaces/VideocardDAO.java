package app.dao.interfaces;

import app.models.Videocard;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface VideocardDAO {
    List<Videocard> findByMemory(@NotNull String memory);
}
