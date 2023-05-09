package org.jetlinks.core.message.codec.lwm2m;

public class SimpleLwM2MExchangeMessage implements LwM2MExchangeMessage {

    private boolean isUpFirstMode;

    private LwM2MDownlinkMessage    downlinkMessage;

    private LwM2MUplinkMessage      uplinkMessage;

    private String                  resultCode;

    private String                  resultMessage;

    private Exception               exception;

    private SimpleLwM2MExchangeMessage(boolean isUpFirstMode,
                                       LwM2MDownlinkMessage downlinkMessage, LwM2MUplinkMessage uplinkMessage,
                                       String resultCode, String resultMessage, Exception exception) {
        this.isUpFirstMode = isUpFirstMode;
        this.downlinkMessage = downlinkMessage;
        this.uplinkMessage = uplinkMessage;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.exception = exception;
    }

    /**
     *  下方指令消息和（在预期时间内）接收到响应消息
     */
    public static SimpleLwM2MExchangeMessage ofSuccess(LwM2MDownlinkMessage downlinkMessage,
                                                       LwM2MUplinkMessage uplinkMessage) {
        return new SimpleLwM2MExchangeMessage(false, downlinkMessage, uplinkMessage, "SUCCESS", "交换消息成功", null);
    }

    /**
     * 上送的请求和下方的响应消息
     */
    public static SimpleLwM2MExchangeMessage ofSuccess(LwM2MUplinkMessage uplinkMessage,
                                                       LwM2MDownlinkMessage downlinkMessage) {
        return new SimpleLwM2MExchangeMessage(true, downlinkMessage, uplinkMessage, "SUCCESS", "交换消息成功", null);
    }

    /**
     * 下发指令失败
     */
    public static SimpleLwM2MExchangeMessage ofFail(LwM2MDownlinkMessage downlinkMessage,
                                                    String resultCode, String resultMessage, Exception e) {
        if (resultMessage == null) resultMessage = "交换消息不成功";
        return new SimpleLwM2MExchangeMessage(false, downlinkMessage, null, resultCode, resultMessage, e);
    }

    @Override
    public boolean isUpFirstMode() {
        return isUpFirstMode;
    }

    @Override
    public LwM2MUplinkMessage getUplinkMessage() {
        return uplinkMessage;
    }

    @Override
    public LwM2MDownlinkMessage getDownlinkMessage() {
        return downlinkMessage;
    }

    @Override
    public boolean isSuccess() {
        return ("SUCCESS".equals(resultCode));
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMessage() {
        return resultMessage;
    }

    @Override
    public Exception getException() {
        return exception;
    }

    @Override
    public String getRegistrationId() {
        if (uplinkMessage != null) {
            return uplinkMessage.getRegistrationId();
        }
        return downlinkMessage.getRegistrationId();
    }

    @Override
    public Integer getMessageId() {
        Integer msgId = null;
        if (uplinkMessage != null) {
            msgId = uplinkMessage.getMessageId();
            if (msgId != null) {
                return msgId;
            }
        }
        if (downlinkMessage != null) {
            msgId = downlinkMessage.getMessageId();
            return msgId;
        }
        return null;
    }

    @Override
    public String toString() {
        return "SimpleLwM2MExchangeMessage{" +
                "isUpFirstMode=" + isUpFirstMode +
                ", downlinkMessage=" + downlinkMessage +
                ", uplinkMessage=" + uplinkMessage +
                ", resultCode='" + resultCode + '\'' +
                ", resultMessage='" + resultMessage + '\'' +
                ", exception=" + exception +
                '}';
    }
}
