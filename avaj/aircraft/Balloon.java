package aircraft;

import simulator.Coordinates;
import simulator.SimulationWriter;

public class Balloon extends Aircraft {
    public Balloon(long p_id, String p_name, Coordinates p_coordinate) {
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
                message = "Perfect weather for a balloon ride! Let's go higher!";
                p_longitude = 2;
                p_height = 4;
                break;

            case "RAIN":
                message = "Rain?! I'm a balloon, not a submarine!";
                p_height = -5;
                break;

            case "FOG":
                message = "I can't see a thing! Are we still flying?";
                p_height = -3;
                break;

            case "SNOW":
                message = "Snow?! My balloon is turning into a snowball!";
                p_height = -15;
                break;
        }
        String logMessage = "Balloon#" + name + "(" + id + "): " + message;
        SimulationWriter.getInstance().writeLine(logMessage);
        updateCoordinates(p_longitude, p_latitude, p_height);
    }
}