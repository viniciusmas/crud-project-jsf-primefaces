package com.crud.project.jsf.primafaces.controller.user;

import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import com.crud.project.jsf.primafaces.base.BaseBeans;
import com.crud.project.jsf.primafaces.model.UserEntity;
import com.crud.project.jsf.primafaces.model.repositories.IUserRepository;

@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "userAddEditManagedBean")
public class UserAddEditManagedBean extends BaseBeans {
	
	private static final long serialVersionUID = 1681735543097743050L;
	
	@Inject
	private UserManagedBean managedBeanUser;
	
	@Inject
	private IUserRepository userRepository;
	
	@Inject
	private FacesContext context;
	
	private UserEntity user;
	
	private String title;
		
	public UserAddEditManagedBean() {
		this.user = new UserEntity();
	}
	
	public void add() {
		this.title = this.getResourceProperty("labels", "user_add");
	}
	
	public void update() {
		this.title = this.getResourceProperty("labels", "user_update");
		this.user = managedBeanUser.getSelectedUser();
	}
	
	public void save() {
		if(this.user != null) {
			if(this.user.getId() == null) {
				//Add
				this.userRepository.save(this.user);
			}else {
				//Update
				this.userRepository.save(this.user);
			}
		}
	}
	
	public void cancel() {
		this.managedBeanUser.unSelectUser();
	}
	
	public String getResourceProperty(String resource, String label) {
		Application application = this.context.getApplication();
		ResourceBundle bundle = application.getResourceBundle(this.context, resource);

		return bundle.getString(label);
	}
	
	//getter and setter

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}