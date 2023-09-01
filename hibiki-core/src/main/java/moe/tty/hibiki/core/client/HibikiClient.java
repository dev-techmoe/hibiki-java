package moe.tty.hibiki.core.client;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import moe.tty.hibiki.core.channelmanager.HibikiChannelManager;
import moe.tty.hibiki.core.channelmanager.entity.HibikiPushChannel;
import moe.tty.hibiki.core.channelmanager.impl.DefaultHibikiChannelManager;
import moe.tty.hibiki.core.exceptions.PushChannelNotFoundException;
import moe.tty.hibiki.core.pushservices.PushService;
import moe.tty.hibiki.core.pushservices.PushServiceConfig;

import java.util.Objects;

/**
 * main hibiki client for pushing message to channel
 * @since 1.0
 */
@Slf4j
public class HibikiClient {

    /**
     * the channel manager instance used by this client
     */
    private HibikiChannelManager channelManager;

    /**
     * if no channelManager to be given, use the DefaultHibikiChannelManager by default
     */
    public HibikiClient() {
        this.channelManager = new DefaultHibikiChannelManager();
    }

    public HibikiClient(HibikiChannelManager channelManager) {
        this.channelManager = channelManager;
    }

    /**
     * Get the channel manager
     * @return channel manager instance
     */
    public HibikiChannelManager getChannelManager() {
        return channelManager;
    }

    /**
     * push message to specified channel
     * @param channelName the name of target channel
     * @param message message
     * @throws PushChannelNotFoundException when channel not exists
     * @since 1.0
     */
    @SneakyThrows
    public void push(String channelName, String message) {
        // get the channel
        HibikiPushChannel pushChannel = channelManager.getChannel(channelName);
        if (Objects.isNull(pushChannel)) throw new PushChannelNotFoundException(channelName);
        // initialize the push service
        PushService pushService = pushChannel.getPushService().getPushServicesClass().newInstance();
        // push message
        log.debug("pushing to channel \"{}\" message: \"{}\"", channelName, message);
        pushService.push(pushChannel.getPushServiceConfig(), message);
    }
}
