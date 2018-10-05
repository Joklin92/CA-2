package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Cityinfo;
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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("cityinfo")
public class CityInfoResource {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;
    private Facade facade;

    public CityInfoResource() {
       facade = new Facade();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        facade.addEntityManagerFactory(emf);
    }

    @GET // work
    @Path("/allZips") //with a sematic url parameter
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllZips() {
        List<Cityinfo> cityinfo = facade.getZipCodes();
        if (cityinfo == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return JSONConverter.getJSONFromCityinfos(cityinfo);
    }
}
