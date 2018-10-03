/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import entity.Address;
import entity.Hobby;
import entity.Person;
import java.util.List;

/**
 *
 * @author Joklin
 */
public class AddressMapper {
    private String street;
    private String additionalInfo;
    
    private String[] persons;
    
    private String city;
    
    public AddressMapper(Address address) {
        this.street = address.getStreet();
        this.city = address.getCityinfo().getCity();

        List<Person> person = address.getPersonAddress();
        this.persons = new String[person.size()];

        for(int i = 0; i < person.size(); i++)
        {
            Person p = person.get(i);
            String per = p.getFirstName() + " " + p.getLastName();
            persons[i] = per;
        }
    }

    public AddressMapper(String street) {
        this.street = street;
    }

    
    
    @Override
    public String toString() {
        return "AddressMapper{" + "street=" + street + ", additionalInfo=" + additionalInfo + ", persons=" + persons + ", city=" + city + '}';
    }
    
    
}
