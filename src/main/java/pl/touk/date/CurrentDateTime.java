package pl.touk.date;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CurrentDateTime {
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE_TIME;

    public static LocalDateTime parse(String localDateTime) {
        return LocalDateTime.parse(localDateTime, dateFormatter);
    }
}