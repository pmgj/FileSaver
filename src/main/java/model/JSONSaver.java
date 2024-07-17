package model;

import java.io.FileWriter;

import javax.json.bind.JsonbBuilder;

public class JSONSaver implements FileSaver {
    @Override
    public void save(Person person) {
        try (FileWriter writer = new FileWriter("Person.json")) {
            writer.write(JsonbBuilder.create().toJson(person));
        } catch (Exception ex) {

        }
    }

    @Override
    public String toString() {
        return "JSON";
    }
}
