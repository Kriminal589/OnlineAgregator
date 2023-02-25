package app.models;

import lombok.*;

import javax.persistence.Entity;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Processor extends Model {
    private Integer core;
    private String socket;
}
