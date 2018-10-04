package generator;

import entity.Address;
import entity.Cityinfo;
import facade.Facade;
import entity.Person;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import mappers.CityinfoMapper;

public class RandomTestDataGenerator {

    public void generator(int samples) {

        Facade facade = new Facade();
        facade.addEntityManagerFactory(Persistence.createEntityManagerFactory("persistence"));

        String houseLetter = "";
        int randomizer;
        String[] firstNames = {"Benjamin", "Merle", "Nikolaj", "Marie", "Ellen", "Arthur", "Karla", "Matias", "Marius", "Marcus", "Sofia", "Villads", "Marcus", "Simon", "William", "Maja", "Jonathan", "Mads", "Ida", "Jonathan", "Magnus", 
            "Jakob", "Lucas", "Nicoline", "Julie", "August", "Nicoline", "Laura", "Thea", "Mille"};
        String[] lastNames = {"Jørgensen", "Pedersen", "Sørensen", "Nielsen", "Christensen", "Poulsen", "Vad", "Jensen", "Hansen", "Larsen", "Mortensen", "Andersen", "Kristensen", "Thomsen", "Møller", "Christiansen", "Madsen", "Petersen"};
        String[] address = {"Lærkevej", "Birkevej", "Vibevej", "Vinkelvej", "Østergade", "Engvej", "Vestergade", "Møllevej", "Kirkevej", "Bøgevej", "Industrivej", "Tværvej", "Stationsvej", "Elmevej", "Skovvej", "Nørregade", "Bakkevej", "Søndergade", 
            "Skolevej", "Drosselvej", "Fasanvej", "Mosevej" , "Lindevej" , "Egevej" , "Syrenvej" , "Skovbrynet" , "Mågevej" , "Gyvelvej" , "Kærvej" , "Nyvej" , "Rolighedsvej" ,"Nygade" , "Skolegade" , "Ahornvej" , "Jernbanegade" , "Kastanievej" , 
            "Toftevej" , "Ternevej", "Violvej" , "Pilevej" , "Poppelvej" , "Plantagevej" , "Anemonevej" , "Tjørnevej" , "Rosenvænget" , "Hybenvej"};
        Random rnd = new Random();
        
        
        for (int i = 0; i < samples; i++) {

            Person p = new Person();
            p.setFirstName(firstNames[rnd.nextInt(firstNames.length)]);
            p.setLastName(lastNames[rnd.nextInt(lastNames.length)]);
            p.setPhone(rnd.nextInt(88888888) + 11111111);
            
            Cityinfo city = facade.getSpecificCity(100 + rnd.nextInt(5871));
            
            if(city != null) {
                randomizer = rnd.nextInt(10)+1;
                if(randomizer <= 3) {
                    houseLetter = "A";
                } else if (randomizer <= 5) {
                    houseLetter = "B";
                } else if (randomizer <= 8) {
                    houseLetter = "C";
                } else {
                    houseLetter = "";
                }
            p.setAddress(new Address(address[rnd.nextInt(address.length)] + " " + rnd.nextInt(1000) +houseLetter, city));                    
            facade.addPerson(p);
            houseLetter = "";
            } else {
                i--;
            }
        }
    }
}
