package com.zensar.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.zensar.api.controller.UserController;
import com.zensar.api.service.UserService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class UserControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private UserController userController;

	@Mock
	private UserService service;

	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void testGetUpdatedUserList() throws Exception {

		/*
		 * when(service.getUpdatedUserList(url, positionToUpdate)).thenReturn(list);
		 * assertEquals(Integer.MIN_VALUE,
		 * userController.getUpdatedUserList(url,positionToUpdate,request));
		 */

		/*
		 * mockMvc.perform(get("/getUniqueUserIds")).andExpect(status().isOk())
		 * .andExpect(jsonPath("$.title", Matchers.is("1800flowers")))
		 * .andExpect(jsonPath("$.body", Matchers.is("1800flowers")));
		 */

	}

	@Test
	public void testGetUniqueUserIds() throws Exception {

		/*
		 * when(service.getUniqueUserIds(url)).thenReturn(10);
		 * assertEquals(Integer.MIN_VALUE,
		 * userController.getUniqueUserIds(url,request));
		 */

		/*
		 * mockMvc.perform(post("/getUniqueUserIds")).andExpect(status().isOk())
		 * .andExpect(jsonPath("userId", Matchers.is(10)));
		 */

	}

}
