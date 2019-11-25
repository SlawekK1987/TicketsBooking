package pl.touk.service;

import pl.touk.converter.MovieConverter;
import pl.touk.date.validate.DateValidatorUsingLocalDate;
import pl.touk.exception.ValidationError;
import pl.touk.exception.ValidationException;
import pl.touk.model.dto.MovieDto;
import pl.touk.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static pl.touk.exception.ValidationErrorCode.FROM_DATE;
import static pl.touk.exception.ValidationErrorCode.TO_DATE;
import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class MovieService {
    private final MovieRepository movieRepository;
    private final DateValidatorUsingLocalDate dataValidate;
    private MovieConverter movieConverter = new MovieConverter();

    public List<MovieDto> findMovie(LocalDateTime from, LocalDateTime to) throws ValidationException {
        validate(from, to);
        return movieRepository.findByScreenTimeBetween(from, to).map(movieConverter::convert).collect(toList());
    }

    private void validate(LocalDateTime from, LocalDateTime to) throws ValidationException {
        List<ValidationError> errors = new ArrayList<>();
        if (from == null) {
            errors.add(new ValidationError("From date is empty", FROM_DATE, ""));
        }

        if (to == null) {
            errors.add(new ValidationError("To date is empty", TO_DATE, ""));
        }

        if (from != null && !dataValidate.isValid(from.toString())) {
            errors.add(new ValidationError("From date has not correct format", FROM_DATE, from.toString()));
        }
        if (to != null && !dataValidate.isValid(to.toString())) {
            errors.add(new ValidationError("To date has not correct format", TO_DATE, to.toString()));
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    public List<MovieDto> findAll() {
        return movieRepository.findAllByOrderByTitleAscScreenTimeAsc().map(movieConverter::convert).collect(Collectors.toList());
    }
}