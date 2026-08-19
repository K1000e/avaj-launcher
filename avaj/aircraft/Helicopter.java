package aircraft;

import simulator.Coordinates;
import simulator.SimulationWriter;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions(){
        String currentWeather = this.weatherTower.getWeather(this.coordinates);
        String message = "";
        int p_longitude = 0;
        int p_latitude = 0;
        int p_height = 0;

        switch (currentWeather){
            case "SUN":
                message = "This is hot.";
                p_longitude = 10;
                p_height = 2;
                break;

            case "RAIN":
                message = "I don't like rain!";
                p_longitude = 5;
                break;

            case "FOG":
                message = "There is so much fog!";
                p_longitude = 1;
                break;

            case "SNOW":
                message = "My rotor is going to freeze!";
                p_height = -12;
                break;

        }
        String logMessage = "Helicopter#" + name + "(" + id + "): " + message;
        SimulationWriter.getInstance().writeLine(logMessage);
        updateCoordinates(p_longitude, p_latitude, p_height);
    }
}