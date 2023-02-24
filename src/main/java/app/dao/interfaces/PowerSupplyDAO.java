package app.dao.interfaces;

import app.models.PowerSupply;
import org.jetbrains.annotations.NotNull;

public interface PowerSupplyDAO {
    PowerSupply findByPower(@NotNull String power);
}
