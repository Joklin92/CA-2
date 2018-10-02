package generator;

import facade.Facade;
import entity.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomTestDataGenerator {
    
    Facade pf = new Facade();
    
    public String generator(int samples) {
        
        List<Person> result = new ArrayList();
        String[] firstNames = { "Benjamin" , "Merle" , "Nikolaj" , "Marie" , "Ellen" , "Arthur" , "Karla" , "Matias" , "Marius" , "Marcus" , "Sofia" , "Villads" , "Marcus" , "Simon" , "William" , "Maja" , "Jonathan" , "Mads" , "Ida" , "Jonathan" , "Magnus" , "Jakob" , "Lucas" , "Nicoline" , "Julie" , "August" , "Nicoline" , "Laura" , "Thea" , "Mille" };
        String[] lastNames = { "Jørgensen" , "Pedersen" , "Sørensen" , "Nielsen" , "Christensen" , "Poulsen" , "Vad" , "Jensen" , "Hansen" , "Larsen" , "Mortensen" , "Andersen" , "Kristensen" , "Thomsen" , "Møller" , "Christiansen" , "Madsen" , "Petersen"  };
        String[] address = {"Lærkevej" , "Birkevej" , "Vibevej" , "Vinkelvej" , "Østergade" , "Engvej" , "Vestergade" , "Møllevej" , "Kirkevej" , "Bøgevej" , "Industrivej" , "Tværvej" , "Stationsvej" , "Elmevej" , "Skovvej" , "Nørregade" , "Bakkevej" , "Søndergade" , "Skolevej" , "Drosselvej" , "Fasanvej"};
        Random rnd = new Random();
        Random rndPhoneNumber = new Random();
        
        for (int i = 0; i < samples; i++) {
        Person p = new Person();
        p.setFirstName(firstNames[rnd.nextInt(firstNames.length) + 1]);
        p.setLastName(lastNames[rnd.nextInt(lastNames.length) + 1]);
        p.setCity(city);
            result.add(p);
        }
           return "";     
    }
    
}
