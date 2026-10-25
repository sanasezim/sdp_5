package navigation;

public class WalkStrategy implements RouteStrategy {

    @Override
    public String buildRoute(String start, String destination, double distanceKm) {

        double averageSpeed = 5.0;
        double travelTime = distanceKm / averageSpeed * 60;

        return String.format(
                "Walking route: %s -> %s | Distance: %.1f km | Estimated time: %.0f minutes",
                start,
                destination,
                distanceKm,
                travelTime
        );
    }
}