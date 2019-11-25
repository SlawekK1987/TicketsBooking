package pl.touk.model.dto;

import lombok.*;
import pl.touk.model.Client;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String name;
    private String surname;
    private Client client;
    private int seatNumber;
}