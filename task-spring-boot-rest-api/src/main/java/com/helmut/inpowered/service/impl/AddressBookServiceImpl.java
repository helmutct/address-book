package com.helmut.inpowered.service.impl;

import com.helmut.inpowered.domain.AddressBook;
import com.helmut.inpowered.enums.Gender;
import com.helmut.inpowered.repository.AddressBookRepository;
import com.helmut.inpowered.service.AddressBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl implements AddressBookService {

	@Autowired
	private AddressBookRepository addressBookRepository;

	@Override
	public long countMalesInAddressBook() {
		return addressBookRepository.countByGender(Gender.M.toString());
	}

	@Override
	public AddressBook findOldestPerson() {
		return addressBookRepository.findOldestPerson();
	}

	@Override
	public AddressBook findFirstByNameContainingIgnoreCase(String name) {
		return addressBookRepository.findFirstByNameContainingIgnoreCase(name);
	}

}
