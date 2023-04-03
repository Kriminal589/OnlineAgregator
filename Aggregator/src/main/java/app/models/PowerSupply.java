package app.models;

import lombok.*;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PowerSupply extends Model{
    private String power;
}
