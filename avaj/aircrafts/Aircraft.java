package avaj.aircrafts;

import avaj.aircrafts.*;
import avaj.weather_definer.*;
import avaj.simulator.*;

/**
 * Created by mdynia on 2/2/19.
 */

public class Aircraft {
    protected long          id;
    protected String        name;
    protected Coordinates   coordinates;
    private static long            idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }
    private long nextId() {
        return (++idCounter);
    }
}
