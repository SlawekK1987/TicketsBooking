package pl.touk.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class CurrentDateTime {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd::MMM::yyyy HH::mm::ss");
    private static final ZoneId zoneId = ZoneId.systemDefault();

    static LocalDateTime now() {
        return LocalDateTime.now();
    }

    static LocalDateTime getLocalDateTime(long date) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date), TimeZone.getDefault().toZoneId());
    }

}