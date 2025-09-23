class Weather {
    String condition;

    Weather(String condition) {
        this.condition = condition;
        System.out.println("Weather constructor called");
    }

    void showWeather() {
        System.out.println("General weather: " + condition);
    }
}
class Storm extends Weather {
    Storm(String condition) {
        super(condition); 
        System.out.println("Storm constructor called");
    }

    @Override
    void showWeather() {
        System.out.println("Stormy weather: " + condition);
    }
}
class Thunderstorm extends Storm {
    Thunderstorm(String condition) {
        super(condition);
        System.out.println("Thunderstorm constructor called");
    }

    @Override
    void showWeather() {
        System.out.println("Thunderstorm with lightning: " + condition);
    }
}
class Sunshine extends Weather {
    Sunshine(String condition) {
        super(condition);
        System.out.println("Sunshine constructor called");
    }

    @Override
    void showWeather() {
        System.out.println("Sunny weather: " + condition);
    }
}
public class WeatherTest {
    public static void main(String[] args) {
        Weather w1 = new Weather("Mild");
        Storm s1 = new Storm("Strong winds");
        Thunderstorm t1 = new Thunderstorm("Heavy lightning");
        Sunshine sun1 = new Sunshine("Clear sky");

        System.out.println("\n--- Demonstration ---");
        w1.showWeather();
        s1.showWeather();
        t1.showWeather();
        sun1.showWeather();
    }
}
