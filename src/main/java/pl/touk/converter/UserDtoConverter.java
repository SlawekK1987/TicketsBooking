package pl.touk.converter;

import pl.touk.model.User;
import pl.touk.model.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User userEntity) {
        return new UserDto(userEntity.getName(), userEntity.getSurname(), userEntity.getClient(), userEntity.getSeatNumber());
    }
}
