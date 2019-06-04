package avaj.simulator;

import avaj.aircrafts.*;
import avaj.weather_definer.*;
import avaj.simulator.*;

public class InvalidContentException extends Exception {
    public InvalidContentException(String ExceptionMessage) {
        super(ExceptionMessage);
    }
}
