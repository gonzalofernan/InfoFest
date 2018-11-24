package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Festival {

	private String id;
	private String name;
	private String location;
	private List<Group> groups;

	public Festival() {

	}

	public Festival(String name) {
		this.name = name;

	}

	protected void setSongs(List<Group> s) {
		groups = s;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public Group getGroup(String id) {
		if (groups == null)
			return null;

		Group group = null;
		for (Group g : groups)
			if (g.getId().equals(id))
			{
				group = g;
				break;
			}
		return group;
	}

	public void addGroup(Group g) {
		// TODO Auto-generated method stub
		if (groups == null)
			groups = new ArrayList<Group>();
		groups.add(g);

	}

	public void deleteGroup(Group g) {
		groups.remove(g);
	}

	public void deleteGroup(String id) {
		// TODO Auto-generated method stub
		Group g = getGroup(id);
		if (g != null)
			groups.remove(g);

	}

}
