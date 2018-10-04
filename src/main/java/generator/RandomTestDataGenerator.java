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
        String side = "";
        int randomizer;
        int sideRandomizer;
        String[] firstNames = {"Benjamin", "Merle", "Nikolaj", "Marie", "Ellen", "Arthur", "Karla", "Matias", "Marius", "Marcus", "Sofia", "Villads", "Marcus", "Simon", "William", "Maja", "Jonathan", "Mads", "Ida", "Jonathan", "Magnus", 
            "Jakob", "Lucas", "Nicoline", "Julie", "August", "Nicoline", "Laura", "Thea", "Mille"};
        String[] lastNames = {"Jørgensen", "Pedersen", "Sørensen", "Nielsen", "Christensen", "Poulsen", "Vad", "Jensen", "Hansen", "Larsen", "Mortensen", "Andersen", "Kristensen", "Thomsen", "Møller", "Christiansen", "Madsen", "Petersen"};
        String[] address = {"Lærkevej", "Birkevej", "Vibevej", "Vinkelvej", "Østergade", "Engvej", "Vestergade", "Møllevej", "Kirkevej", "Bøgevej", "Industrivej", "Tværvej", "Stationsvej", "Elmevej", "Skovvej", "Nørregade", "Bakkevej", "Søndergade", 
            "Skolevej", "Drosselvej", "Fasanvej", "Mosevej" , "Lindevej" , "Egevej" , "Syrenvej" , "Skovbrynet" , "Mågevej" , "Gyvelvej" , "Kærvej" , "Nyvej" , "Rolighedsvej" ,"Nygade" , "Skolegade" , "Ahornvej" , "Jernbanegade" , "Kastanievej" , 
            "Toftevej" , "Ternevej", "Violvej" , "Pilevej" , "Poppelvej" , "Plantagevej" , "Anemonevej" , "Tjørnevej" , "Rosenvænget" , "Hybenvej", "Toften" , "Svinget" , "Enghavevej" , "Skrænten" , "Bellisvej" , "Vandværksvej" , "Irisvej" , "Valmuevej" ,
            "Svalevej" , "Spurvevej" , "Solsortevej" , "Parkvej" , "Grønningen" , "Hasselvej" , "Kløvervej" , "Præstevænget" , "Møllebakken" , "Gartnervænget" , "Møllevænget" , "Kirkebakken" , "Falkevej" , "Grønnegade" , "Vesterled" , "Kildevej" , "Strandvejen" , 
            "Glentevej" , "Søvej" , "Torvet" , "Tranevej" , "Stadionvej" , "Solbakken" , "Odinsvej" , "Enebærvej" , "Hovedgaden" , "Smedevej" , "Birkevænget" , "Solvænget" , "Åvej" , "Rugvænget" , "Vestervang" , "Rønnevej" , "Skovvænget" , "Mejerivej" , "Krogen" , 
            "Granvej" , "Ørnevej" , "Thorsvej" , "Teglværksvej" , "Lyngvej" , "Kirkegade" , "Udsigten" , "Lupinvej" , "Præstegårdsvej" , "Mejsevej"};
        Random rnd = new Random();
        
        
        for (int i = 0; i < samples; i++) {

            Person p = new Person();
            p.setFirstName(firstNames[rnd.nextInt(firstNames.length)]);
            p.setLastName(lastNames[rnd.nextInt(lastNames.length)]);
            p.setPhone(rnd.nextInt(88888888) + 11111111);
            
            Cityinfo city = facade.getSpecificCity(100 + rnd.nextInt(5871));
            
            if(city != null) {
                randomizer = rnd.nextInt(15)+1;
                if(randomizer <= 3) {
                    houseLetter = "A";
                } else if (randomizer <= 5) {
                    houseLetter = "B";
                } else if (randomizer <= 8) {
                    houseLetter = "C";
                } else if (randomizer <= 10) {
                    houseLetter = "D";
                } else {
                    houseLetter = "";
                }
                sideRandomizer = rnd.nextInt(15) + 1;
                if(sideRandomizer <= 5) {
                    side = "th";
                } else if(sideRandomizer <=10) {
                    side = "tv";
                } else {
                    side = "";
                }
            p.setAddress(new Address(address[rnd.nextInt(address.length)] + " " + rnd.nextInt(10000) +houseLetter + " " + side, city));                    
            facade.addPerson(p);
            houseLetter = "";
            side = "";
            } else {
                i--;
            }
        }
    }
}
