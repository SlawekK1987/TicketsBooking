package pl.touk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking", schema = "Public", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long userId;
    private LocalDateTime reservationDate;
    private int moveId;
    private int screenRoomId;
    private int seatNumber;
    private BigDecimal totalAmountToPay;
    private boolean confirm;
}