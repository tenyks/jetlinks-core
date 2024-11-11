package org.jetlinks.core.route;

import lombok.Getter;

@Getter
class DefaultMqttRoute implements MqttRoute {

    private final String topic;
    private final String replyTopic;
    private final transient TemplateTopic templateTopic;
    private final boolean upstream;
    private final boolean downstream;
    private final boolean downstreamForFunctionHandleResponse;
    private final int qos;
    private final String group;
    private final String description;
    private final String example;

    DefaultMqttRoute(String manufacturerCode,
                     String topic,
                     String replyTopic,
                     boolean upstream,
                     boolean downstream,
                     boolean downstreamForFunctionHandleResponse,
                     int qos,
                     String group,
                     String description,
                     String example) {
        this.topic = topic;
        this.replyTopic = replyTopic;
        this.templateTopic = new TemplateTopic(topic, 1, manufacturerCode);
        this.upstream = upstream;
        this.downstream = downstream;
        this.downstreamForFunctionHandleResponse = downstreamForFunctionHandleResponse;
        this.qos = qos;
        this.group = group;
        this.description = description;
        this.example = example;
    }

    @Override
    public TemplateTopic getTopicTemplate() {
        return templateTopic;
    }

    static DefaultMqttRouteBuilder builder() {
        return new DefaultMqttRouteBuilder();
    }

    static class DefaultMqttRouteBuilder implements Builder {
        private String  manufacturerCode;
        private String  topic;
        private String  replyTopic;
        private boolean upstream;
        private boolean downstream;
        private boolean downstreamForFunctionHandleResponse;
        private int qos;
        private String group;
        private String description;
        private String example;

        DefaultMqttRouteBuilder() {
        }

        @Override
        public DefaultMqttRouteBuilder manufacturerCode(String manufacturerCode) {
            this.manufacturerCode = manufacturerCode;
            return this;
        }

        public DefaultMqttRouteBuilder topic(String topic) {
            this.topic = topic;
            return this;
        }

        public DefaultMqttRouteBuilder replyTopic(String topic) {
            this.replyTopic = topic;
            return this;
        }

        public DefaultMqttRouteBuilder upstream(boolean upstream) {
            this.upstream = upstream;
            return this;
        }

        public DefaultMqttRouteBuilder downstream(boolean downstream) {
            if (downstream) {
                this.downstream = true;
            } else {
                this.downstream = false;
                this.downstreamForFunctionHandleResponse = false;
            }

            return this;
        }

        public DefaultMqttRouteBuilder downstreamForFunctionHandleResponse(boolean downstreamForFunctionHandleResponse) {
            if (downstreamForFunctionHandleResponse) {
                this.downstream = true;
                this.downstreamForFunctionHandleResponse = true;
            } else {
                this.downstreamForFunctionHandleResponse = false;
            }

            return this;
        }

        public DefaultMqttRouteBuilder qos(int qos) {
            this.qos = qos;
            return this;
        }

        public DefaultMqttRouteBuilder group(String group) {
            this.group = group;
            return this;
        }

        public DefaultMqttRouteBuilder description(String description) {
            this.description = description;
            return this;
        }

        public DefaultMqttRouteBuilder example(String example) {
            this.example = example;
            return this;
        }

        public DefaultMqttRoute build() {
            return new DefaultMqttRoute(manufacturerCode, topic, replyTopic, upstream, downstream, downstreamForFunctionHandleResponse, qos, group, description, example);
        }

        public String toString() {
            return "DefaultMqttRoute.DefaultMqttRouteBuilder(manufacturerCode=" + this.manufacturerCode + ", topic=" + this.topic + ", replyTopic=" + this.replyTopic +
                    ", upstream=" + this.upstream + ", downstream=" + this.downstream +
                    ", downstreamForFunctionHandleResponse=" + this.downstreamForFunctionHandleResponse +
                    ", qos=" + this.qos + ", group=" + this.group +
                    ", description=" + this.description + ", example=" + this.example + ")";
        }
    }
}
