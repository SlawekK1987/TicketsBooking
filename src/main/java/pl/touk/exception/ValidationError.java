package pl.touk.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class ValidationError {
    private String msg;
    private ValidationErrorCode code;
    private String value;
}
