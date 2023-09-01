package moe.tty.hibiki.core.channelmanager.impl;

import lombok.extern.slf4j.Slf4j;
import moe.tty.hibiki.core.channelmanager.HibikiChannelManager;
import moe.tty.hibiki.core.channelmanager.entity.HibikiPushChannel;
import moe.tty.hibiki.core.enums.PushServices;
import moe.tty.hibiki.core.pushservices.PushServiceConfig;

import java.util.concurrent.ConcurrentHashMap;

/**
 * channel manager for HibikiClient
 * @since 1.0
 */
@Slf4j
public class DefaultHibikiChannelManager implements HibikiChannelManager {

    private final ConcurrentHashMap<String, HibikiPushChannel> channels = new ConcurrentHashMap<>();

    /**
     * add a channel configuration
     * @param channelName the name of the channel
     * @param pushService the push service used by this channel
     * @param pushServiceConfig the push service configuration of this channel
     * @since 1.0
     */
    @Override
    public void addChannel(String channelName, PushServices pushService, PushServiceConfig pushServiceConfig) {
        log.debug("add channel channelName=\"{}\" pushService=\"{}\" pushServiceConfig=\"{}\"",
                channelName, pushService, pushServiceConfig);
        HibikiPushChannel pushChannel = HibikiPushChannel.builder()
                .pushService(pushService)
                .pushServiceConfig(pushServiceConfig)
                .build();
        channels.put(channelName, pushChannel);
    }

    /**
     * get the channel by name
     * @param channelName name of the channel
     * @since 1.0
     */
    @Override
    public HibikiPushChannel getChannel(String channelName) {
        return channels.get(channelName);
    }

    /**
     * load channel configuration from jvm properties
     * @since 1.0
     */
    public void loadFromJvmProperties() {
        // TODO
    }

}
