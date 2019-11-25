package pl.touk.converter;

import pl.touk.model.ScreenTime;
import pl.touk.model.dto.ScreenTimeDto;
import org.springframework.core.convert.converter.Converter;

public class ScreenTimeDtoConverter implements Converter<ScreenTime, ScreenTimeDto> {

    @Override
    public ScreenTimeDto convert(ScreenTime screenTime) {
        String title = screenTime.getMovie().getTitle();
        return new ScreenTimeDto(screenTime.getScreenTime(), title, screenTime.getScreenRoomId(), screenTime.getAvailableSeat());
    }
}
