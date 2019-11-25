package pl.touk.repository;

import pl.touk.model.Movie;
import pl.touk.model.ScreenTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ScreenTimeRepository extends JpaRepository<ScreenTime, Long> {
    ScreenTime findByMovieAndScreenTime(Movie movie, LocalDateTime screenTime);

    ScreenTime findByScreenTime(LocalDateTime screeningTime);
}
