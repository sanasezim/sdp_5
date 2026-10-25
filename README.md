# Assignment 5 — Strategy Pattern

## Project Description

This project demonstrates the **Strategy Design Pattern** using a navigation system.

The application can build a route using different transportation strategies:

- Car
- Walking
- Bicycle

The `Navigator` class acts as the **Context**. It stores a reference to a `RouteStrategy` and delegates the route calculation to the selected strategy.

The strategy can be changed at runtime without modifying the `Navigator` class.

---

## Strategy Pattern Structure

### Strategy Interface

`RouteStrategy`

Defines the common method:

```java
String buildRoute(String start, String destination, double distanceKm);
```

### Concrete Strategies

The project contains three implementations:

- `CarStrategy`
- `WalkStrategy`
- `CycleStrategy`

Each strategy calculates estimated travel time using a different average speed.

### Context

`Navigator`

The Navigator does not know how each route is calculated. It only works with the `RouteStrategy` interface.

The strategy can be changed using:

```java
navigator.setRouteStrategy(new WalkStrategy());
```

### Client

`Main`

The `Main` class creates the Navigator, selects strategies, and demonstrates runtime strategy switching.

---

## Project Structure

```text
src
└── main
    └── java
        └── navigation
            ├── RouteStrategy.java
            ├── CarStrategy.java
            ├── WalkStrategy.java
            ├── CycleStrategy.java
            ├── Navigator.java
            └── Main.java
```

---

## Example

The program first uses the car strategy:

```java
Navigator navigator = new Navigator(new CarStrategy());
navigator.planRoute(start, destination, distanceKm);
```

Then the strategy is changed at runtime:

```java
navigator.setRouteStrategy(new WalkStrategy());
navigator.planRoute(start, destination, distanceKm);
```

And later:

```java
navigator.setRouteStrategy(new CycleStrategy());
navigator.planRoute(start, destination, distanceKm);
```

No `if` or `switch` statement is required inside the `Navigator`.

---

## Clean Code Principles

The project applies several Clean Code principles:

1. **Single Responsibility Principle**  
   Each strategy is responsible for only one route calculation algorithm.

2. **Meaningful Names**  
   Classes such as `CarStrategy`, `WalkStrategy`, and `CycleStrategy` clearly describe their purpose.

3. **Polymorphism Instead of Conditionals**  
   Different algorithms are selected using the `RouteStrategy` interface instead of large `if` or `switch` statements.

4. **Low Coupling**  
   `Navigator` depends on the `RouteStrategy` interface and not on concrete strategy classes.

5. **Open/Closed Principle**  
   A new route strategy can be added without modifying the existing `Navigator` class.

---

## How to Run

Requirements:

- Java JDK 17
- IntelliJ IDEA

Steps:

1. Open the project in IntelliJ IDEA.
2. Open:

```text
src/main/java/navigation/Main.java
```

3. Run the `main()` method.
4. Check the output in the Run console.

---

## Expected Output

```text
=== CAR ===
Car route: Astana IT University -> Khan Shatyr | Distance: 8.0 km | Estimated time: 10 minutes

=== WALK ===
Walking route: Astana IT University -> Khan Shatyr | Distance: 8.0 km | Estimated time: 96 minutes

=== BICYCLE ===
Bicycle route: Astana IT University -> Khan Shatyr | Distance: 8.0 km | Estimated time: 32 minutes
```

---

## Advantages of Strategy Pattern

- Removes large conditional statements.
- Makes algorithms interchangeable.
- Makes the code easier to extend.
- Keeps individual algorithms separated.
- Allows changing behavior at runtime.

## Disadvantages

- Creates additional classes.
- The client needs to know which strategy to select.
- For very simple applications, the pattern may add unnecessary complexity.

---

## Conclusion

The Strategy Pattern makes the navigation system flexible because different route algorithms can be selected and changed at runtime.

The `Navigator` remains independent from the concrete route calculation algorithms. New strategies can also be added without changing the existing context class.
