package avaj.weather_definer;

import avaj.aircrafts.*;
import avaj.weather_definer.*;
import avaj.simulator.*;

/**
 * Created by mdynia on 2/2/19.
 */

public class WeatherTower extends Tower {
    private static int Simulations_nb;
    public static int i = 0;

    public static String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
    public void changeWeather()
    {
        while (Simulations_nb > this.i) {
            super.conditionChanged();
            this.i++;
        }
    }
    public static void setSimulations_nb(int Simulations)
    {
        Simulations_nb = Simulations;
    }
}
