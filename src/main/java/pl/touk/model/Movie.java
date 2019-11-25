package pl.touk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movie", schema = "Public", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<ScreenTime> screenTime;
}