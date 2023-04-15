package org.jetlinks.core.message.codec.lwm2m;

/**
 * LwM2M消息互通，如：下发的请求与上送的响应，上送的请求和下方的响应
 *
 * @author v-lizy8
 * @date 2023/3/27
 */
public interface LwM2MExchangeMessage {

    /**
     * 对端拒绝请求
     */
    String RC_REJECTED_BY_PEER = "EC_REJ_PEER";

    /**
     * 请求已取消
     */
    String RC_CANCELLED = "EC_CANCELLED";

    /**
     * 发送失败
     */
    String RC_SEND_FAIL = "EC_SEND_FAIL";

    /**
     * 不能识别的响应消息
     */
    String RC_UNKNOWN_RESPONSE = "EC_UKN_RSP";

    /**
     * 客户端已（节能）休眠
     */
    String RC_CLIENT_SLEEP = "EC_CLN_SLP";

    /**
     * 超时无响应
     */
    String RC_TIMEOUT = "EC_TIMEOUT";

    /**
     * @return  如果是上送请求和响应的模式，返回true；
     */
    boolean isUpFirstMode();

    /**
     * @return  相关的上送的消息
     */
    LwM2MUplinkMessage  getUplinkMessage();

    /**
     * @return  相关的下发的消息
     */
    LwM2MDownlinkMessage    getDownlinkMessage();

    /**
     * @return  如果成功交换消息（并非一定是业务成功），返回true；
     */
    boolean isSuccess();

    /**
     * @return  消息交换结果编码，SUCCESS表示成功
     */
    String  getResultCode();

    /**
     * @return  消息交换结果提示信息
     */
    String  getResultMessage();

    /**
     * @return  交换消息过程发生的异常错误
     */
    Exception   getException();
}
