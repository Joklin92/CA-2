package entity;

import java.util.List;

/**
 *
 * @author malik
 */
public class PersonDTO 
{
    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private int phone;       
    private String[] hobbies;
    
    public PersonDTO() {
    }

    public PersonDTO(Person person) {
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.address = person.getAddress();
        this.phone = person.getPhone();
        
        List<Hobby> hobby = person.getHobbys();
        this.hobbies = new String[hobby.size()];
        
        for(int i = 0; i < hobby.size(); i++)
        {
            Hobby hob = hobby.get(i);
            String h = hob.getName() + " " + hob.getDescription();
            hobbies[i] = h;
        }
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "\nid: " + id 
                + "\nfirstName: " + firstName 
                + "\nlastName: " + lastName 
                + "\naddress: " + address 
                + "\nphone: " + phone 
                + "\nhobbies: " + hobbies;
    }
}
