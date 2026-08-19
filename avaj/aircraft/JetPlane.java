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
                message = "Clear skies! Time to push the throttle.";
                p_latitude = 10;
                p_height = 2;

                break;
            case "RAIN":
                message = "Rain on the runway? Keep your eyes open!";
                p_latitude = 5;
                break;

            case "FOG":
                message = "I can't see the runway, but I trust my instruments.";
                p_latitude = 1;
                break;

            case "SNOW":
                message = "Winter is coming! Let's get out of here.";
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