package com.helmut.inpowered.repository;

import com.helmut.inpowered.domain.AddressBook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {

	long countBy();

	@Query(value = "SELECT count(ID_ADDRESS_BOOK) FROM ADDRESS_BOOK where gender = :gender", nativeQuery = true)
	long countByGender(@Param("gender") String gender);

	@Query(value = "SELECT * FROM ADDRESS_BOOK ORDER BY BIRTHDATE ASC limit 1", nativeQuery = true)
	AddressBook findOldestPerson();

	AddressBook findFirstByNameContainingIgnoreCase(String name);

}
