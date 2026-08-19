package simulator;

import exceptions.SimulationWriterException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SimulationWriter {
    private static SimulationWriter instance;
    private final BufferedWriter writer;

    private SimulationWriter() {
        String fileName = "simulation.txt";
        try {
            this.writer = new BufferedWriter(new FileWriter(fileName, false));
        } catch (IOException e) {
            throw new SimulationWriterException("Unable to create simulation file: " + fileName, e);
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
            throw new SimulationWriterException("Unable to write to simulation file", e);
        }
    }

    public void close() {
        try {
            if (this.writer != null) {
                this.writer.flush();
                this.writer.close();
            }
        } catch (IOException e) {
            throw new SimulationWriterException("Unable to close simulation file", e);
        }
    }
}
