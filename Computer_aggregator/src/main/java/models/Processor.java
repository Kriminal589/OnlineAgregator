package models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Processor extends Model {
    private String socket;
    private String frequency;
    private String numberOfCores;
}
