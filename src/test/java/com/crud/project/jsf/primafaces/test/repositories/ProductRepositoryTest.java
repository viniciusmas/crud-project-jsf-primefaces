package com.crud.project.jsf.primafaces.test.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.crud.project.jsf.primafaces.model.ProductEntity;
import com.crud.project.jsf.primafaces.model.repositories.IProductRepository;
import com.crud.project.jsf.primafaces.test.AbstractDataBaseTest;

public class ProductRepositoryTest extends AbstractDataBaseTest {

	private static final Logger LOGGER = Logger.getLogger(ProductRepositoryTest.class);

	@Inject
	private IProductRepository productRepository;

	@Test
	public void testProductRepository() {
		List<ProductEntity> products = this.productRepository.findAll();

		LOGGER.info(products);
	}
}
