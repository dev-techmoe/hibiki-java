package moe.tty.hibiki.core.pushservices.wecom;

import lombok.Builder;
import lombok.Data;
import moe.tty.hibiki.core.pushservices.PushServiceConfig;

/**
 * Channel configuration for WeCom
 * @since 1.0
 */
@Data
@Builder
public class WeComChannelConfig implements PushServiceConfig {
    private final String serviceName = "wecom";

    /**
     * Web hook url for chat bot
     * e.g. <code>https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=xxxxxxxxxx</code>
     */
    private String webHookUrl;
}
