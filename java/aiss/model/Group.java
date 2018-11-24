package aiss.model;

public class Group {
	
	private String id;
	private String name;
	private String genre;
	private String singer;
	private String leadGuitarist;
	
	public Group() {
		
	}

public Group(String name, String genre, String singer, String leadGuitarist) {
		
		this.name = name;
		this.genre = genre;
		this.singer = singer;
		this.leadGuitarist = leadGuitarist;
	}
	
	public Group(String id,String name, String genre, String singer, String leadGuitarist) {
		
		this.id=id;
		this.name = name;
		this.genre = genre;
		this.singer = singer;
		this.leadGuitarist = leadGuitarist;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getLeadGuitarist() {
		return leadGuitarist;
	}

	public void setLeadGuitarist(String leadGuitarist) {
		this.leadGuitarist = leadGuitarist;
	}

	
	
	
	
	

}
