package models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RAM extends Model {
    private String frequency;
    private String memoryCapacity;
}
