package navigation;

public class CycleStrategy implements RouteStrategy {

    @Override
    public String buildRoute(String start, String destination, double distanceKm) {

        double averageSpeed = 15.0;
        double travelTime = distanceKm / averageSpeed * 60;

        return String.format(
                "Bicycle route: %s -> %s | Distance: %.1f km | Estimated time: %.0f minutes",
                start,
                destination,
                distanceKm,
                travelTime
        );
    }
}