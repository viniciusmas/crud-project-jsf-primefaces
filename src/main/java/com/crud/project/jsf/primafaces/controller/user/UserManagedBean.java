package com.crud.project.jsf.primafaces.controller.user;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import com.crud.project.jsf.primafaces.base.BaseBeans;
import com.crud.project.jsf.primafaces.model.UserEntity;
import com.crud.project.jsf.primafaces.model.repositories.IUserRepository;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "userManagedBean")
public class UserManagedBean extends BaseBeans {

	private static final long serialVersionUID = 7824582916113313657L;
	
	private static final Logger LOGGER = Logger.getLogger(UserManagedBean.class);
	
	@Inject
	private IUserRepository userRepository;
	
	private List<UserEntity> users;
	
	private UserEntity selectedUser;
	
	private Long id;

	public UserManagedBean() {
		
	}
	
	public void onLoad() {
		this.users = this.userRepository.findAll();
	}
	
	public void selectUser(SelectEvent event) {
		try {
			if(event.getObject() != null) {
				this.selectedUser = (UserEntity) event.getObject();
			}else {
				this.selectedUser = null;
			}
		}catch (Exception e) {
			this.selectedUser = null;
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	public void unSelectUser() {
		this.selectedUser = null;
	}
	
	public void delete() {
		if(this.selectedUser != null) {
			this.userRepository.delete(this.selectedUser.getId());
		}
	}
	
	//getter and setter

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public UserEntity getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserEntity selectedUser) {
		this.selectedUser = selectedUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
