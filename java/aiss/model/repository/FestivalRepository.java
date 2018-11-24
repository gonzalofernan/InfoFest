package aiss.model.repository;

import java.util.Collection;

import aiss.model.Festival;
import aiss.model.Group;

public interface FestivalRepository {
	
	
	// Groups
	public void addGroup(Group g);
	public Collection<Group> getAllGroups();
	public Group getGroup(String groupId);
	public void updateGroup(Group g);
	public void deleteGroup(String groupId);
	
	// Festival
	public void addFestival(Festival f);
	public Collection<Festival> getAllFestivals();
	public Festival getFestival(String id);
	public void updateFestival(Festival f);
	public void deleteFestival(String id);
	
	public Collection<Group> getAll(String groupId);
	public void addGroup(String festivalId, String groupId);
	public void removeGroup(String festivalId, String groupId); 

	
	
	
	

}
