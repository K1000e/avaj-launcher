package tower;

import simulator.Coordinates;

public final class WeatherProvider {
    private static final WeatherProvider INSTANCE = new WeatherProvider();
    private final String[] weather =  {
            "SUN",
            "RAIN",
            "FOG",
            "SNOW"
    };

    private WeatherProvider() {
    }

    public static WeatherProvider getInstance() {
        return INSTANCE;
    }

    public String getCurrentWeather(Coordinates p_coordinates){
        int value = Math.abs(
                p_coordinates.getLongitude() * 3
                + p_coordinates.getLatitude() * 5
                + p_coordinates.getHeight() * 7
        );

        return weather[value % weather.length];
    }
}