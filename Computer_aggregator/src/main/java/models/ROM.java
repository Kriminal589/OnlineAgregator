package models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ROM extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
