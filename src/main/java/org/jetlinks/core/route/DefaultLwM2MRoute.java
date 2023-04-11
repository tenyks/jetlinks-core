package org.jetlinks.core.route;

import lombok.Getter;
import org.jetlinks.core.message.codec.lwm2m.LwM2MResource;

@Getter
public class DefaultLwM2MRoute implements LwM2MRoute {

    private final LwM2MResource resource;
    private final String path;
    private final String messageType;
    private final boolean upstream;
    private final boolean downstream;
    private final String group;
    private final String description;
    private final String example;

    DefaultLwM2MRoute(LwM2MResource resource,
                      String path,
                      String messageType,
                      boolean upstream,
                      boolean downstream,
                      String group,
                      String description,
                      String example) {
        this.resource = resource;
        this.path = path;
        this.messageType = messageType;
        this.upstream = upstream;
        this.downstream = downstream;
        this.group = group;
        this.description = description;
        this.example = example;
    }

    @Override
    public String toString() {
        return "DefaultLwM2MRoute{" +
                "resource='" + resource + '\'' +
                "path='" + path + '\'' +
                ", messageType='" + messageType + '\'' +
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
        private LwM2MResource resource;
        private String path;
        private String messageType;
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
        public Builder resource(LwM2MResource resource) {
            this.resource = resource;
            return this;
        }

        @Override
        public Builder messageType(String msgType) {
            this.messageType = msgType;
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
            return new DefaultLwM2MRoute(resource, path, messageType, upstream, downstream, group, description, example);
        }

        public String toString() {
            return "DefaultMqttRoute.DefaultMqttRouteBuilder(resource=" + this.resource + ", path=" + this.path + ", upstream=" + this.upstream + ", downstream=" + this.downstream + ", group=" + this.group + ", description=" + this.description + ", example=" + this.example + ")";
        }
    }

}
