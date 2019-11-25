package pl.touk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Component
@Table(name = "screen_times", schema = "Public", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class ScreenTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime screenTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    private Long screenRoomId;

    //TODO Nie działa
    private HashMap<Integer, ArrayList<Integer>> availableSeat;
}