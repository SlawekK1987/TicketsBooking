package pl.touk.controller;

import pl.touk.model.ScreenRoom;
import pl.touk.repository.ScreenRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/screenRoom")
public class ScreenRoomController {
    private final ScreenRoomRepository screenRoomRepository;

    @GetMapping("/")
    public List<ScreenRoom> getScreenRoom() {
        return (List<ScreenRoom>) screenRoomRepository.findAll();
    }
}