package pl.touk.controller;

import pl.touk.exception.ValidationException;
import pl.touk.model.dto.MovieDto;
import pl.touk.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/")
    public List<MovieDto> getMovies(@RequestParam("from") @DateTimeFormat(iso = DATE_TIME) LocalDateTime from,
                                    @RequestParam("to") @DateTimeFormat(iso = DATE_TIME) LocalDateTime to) throws ValidationException {

        log.info("User search movies: [from: " + from + ", to: " + to + "]");
        return movieService.findMovie(from, to);
    }

    @GetMapping
    public List<MovieDto> findAll(){
        return movieService.findAll();
    }
}