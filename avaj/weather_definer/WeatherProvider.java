package avaj.weather_definer;

import avaj.aircrafts.*;
import avaj.weather_definer.*;
import avaj.simulator.*;
import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather = {"RAIN","FOG","SUN","SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return (WeatherProvider.weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates)/// to check this shit
    {
        Random rand = new Random();

        int n = rand.nextInt(4);
        return (weather[n]);
    }
}
