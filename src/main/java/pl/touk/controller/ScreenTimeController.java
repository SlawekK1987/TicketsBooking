package pl.touk.controller;

import pl.touk.model.dto.ScreenTimeDto;
import pl.touk.service.ScreenTimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/screenTime")
public class ScreenTimeController {
    private final ScreenTimeService screenTimeService;

    @GetMapping
    public ScreenTimeDto getAvailableSeat(@RequestParam("title") String title,
                                          @RequestParam("screenTime") @DateTimeFormat(iso = DATE_TIME) LocalDateTime screenTime) {
        return screenTimeService.getAvailableSeat(title, screenTime);
    }
}