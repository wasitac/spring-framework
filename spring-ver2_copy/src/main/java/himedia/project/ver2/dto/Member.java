package himedia.project.ver2.dto;

import org.apache.ibatis.type.Alias;

@Alias("Member")
public class Member {
	private String name;
	private Long id;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
