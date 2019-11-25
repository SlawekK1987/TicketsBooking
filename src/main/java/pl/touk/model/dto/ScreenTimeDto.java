package pl.touk.model.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ScreenTimeDto {
    private LocalDateTime screenTime;
    private String movieTitle;
    private Long screenRoomId;

    private Map<Integer, ArrayList<Integer>> availableSeat;
}