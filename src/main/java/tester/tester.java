package tester;

import facade.Facade;
import generator.RandomTestDataGenerator;
import javax.persistence.Persistence;

public class tester {

    public static void main(String[] args) {
        
        Facade facade = new Facade();
        facade.addEntityManagerFactory(Persistence.createEntityManagerFactory("persistence"));
     //   RandomTestDataGenerator rtdg = new RandomTestDataGenerator();
     //   rtdg.generator(100);

      //  System.out.println(facade.getZipCodes());
        
    }
    
}


