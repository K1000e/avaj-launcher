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
                message = "What a beautiful day! These rotors are loving it.";
                p_longitude = 10;
                p_height = 2;
                break;

            case "RAIN":
                message = "Rain again? I hope these rotors are waterproof.";
                p_longitude = 5;
                break;

            case "FOG":
                message = "Too much fog! I'm flying by instinct now.";
                p_longitude = 1;
                break;

            case "SNOW":
                message = "My rotors are freezing! This is getting dangerous.";
                p_height = -12;
                break;

        }
        String logMessage = "Helicopter#" + name + "(" + id + "): " + message;
        SimulationWriter.getInstance().writeLine(logMessage);
        updateCoordinates(p_longitude, p_latitude, p_height);
    }
}