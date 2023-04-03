package app.models;

import lombok.*;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Processor extends Model {
    private Integer core;
    private String socket;
}
