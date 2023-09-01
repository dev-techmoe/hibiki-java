package moe.tty.hibiki.core;

import moe.tty.hibiki.core.client.HibikiClient;
import moe.tty.hibiki.core.enums.PushServices;
import moe.tty.hibiki.core.pushservices.wecom.WeComChannelConfig;
import org.junit.jupiter.api.Test;

public class HibikiClientTest {

    @Test
    public void testHibikiClient() {
        HibikiClient client = new HibikiClient();
        client.getChannelManager().addChannel("test", PushServices.STDOUT, null);

        client.push("test", "hello");
    }
}
