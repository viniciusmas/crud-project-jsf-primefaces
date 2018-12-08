package com.crud.project.jsf.primafaces.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.project.jsf.primafaces.model.ProductEntity;

public interface IProductRepository extends JpaRepository<ProductEntity, Long>{

}
