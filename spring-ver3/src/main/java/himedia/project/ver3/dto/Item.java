package himedia.project.ver3.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
	private Long id;
	private String name;
	private Integer price;
	private Integer quantity;
	public Item() {}

	public Item(String name, Integer price, Integer quantity) {
		System.out.println("dto 생성생성생성자 실행");
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
}
