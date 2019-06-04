package avaj.simulator;

import avaj.aircrafts.*;
import avaj.weather_definer.*;
import avaj.simulator.*;
import java.io.*;


public class Main {
    public static FileRecorder file = new FileRecorder("simulations.txt");
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (Integer.parseInt(line) <= 0) {
                throw new InvalidContentException("Invalid number of simulations!");
            }
            WeatherTower weatherTower = new WeatherTower();
            AircraftFactory aircraft = new AircraftFactory();
            weatherTower.setSimulations_nb(Integer.parseInt(line));
            int line_nbr = 2;
            while ((line = reader.readLine()) != null) {
                String[] splited = line.split(" ");
                if (splited.length != 5) {
                    throw new InvalidContentException("Format is not valid: Type + Name + Longitude + Latitude + Height! LINE: " + line_nbr);
                }
                if (!splited[0].equals("Baloon") && !splited[0].equals("JetPlane") && !splited[0].equals("Helicopter")) {
                    throw new InvalidContentException("Available aircraft: Baloon, JetPlane, Helicopter! LINE: " + line_nbr);
                }
                if (Integer.parseInt(splited[2]) < 0){
                    throw new InvalidContentException("Longitude below 0 is unacceptable! LINE: " + line_nbr);
                }
                if (Integer.parseInt(splited[3]) < 0){
                    throw new InvalidContentException("Latitude below 0 is unacceptable! LINE: " + line_nbr);
                }
                if (Integer.parseInt(splited[4]) < 0){
                    throw new InvalidContentException("Height below 0 is unacceptable! LINE: " + line_nbr);
                }
                Flyable flyable = aircraft.newAircraft(splited[0],
                        splited[1],
                        Integer.parseInt(splited[2]),
                        Integer.parseInt(splited[3]),
                        Integer.parseInt(splited[4]));
                flyable.registerTower(weatherTower);
                line_nbr++;
            }
            weatherTower.changeWeather();
            file.closeFile();
            BufferedReader reader1 = new BufferedReader(new FileReader("simulations.txt"));
           while ((line = reader1.readLine()) != null)
           {
               System.out.println(line);
           }

        }
        catch (InvalidContentException e)
        {
            System.out.println(e);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
