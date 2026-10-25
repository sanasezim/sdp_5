package navigation;

public class Main {

    public static void main(String[] args) {

        String start = "Astana IT University";
        String destination = "Khan Shatyr";
        double distanceKm = 8.0;

        Navigator navigator = new Navigator(
                new CarStrategy()
        );

        System.out.println("=== CAR ===");
        navigator.planRoute(
                start,
                destination,
                distanceKm
        );

        System.out.println();

        System.out.println("=== WALK ===");
        navigator.setRouteStrategy(
                new WalkStrategy()
        );

        navigator.planRoute(
                start,
                destination,
                distanceKm
        );

        System.out.println();

        System.out.println("=== BICYCLE ===");
        navigator.setRouteStrategy(
                new CycleStrategy()
        );

        navigator.planRoute(
                start,
                destination,
                distanceKm
        );
    }
}