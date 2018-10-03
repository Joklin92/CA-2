package entity;

import entity.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-03T11:36:29")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-03T12:33:33")
>>>>>>> 2e7b4dd0b04c0a3310c25cd50a3094472a2a794e
@StaticMetamodel(Hobby.class)
public class Hobby_ { 

    public static volatile ListAttribute<Hobby, Person> hobbys;
    public static volatile SingularAttribute<Hobby, String> name;
    public static volatile SingularAttribute<Hobby, String> description;

}