package org.jetlinks.core.route;

public interface LwM2MRoute extends Route {

    String getPath();

    boolean isUpstream();

    boolean isDownstream();

    @Override
    default String getAddress() {
        return getPath();
    }

    static LwM2MRoute.Builder builder(String path) {
        return DefaultLwM2MRoute
                .builder()
                .path(path);
    }

    interface Builder {

        LwM2MRoute.Builder group(String group);

        LwM2MRoute.Builder path(String path);

        LwM2MRoute.Builder downstream(boolean downstream);

        LwM2MRoute.Builder upstream(boolean downstream);

        LwM2MRoute.Builder description(String description);

        LwM2MRoute.Builder example(String example);

        LwM2MRoute build();
    }

}
