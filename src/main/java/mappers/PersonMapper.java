package mappers;

import entity.Hobby;
import entity.Person;
import java.util.List;

/**
 *
 * @author malik
 */
public class PersonMapper 
{
    public String fullName;
    private String address;
    private int phone;  
    
    private String[] hobbies;

    public PersonMapper(String firstName, String lastName, String address, int phone) {
        this.fullName = firstName + " " + lastName;
        this.address = address;
        this.phone = phone;
    }
    
    public PersonMapper(Person person) {
        this.fullName = person.getFirstName() + " " + person.getLastName();
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
        return "PersonMapper{" + "fullName=" + fullName + ", address=" + address + ", phone=" + phone + ", hobbies=" + hobbies + '}';
    }
}
