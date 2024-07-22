package command;

import model.Person;
import strategy.CSVSaver;

public class CSVSaveCommand implements Command {
    private CSVSaver saver;

    public CSVSaveCommand(CSVSaver saver) {
        this.saver = saver;
    }

    @Override
    public void execute(Person p) {
        saver.save(p);
    }

    @Override
    public String toString() {
        return "CSV";
    }
}
