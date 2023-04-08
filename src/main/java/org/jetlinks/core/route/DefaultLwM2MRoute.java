package org.jetlinks.core.route;

import lombok.Getter;

@Getter
public class DefaultLwM2MRoute implements LwM2MRoute {

    private final String path;
    private final boolean upstream;
    private final boolean downstream;
    private final String group;
    private final String description;
    private final String example;

    DefaultLwM2MRoute(String path,
                     boolean upstream,
                     boolean downstream,
                     String group,
                     String description,
                     String example) {
        this.path = path;
        this.upstream = upstream;
        this.downstream = downstream;
        this.group = group;
        this.description = description;
        this.example = example;
    }


    static DefaultLwM2MRoute.DefaultLwM2MRouteBuilder builder() {
        return new DefaultLwM2MRoute.DefaultLwM2MRouteBuilder();
    }


    static class DefaultLwM2MRouteBuilder implements LwM2MRoute.Builder {
        private String path;
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
            return new DefaultLwM2MRoute(path, upstream, downstream, group, description, example);
        }

        public String toString() {
            return "DefaultMqttRoute.DefaultMqttRouteBuilder(topic=" + this.path + ", upstream=" + this.upstream + ", downstream=" + this.downstream + ", group=" + this.group + ", description=" + this.description + ", example=" + this.example + ")";
        }
    }

}
