package com.crud.project.jsf.primafaces.test.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.crud.project.jsf.primafaces.model.UserEntity;
import com.crud.project.jsf.primafaces.model.repositories.IUserRepository;
import com.crud.project.jsf.primafaces.test.AbstractDataBaseTest;

public class UserRepositoryTest extends AbstractDataBaseTest {

	private static final Logger LOGGER = Logger.getLogger(UserRepositoryTest.class);

	@Inject
	private IUserRepository userRepository;

	@Test
	public void testUserRepository() {
		List<UserEntity> users = this.userRepository.findAll();

		LOGGER.info(users);
	}
}
