package avaj.weather_definer;

import avaj.aircrafts.*;
import avaj.weather_definer.*;
import avaj.simulator.*;

/**
 * Created by mdynia on 2/2/19.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();
    private List<Flyable> remover = new ArrayList<Flyable>();
    public void register(Flyable flyable)
    {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable)
    {
        remover.add(flyable);
    }

    protected void conditionChanged()
    {
        if (observers.isEmpty())
        {
            WeatherTower.setSimulations_nb(0);
            Main.file.writeToFile("No aircraft available!\n");
        }
        else {
            Main.file.writeToFile("___________Simulation №" + (WeatherTower.i + 1) + "___________\n");
            for (Flyable flyable : observers) {
                flyable.updateConditions();
            }
            observers.removeAll(remover);
            remover.clear();
        }
    }
}

