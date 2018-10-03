package tester;

import facade.Facade;
import generator.RandomTestDataGenerator;
import javax.persistence.Persistence;

public class tester {

    public static void main(String[] args) {
        
        Facade facade = new Facade();
        facade.addEntityManagerFactory(Persistence.createEntityManagerFactory("persistence"));
        //RandomTestDataGenerator rtdg = new RandomTestDataGenerator();
      //  rtdg.generator(10);
      
        System.out.println("derp" + facade.getPersonByPhone(88689226));

    }
    
}


