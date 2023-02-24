package app.dao.interfaces;

import app.models.PowerSupply;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface PowerSupplyDAO {
    List<PowerSupply> findByPower(@NotNull String power);
    List<PowerSupply>
}
