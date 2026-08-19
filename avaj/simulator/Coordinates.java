package simulator;

public class Coordinates {
    private final int longitude;
    private final int latitude;
    private final int height;

    Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }

    public Coordinates newCoordinates(int p_longitude, int p_latitude, int p_height) {
        return new Coordinates(p_longitude, p_latitude, p_height);
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}