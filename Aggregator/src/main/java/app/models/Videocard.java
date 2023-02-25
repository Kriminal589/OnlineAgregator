package app.models;

import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Videocard extends Model {
    private String memory;
    private String frequency;
}
