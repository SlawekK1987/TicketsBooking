package pl.touk.service;

import pl.touk.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ConfirmService {
    //TODO Implementacja nie jest ukończona
    //TODO obsługa błędów
    private final BookingRepository bookingRepository;

    public String confirmBooking(String code) {
        validate(code);

        return null;
    }

    private static final Pattern splitter = Pattern.compile("([a-f0-9]{8}(-[a-f0-9]{4}){4}[a-f0-9]{8})");

    private void validate(String code) {
        Matcher m = splitter.matcher(code);
        boolean matches = m.matches();
        System.out.println(matches);
    }
}