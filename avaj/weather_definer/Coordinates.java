package avaj.weather_definer;

import avaj.aircrafts.*;
import avaj.weather_definer.*;
import avaj.simulator.*;

/**
 * Created by mdynia on 2/2/19.
 */
public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;

    // package

    public  Coordinates(int longitude, int latitude, int height)
    {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }
    public int getLongitude()
    {
        return (this.longitude);
    }
    public int getLatitude()
    {
        return (this.latitude);
    }
    public int getHeight()
    {
        return (this.height);
    }

    public void setLongitude(int i) {
        this.longitude = i;
    }
    public void setLatitude(int i) {
        this.latitude = i;
    }
    public void setHeight(int i)
    {
        this.height = i;
    }
}
