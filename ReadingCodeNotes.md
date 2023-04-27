

# 编解码为主线的关键类

## 基础数据类型
* org.jetlinks.core.codec.Codec
* org.jetlinks.core.codec.Decoder
* org.jetlinks.core.codec.Encoder
* org.jetlinks.core.codec.CodecsSupport
* org.jetlinks.core.codec.defaults.DefaultCodecsSupport
* org.jetlinks.core.Value
* |- org.jetlinks.core.SimpleValue
* org.jetlinks.core.Values
* |- org.jetlinks.core.SimpleValues

## 设备或物模型消息类型
* org.jetlinks.core.message.codec.MessageCodecContext: getDeviceOperator(),
* |- org.jetlinks.core.message.codec.MessageEncodeContext: getMessage(), reply() 
* |-- org.jetlinks.core.message.codec.ToDeviceMessageContext: sendToDevice(EncodedMessage), getSession(), 
* |- org.jetlinks.core.message.codec.MessageDecodeContext: getMessage()
* |-- org.jetlinks.core.message.codec.FromDeviceMessageContext: getDevice(), getSession()
* org.jetlinks.core.message.codec.MessagePayloadType
* org.jetlinks.core.message.codec.DeviceMessageEncoder
* org.jetlinks.core.message.codec.DeviceMessageDecoder
* org.jetlinks.core.message.codec.DeviceMessageCodec
* org.jetlinks.core.message.codec.InterceptorDeviceMessageCodec
* 


## 框架
* org.jetlinks.core.spi.ProtocolSupportProvider
* org.jetlinks.core.spi.ServiceContext
* org.jetlinks.core.ProtocolSupport
* org.jetlinks.core.ProtocolSupports
* org.jetlinks.core.message.interceptor.DeviceMessageCodecInterceptor
* |- org.jetlinks.core.message.interceptor.DeviceMessageDecodeInterceptor
* |- org.jetlinks.core.message.interceptor.DeviceMessageEncodeInterceptor
* org.jetlinks.core.message.interceptor.DeviceMessageSenderInterceptor
* 

## 官方插件的关键类


## 落地侧的关键类
