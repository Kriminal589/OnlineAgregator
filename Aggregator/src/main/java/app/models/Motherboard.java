package app.models;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
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
