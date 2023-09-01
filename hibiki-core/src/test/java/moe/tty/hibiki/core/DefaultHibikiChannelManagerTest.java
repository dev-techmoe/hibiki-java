package moe.tty.hibiki.core;

import static org.assertj.core.api.Assertions.*;

import moe.tty.hibiki.core.channelmanager.entity.HibikiPushChannel;
import moe.tty.hibiki.core.channelmanager.impl.DefaultHibikiChannelManager;
import moe.tty.hibiki.core.enums.PushServices;
import moe.tty.hibiki.core.pushservices.wecom.WeComChannelConfig;
import org.junit.jupiter.api.Test;

public class DefaultHibikiChannelManagerTest {

    @Test
    public void testAddAndGetChannel() {
        DefaultHibikiChannelManager channelManager = new DefaultHibikiChannelManager();
        channelManager.addChannel("channel1",
                PushServices.WE_COM,
                WeComChannelConfig.builder().webHookUrl("http://example.com").build());
        channelManager.addChannel("channel2", PushServices.WE_COM, WeComChannelConfig.builder().build());
        HibikiPushChannel channel1 = channelManager.getChannel("channel1");
        assertThat(channel1).isNotNull();
        assertThat(channel1.getPushService()).isNotNull();
        assertThat(channel1.getPushServiceConfig()).isNotNull();
    }

}
