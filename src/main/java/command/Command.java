package command;

import model.Person;

public interface Command {
    public void execute(Person p);
}
