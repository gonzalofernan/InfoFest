package aiss.model.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.Festival;
import aiss.model.repository.FestivalRepository;
import aiss.model.repository.MapFestivalRepository;


@Path("/lists")
public class FestivalResource {
	
	/* Singleton */
	private static FestivalResource _instance=null;
	FestivalRepository repository;
	
	private FestivalResource() {
		repository=MapFestivalRepository.getInstance();

	}
	
	public static FestivalResource getInstance()
	{
		if(_instance==null)
				_instance=new FestivalResource();
		return _instance;
	}
	

	@GET
	@Produces("application/json")
	public Collection<Festival> getAll()
	{
		return repository.getAllFestivals();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Festival get(@PathParam("id") String id)
	{
		Festival festival = repository.getFestival(id);
		
		if (festival == null) {
			throw new NotFoundException("The festival with id="+ id +" was not found");			
		}
		
		return festival;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addGroup(@Context UriInfo uriInfo, Festival festival) {
		if (festival.getName() == null || "".equals(festival.getName()))
			throw new BadRequestException("The name of the Festival must not be null");
		
//		if (festival.getLocation()!=null)
//			throw new BadRequestException("The Location property is not editable.");

		repository.addFestival(festival);

		// Builds the response. Returns the group the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(festival.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(festival);			
		return resp.build();
	}

	
	@PUT
	@Consumes("application/json")
	public Response updateGroup(Festival festival) {
		Festival oldfestival= repository.getFestival(festival.getId());
		if (oldfestival == null) {
			throw new NotFoundException("The festival with id="+ festival.getId() +" was not found");			
		}
		
//		if (festival.getLocation()!=null)
//			throw new BadRequestException("The location property is not editable.");
//		
		// Update name
		if (festival.getName()!=null)
			oldfestival.setName(festival.getName());
		
		// Update description
		if (festival.getLocation()!=null)
			oldfestival.setLocation(festival.getLocation());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeGroup(@PathParam("id") String id) {
		Festival toberemoved=repository.getFestival(id);
		if (toberemoved == null)
			throw new NotFoundException("The festival with id="+ id +" was not found");
		else
			repository.deleteFestival(id);
		
		return Response.noContent().build();
	}
	
	
	
}
