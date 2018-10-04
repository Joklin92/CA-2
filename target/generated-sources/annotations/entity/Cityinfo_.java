package entity;

import entity.Address;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-04T10:41:37")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-04T09:20:30")
>>>>>>> ce469df43b87296305d551169f2c70d11ff14be5
@StaticMetamodel(Cityinfo.class)
public class Cityinfo_ { 

    public static volatile SingularAttribute<Cityinfo, Integer> zipCode;
    public static volatile SingularAttribute<Cityinfo, String> city;
    public static volatile ListAttribute<Cityinfo, Address> addressCity;

}