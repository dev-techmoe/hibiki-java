package moe.tty.hibiki.core;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import moe.tty.hibiki.core.utils.HttpRequestUtil;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class HttpRequestUtilTest {
    private final String HTTP_BIN_BASE_URL = "https://httpbin.org";

    @Data
    private static class TestPostBody {
        private final String bodyKey = "bodyValue";
    }

    @Test
    @SuppressWarnings("rawtypes")
    public void testPerformJsonGet() {
        String url = HTTP_BIN_BASE_URL + "/get?key=value";
        HashMap<String, ?> result = HttpRequestUtil.performJsonGet(url, null, HashMap.class);
        log.info("httpbin response: {}", result);
        assertThat(result).isNotNull();
        assertThat(((Map) result.get("args")).get("key")).isEqualTo("value");
    }

    @Test
    public void testPerformJsonPost() {
        String url = HTTP_BIN_BASE_URL + "/post";
        TestPostBody body = new TestPostBody();
        HashMap<String, ?> result = HttpRequestUtil.performJsonPost(url, body, null, HashMap.class);
        assertThat(result).isNotNull();
        assertThat(result.get("data")).isNotNull();
    }

    @Test
    public void testPassHeaders() {
        String url = HTTP_BIN_BASE_URL + "/get?key=value";
        Map<String, String> headers = Collections.singletonMap("headerkey", "headerValue");
        HashMap<String, ?> result = HttpRequestUtil.performJsonGet(url, headers, HashMap.class);
        log.info("httpbin response: {}", result);
        assertThat(result).isNotNull();
        assertThat(((Map) result.get("headers")).get("Headerkey")).isEqualTo("headerValue");
    }
}
