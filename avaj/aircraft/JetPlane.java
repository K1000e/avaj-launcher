package aircraft;

import simulator.Coordinates;
import simulator.SimulationWriter;

public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
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
                message = "I like sunny day!";
                p_latitude = 10;
                p_height = 2;

                break;
            case "RAIN":
                message = "It's raining. Better watch out for lightings.";
                p_latitude = 5;
                break;

            case "FOG":
                message = "There is so much fog!";
                p_latitude = 1;
                break;

            case "SNOW":
                message = "OMG! Winter is coming!";
                p_height = -7;
                break;

            default:
                break;
        }
        String logMessage = "JetPlane#" + name + "(" + id + "): " + message;
        SimulationWriter.getInstance().writeLine(logMessage);
        updateCoordinates(p_longitude, p_latitude, p_height);
    }
}