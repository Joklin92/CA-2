package facade;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public interface IFacade {
    
    public void addEntityManagerFactory(EntityManagerFactory factory); //works        
    public EntityManager getEntityManager(); //works
    public void postPerson();
    public Person putPerson();
    public void deletePerson(int id);
    public Person getPersonByPhone(int phoneNumber);
    public List<Person> getPersonsByHobby(String hobby);
    public List<Person> getPersonsByCity(String city);
    public Integer getPeopleCountByHobby(String hobby);
    public List<Integer> getZipCodes();
}
