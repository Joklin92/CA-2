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
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
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

   
    public PersonResource() {
        pf = new Facade();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        pf.addEntityManagerFactory(emf);
    }
    @GET
     
    @Path("{phone}") //with a sematic url parameter
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomerById(@PathParam("phone") int phone) {
        PersonMapper p = pf.getPersonByPhone(phone);
//        if (p == null) {
//            throw new WebApplicationException(Response.Status.NOT_FOUND); //look for 404 not found in the browser.
//        }
        return JSONConverter.getJSONFromPerson(p);
        //Response.ok().entity(JSONConverter.getJSONFromPerson());
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
