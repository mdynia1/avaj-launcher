package avaj.aircrafts;

import avaj.aircrafts.*;
import avaj.weather_definer.*;
import avaj.simulator.*;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        String str = type.toLowerCase();
        if (str.equals("baloon")) {
            return new Baloon(name, coordinates);
        }
        else if (str.equals("jetplane")) {
            return new JetPlane(name, coordinates);
        }
        else if (str.equals("helicopter")) {
            return new Helicopter(name, coordinates);
        } else {
            return null;
        }
    }
}
