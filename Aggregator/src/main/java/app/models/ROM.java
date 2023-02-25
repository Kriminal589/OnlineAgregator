package app.models;

import lombok.*;

import javax.persistence.Entity;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ROM extends Model{
    private String type;
    private String memory;
}
