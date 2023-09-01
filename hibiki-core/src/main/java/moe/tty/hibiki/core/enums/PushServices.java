package moe.tty.hibiki.core.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import moe.tty.hibiki.core.pushservices.PushService;
import moe.tty.hibiki.core.pushservices.PushServiceConfig;
import moe.tty.hibiki.core.pushservices.stdout.StdoutPushService;
import moe.tty.hibiki.core.pushservices.stdout.StdoutPushServiceConfig;
import moe.tty.hibiki.core.pushservices.wecom.WeComChannelConfig;
import moe.tty.hibiki.core.pushservices.wecom.WeComPushService;

import java.util.HashMap;

/**
 * push service definition
 * @since 1.0
 */
@AllArgsConstructor
@Getter
public enum PushServices {

    WE_COM("wecom", WeComPushService.class, WeComChannelConfig.class),
    STDOUT("stdout", StdoutPushService.class, StdoutPushServiceConfig.class)
    ;
    private static HashMap<String, PushServices> nameMapping = new HashMap<String, PushServices>() {{
       put("wecom", WE_COM);
       put("stdout", STDOUT);
    }};
    public static PushServices getByName(String name) {
        return nameMapping.get(name);
    }
    /**
     * channel name
     */
    private final String name;
    /**
     * channel service class
     */
    private final Class<? extends PushService<?>> pushServicesClass;
    /**
     * channel config class
     */
    private final Class<? extends PushServiceConfig> pushServiceConfigClass;

}
