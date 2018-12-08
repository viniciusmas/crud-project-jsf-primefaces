package com.crud.project.jsf.primafaces.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.project.jsf.primafaces.model.CategoryEntity;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long>{

}
