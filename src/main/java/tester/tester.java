package tester;

import java.util.HashMap;
import javax.persistence.Persistence;

public class tester {

    public static void main(String[] args) {
        HashMap puproperties = new HashMap<>();

        puproperties.put("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql");
        Persistence.generateSchema("persistence", puproperties);
        puproperties.put("javax.persistence.sql-load-script-source", "scripts/CityScript.sql");
        Persistence.generateSchema("persistence", puproperties);
        puproperties.remove("javax.persistence.sql-load-script-source");
        Persistence.generateSchema("persistence", puproperties);

    }
}


