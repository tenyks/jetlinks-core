package org.jetlinks.core.message.extend;

import org.jetlinks.core.message.*;
import org.jetlinks.core.message.event.EventMessage;
import org.jetlinks.core.message.firmware.*;
import org.jetlinks.core.message.function.FunctionInvokeMessage;
import org.jetlinks.core.message.function.FunctionInvokeMessageReply;
import org.jetlinks.core.message.property.ReadPropertyMessage;
import org.jetlinks.core.message.property.ReadPropertyMessageReply;
import org.jetlinks.core.message.property.WritePropertyMessage;
import org.jetlinks.core.message.property.WritePropertyMessageReply;
import org.jetlinks.core.message.state.DeviceStateCheckMessage;
import org.jetlinks.core.message.state.DeviceStateCheckMessageReply;

import java.util.List;

/**
 * 物模型Header、Property和Parameter及取值
 * @author tenyks.lee
 * @since 3.1
 * @version 1.0
 */
public class DeviceMessageObserver implements ExtendedFunction<Iterable<ThingItemAndValue>> {

    public Iterable<ThingItemAndValue>     observe(ThingMessage msg) {
        return route(msg);
    }

    private void collect(List<ThingItemAndValue> buf) {

    }

    @Override
    public Iterable<ThingItemAndValue> apply(ReadPropertyMessage message) {



        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(ReadPropertyMessageReply message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(WritePropertyMessage message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(WritePropertyMessageReply message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(FunctionInvokeMessage message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(FunctionInvokeMessageReply message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(ReadFirmwareMessage message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(ReadFirmwareMessageReply message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(DeviceStateCheckMessage message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(DeviceStateCheckMessageReply message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(RequestFirmwareMessage message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(RequestFirmwareMessageReply message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(ChildDeviceMessage message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(ChildDeviceMessageReply message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(UpgradeFirmwareMessage message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(UpgradeFirmwareMessageReply message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(DerivedMetadataMessage message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(DeviceRegisterMessage message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(DeviceUnRegisterMessage message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(DeviceOnlineMessage message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(DeviceOfflineMessage message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(DisconnectDeviceMessage message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(DisconnectDeviceMessageReply message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(DirectDeviceMessage message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(AcknowledgeDeviceMessage message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(UpdateTagMessage message) {
        return null;
    }

    @Override
    public Iterable<ThingItemAndValue> apply(EventMessage message) {
        return null;
    }
}
