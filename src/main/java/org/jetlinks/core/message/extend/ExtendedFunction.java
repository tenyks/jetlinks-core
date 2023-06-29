package org.jetlinks.core.message.extend;

import org.jetlinks.core.message.*;
import org.jetlinks.core.message.event.EventMessage;
import org.jetlinks.core.message.firmware.*;
import org.jetlinks.core.message.function.FunctionInvokeMessage;
import org.jetlinks.core.message.function.FunctionInvokeMessageReply;
import org.jetlinks.core.message.property.*;
import org.jetlinks.core.message.state.DeviceStateCheckMessage;
import org.jetlinks.core.message.state.DeviceStateCheckMessageReply;

/**
 * 消息扩展函数
 * @param <T>
 */
public interface ExtendedFunction<T> {

    T apply(ReadPropertyMessage message);

    T apply(ReadPropertyMessageReply message);

    T apply(WritePropertyMessage message);

    T apply(WritePropertyMessageReply message);

    T apply(FunctionInvokeMessage message);

    T apply(FunctionInvokeMessageReply message);

    T apply(ReadFirmwareMessage message);

    T apply(ReadFirmwareMessageReply message);

    T apply(DeviceStateCheckMessage message);

    T apply(DeviceStateCheckMessageReply message);

    T apply(RequestFirmwareMessage message);

    T apply(RequestFirmwareMessageReply message);

    T apply(ChildDeviceMessage message);

    T apply(ChildDeviceMessageReply message);

    T apply(UpgradeFirmwareMessage message);

    T apply(UpgradeFirmwareMessageReply message);

    T apply(DerivedMetadataMessage message);

    T apply(DeviceRegisterMessage message);

    T apply(DeviceUnRegisterMessage message);

    T apply(DeviceOnlineMessage message);

    T apply(DeviceOfflineMessage message);

    T apply(DisconnectDeviceMessage message);

    T apply(DisconnectDeviceMessageReply message);

    T apply(DirectDeviceMessage message);

    T apply(AcknowledgeDeviceMessage message);

    T apply(UpdateTagMessage message);

    T apply(EventMessage message);

    default T route(ThingMessage message) {
        if (message instanceof ReadPropertyMessage) {
            return apply((ReadPropertyMessage) message);
        }
        if (message instanceof ReadPropertyMessageReply) {
            return apply((ReadPropertyMessageReply) message);
        }
        if (message instanceof WritePropertyMessage) {
            return apply((WritePropertyMessage) message);
        }
        if (message instanceof WritePropertyMessageReply) {
            return apply((WritePropertyMessageReply) message);
        }
        if (message instanceof FunctionInvokeMessage) {
            return apply((FunctionInvokeMessage) message);
        }
        if (message instanceof FunctionInvokeMessageReply) {
            return apply((FunctionInvokeMessageReply) message);
        }
        if (message instanceof ReadFirmwareMessage) {
            return apply((ReadFirmwareMessage) message);
        }
        if (message instanceof ReadFirmwareMessageReply) {
            return apply((ReadFirmwareMessageReply) message);
        }
        if (message instanceof DeviceStateCheckMessage) {
            return apply((DeviceStateCheckMessage) message);
        }
        if (message instanceof DeviceStateCheckMessageReply) {
            return apply((DeviceStateCheckMessageReply) message);
        }
        if (message instanceof RequestFirmwareMessage) {
            return apply((RequestFirmwareMessage) message);
        }
        if (message instanceof RequestFirmwareMessageReply) {
            return apply((RequestFirmwareMessageReply) message);
        }
        if (message instanceof ChildDeviceMessage) {
            return apply((ChildDeviceMessage) message);
        }
        if (message instanceof ChildDeviceMessageReply) {
            return apply((ChildDeviceMessageReply) message);
        }
        if (message instanceof UpgradeFirmwareMessage) {
            return apply((UpgradeFirmwareMessage) message);
        }
        if (message instanceof UpgradeFirmwareMessageReply) {
            return apply((UpgradeFirmwareMessageReply) message);
        }
        if (message instanceof DerivedMetadataMessage) {
            return apply((DerivedMetadataMessage) message);
        }
        if (message instanceof DeviceRegisterMessage) {
            return apply((DeviceRegisterMessage) message);
        }
        if (message instanceof DeviceUnRegisterMessage) {
            return apply((DeviceUnRegisterMessage) message);
        }
        if (message instanceof DeviceOnlineMessage) {
            return apply((DeviceOnlineMessage) message);
        }
        if (message instanceof DeviceOfflineMessage) {
            return apply((DeviceOfflineMessage) message);
        }
        if (message instanceof DisconnectDeviceMessage) {
            return apply((DisconnectDeviceMessage) message);
        }
        if (message instanceof DisconnectDeviceMessageReply) {
            return apply((DisconnectDeviceMessageReply) message);
        }
        if (message instanceof DirectDeviceMessage) {
            return apply((DirectDeviceMessage) message);
        }
        if (message instanceof AcknowledgeDeviceMessage) {
            return apply((AcknowledgeDeviceMessage) message);
        }
        if (message instanceof UpdateTagMessage) {
            return apply((UpdateTagMessage) message);
        }
        if (message instanceof EventMessage) {
            return apply((EventMessage) message);
        }

        return null;
    }

}
