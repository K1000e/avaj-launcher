package aircraft;

import simulator.Coordinates;

public final class AircraftFactory {
    private static final AircraftFactory INSTANCE = new AircraftFactory();

    private static long nextId = 1;

    private AircraftFactory(){}

    public static AircraftFactory getInstance(){
        return INSTANCE;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates){
        return switch (p_type) {
            case "Balloon" -> new Balloon(nextId++, p_name, p_coordinates);
            case "Helicopter" -> new Helicopter(nextId++, p_name, p_coordinates);
            case "JetPlane" -> new JetPlane(nextId++, p_name, p_coordinates);
            default -> null;
        };

    }
}