package com.crud.project.jsf.primafaces.test.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.crud.project.jsf.primafaces.model.CategoryEntity;
import com.crud.project.jsf.primafaces.model.repositories.ICategoryRepository;
import com.crud.project.jsf.primafaces.test.AbstractDataBaseTest;

public class CategoryRepositoryTest extends AbstractDataBaseTest {

	private static final Logger LOGGER = Logger.getLogger(CategoryRepositoryTest.class);

	@Inject
	private ICategoryRepository categoryRepository;

	@Test
	public void testCategoryRepository() {
		List<CategoryEntity> categories = this.categoryRepository.findAll();

		LOGGER.info(categories);
	}
}
