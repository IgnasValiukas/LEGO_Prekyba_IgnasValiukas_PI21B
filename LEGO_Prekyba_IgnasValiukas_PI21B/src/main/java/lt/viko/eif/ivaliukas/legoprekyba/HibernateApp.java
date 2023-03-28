package lt.viko.eif.ivaliukas.legoprekyba;

import lt.viko.eif.ivaliukas.legoprekyba.model.LegoKonstruktorius;
import lt.viko.eif.ivaliukas.legoprekyba.model.Pardavejas;
import lt.viko.eif.ivaliukas.legoprekyba.model.Paskyra;
import lt.viko.eif.ivaliukas.legoprekyba.util.HibernateUtil;
import lt.viko.eif.ivaliukas.legoprekyba.util.JaxbUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateApp {
    public static void main(String[] args) {
        Paskyra paskyra = new Paskyra("IgnasVpro", "123");
        LegoKonstruktorius legoKonstruktorius = new LegoKonstruktorius("F&F Dodge", "78523");
        LegoKonstruktorius legoKonstruktorius1 = new LegoKonstruktorius("F&F Porsche", "42569");
        Pardavejas pardavejas = new Pardavejas("Ignas", "Valiukas", "+37060000000", paskyra, List.of(legoKonstruktorius, legoKonstruktorius1));

        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(pardavejas);
            transaction.commit();
        }catch(Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            List<Pardavejas> pardavejas1 = session.createQuery( "from Pardavejas", Pardavejas.class).list();
            pardavejas1.forEach(pard -> System.out.println(pard));
            System.out.println("--------------------");
            pardavejas1.forEach(pard -> JaxbUtil.convertToXML(pard));

            System.in.read();
        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {

        }
    }
}
