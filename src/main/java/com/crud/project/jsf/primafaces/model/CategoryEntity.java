package com.crud.project.jsf.primafaces.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.crud.project.jsf.primafaces.base.BaseEntities;

@Entity
@Table(name = "Categories")
@AttributeOverride(name = "id", column = @Column(name = "CategoryID"))
public class CategoryEntity extends BaseEntities<Long> {

	private static final long serialVersionUID = -5099187464640073288L;
	
	private String categoryName;	
	
	private String description;
	
	private Byte[] picture;
	
	public CategoryEntity() {
		// TODO Auto-generated constructor stub
	}

	public CategoryEntity(String categoryName, String description, Byte[] picture) {
		super();
		this.categoryName = categoryName;
		this.description = description;
		this.picture = picture;
	}
	
	public CategoryEntity(Long id,String categoryName, String description, Byte[] picture) {
		super();
		this.setId(id);
		this.categoryName = categoryName;
		this.description = description;
		this.picture = picture;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte[] getPicture() {
		return picture;
	}

	public void setPicture(Byte[] picture) {
		this.picture = picture;
	}
	
	
	

}
