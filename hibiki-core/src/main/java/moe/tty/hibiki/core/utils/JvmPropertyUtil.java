package moe.tty.hibiki.core.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * utils for some operation for jvm properties
 * @since 1.0
 */
public class JvmPropertyUtil {

    /**
     * TODO: convert the jvm properties (pass by <code>-P</code> param when launch app) to a tree struct
     * example:
     * give this properties below:
     * - example.abc.name=john
     * - example.abc.age=18
     * - example.def.name=jack
     * - example.def.age=21
     * return this map:
     * example -> abc -> name = join
     *                -> age  = 18
     *         -> def -> name = jack
     *                -> age  = 21
     * @since 1.0
     */
    public static Map<String, ?> getPropertyTree(String rootNode) {
        Enumeration<?> propertyKeys = System.getProperties().propertyNames();
        return null;
    }


}
