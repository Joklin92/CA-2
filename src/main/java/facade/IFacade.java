package facade;

import entity.Address;
import entity.Cityinfo;
import entity.Hobby;
import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mappers.PersonMapper;

public interface IFacade {

    public void addEntityManagerFactory(EntityManagerFactory factory);
    public EntityManager getEntityManager();
    public Person addPerson(Person person);
    public PersonMapper getPersonByPhone(int phoneNumber);
    public List<Person> getPersonsByHobby(Hobby hobby);
    public List<Person> getPersonsByCity(Address city);
    public Long getPeopleCountByHobby(Hobby hobby);
    public List<Cityinfo> getZipCodes();
}