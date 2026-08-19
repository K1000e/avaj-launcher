package simulator;

import aircraft.AircraftFactory;
import aircraft.Flyable;
import exceptions.InvalidAircraftException;
import exceptions.InvalidCoordinatesException;
import exceptions.InvalidScenarioException;
import tower.WeatherTower;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulator {

    private static void run(String[] args) throws InvalidScenarioException, InvalidAircraftException, InvalidCoordinatesException {
        if (args.length != 1)
            throw new InvalidScenarioException("Need exactly 1 argument");

        SimulationWriter writer = null;

        File file = new File(args[0]);

        try (Scanner scanner = new Scanner(file)){

            int simulationCount;

            try {
                simulationCount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                throw new InvalidScenarioException("Invalid number of simulations");
            }

            if (simulationCount <= 0 ){
                throw new InvalidScenarioException("The number of simulations must be positive");
            }

            writer = SimulationWriter.getInstance();

            AircraftFactory factory = AircraftFactory.getInstance();
            WeatherTower weatherTower = new WeatherTower();

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                if (line.isEmpty())
                    throw new InvalidScenarioException("Invalid scenario");

                String[] parts = line.trim().split("\\s+");
                if (parts.length != 5)
                    throw new InvalidScenarioException("Invalid scenario");

                String type = parts[0];
                if (!(type.equals("Balloon") || type.equals("Helicopter") ||  type.equals("JetPlane")))
                    throw new InvalidAircraftException("Invalid aircraft type: " + type);

                String name = parts[1];

                Coordinates coordinates = getCoordinates(parts);
                Flyable flyable = factory.newAircraft(type, name, coordinates);
                flyable.registerTower(weatherTower);
            }
            for (int i = 1; i <= simulationCount; i++) {
                weatherTower.changeWeather();
            }
        } catch (FileNotFoundException e) {
            throw new InvalidScenarioException("Scenario file not found");
        }
        finally {
            if (writer != null){
                writer.close();
            }
        }
    }

    private static Coordinates getCoordinates(String[] parts) throws InvalidCoordinatesException {
        int longitude;
        int latitude;
        int height;

        try {
            longitude = Integer.parseInt(parts[2]);
            latitude = Integer.parseInt(parts[3]);
            height = Integer.parseInt(parts[4]);
        } catch (NumberFormatException e) {
            throw new InvalidCoordinatesException("Invalid coordinates");
        }
        if (longitude < 0 || latitude < 0 || height < 0 || height > 100)
            throw new InvalidCoordinatesException("Invalid coordinates");

        return new Coordinates(longitude, latitude, height);
    }

    public static void main(String[] args) {

        try{
            run(args);
        }
        catch (InvalidScenarioException
               | InvalidAircraftException
               | InvalidCoordinatesException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
