package com.helmut.inpowered.service;

import com.helmut.inpowered.domain.AddressBook;
import com.helmut.inpowered.repository.AddressBookRepository;
import com.helmut.inpowered.service.impl.AddressBookServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AddressBookServiceTest {

	@InjectMocks
	private AddressBookServiceImpl service;

	@Mock
	private AddressBookRepository repository;

	@Test
	void testCountMalesInAddressBook() {
		Long countMales = 3L;
		Mockito.when(repository.countByGender("M")).thenReturn(countMales);

		service.countMalesInAddressBook();

		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		Mockito.verify(repository).countByGender(captor.capture());
	}

	@Test
	void testFindOldestPerson() {

		AddressBook addressBook = new AddressBook();
		addressBook.setName("Wes Jackson");

		Mockito.when(repository.findOldestPerson()).thenReturn(addressBook);

		service.findOldestPerson();

		Mockito.verify(repository).findOldestPerson();
	}

	@Test
	void testFindByName() {

		String name = "Paul";

		AddressBook addressBook = new AddressBook();
		addressBook.setName("Paul Robinson");

		Mockito.when(repository.findFirstByNameContainingIgnoreCase(name)).thenReturn(addressBook);

		service.findFirstByNameContainingIgnoreCase(name);

		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		Mockito.verify(repository).findFirstByNameContainingIgnoreCase(captor.capture());

		Assertions.assertEquals(name, captor.getValue());
	}
}
