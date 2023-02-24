package app.service;

import app.models.Motherboard;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class MotherboardService extends ServiceModule<Motherboard> {

    public MotherboardService() {
        super(Motherboard::new);

    }

}
