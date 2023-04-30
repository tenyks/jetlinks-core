package org.jetlinks.core.message.codec.lwm2m;

import org.jetlinks.core.route.LwM2MRoute;

/**
 * @author v-lizy8
 * @date 2023/3/27
 */
public class SimpleLwM2MDownlinkMessage extends AbstractLwM2MMessage implements LwM2MDownlinkMessage {

    public SimpleLwM2MDownlinkMessage(LwM2MRoute route) {
        this.setRequestOperation(route.getOperation());
        this.setPath(route.getPath());
    }

    public SimpleLwM2MDownlinkMessage() {

    }
}
