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
import mappers.CityinfoMapper;
import mappers.PersonMapper;

public class Facade implements IFacade {

    private EntityManagerFactory factory;

    public Facade(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public Facade() {
    }

    @Override
    public void addEntityManagerFactory(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    @Override
    public Person addPerson(Person person) { //works
        EntityManager manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(person);
            manager.getTransaction().commit();
            return person;
        } finally {
            manager.close();
        }
    }

    public List<PersonMapper> getallcompletePersons() { //works
        EntityManager manager = factory.createEntityManager();

        List<PersonMapper> pms;

        try {
            manager.getTransaction().begin();
            pms = manager.createQuery("Select new mappers.PersonMapper(p.firstName, p.lastName) from Person p").getResultList();
            manager.getTransaction().commit();
            return pms;
        } finally {
            manager.close();
        }
    }
    
    
      public Person getcompletePerson(int id) {
        EntityManager em = factory.createEntityManager();

        try {
            Person p = em.find(Person.class, id);
            if (p == null) {
                return null;
            }
            return p;
        } finally {
            em.close();
        }
    }
      
      public List<PersonMapper> getallcontactinfo() { //works
        EntityManager manager = factory.createEntityManager();

        List<PersonMapper> pms = null;

        try {
            manager.getTransaction().begin();
            pms = manager.createQuery("Select new mappers.PersonMapper(p.firstName, p.lastName, p.address) from Person p").getResultList();
            manager.getTransaction().commit();
            return pms;
        } finally {
            manager.close();
        }
    }
      
      public Person getPersonbyid(int id) {
        EntityManager em = factory.createEntityManager();

        try {
            Person p = em.find(Person.class, id);
            if (p == null) {
                return null;
            }
            return p;
        } finally {
            em.close();
        }
    }      
      
    

    @Override
    public PersonMapper getPersonByPhone(int phoneNumber) { //works
        EntityManager manager = getEntityManager();
        PersonMapper p = null;

        Query query = getEntityManager().createQuery("SELECT NEW mappers.PersonMapper(p.firstName, p.lastName, p.phone) FROM Person AS p WHERE p.phone = :phone");
        query.setParameter("phone", phoneNumber);
        p = (PersonMapper) query.getSingleResult();
        return p;
    }

    @Override
    public List<Person> getPersonsByHobby(Hobby hobby) {
        List<Person> byHobby = new ArrayList<>();
        System.out.println("Name of hobby: " + hobby);
        Query query = getEntityManager().createQuery("SELECT NEW mappers.PersonMapper(p.firstName, p.lastName) FROM Person AS p LEFT JOIN p.hobbys h WHERE h.name = :hobby");
        query.setParameter("hobby", hobby);

        return byHobby;
    }

  
    public List<Person> getPersonsByCity(List<Address> addresses) {        
        List<Person> byCity = new ArrayList<>();
        System.out.println("first");
        Query query = getEntityManager().createQuery("SELECT NEW mappers.PersonMapper(p.firstName, p.lastName) FROM Person AS p LEFT JOIN p.address h WHERE h.street = :street");
        for (int i = 0; i < addresses.size(); i++) {
        query.setParameter("street", addresses.get(i));
        byCity.add((Person) query.getSingleResult());
        }
        System.out.println("done");
        return byCity;
    }
    
    public List<Address> getAddressByZip(int zipcode) {
        List<Address> addresses = new ArrayList();  

        Query query = getEntityManager().createQuery("SELECT NEW mappers.AddressMapper(a.street) FROM Address AS a WHERE a.city.zipCode = :CITY_ZIP");
        query.setParameter("CITY_ZIP", zipcode);
        addresses = query.getResultList();

        return addresses;
    }

    @Override
    public Long getPeopleCountByHobby(Hobby hobby) {
        Long total;

        Query query = getEntityManager().createQuery("SELECT SUM(SIZE(h.hobbys)) FROM Hobby h where h.name = :name");
        total = (Long) query.getSingleResult();
        return total;
    }

    @Override
    public List<Cityinfo> getZipCodes() { //works
        EntityManager manager = factory.createEntityManager();

        List<Cityinfo> cityinfo = null;

        System.out.println("first");
        try {
            System.out.println("second");
            manager.getTransaction().begin();
            cityinfo = manager.createQuery("Select c.zipCode from Cityinfo c").getResultList();
            System.out.println("third");
            manager.getTransaction().commit();
            return cityinfo;
        } finally {
            manager.close();
        }
    }
        
        public Person deletePerson(int id) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            Person p = em.find(Person.class, id);
            em.remove(p);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }
    
    public Cityinfo getCityinfo(int id) { //works
    {
        EntityManager manager = getEntityManager();

        Cityinfo ci = null;

        try
        {
            manager.getTransaction().begin();
            ci = manager.find(Cityinfo.class, id);
            manager.getTransaction().commit();
            return ci;
        }
        finally
        {
            manager.close();
        }
    }
    }
   
    public CityinfoMapper getZipcode(int zipcode) 
    {
        EntityManager manager = getEntityManager();

        CityinfoMapper c = null;

        try
        {
            manager.getTransaction().begin();
            c = manager.find(CityinfoMapper.class, zipcode);
            manager.getTransaction().commit();
            return c;
        }
        finally
        {
            manager.close();
        }
    }
}
