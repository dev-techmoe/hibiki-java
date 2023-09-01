package moe.tty.hibiki.core.channelmanager.entity;

import lombok.Builder;
import lombok.Data;
import moe.tty.hibiki.core.enums.PushServices;
import moe.tty.hibiki.core.pushservices.PushServiceConfig;

/**
 * entity class of push channel
 * @since 1.0
 */
@Data
@Builder
public class HibikiPushChannel {
    /**
     * push services enum value
     */
    private final PushServices pushService;
    /**
     * config entity for push service
     */
    private final PushServiceConfig pushServiceConfig;
}