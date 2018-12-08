package com.crud.project.jsf.primafaces.controller.category;

import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import com.crud.project.jsf.primafaces.base.BaseBeans;
import com.crud.project.jsf.primafaces.model.CategoryEntity;
import com.crud.project.jsf.primafaces.model.repositories.ICategoryRepository;

@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "categoryAddEditManagedBean")
public class CategoryAddEditManagedBean extends BaseBeans {

	private static final long serialVersionUID = 4754486518733123966L;
	
	@Inject
	private CategoryManagedBean managedBeanCategory;
	
	@Inject
	private ICategoryRepository categoryRepository;
	
	@Inject
	private FacesContext context;
	
	private CategoryEntity category;
	
	private String title;

	public CategoryAddEditManagedBean() {
		this.category = new CategoryEntity();
	}

	public void add() {
		this.title = this.getResourceProperty("labels", "category_add");
	}
	
	public void update() {
		this.title = this.getResourceProperty("labels", "category_update");
		this.category = managedBeanCategory.getSelectedCategory();
	}
	
	public void save() {
		if (this.category != null) {
			if (this.category.getId() == null) {
				// Add
				this.categoryRepository.save(this.category);
			} else {
				// Update
				this.categoryRepository.save(this.category);
			}
		}
	}
	
	public void cancel() {
		this.managedBeanCategory.unSelectCategory();
	}
	
	public String getResourceProperty(String resource, String label) {
		Application application = this.context.getApplication();
		ResourceBundle bundle = application.getResourceBundle(this.context, resource);

		return bundle.getString(label);
	}
	
	//getter and setter
	
	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}