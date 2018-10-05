package mappers;

import entity.Address;
import entity.Hobby;
import entity.Person;
import java.util.List;

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
