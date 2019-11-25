package pl.touk.controller;

import pl.touk.service.ConfirmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ConfirmController {
    private final ConfirmService confirmService;

    @PostMapping
    public String confirm(@RequestParam("code") String code) {
        return confirmService.confirmBooking(code);
    }
}
