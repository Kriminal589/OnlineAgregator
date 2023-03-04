package app.models;

import lombok.*;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ROM extends Model{
    private String type;
    private String memory;
}
