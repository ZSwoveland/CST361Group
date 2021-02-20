package business;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import beans.ResponseDataModel;


@Path("motion")
public class MotionRestService {
	
	
	@Context
    private UriInfo context;
 
    /** Creates a new instance of HelloWorld */
    public MotionRestService() {
    }
    
    @GET
    @Path("/getmotionj/{firstName}/{lastName}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDataModel getAlbumj(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
    	
    
    	
    }
    
    @GET
    @Path("/getmotionx/{firstName}/{lastName}")
    @Produces(MediaType.APPLICATION_XML)
    public ResponseDataModel getAlbumx(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
    	
    	
    }
 
    /**
     * Retrieves representation of an instance of helloWorld.HelloWorld
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml() {
        return "<html lang=\"en\"><body><h1>Hello, World!!</h1></body></html>";
    }

}
