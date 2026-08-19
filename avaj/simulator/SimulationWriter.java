package simulator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SimulationWriter {
    private static SimulationWriter instance;
    private BufferedWriter writer;
    private final String fileName = "simulation.txt";

    private SimulationWriter() {
        try {
            this.writer = new BufferedWriter(new FileWriter(fileName, false));
        } catch (IOException e) {
            System.err.println("Erreur d'initialisation du fichier de simulation : " + e.getMessage());
            System.exit(1);
        }
    }

    public static SimulationWriter getInstance() {
        if (instance == null) {
            instance = new SimulationWriter();
        }
        return instance;
    }

    public void writeLine(String message) {
        try {
            this.writer.write(message);
            this.writer.newLine();
        } catch (IOException e) {
            System.out.println("Erreur d'écriture dans la simulation : " + e.getMessage());
        }
    }

    public void close() {
        try {
            if (this.writer != null) {
                this.writer.flush();
                this.writer.close();
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la fermeture du fichier : " + e.getMessage());
        }
    }
}
