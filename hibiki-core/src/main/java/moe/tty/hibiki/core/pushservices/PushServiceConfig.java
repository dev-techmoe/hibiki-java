package moe.tty.hibiki.core.pushservices;

/**
 * Config class template for the push service
 * @since 1.0
 */
public interface PushServiceConfig {

    /**
     * Get the service name of current config
     * @return service name e.g. telegram
     * @since 1.0
     */
    String getServiceName();
}
