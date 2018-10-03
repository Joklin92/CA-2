package entity;

import entity.Cityinfo;
import entity.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-03T15:05:32")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-03T14:10:04")
>>>>>>> d4351be9f1971ef9092f7cf65943a0baba1280ff
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile ListAttribute<Address, Person> personAddress;
    public static volatile SingularAttribute<Address, Cityinfo> city;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, String> additionalInfo;

}