package mx.utng.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="suppliers")
public class Supplier {
	@Id @GeneratedValue
	private Long id;
	@Column(length = 50)
	private String description;
	@Column(length = 50)
	private String name;
	
	
	public Supplier(String description, String name) {
		super();
		this.description = description;
		this.name = name;
	}

	public Supplier() {
		this("","");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
