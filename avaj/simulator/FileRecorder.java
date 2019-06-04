package avaj.simulator;

import avaj.aircrafts.*;
import avaj.weather_definer.*;
import avaj.simulator.*;
import java.io.*;

public class FileRecorder {

    private FileWriter fw = null;
     FileRecorder(String content) {
        try {
            this.fw = new FileWriter(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeToFile(String data) {
        try {
            fw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeFile() {
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
