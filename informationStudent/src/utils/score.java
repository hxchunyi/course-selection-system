package utils;

public class score {
	private String id;
	private String name;
	private String score;
	private String semester;
	
	public score(String id,String name , String score ,String semester){
		this.id=id;
		this.name=name;
		this.score=score;
		this.semester=semester;
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

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	
}
