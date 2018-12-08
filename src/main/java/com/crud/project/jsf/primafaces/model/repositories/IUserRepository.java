package com.crud.project.jsf.primafaces.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.project.jsf.primafaces.model.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long>{

	public UserEntity findByUsernameAndPassword(String username, String password);

}
