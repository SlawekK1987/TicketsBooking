package pl.touk.model.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private String title;
    private List<ScreenTimeDto> screenTimeDto;
}
