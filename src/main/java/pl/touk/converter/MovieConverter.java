package pl.touk.converter;

import pl.touk.model.Movie;
import pl.touk.model.dto.MovieDto;
import pl.touk.model.dto.ScreenTimeDto;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

public class MovieConverter implements Converter<Movie, MovieDto> {

    @Override
    public MovieDto convert(Movie movieEntity) {
        List<ScreenTimeDto> collect = movieEntity.getScreenTime().stream().map(el -> new ScreenTimeDtoConverter().convert(el)).collect(Collectors.toList());
        return new MovieDto(movieEntity.getTitle(), collect);
    }
}
