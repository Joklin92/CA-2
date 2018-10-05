package tester;

import facade.Facade;
import generator.RandomTestDataGenerator;
import javax.persistence.Persistence;
import rest.CityInfoResource;
import rest.PersonResource;

public class tester {

    public static void main(String[] args) {

        Facade facade = new Facade();
        facade.addEntityManagerFactory(Persistence.createEntityManagerFactory("persistence"));
        PersonResource pr = new PersonResource();
        CityInfoResource cr = new CityInfoResource();
        RandomTestDataGenerator rtdg = new RandomTestDataGenerator();
        rtdg.generator(999);

//        System.out.println(facade.getallcompletePersons());
//        System.out.println(facade.getZipCodes());
//        System.out.println(facade.getPersonByPhone(73463229));
//        System.out.println(facade.getallcompletePersons());        
        //System.out.println(facade.getPersonsByCity(facade.getAddressByZip(1903)));
        //System.out.println(facade.getAllPersons());        
//        System.out.println(facade.getPersonsByCity(1903));
//        System.out.println(facade.getAddressByZip(1903));
//        System.out.println(facade.getAllHobbies());
//        facade.addHobbyToPerson(facade.getPerson(1), facade.getHobby("Film"));
        //System.out.println(pr.getPersonByid(2));
  //      System.out.println(pr.getPersonByPhone(20199468));
    //    System.out.println(facade.getCityByZip(2750));
        System.out.println(cr.getCityByZip(2750));
    }

}
