package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import facade.Facade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    public String getPersonByPhone(@PathParam("phone") int phone) {
        System.out.println("first");
        PersonMapper p = pf.getPersonByPhone(phone);

        return JSONConverter.getJSONFromPersonMapper(p);

    }
    
    @GET
    @Path("complete") //with a sematic url parameter
    @Produces(MediaType.APPLICATION_JSON)
    public String getallPerson() {
        List<PersonMapper> p = pf.getAllPersons();
        if (p == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return JSONConverter.getJSONFromPersonMapper(p);

    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postPerson(String json) {
        Person p = JSONConverter.getPersonFromJson(json);
        System.out.println("Person: " + p);
        pf.addPerson(p);
       
        return Response.ok().entity(gson.toJson(p)).build();
    }
    
}

   

