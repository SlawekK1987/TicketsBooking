package pl.touk.controller;

import pl.touk.exception.ValidationException;
import pl.touk.model.dto.SummaryDto;
import pl.touk.model.dto.UserDto;
import pl.touk.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public SummaryDto saveBooking(@RequestBody List<UserDto> userDto) throws ValidationException {
        return bookingService.saveBooking(userDto);
    }
}