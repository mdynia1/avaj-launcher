package avaj.aircrafts;

import avaj.aircrafts.*;
import avaj.weather_definer.*;
import avaj.simulator.*;

/**
 * Created by mdynia on 2/2/19.
 */

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower WeatherTower);

}

