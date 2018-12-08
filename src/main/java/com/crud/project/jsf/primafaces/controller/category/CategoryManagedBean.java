package com.crud.project.jsf.primafaces.controller.category;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import com.crud.project.jsf.primafaces.base.BaseBeans;
import com.crud.project.jsf.primafaces.model.CategoryEntity;
import com.crud.project.jsf.primafaces.model.repositories.ICategoryRepository;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "categoryManagedBean")
public class CategoryManagedBean extends BaseBeans {

	private static final long serialVersionUID = 2772416308632360730L;
	
	private static final Logger LOGGER = Logger.getLogger(CategoryManagedBean.class);
	
	@Inject
	private ICategoryRepository categoryRepository;
	
	private List<CategoryEntity> categories;
	
	private CategoryEntity selectedCategory;
	
	private Long id;

	public CategoryManagedBean() {
		
	}
	
	public void onLoad() {
		this.categories = this.categoryRepository.findAll();
	}
	
	public void selectCategory(SelectEvent event) {
		try {
			if(event.getObject() != null) {
				this.selectedCategory = (CategoryEntity) event.getObject();
			}else {
				this.selectedCategory = null;
			}
			
		}catch (Exception e) {
			this.selectedCategory = null;
			LOGGER.error(e.getMessage(), e);
		}
	}

	public void unSelectCategory() {
		this.selectedCategory = null;
	}
	
	public void delete() {
		if(this.selectedCategory != null) {
			this.categoryRepository.delete(this.selectedCategory.getId());
		}
	}
	
	//getter and setter

	public List<CategoryEntity> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryEntity> categories) {
		this.categories = categories;
	}
	
	public CategoryEntity getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(CategoryEntity selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}