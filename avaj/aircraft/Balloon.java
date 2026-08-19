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
                message = "Let's enjoy the good weather and take some pics.";
                p_longitude = 2;
                p_height = 4;
                break;

            case "RAIN":
                message = "Damn you rain! You messed up my balloon.";
                p_height = -5;
                break;

            case "FOG":
                message = "There is so much fog!";
                p_height = -3;
                break;

            case "SNOW":
                message = "It's snowing. We're gonna crash.";
                p_height = -15;
                break;
        }
        String logMessage = "Balloon#" + name + "(" + id + "): " + message;
        SimulationWriter.getInstance().writeLine(logMessage);
        updateCoordinates(p_longitude, p_latitude, p_height);
    }
}