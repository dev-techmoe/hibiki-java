package moe.tty.hibiki.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Exception class for push failed (e.g. network unreachable, target server international error)
 * @since 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PushFailedException extends RuntimeException {
    public PushFailedException(String message) {
        super(message);
    }

    public PushFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
