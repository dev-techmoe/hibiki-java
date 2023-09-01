package moe.tty.hibiki.core.exceptions;

/**
 * exception class for push channel not found
 * @since 1.0
 */
public class PushChannelNotFoundException extends RuntimeException{
    public PushChannelNotFoundException(String channelName) {
        super("channel not found: "+ channelName);
    }
}
