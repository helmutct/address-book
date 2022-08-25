package com.helmut.inpowered.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.helmut.inpowered.InpoweredApplication;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@Import(InpoweredApplication.class)
public class AddressBookControllerTest {

	private static final String ADDRESS_BOOK_PATH = "/address-book";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void shouldReturnCorrectMalesNumber() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(ADDRESS_BOOK_PATH + "/count-males"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", Is.is(3)));
	}

	@Test
	void shouldReturnCorrectOldestPerson() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(ADDRESS_BOOK_PATH + "/person/oldest"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is("Wes Jackson")));
	}

	@Test
	void shouldReturnCorrectDaysBetweenBirthdays() throws Exception {
		String name1 = "Bill";
		String name2 = "Paul";

		this.mockMvc
				.perform(MockMvcRequestBuilders
						.get(ADDRESS_BOOK_PATH + "/person/name1/" + name1 + "/name2/" + name2 + "/diff-age-days"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", Is.is(2862)));
	}
}
