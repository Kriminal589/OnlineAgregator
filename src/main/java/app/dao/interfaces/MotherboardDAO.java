package app.dao.interfaces;

import app.models.Motherboard;
import org.jetbrains.annotations.NotNull;

public interface MotherboardDAO {
    Motherboard findBySocket(@NotNull String socket);
    Motherboard findBySize(@NotNull String size);
}
