package model;

import java.io.FileOutputStream;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

public class XMLSaver implements FileSaver {
    @Override
    public void save(Person person) {
        try {
            JAXBContext contextObj = JAXBContext.newInstance(Person.class);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerObj.marshal(person, new FileOutputStream("Person.xml"));
        } catch (Exception ex) {

        }
    }

    @Override
    public String toString() {
        return "XML";
    }
}
