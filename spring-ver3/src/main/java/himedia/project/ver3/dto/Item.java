package himedia.project.ver3.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
	private Long itemId;
	private String name;
	private Long price;
	private Long count;
}
