package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import facade.Facade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mappers.PersonMapper;

@Path("person")
public class PersonResource {
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;
    private Facade pf;

//     private static Map<Integer, PersonMapper> customers = new HashMap();
//
//   static {
//        customers.put(1, new PersonMapper("hej", "dav", 2345621));
//        customers.put(2, new PersonMapper("hej", "dav", 2231432));
//        customers.put(3, new PersonMapper("dav", "hej", 2322456));
//    }
    
    /**
     * Creates a new instance of Person
     */
    public PersonResource() {
        pf = new Facade();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        pf.addEntityManagerFactory(emf);
    }

    @GET
    @Path("complete/{phone}") //with a sematic url parameter
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomerByPhone(@PathParam("phone") int phone) {
        System.out.println("first");
        PersonMapper p = pf.getPersonByPhone(phone);

        return JSONConverter.getJSONFromPerson(p);

    }
    
    @GET
    @Path("complete") //with a sematic url parameter
    @Produces(MediaType.APPLICATION_JSON)
    public String getallperson(@PathParam("phone") int phone) {
        List<Person> p = pf.getAllPersons();
        if (p == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return JSONConverter.getJSONFromPersons(p);

    }
//    @GET
//    @Path("/{phone}") //works
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getPersonById(@PathParam("id") int phone) {
//        Facade.getPersonByPhone(phone)
//        return Response.ok().entity(JSONConverter.getJSONFromPesrson()).build();
//        //return Response.ok().entity(converter.getJSONFromPerson(persons.get(id))).build();
//    }

   
}
