package org.jetlinks.core.route;

import lombok.Getter;
import org.jetlinks.core.message.codec.MessagePayloadType;
import org.jetlinks.core.message.codec.lwm2m.LwM2MOperation;

@Getter
public class DefaultLwM2MRoute implements LwM2MRoute {

    private final LwM2MOperation    operation;
    private final String    path;
    private final MessagePayloadType payloadType;
    private final boolean upstream;
    private final boolean downstream;
    private final String group;
    private final String description;
    private final String example;

    DefaultLwM2MRoute(LwM2MOperation operation,
                      String path,
                      MessagePayloadType payloadType,
                      boolean upstream,
                      boolean downstream,
                      String group,
                      String description,
                      String example) {
        this.operation = operation;
        this.path = path;
        this.payloadType = payloadType;
        this.upstream = upstream;
        this.downstream = downstream;
        this.group = group;
        this.description = description;
        this.example = example;
    }

    @Override
    public String toString() {
        return "DefaultLwM2MRoute{" +
                "operation=" + operation +
                ", path='" + path + '\'' +
                ", payloadType=" + payloadType +
                ", upstream=" + upstream +
                ", downstream=" + downstream +
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
        private boolean upstream;
        private boolean downstream;
        private String group;
        private String description;
        private String example;

        DefaultLwM2MRouteBuilder() {
        }

        public DefaultLwM2MRoute.DefaultLwM2MRouteBuilder path(String path) {
            this.path = path;
            return this;
        }

        @Override
        public Builder operation(LwM2MOperation operation) {
            this.operation = operation;
            return this;
        }

        @Override
        public Builder payloadType(MessagePayloadType payloadType) {
            this.payloadType = payloadType;
            return this;
        }

        public DefaultLwM2MRoute.DefaultLwM2MRouteBuilder upstream(boolean upstream) {
            this.upstream = upstream;
            return this;
        }

        public DefaultLwM2MRoute.DefaultLwM2MRouteBuilder downstream(boolean downstream) {
            this.downstream = downstream;
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
            return new DefaultLwM2MRoute(operation, path, payloadType, upstream, downstream, group, description, example);
        }

        public String toString() {
            return "DefaultMqttRoute.DefaultMqttRouteBuilder(operation=" + this.operation + ", path=" + this.path + ", payloadType=" + this.payloadType + ", upstream=" + this.upstream + ", downstream=" + this.downstream + ", group=" + this.group + ", description=" + this.description + ", example=" + this.example + ")";
        }
    }

}
