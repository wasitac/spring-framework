package himedia.project.ver2.domain;

public class ItemTwo {
	private Long id;
	private String name;
	
	public ItemTwo(String etc) {
		System.out.println(etc);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
