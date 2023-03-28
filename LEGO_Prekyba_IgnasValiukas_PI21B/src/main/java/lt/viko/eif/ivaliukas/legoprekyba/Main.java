package lt.viko.eif.ivaliukas.legoprekyba;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lt.viko.eif.ivaliukas.legoprekyba.model.LegoKonstruktorius;
import lt.viko.eif.ivaliukas.legoprekyba.model.Pardavejas;
import lt.viko.eif.ivaliukas.legoprekyba.model.Paskyra;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        Paskyra paskyra = new Paskyra(1,"IgnasVpro", "123");
        LegoKonstruktorius legoKonstruktorius = new LegoKonstruktorius(1, "F&F Dodge", "78523");
        LegoKonstruktorius legoKonstruktorius1 = new LegoKonstruktorius(2, "F&F Porsche", "42569");
        Pardavejas pardavejas = new Pardavejas(1, "Ignas", "Valiukas", "+37060000000", paskyra, List.of(legoKonstruktorius, legoKonstruktorius1));

        System.out.println((pardavejas));

        JAXBContext context = JAXBContext.newInstance(Pardavejas.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        OutputStream os = new FileOutputStream("generated.xml");
        marshaller.marshal(pardavejas, System.out);
        marshaller.marshal(pardavejas, os);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        Path path = Path.of("generated.xml");

        String xmlContent = Files.readString(path);
        System.out.print(xmlContent);

        StringReader reader = new StringReader(xmlContent);

        Pardavejas pardavejas1 = (Pardavejas) unmarshaller.unmarshal(reader);

        System.out.println(pardavejas1);
    }
}