package com.helmut.inpowered.controller;

import java.time.temporal.ChronoUnit;

import com.helmut.inpowered.domain.AddressBook;
import com.helmut.inpowered.service.AddressBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address-book")
public class AddressBookController {

	@Autowired
	private AddressBookService addressBookService;

	@GetMapping(value = "/count-males")
	public long countMalesInAddressBook() {

		return addressBookService.countMalesInAddressBook();
	}

	@GetMapping(value = "/person/oldest")
	public ResponseEntity<AddressBook> findOldestPerson() {

		return new ResponseEntity<>(addressBookService.findOldestPerson(), HttpStatus.OK);
	}

	@GetMapping(value = "/person/name1/{name1}/name2/{name2}/diff-age-days")
	public ResponseEntity<Long> calc(@PathVariable String name1, @PathVariable String name2) {

		AddressBook person1 = addressBookService.findFirstByNameContainingIgnoreCase(name1);
		AddressBook person2 = addressBookService.findFirstByNameContainingIgnoreCase(name2);
		Long diff = ChronoUnit.DAYS.between(person1.getBirthdate(), person2.getBirthdate());

		return new ResponseEntity<>(diff, HttpStatus.OK);
	}

}