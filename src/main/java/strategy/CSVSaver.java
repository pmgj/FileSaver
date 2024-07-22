package strategy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import model.CustomCSVWriterStrategy;
import model.Person;

public class CSVSaver implements FileSaver {
    @Override
    public void save(Person person) {
        List<Person> EmployeeList = new ArrayList<>();
        EmployeeList.add(person);
        try (FileWriter writer = new FileWriter("Person.csv")) {
            var mappingStrategy = new CustomCSVWriterStrategy<Person>();
            mappingStrategy.setType(Person.class);

            var builder = new StatefulBeanToCsvBuilder<Person>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mappingStrategy)
                    .build();
            builder.write(EmployeeList);
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {

        }
    }

    @Override
    public String toString() {
        return "CSV";
    }
}