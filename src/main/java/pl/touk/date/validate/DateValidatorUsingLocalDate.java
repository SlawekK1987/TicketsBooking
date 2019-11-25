package pl.touk.date.validate;

import pl.touk.date.CurrentDateTime;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeParseException;

@Component
public class DateValidatorUsingLocalDate implements DateValidator {

    @Override
    public boolean isValid(String dateStr) {
        try {
            CurrentDateTime.parse(dateStr);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}