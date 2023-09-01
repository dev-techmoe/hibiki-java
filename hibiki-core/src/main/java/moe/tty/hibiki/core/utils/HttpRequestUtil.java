package moe.tty.hibiki.core.utils;


import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.Reader;
import java.util.Map;
import java.util.Objects;

/**
 * Util for sending http request
 * @since 1.0
 */
@Slf4j
public class HttpRequestUtil {
    public static final String HTTP_METHOD_GET = "get";
    public static final String HTTP_METHOD_POST = "post";

    /**
     * Perform a http GET request, and unmarshal the result to object of specified type
     * @param url target url
     * @param headers headers fill to request
     * @param responseType the class of response body
     * @return response data from the http request
     * @param <T> type of response data
     * @since 1.0
     */
    public static <T> T performJsonGet(String url, Map<String, String> headers, Class<T> responseType) {
        return performJsonRequest(url, HTTP_METHOD_GET, null, headers, responseType);
    }

    /**
     * Perform a http POST request, and unmarshal the result to object of specified type
     * @param url target url
     * @param requestBody request body
     * @param headers headers fill to request
     * @param responseType the class of response body
     * @return response data from the http request
     * @param <T> type of response data
     * @since 1.0
     */
    public static <T> T performJsonPost(String url, Object requestBody, Map<String, String> headers, Class<T> responseType) {
        return performJsonRequest(url, HTTP_METHOD_POST, requestBody, headers, responseType);
    }

    /**
     * Perform a http POST request, and unmarshal the result to object of specified type
     * @param url target url
     * @param httpMethod http method of request e.g. <code>get</code>/<code>post</code>
     * @param requestBody request body
     * @param headers headers fill to request
     * @param responseType the class of response body
     * @return response data from the http request
     * @param <T> type of response data
     * @since 1.0
     */
    @SneakyThrows
    public static <T> T performJsonRequest(String url, String httpMethod, Object requestBody,
                                       Map<String, String> headers, Class<T> responseType) {
        Gson gson = JsonUtil.getGson();

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
        Request.Builder requestBuilder = new Request.Builder();

        // set url
        requestBuilder.url(url);

        // add request body
        if (Objects.nonNull(requestBody)) {
            String requestBodyJson = gson.toJson(requestBody);
            RequestBody body = RequestBody.create(requestBodyJson, MediaType.parse("application/json; charset=utf-8"));
            requestBuilder.post(body);
        }

        // add headers
        if (Objects.nonNull(headers)) {
            Headers requestHeaders = Headers.of(headers);
            requestBuilder.headers(requestHeaders);
        }

        // send request and get response
        try (Response response = okHttpClient.newCall(requestBuilder.build()).execute()) {
            if (!Objects.isNull(response.body())) {
                try (Reader reader = response.body().charStream()) {
                    return gson.fromJson(reader, responseType);
                }
            }
        }
        return null;
    }
}
