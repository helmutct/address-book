package com.helmut.inpowered.service;

import com.helmut.inpowered.domain.AddressBook;

import org.springframework.stereotype.Service;

@Service
public interface AddressBookService {

	long countMalesInAddressBook();

	AddressBook findOldestPerson();

	AddressBook findFirstByNameContainingIgnoreCase(String name);

}