package pl.touk.model;

import java.math.BigDecimal;

public enum Client {
    ADULT, STUDENT, CHILD;

    public BigDecimal getTicketPrice() {
        switch (this) {
            case ADULT:
                return BigDecimal.valueOf(25);
            case STUDENT:
                return BigDecimal.valueOf(18);
            case CHILD:
                return BigDecimal.valueOf(12.5);
            default:
                throw new AssertionError("Unknown operations " + this);
        }
    }
}
