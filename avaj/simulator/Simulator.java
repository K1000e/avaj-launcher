package simulator;

import aircraft.AircraftFactory;
import aircraft.Flyable;
import tower.WeatherTower;

import java.io.File;
import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Need exactly 1 argument");
            return;
        }
        File file = new File(args[0]);
        try (Scanner scanner = new Scanner(file)) {
            int simulationCount = Integer.parseInt(scanner.nextLine());
            if (simulationCount <= 0 ){
                System.out.println("Error the number of simulations need to be positive");
                return;
            }
            SimulationWriter writer = SimulationWriter.getInstance();

            AircraftFactory factory = AircraftFactory.getInstance();
            WeatherTower weatherTower = new WeatherTower();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.trim().split("\\s+");
                if (parts.length != 5){
                    System.out.println("Invalid scenario");
                    return;
                }

                String type = parts[0];
                if (!(type.equals("Balloon") || type.equals("Helicopter") ||  type.equals("JetPlane"))) {
                    System.out.println("Invalid scenario");
                    return;
                }
                String name = parts[1];
                int longitude = Integer.parseInt(parts[2]);
                int latitude = Integer.parseInt(parts[3]);
                int height = Integer.parseInt(parts[4]);
                if (longitude < 0 || latitude < 0 || height < 0 || height > 100) {
                    System.out.println("Invalid scenario");
                    return;
                }
                Coordinates coordinates = new Coordinates(longitude, latitude, height);
                Flyable flyable = factory.newAircraft(type, name, coordinates);
                flyable.registerTower(weatherTower);
            }
            for (int i = 1; i <= simulationCount; i++) {
                weatherTower.changeWeather();
            }

            writer.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
