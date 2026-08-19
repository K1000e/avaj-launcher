package aircraft;

import simulator.Coordinates;
import simulator.SimulationWriter;

public class Aircraft extends Flyable{
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long id, String name, Coordinates p_coordinate) {
        this.id = id;
        this.name = name;
        this.coordinates = p_coordinate;
    }

    protected void updateCoordinates(int p_longitude, int p_latitude, int p_height){
        int	newLongitude = coordinates.getLongitude() + p_longitude;

        int	newLatitude = coordinates.getLatitude() + p_latitude;

        int	newHeight = coordinates.getHeight() + p_height;
        if (newHeight <= 0){
            String logMessage = getClass().getSimpleName() + "#" + name + "(" + id + ") landing.";
            SimulationWriter.getInstance().writeLine(logMessage);
            unregisterTower();
            return;
        }
        if (newHeight > 100)
            newHeight = 100;

        this.coordinates = coordinates.newCoordinates(newLongitude, newLatitude, newHeight);
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public void updateConditions() {

    }
}