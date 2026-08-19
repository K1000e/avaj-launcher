package tower;

import aircraft.Aircraft;
import aircraft.Flyable;
import simulator.SimulationWriter;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers =  new ArrayList<>();

    public void register(Flyable p_flyable) {
        Aircraft aircraft = (Aircraft) p_flyable;
        observers.add(p_flyable);
        String logMessage = "Tower says: " + aircraft.getClass().getSimpleName() + "#" + aircraft.getName() + "(" + aircraft.getId() + ")" + " registered to weather tower.";
        SimulationWriter.getInstance().writeLine(logMessage);
    }

    public void unregister(Flyable p_flyable) {
        Aircraft aircraft = (Aircraft) p_flyable;
        observers.remove(p_flyable);
        String logMessage = "Tower says: " + aircraft.getClass().getSimpleName() + "#" + aircraft.getName() + "(" + aircraft.getId() + ")" + " unregistered from weather tower.";
        SimulationWriter.getInstance().writeLine(logMessage);
    }

    protected void conditionChanged() {
        for (Flyable p_flyable : new ArrayList<>(observers)) {
            p_flyable.updateConditions();
        }
    }
}