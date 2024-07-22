package command;

import model.Person;
import strategy.XMLSaver;

public class XMLSaveCommand implements Command {
    private XMLSaver saver;

    public XMLSaveCommand(XMLSaver saver) {
        this.saver = saver;
    }

    @Override
    public void execute(Person p) {
        saver.save(p);
    }

    @Override
    public String toString() {
        return "XML";
    }
}
