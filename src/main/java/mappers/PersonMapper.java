package mappers;

import entity.Address;
import entity.Hobby;
import entity.Person;
import java.util.List;

public class PersonMapper {

    private Integer id;
    public String fullName;
    private String firstName;
    private String lastName;
    private String address;
    private int phone;
    private String[] hobbies;

    public PersonMapper() {
    }

    public PersonMapper(Person person) {
        this.fullName = person.getFirstName() + " " + person.getLastName();
       // this.address = person.getAddress();
        this.phone = person.getPhone();

        List<Hobby> hobby = person.getHobbies();
        this.hobbies = new String[hobby.size()];

        for (int i = 0; i < hobby.size(); i++) {
            Hobby hob = hobby.get(i);
            String h = hob.getName() + " " + hob.getDescription();
            hobbies[i] = h;
        }
    }

    public PersonMapper(String firstName, String lastName) {
        this.fullName = firstName + " " + lastName;
        
    }   
    
    public PersonMapper(String firstName, String lastName, int phonenumber) {
        this.fullName = firstName + " " + lastName;
        this.phone = phonenumber;
    }
    
    public PersonMapper(String firstName, String lastName, Address address, int phonenumber) {
        this.fullName = firstName + " " + lastName;
        this.address = address.getStreet() + address.getCityinfo().getCity();
        this.phone = phonenumber;
    }

    

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }    

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "PersonMapper{" + "fullName=" + fullName + ", address=" + address + ", phone=" + phone + ", hobbies=" + hobbies + '}';
    }
}
