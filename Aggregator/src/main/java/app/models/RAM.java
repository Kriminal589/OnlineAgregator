package app.models;

import lombok.*;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RAM extends Model {
    private String frequency;
    private String type;
    private String memory;
}
