package moe.tty.hibiki.core.pushservices;

/**
 * push service definition
 * @param <T> the config entity of the push service
 */
public interface PushService<T extends PushServiceConfig>  {
    /**
     * push a message
     * @param channel channel definition object
     * @param text message content
     */
    void push(T channel, String text);
}
