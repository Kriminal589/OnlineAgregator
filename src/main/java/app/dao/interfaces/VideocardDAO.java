package app.dao.interfaces;

import app.models.Videocard;
import org.jetbrains.annotations.NotNull;

public interface VideocardDAO {
    Videocard findByMemory(@NotNull String memory);
}
