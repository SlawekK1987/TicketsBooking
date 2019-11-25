package pl.touk.service;

import pl.touk.exception.ValidationError;
import pl.touk.exception.ValidationException;
import pl.touk.model.Booking;
import pl.touk.model.dto.SummaryDto;
import pl.touk.model.dto.UserDto;
import pl.touk.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static pl.touk.exception.ValidationErrorCode.*;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class BookingService {
    private final BookingRepository repository;

    public SummaryDto saveBooking(List<UserDto> userDto) throws ValidationException {
        validate(userDto);

        Booking booking = createBooking(userDto);
        repository.save(booking);

        return new SummaryDto(booking.getTotalAmountToPay(), LocalDateTime.now(), generateLinkToConfirm());
    }

    private Booking createBooking(List<UserDto> userDto) {
        return Booking.builder()
                .moveId(-1)
                .screenRoomId(-1)
                .seatNumber(-1)
                .reservationDate(CurrentDateTime.now())
                .userId(-1)
                .totalAmountToPay(getTotalAmountToPay(userDto))
                .confirm(false)
                .build();
    }

    private String generateLinkToConfirm() {
        final String hostPort = "localhost:8080/?code=";
        return hostPort + UUID.randomUUID().toString();
    }

    private BigDecimal getTotalAmountToPay(List<UserDto> userDto) {
        return userDto.stream()
                .map(el -> el.getClient().getTicketPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private void validate(List<UserDto> userDto) throws ValidationException {
        List<ValidationError> errors = new ArrayList<>();
        final String capitalLetterRegexp = "\\b[A-Z].*?\\b";
        final String separatedWordsRegexp = "\\w+_\\w+";
//        final String specialSigns = "[!@#$%^&*(),.?\":{}|<>=]";

        if (userDto.isEmpty()) {
            errors.add(new ValidationError("List is empty", SEAT_NUMBER, ""));
        }
        LocalDateTime startDate = CurrentDateTime.getLocalDateTime(1574427026322L);

        if (ChronoUnit.MINUTES.between(startDate, LocalDateTime.now()) < 15) {
            errors.add(new ValidationError("Seats can be booked at latest 15 minutes before the screening begins", RESERVATION_TIME, startDate.toString()));
        }

        userDto.forEach(user -> {
            String userName = user.getName();
            String userSurname = user.getSurname();

            if (userName == null) {
                errors.add(new ValidationError("Name does not define", NAME, ""));
            }
            if (userSurname == null) {
                errors.add(new ValidationError("Surname does not define", SURNAME, ""));
            }
            if (user.getSeatNumber() == 0) {
                errors.add(new ValidationError("Seat does not choose", SEAT_NUMBER, String.valueOf(user.getSeatNumber())));
            }
            if (userName != null && userSurname != null) {
                if (userName.isEmpty()) {
                    errors.add(new ValidationError("Name should not be empty", NAME, userName));
                }
                if (userSurname.isEmpty()) {
                    errors.add(new ValidationError("Surname should not be empty", SURNAME, userSurname));
                }
                if (userName.length() <= 2) {
                    errors.add(new ValidationError("Name should be at least three characters long", NAME, userName));
                }
                if (userSurname.length() <= 2) {
                    errors.add(new ValidationError("Surname should be at least three characters long", SURNAME, userSurname));
                }
                if (!userName.matches(capitalLetterRegexp)) {
                    errors.add(new ValidationError("Name should start with a capital letter", NAME, userName));
                }
                if (!userSurname.matches(capitalLetterRegexp)) {
                    errors.add(new ValidationError("Surname should start with a capital letter", SURNAME, userSurname));
                }
                if (userSurname.matches(separatedWordsRegexp)) {
                    String[] words = userSurname.split("_");
                    if (!words[0].matches(capitalLetterRegexp) || !words[1].matches(capitalLetterRegexp)) {
                        errors.add(new ValidationError("The surname should be consist of two parts separated with a single dash." +
                                " The second part should also start with a capital letter.", SURNAME, userSurname));
                    }
                }
//            if (!userName.matches(specialSigns)){
//                errors.add(new ValidationError("Name contains special signs.", NAME, userName));
//            }
            }
        });
        if (!errors.isEmpty()) {
            errors.forEach(el -> log.error(el.toString()));
            throw new ValidationException(errors);
        }
    }
}
