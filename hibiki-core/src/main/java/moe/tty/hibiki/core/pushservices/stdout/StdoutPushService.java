package moe.tty.hibiki.core.pushservices.stdout;

import lombok.extern.slf4j.Slf4j;
import moe.tty.hibiki.core.pushservices.PushService;
import moe.tty.hibiki.core.pushservices.PushServiceConfig;

/**
 * a simple push service for testing
 * it will output messages to stdout
 * @since 1.0
 */
@Slf4j
public class StdoutPushService implements PushService<StdoutPushServiceConfig> {

    @Override
    public void push(StdoutPushServiceConfig channel, String text) {
        log.info("stdout push: {}", text);
    }
}
