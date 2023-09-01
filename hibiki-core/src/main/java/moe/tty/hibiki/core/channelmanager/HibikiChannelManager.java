package moe.tty.hibiki.core.channelmanager;

import moe.tty.hibiki.core.channelmanager.entity.HibikiPushChannel;
import moe.tty.hibiki.core.enums.PushServices;
import moe.tty.hibiki.core.pushservices.PushServiceConfig;

/**
 * interface definition for channel manager
 * @since 1.0
 */
public interface HibikiChannelManager {

    /**
     * add a channel to channelManager
     * @param channelName channel name
     * @param pushService push service enumerate value
     * @param pushServiceConfig the config entity for push service
     * @since 1.0
     */
    void addChannel(String channelName, PushServices pushService, PushServiceConfig pushServiceConfig);

    /**
     * get the channel definition by a channel name
     * @param channelName channel name
     * @return channel definition entity
     * @since 1.0
     */
    HibikiPushChannel getChannel(String channelName);
}
