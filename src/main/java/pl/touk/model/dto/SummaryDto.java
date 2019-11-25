package pl.touk.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class SummaryDto {
    private BigDecimal totalAmount;
    private LocalDateTime expirationTime;
    private String linkToConfirm;
}
