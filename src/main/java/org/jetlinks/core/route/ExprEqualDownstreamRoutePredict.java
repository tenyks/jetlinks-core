package org.jetlinks.core.route;

import com.fasterxml.jackson.databind.JsonNode;
import org.jetlinks.core.message.DeviceMessage;

import javax.annotation.Nonnull;
import java.util.function.Function;

/**
 * @author v-lizy81
 * @version 1.0.0
 * @date 2024/11/5
 * @since V3.1.0
 */
public class ExprEqualDownstreamRoutePredict<R extends Route, M extends DeviceMessage> implements DownstreamRoutePredict<R, M> {

    private final Object                expectedValue;

    private final Function<JsonNode, Object>   getter;

    public ExprEqualDownstreamRoutePredict(Function<JsonNode, Object> getter, Object expectedValue) {
        this.expectedValue = expectedValue;
        this.getter = getter;
    }

    @Override
    public boolean isAcceptable(@Nonnull R route, @Nonnull M message, @Nonnull JsonNode encodedMsg) {
        Object realVal = getter.apply(encodedMsg);

        if (realVal == null) return (expectedValue == null);

        return realVal.equals(expectedValue);
    }

    @Override
    public boolean isAcceptable(@Nonnull R route, @Nonnull M message) {
        return false;
    }
}
