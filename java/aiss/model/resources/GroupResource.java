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

import aiss.model.Group;
import aiss.model.repository.FestivalRepository;
import aiss.model.repository.MapFestivalRepository;


@Path("/groups")
public class GroupResource {

	public static GroupResource _instance=null;
	FestivalRepository repository;
	
	private GroupResource(){
		repository=MapFestivalRepository.getInstance();
	}
	
	public static GroupResource getInstance()
	{
		if(_instance==null)
			_instance=new GroupResource();
		return _instance; 
	}
	//A partir de aqui
	@GET
	@Produces("application/json")
	public Collection<Group> getAll()
	{
		return repository.getAllGroups();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Group get(@PathParam("id") String groupId)
	{
		Group group = repository.getGroup(groupId);
		
		if(group == null) {
			throw new NotFoundException("The group with the id " + groupId + " was not found");
		}
		
		return group;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addGroup(@Context UriInfo uriInfo, Group group) {
		if (group.getName() == null || "".equals(group.getName()))
			throw new BadRequestException("The name of the group must not be null");
		
//		if (group.getGenre()!=null)
//			throw new BadRequestException("The group property is not editable.");

		repository.addGroup(group);

		// Builds the response. Returns the song the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(group.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(group);			
		return resp.build();
	}

	
	
	@PUT
	@Consumes("application/json")
	public Response updateGroup(Group group) {
		Group oldgroup = repository.getGroup(group.getId());
		if (oldgroup == null) {
			throw new NotFoundException("The group with id="+ group.getId() +" was not found");			
		}
		
		if (group.getName() == null || "".equals(group.getName()))
			throw new BadRequestException("The name of the group must not be null");
			repository.updateGroup(group);
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeGroup(@PathParam("id") String groupId) {
		Group toberemoved=repository.getGroup(groupId);
		if (toberemoved == null)
			throw new NotFoundException("The group with id="+ groupId +" was not found");
		else
			repository.deleteGroup(groupId);
		
		return Response.noContent().build();
	}
	
	
	
}
