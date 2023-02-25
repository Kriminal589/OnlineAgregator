package app.models;

import lombok.*;

import javax.persistence.Entity;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Motherboard extends Model {
    private String socket;

    //form factor
    private String size;
}
