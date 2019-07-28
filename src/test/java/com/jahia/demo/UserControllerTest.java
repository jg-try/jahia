package com.jahia.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getUsersTest() {
		String verifiedUsers = "[{\"id\":1,\"name\":\"John\",\"email\":\"john@domain.com\"},{\"id\":2,\"name\":\"Julie\",\"email\":\"julie@domain.com\"},{\"id\":3,\"name\":\"Jennifer\",\"email\":\"jennifer@domain.com\"},{\"id\":4,\"name\":\"Helen\",\"email\":\"helen@domain.com\"},{\"id\":5,\"name\":\"Rachel\",\"email\":\"rachel@domain.com\"}]";
		try {
			this.mvc.perform(get("/users")).andDo(print()).andExpect(status().isOk())
					.andExpect(content().string(containsString(verifiedUsers)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
