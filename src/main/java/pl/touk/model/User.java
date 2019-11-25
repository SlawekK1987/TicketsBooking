package pl.touk.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user", schema = "Public", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Client client;
    private Long bookingId;
    private int seatNumber;
}
