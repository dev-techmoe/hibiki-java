package moe.tty.hibiki.core.utils;

import com.google.gson.Gson;

/**
 * util for handing json
 * @since 1.0
 */
public class JsonUtil {
    private static final Gson gsonInstance = new Gson();
    public static Gson getGson() {
        return gsonInstance;
    }
}
