package app.dao.interfaces;

import app.models.Motherboard;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface MotherboardDAO {
    List<Motherboard> findBySocket(@NotNull String socket);
    List<Motherboard> findBySize(@NotNull String size);
    List<Motherboard> findBySizeAndSocket(@NotNull String socket, @NotNull String size);
}
