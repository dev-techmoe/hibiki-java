package moe.tty.hibiki.core.pushservices.stdout;

import moe.tty.hibiki.core.pushservices.PushServiceConfig;

/**
 * the push service config for StdoutPushService
 * @since 1.0
 */
public class StdoutPushServiceConfig implements PushServiceConfig {
    @Override
    public String getServiceName() {
        return "stdout";
    }
}
