package entity;

import entity.Cityinfo;
import entity.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-04T13:00:49")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile ListAttribute<Address, Person> personAddress;
    public static volatile SingularAttribute<Address, Cityinfo> city;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, String> additionalInfo;

}