package command;

import model.Person;
import strategy.JSONSaver;

public class JSONSaveCommand implements Command {
    private JSONSaver saver;

    public JSONSaveCommand(JSONSaver saver) {
        this.saver = saver;
    }

    @Override
    public void execute(Person p) {
        saver.save(p);
    }

    @Override
    public String toString() {
        return "JSON";
    }
}
