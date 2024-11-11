package org.jetlinks.core.route;

import com.fasterxml.jackson.databind.JsonNode;
import org.jetlinks.core.message.DeviceMessage;

import javax.annotation.Nonnull;

/**
 * @author v-lizy81
 * @version 1.0.0
 * @date 2024/11/11
 * @since V3.1.0
 */
public class DownstreamRoutePredictBySvcId<R extends Route, M extends DeviceMessage> implements DownstreamRoutePredict<R, M> {

    private final String      expectedSvcId;

    public DownstreamRoutePredictBySvcId(String expectedSvcId) {
        if (expectedSvcId == null) {
            throw new IllegalArgumentException("参数不全。[0x37DRPBS2064]");
        }
        this.expectedSvcId = expectedSvcId;
    }

    @Override
    public boolean isAcceptable(@Nonnull R route, @Nonnull M message, @Nonnull JsonNode encodedMsg) {
        return isAcceptable(route, message);
    }

    @Override
    public boolean isAcceptable(@Nonnull R route, @Nonnull M message) {
        String realSvcId = message.getServiceId();

        return expectedSvcId.equals(realSvcId);
    }

    @Override
    public String toString() {
        return "DownstreamRoutePredictBySvcId{" +
                "expectedSvcId='" + expectedSvcId + '\'' +
                '}';
    }
}
