package app.models;

import lombok.*;

import javax.persistence.Entity;

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
