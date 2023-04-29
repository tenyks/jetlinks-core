package org.jetlinks.core.route;

import lombok.Getter;
import org.jetlinks.core.message.codec.MessagePayloadType;
import org.jetlinks.core.message.codec.lwm2m.LwM2MOperation;

@Getter
public class DefaultLwM2MRoute implements LwM2MRoute {

    private final LwM2MOperation    operation;
    private final String    path;
    private final String    messageType;
    private final MessagePayloadType payloadType;
    private final boolean upstream;
    private final boolean downstream;
    private final boolean request;
    private final String group;
    private final String description;
    private final String example;

    DefaultLwM2MRoute(String path,
                      LwM2MOperation operation,
                      MessagePayloadType payloadType,
                      String messageType,
                      boolean upstream,
                      boolean downstream,
                      boolean request,
                      String group,
                      String description,
                      String example) {
        this.path = path;
        this.operation = operation;
        this.payloadType = payloadType;
        this.messageType = messageType;
        this.upstream = upstream;
        this.downstream = downstream;
        this.request = request;
        this.group = group;
        this.description = description;
        this.example = example;
    }

    @Override
    public String toString() {
        return "DefaultLwM2MRoute{" +
                "operation=" + operation +
                ", path='" + path + '\'' +
                ", messageType='" + messageType + '\'' +
                ", payloadType=" + payloadType +
                ", upstream=" + upstream +
                ", downstream=" + downstream +
                ", request=" + request +
                ", group='" + group + '\'' +
                ", description='" + description + '\'' +
                ", example='" + example + '\'' +
                '}';
    }

    static DefaultLwM2MRoute.DefaultLwM2MRouteBuilder builder() {
        return new DefaultLwM2MRoute.DefaultLwM2MRouteBuilder();
    }

    static class DefaultLwM2MRouteBuilder implements LwM2MRoute.Builder {
        private LwM2MOperation operation;
        private String path;
        private MessagePayloadType payloadType;
        private String messageType;
        private boolean upstream;
        private boolean downstream;
        private boolean request;
        private String group;
        private String description;
        private String example;

        DefaultLwM2MRouteBuilder() {
        }

        public DefaultLwM2MRoute.DefaultLwM2MRouteBuilder path(String path) {
            this.path = path;
            return this;
        }

        public DefaultLwM2MRoute.DefaultLwM2MRouteBuilder messageType(String messageType) {
            this.messageType = messageType;
            return this;
        }

        @Override
        public Builder payloadType(MessagePayloadType payloadType) {
            this.payloadType = payloadType;
            return this;
        }

        @Override
        public Builder upstreamResponse() {
            this.upstream = true;
            this.downstream = false;
            this.request = false;
            return this;
        }

        @Override
        public Builder upstreamRequest(LwM2MOperation operation) {
            this.upstream = true;
            this.downstream = false;
            this.request = true;
            this.operation = operation;

            return this;
        }

        @Override
        public Builder downstreamRequest(LwM2MOperation operation) {
            this.upstream = false;
            this.downstream = true;
            this.request = true;
            this.operation = operation;

            return this;
        }

        @Override
        public Builder downstreamResponse() {
            this.upstream = false;
            this.downstream = true;
            this.request = false;

            return this;
        }

        public DefaultLwM2MRoute.DefaultLwM2MRouteBuilder group(String group) {
            this.group = group;
            return this;
        }

        public DefaultLwM2MRoute.DefaultLwM2MRouteBuilder description(String description) {
            this.description = description;
            return this;
        }

        public DefaultLwM2MRoute.DefaultLwM2MRouteBuilder example(String example) {
            this.example = example;
            return this;
        }

        public DefaultLwM2MRoute build() {
            return new DefaultLwM2MRoute(path, operation, payloadType, messageType, upstream, downstream, request, group, description, example);
        }

        @Override
        public String toString() {
            return "DefaultLwM2MRouteBuilder{" +
                    "operation=" + operation +
                    ", path='" + path + '\'' +
                    ", payloadType=" + payloadType +
                    ", messageType='" + messageType + '\'' +
                    ", upstream=" + upstream +
                    ", downstream=" + downstream +
                    ", request=" + request +
                    ", group='" + group + '\'' +
                    ", description='" + description + '\'' +
                    ", example='" + example + '\'' +
                    '}';
        }
    }

}
