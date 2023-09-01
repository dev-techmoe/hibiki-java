package moe.tty.hibiki.core.pushservices.wecom;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import moe.tty.hibiki.core.exceptions.PushFailedException;
import moe.tty.hibiki.core.pushservices.PushService;
import moe.tty.hibiki.core.utils.HttpRequestUtil;

import java.util.List;

/**
 * Push service for WeCom (a.k.a Qiyeweixin, 企业微信 in Chinese)
 * @author techmoe
 * @since 1.0
 */
public class WeComPushService implements PushService<WeComChannelConfig>{

    /**
     * data class for the request body of WeCom web hook api
     * @since 1.0
     */
    @Data
    @Builder
    private static class WeComPushApiRequest {

        @Data
        @Builder
        public static class TextField {
            /**
             * the content of message (markdown)
             */
            @SerializedName("content")
            private String content;
            /**
             * the mentioned <bold>user id</bold> list of message
             */
            @SerializedName("mentioned_list")
            private List<String> mentionedList;
            /**
             * the mentioned <bold>mobile number</bold> list of message
             */
            @SerializedName("mentioned_mobile_list")
            private List<String> mentionedMobileList;
        }

        /**
         * the type of message (only can be set to <code>text</code>)
         */
        @SerializedName("msgtype")
        private final String msgType = "text";
        /**
         * content detail for message
         */
        @SerializedName("text")
        private TextField text;
    }

    /**
     * the response body of WeCom web hook api
     */
    @Data
    public static class WeComPushApiResponse {
        /**
         * error code
         */
        @SerializedName("errcode")
        private Integer errCode;
        /**
         * error message
         */
        @SerializedName("errmsg")
        private String errMessage;
    }

    /**
     * push message
     * @param channel channel configuration for wework
     * @param text push content (markdown)
     * @throws PushFailedException if WeWork service return error
     * @since 1.0
     */
    @Override
    public void push(WeComChannelConfig channel, String text) {
        // build request body
        WeComPushApiRequest.TextField textField = WeComPushApiRequest.TextField.builder()
                .content(text)
                .build();
        WeComPushApiRequest request = WeComPushApiRequest.builder().text(textField).build();

        // perform request
        WeComPushApiResponse response = HttpRequestUtil.performJsonPost(channel.getWebHookUrl(),
                request,
                null,
                WeComPushApiResponse.class);

        // check pushing success or not
        if (response.getErrCode() != 0) {
            throw new PushFailedException("WeWorkPushFailed. " + response);
        }
    }

}
