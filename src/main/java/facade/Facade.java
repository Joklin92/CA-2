package facade;

import entity.Address;
import entity.Cityinfo;
import entity.Hobby;
import entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import mappers.PersonMapper;

public class Facade implements IFacade {

    private EntityManagerFactory factory;
    
    public Facade(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public Facade() {
    }

    
    @Override
    public void addEntityManagerFactory(EntityManagerFactory factory) 
    {
        this.factory = factory;
    }

    @Override
    public EntityManager getEntityManager() 
    {
        return factory.createEntityManager();
    }

    @Override
    public Person addPerson(Person person) 
    {
        EntityManager manager = getEntityManager();
        try
        {
            manager.getTransaction().begin();
            manager.persist(person);
            manager.getTransaction().commit();
            return person;
        }
        finally
        {
            manager.close();
        }
    }

    @Override
    public PersonMapper getPersonByPhone(int phoneNumber) 
    {
        EntityManager manager = getEntityManager();
        PersonMapper p = null;
        
        Query query = getEntityManager().createQuery("SELECT NEW mappers.PersonMapper(p.firstName, p.lastName, p.phone) FROM Person AS p WHERE p.phone = :phone");
        query.setParameter("phone", phoneNumber);
        p = (PersonMapper) query.getSingleResult();
        return p;
    }

    @Override
    public List<Person> getPersonsByHobby(Hobby hobby) 
    {
        List<Person> byHobby = new ArrayList<>();
        System.out.println("Name of hobby: " + hobby);
        Query query = getEntityManager().createQuery("SELECT NEW mappers.PersonMapper(p.firstName, p.lastName) FROM Person AS p LEFT JOIN p.hobbys h WHERE h.name = :hobby");
        query.setParameter("hobby", hobby);

        return byHobby;
    }

    @Override
    public List<Person> getPersonsByCity(Address city) 
    {
        List<Person> byCity = new ArrayList<>();
        System.out.println("Name of city: " + city);
        Query query = getEntityManager().createQuery("SELECT NEW mappers.PersonMapper(p.firstName, p.lastName) FROM Person AS p WHERE p.address = :city");
        query.setParameter("CITY", city);
        byCity = query.getResultList();
        return byCity;
    }

    @Override
    public Long getPeopleCountByHobby(Hobby hobby) 
    {
        Long total;
        
        Query query = getEntityManager().createQuery("SELECT SUM(SIZE(h.hobbys)) FROM Hobby h where h.name = :name");
        total = (Long) query.getSingleResult();
        return total;
    }

    @Override
    public List<Cityinfo> getZipCodes() 
    {
        EntityManager manager = factory.createEntityManager();

        List<Cityinfo> cityinfo = null;

        System.out.println("first");
        try
        {
            System.out.println("second");
            manager.getTransaction().begin();
            cityinfo = manager.createQuery("Select c.zipCode from Cityinfo c").getResultList();
            System.out.println("third");
            manager.getTransaction().commit();
            return cityinfo;
        }
        finally
        {
            manager.close();
        }
    }
}
