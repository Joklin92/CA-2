package entity;

import entity.Address;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-03T15:05:32")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-03T14:10:04")
>>>>>>> d4351be9f1971ef9092f7cf65943a0baba1280ff
@StaticMetamodel(Cityinfo.class)
public class Cityinfo_ { 

    public static volatile SingularAttribute<Cityinfo, Integer> zipCode;
    public static volatile SingularAttribute<Cityinfo, String> city;
    public static volatile ListAttribute<Cityinfo, Address> addressCity;

}