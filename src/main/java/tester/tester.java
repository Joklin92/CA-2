package tester;

import generator.RandomTestDataGenerator;
import java.util.HashMap;
import javax.persistence.Persistence;

public class tester {

    public static void main(String[] args) {
        HashMap puproperties = new HashMap<>();
        RandomTestDataGenerator rtdg = new RandomTestDataGenerator();
<<<<<<< HEAD
    rtdg.generator(5);

        puproperties.put("javax.persistence.sql-load-script-source", "scripts/clearDB.sql");
=======


        puproperties.put("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql");
>>>>>>> e28e02ac24e9c6c72248899baf306789cc87c7b2
        Persistence.generateSchema("persistence", puproperties);
        puproperties.put("javax.persistence.sql-load-script-source", "scripts/CityScript.sql");
        Persistence.generateSchema("persistence", puproperties);
        puproperties.remove("javax.persistence.sql-load-script-source");
        Persistence.generateSchema("persistence", puproperties);
<<<<<<< HEAD
=======


>>>>>>> e28e02ac24e9c6c72248899baf306789cc87c7b2
    }
}


