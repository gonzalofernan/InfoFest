package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.model.Festival;
import aiss.model.Group;

public class MapFestivalRepository implements FestivalRepository {

	Map<String, Festival> festivalMap;
	Map<String, Group> groupMap;
	private static MapFestivalRepository instance = null;
	private int index = 0; // Index to create playlists and songs' identifiers.

	public static MapFestivalRepository getInstance() {

		if (instance == null) {
			instance = new MapFestivalRepository();
			instance.init();
		}

		return instance;
	}

	public void init() {

		festivalMap = new HashMap<String, Festival>();
		groupMap = new HashMap<String, Group>();

		// Create groups

		Group group = new Group();
		group.setName("Kiss");
		group.setGenre("Rock");
		group.setSinger("Paul Stanley");
		group.setLeadGuitarist("Tommy Thayer");
		addGroup(group);
		
		Group groupp = new Group();
		groupp.setName("AcDc");
		groupp.setGenre("Rock");
		groupp.setSinger("Brian Johnson");
		groupp.setLeadGuitarist("Angus Young");
		addGroup(groupp);

		

		// Create Festival

		Festival extremusika = new Festival();
		extremusika.setName("Extremusika");
		extremusika.setLocation("Cáceres");
		addFestival(extremusika);

		Festival viñaRock = new Festival();
		viñaRock.setName("Viña Rock");
		viñaRock.setLocation("Villarrobledo");
		addFestival(viñaRock);

		Festival resurrectionFest = new Festival();
		resurrectionFest.setName("Resurrection Fest");
		resurrectionFest.setLocation("Viveiro");
		addFestival(resurrectionFest);

		Festival download = new Festival();
		download.setName("Download");
		download.setLocation("Madrid");
		addFestival(download);

		// Add groups to festivals

		addGroup(extremusika.getId(),group.getId());
		addGroup(viñaRock.getId(),group.getId());
		addGroup(resurrectionFest.getId(),groupp.getId());
		addGroup(download.getId(),groupp.getId());
		
		
	
		
		

	}

	// Festival related operations
	
	@Override
	public void addFestival(Festival f) {
		String id = "f" + index++;
		f.setId(id);
		festivalMap.put(id, f);
	}

	@Override
	public Collection<Festival> getAllFestivals() {
		return festivalMap.values();
	}

	@Override
	public Festival getFestival(String id) {
		return festivalMap.get(id);
	}

	@Override
	public void updateFestival(Festival f) {
		festivalMap.put(f.getId(), f);
	}

	@Override
	public void deleteFestival(String id) {
		festivalMap.remove(id);
	}

	@Override
	public void addGroup(String festivalId, String groupId) {
		Festival festival = getFestival(festivalId);
		festival.addGroup(groupMap.get(groupId));
	}

	@Override
	public Collection<Group> getAll(String festivalId) {
		return getFestival(festivalId).getGroups();
	}

	@Override
	public void removeGroup(String festivalId, String groupId) {
		getFestival(festivalId).deleteGroup(groupId);
	}

	
//	@Override
//	public void addGroup(Group g) {
//		String id = "g" + index++;
//		g.setId(id);
//		groupMap.put(id, g);
//	}
//
//	@Override
//	public Collection<Group> getAllGroups() {
//		return groupMap.values();
//	}
//
//	@Override
//	public Group getGroup(String id) {
//		return groupMap.get(id);
//	}
//
//	@Override
//	public void updateGroup(Group g) {
//		groupMap.put(g.getName(), g);
//	}
//
//	@Override
//	public void deleteGroup(String id) {
//		groupMap.remove(id);
//	}
//
//	@Override
//	public void addGroup(String festivalId, String groupId) {
//		Festival festival = getFestival(festivalId);
//		festival.addGroup(groupMap.get(groupId));
//	}
//
//	 @Override
//	 public Collection<Group> getAll(String festivalId) {
//	 return getGroup(festivalId).getName();
//	 }
//
//	@Override
//	public void removeGroup(String name, String genre) {
//		getFestival(name).deleteGroup(name);
//	}

	// Group related operations

	@Override
	public void addGroup(Group g) {
		String id = "g" + index++;
		g.setId(id);
		groupMap.put(id, g);
	}

	@Override
	public Collection<Group> getAllGroups() {
		return groupMap.values();
	}

	@Override
	public Group getGroup(String groupId) {
		return groupMap.get(groupId);
	}

	@Override
	public void updateGroup(Group g) {
		Group group = groupMap.get(g.getId());
		group.setId(g.getId());
		group.setName(g.getName());
		group.setGenre(g.getGenre());
		group.setSinger(g.getSinger());
		group.setLeadGuitarist(g.getLeadGuitarist());
		
	}

	@Override
	public void deleteGroup(String groupId) {
		groupMap.remove(groupId);
	}

}
