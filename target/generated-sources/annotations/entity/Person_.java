package entity;

import entity.Address;
import entity.Hobby;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-03T11:36:29")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-03T12:33:33")
>>>>>>> 2e7b4dd0b04c0a3310c25cd50a3094472a2a794e
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> firstName;
    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile SingularAttribute<Person, Address> address;
    public static volatile ListAttribute<Person, Hobby> hobbys;
    public static volatile SingularAttribute<Person, Integer> phone;
    public static volatile SingularAttribute<Person, Integer> id;

}