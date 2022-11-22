package br.com.fiap.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filme {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = 1L;
	private String name = "Meu setup";
	private String description = "Teste de descrição";
	private BigDecimal price = new BigDecimal(200);
	private String imagePath;
	
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
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Filme [id=" + id + ", name=" + name + ", description=" + description 
				+ ", imagePath=" + imagePath + "]";
	}
	
	
	
}
