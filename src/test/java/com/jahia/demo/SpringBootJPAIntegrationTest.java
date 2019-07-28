package com.jahia.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import com.jahia.demo.entities.User;
import com.jahia.demo.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class SpringBootJPAIntegrationTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void givenUserEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
		User user = userRepository.save(new User("test", "test@test"));
		User foundUser = userRepository.findById(user.getId()).get();

		assertNotNull(foundUser);
		assertEquals(user, foundUser);
	}
	
	
	@Test
	public void givenUserEntityRepository_whenDeleteAndRetreiveEntity_thenOK() {
		User user = userRepository.save(new User("test", "test@test"));
		userRepository.delete(user);
		User foundUser = userRepository.findById(user.getId()).orElse(null);
		
		assertNull(foundUser);
	}
	
	
}