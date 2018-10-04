package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Cityinfo;
import entity.Person;
import facade.Facade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

    public PersonResource() {
        pf = new Facade();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        pf.addEntityManagerFactory(emf);
    }

    @GET//not 100% it take with phone
    @Path("complete") //with a sematic url parameter
    @Produces(MediaType.APPLICATION_JSON)
    public String getallPerson() {
        List<PersonMapper> p = pf.getallcompletePersons();
        if (p == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return JSONConverter.getJSONFromPersonMapper(p);

    }

    @GET // work
    @Path("/{id}") //with a sematic url parameter
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonByid(@PathParam("id") int id) {
        System.out.println("first" + id);
        PersonMapper p = pf.getPersonbyid(id);

        return JSONConverter.getJSONFromPersonMapper(p);
    }
    
    @GET // work
    @Path("/allZips") //with a sematic url parameter
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllZips() {
        List<Cityinfo> cityinfo = pf.getZipCodes();
        if (cityinfo == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return JSONConverter.getJSONFromCityinfos(cityinfo);
    }

    @GET //work
    @Path("contactinfo") //with a sematic url parameter
    @Produces(MediaType.APPLICATION_JSON)
    public String getallcontactinfoPerson() {
        List<PersonMapper> p = pf.getallcontactinfo();
        if (p == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return JSONConverter.getJSONFromPersonMapper(p);

    }

    @GET // work
    @Path("phone/{phone}") //with a sematic url parameter
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonByPhone(@PathParam("phone") int phone) {
        PersonMapper p = pf.getPersonByPhone(phone);

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
    
      @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putPerson(String json) {
        Person newperson = JSONConverter.getPersonFromJson(json);

        

        pf.editPerson(newperson);
        return Response.ok().entity(gson.toJson(newperson)).build();
    }
    
    
     @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("id") int id) {

        Person p = pf.deletePerson(id);
        if (p == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(gson.toJson(p)).build();
    }

}
