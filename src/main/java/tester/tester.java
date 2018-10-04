package tester;

import entity.Hobby;
import entity.Person;
import facade.Facade;
import generator.RandomTestDataGenerator;
import javax.persistence.Persistence;

public class tester {

    public static void main(String[] args) {
      
        Facade facade = new Facade();
        facade.addEntityManagerFactory(Persistence.createEntityManagerFactory("persistence"));
        RandomTestDataGenerator rtdg = new RandomTestDataGenerator();
        rtdg.generator(100);


     //   System.out.println(facade.getallcompletePersons());
        
        //  System.out.println(facade.getZipCodes());
        //  System.out.println(facade.getPersonByPhone(73463229));
        //System.out.println(facade.getallcompletePersons());        
        // System.out.println(facade.getPersonsByCity(facade.getAddressByZip(1903)));
        //System.out.println(facade.getAllPersons());        
        //System.out.println(facade.getPersonsByCity(1903));
        //System.out.println(facade.getAddressByZip(1903));
       // System.out.println(facade.getAllHobbies());
//        facade.addHobbyToPerson(facade.getPerson(1), facade.getHobby("Film"));

    }
    
}


