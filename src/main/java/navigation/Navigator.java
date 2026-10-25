package navigation;

import java.util.Objects;

public class Navigator {

    private RouteStrategy routeStrategy;

    public Navigator(RouteStrategy routeStrategy) {
        setRouteStrategy(routeStrategy);
    }

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = Objects.requireNonNull(routeStrategy);
    }

    public void planRoute(
            String start,
            String destination,
            double distanceKm
    ) {
        String route = routeStrategy.buildRoute(
                start,
                destination,
                distanceKm
        );

        System.out.println(route);
    }
}