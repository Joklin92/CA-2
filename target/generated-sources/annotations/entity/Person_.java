package entity;

import entity.Address;
import entity.Hobby;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-04T10:41:37")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-04T09:20:30")
>>>>>>> ce469df43b87296305d551169f2c70d11ff14be5
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> firstName;
    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile SingularAttribute<Person, Address> address;
    public static volatile ListAttribute<Person, Hobby> hobbys;
    public static volatile SingularAttribute<Person, Integer> phone;
    public static volatile SingularAttribute<Person, Integer> id;

}