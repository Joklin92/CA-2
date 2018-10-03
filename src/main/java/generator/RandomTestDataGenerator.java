package generator;

import entity.Address;
import facade.Facade;
import entity.Person;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class RandomTestDataGenerator {

    public void generator(int samples) {

        Facade facade = new Facade();
        facade.addEntityManagerFactory(Persistence.createEntityManagerFactory("persistence"));
        EntityManager em = facade.getEntityManager();

        String[] firstNames = {"Benjamin", "Merle", "Nikolaj", "Marie", "Ellen", "Arthur", "Karla", "Matias", "Marius", "Marcus", "Sofia", "Villads", "Marcus", "Simon", "William", "Maja", "Jonathan", "Mads", "Ida", "Jonathan", "Magnus", "Jakob", "Lucas", "Nicoline", "Julie", "August", "Nicoline", "Laura", "Thea", "Mille"};
        String[] lastNames = {"Jørgensen", "Pedersen", "Sørensen", "Nielsen", "Christensen", "Poulsen", "Vad", "Jensen", "Hansen", "Larsen", "Mortensen", "Andersen", "Kristensen", "Thomsen", "Møller", "Christiansen", "Madsen", "Petersen"};
        String[] address = {"Lærkevej", "Birkevej", "Vibevej", "Vinkelvej", "Østergade", "Engvej", "Vestergade", "Møllevej", "Kirkevej", "Bøgevej", "Industrivej", "Tværvej", "Stationsvej", "Elmevej", "Skovvej", "Nørregade", "Bakkevej", "Søndergade", "Skolevej", "Drosselvej", "Fasanvej"};
        Random rnd = new Random();

        em.getTransaction().begin();
        for (int i = 0; i < samples; i++) {

            Person p = new Person();
            p.setFirstName(firstNames[rnd.nextInt(firstNames.length)]);
            p.setLastName(lastNames[rnd.nextInt(lastNames.length)]);
            p.setPhone(rnd.nextInt(88888888) + 11111111);
            //p.setAddress(new Address(address[rnd.nextInt(address.length)] + " " + rnd.nextInt(500)));
            em.persist(p);
        }
            em.getTransaction().commit();
        em.close();
    }
}
