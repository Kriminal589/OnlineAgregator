package app.models;

import lombok.*;

import javax.persistence.Entity;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PowerSupply extends Model{
    private String power;
}
