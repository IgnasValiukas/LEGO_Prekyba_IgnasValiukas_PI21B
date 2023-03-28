package lt.viko.eif.ivaliukas.legoprekyba.util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lt.viko.eif.ivaliukas.legoprekyba.model.Pardavejas;


public class JaxbUtil {
    public static void convertToXML (Pardavejas pardavejas){
        try {
            JAXBContext context = JAXBContext.newInstance(Pardavejas.class);

            Marshaller marshaller = null;

            marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
            //OutputStream os = new FileOutputStream("generated.xml");
            marshaller.marshal(pardavejas, System.out);
        }catch (/*FileNotFoundException | */JAXBException e){
            throw new RuntimeException(e);
        }
    }
}
