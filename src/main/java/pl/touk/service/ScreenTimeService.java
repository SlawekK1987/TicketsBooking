package pl.touk.service;

import pl.touk.repository.ScreenTimeRepository;
import pl.touk.model.dto.ScreenTimeDto;
import pl.touk.converter.ScreenTimeDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.touk.model.Movie;
import pl.touk.model.ScreenTime;
import pl.touk.repository.MovieRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class ScreenTimeService {
    private final ScreenTimeRepository screenTimeRepository;
    private final MovieRepository movieRepository;

    //TODO do poprawy
    public ScreenTimeDto getAvailableSeat(String title, LocalDateTime screenTime) {
        Movie movie = movieRepository.findByTitle(title);
        ScreenTime byMovieAndScreenTime = screenTimeRepository.findByMovieAndScreenTime(movie, screenTime);


        ScreenTime byScreenTime = screenTimeRepository.findByScreenTime(screenTime);
        ScreenTime build = ScreenTime.builder()
                .screenTime(byScreenTime.getScreenTime())
                .screenRoomId(byScreenTime.getScreenRoomId())
                .availableSeat(byScreenTime.getAvailableSeat())
                .movie(movie).build();


        return new ScreenTimeDtoConverter().convert(build);
    }
}
