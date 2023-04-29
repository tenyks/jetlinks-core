package org.jetlinks.core.message.codec.lwm2m;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LwM2MResourceTest {

    @Test
    public void parse() {
        LwM2MResource resource;

        resource = LwM2MResource.parse("/19/0/1");
        Assert.assertNotNull(resource);
        Assert.assertEquals(Integer.valueOf(19), resource.getObjectId());
        Assert.assertEquals(Integer.valueOf(0), resource.getObjectInstanceId());
        Assert.assertEquals(Integer.valueOf(1), resource.getResourceId());
        Assert.assertNull(resource.getResourceInstanceId());

    }
}