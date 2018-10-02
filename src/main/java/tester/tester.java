package tester;

import generator.RandomTestDataGenerator;
import java.util.HashMap;
import javax.persistence.Persistence;

public class tester {

    public static void main(String[] args) {
        HashMap puproperties = new HashMap<>();
        RandomTestDataGenerator rtdg = new RandomTestDataGenerator();
//        puproperties.put("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql");
//        Persistence.generateSchema("persistence", puproperties);
//        puproperties.remove("javax.persistence.sql-load-script-source");
//        Persistence.generateSchema("persistence", puproperties);

<<<<<<< HEAD
    rtdg.generator(5);
=======
        puproperties.put("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql");
        Persistence.generateSchema("persistence", puproperties);
        puproperties.put("javax.persistence.sql-load-script-source", "scripts/CityScript.sql");
        Persistence.generateSchema("persistence", puproperties);
        puproperties.remove("javax.persistence.sql-load-script-source");
        Persistence.generateSchema("persistence", puproperties);
>>>>>>> d32c4f1493727d08c592793118757ddf53559b3f

    }
}


