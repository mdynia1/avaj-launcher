package avaj.aircrafts;

import avaj.aircrafts.*;
import avaj.weather_definer.*;
import avaj.simulator.*;

public class JetPlane extends Aircraft implements Flyable {
    WeatherTower weatherTower;
    public String buffer = null;
    //package
    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    public void updateConditions()
    {
        String weather = WeatherTower.getWeather(this.coordinates);
        weather = weather.toLowerCase();
        buffer = "Aircraft#" + this.name + "("+ this.id + "): ";
        if (weather.equals("sun"))
        {
            //coordinates = Coordinates(0, 1, 1);
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
            buffer =  buffer + " This is sun!\n";
        }
        else if (weather.equals("rain"))
        {
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
            buffer =  buffer + " This is rain!\n";
        }
        else if (weather.equals("fog"))
        {
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
            buffer =  buffer + " This is fog!\n";
        }
        else if(weather.equals("snow"))
        {
            this.coordinates.setHeight(this.coordinates.getHeight() - 7);
            buffer =  buffer + " This is snow!\n";
        }
        else
            System.out.println("Something went wrong!\n");
        if (this.coordinates.getHeight() < 0) {
            weatherTower.unregister(this);
            buffer =  buffer + "High time to land JetPlane!\n";
            buffer =  buffer + "Tower says: JetPlane#" + this.name + "("+ this.id + ")" + " unregistered to weather tower.\n";
        }
        else if (this.coordinates.getHeight() > 100) {
            this.coordinates.setHeight(100);
        }
        else if (this.coordinates.getLatitude() > 100) {
            this.coordinates.setHeight(100);
        }
        Main.file.writeToFile(buffer);
    }
    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        Main.file.writeToFile("Tower says: JetPlane#" + this.name + "("+ this.id + ")" + " registered to weather tower.\n");
    }
}
