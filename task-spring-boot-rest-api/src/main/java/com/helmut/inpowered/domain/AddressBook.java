package com.helmut.inpowered.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.helmut.inpowered.enums.Gender;

@Entity
@Table(name = "ADDRESS_BOOK")
public class AddressBook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7196542370709340552L;

	@Id
	@Column(name = "ID_ADDRESS_BOOK")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ADDRESS_BOOKS_SEQ")
	@SequenceGenerator(name = "ADDRESS_BOOKS_SEQ", sequenceName = "ADDRESS_BOOKS_SEQ", allocationSize = 1)
	private long id;

	@Column(name = "NAME", nullable = false, length = 50)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "GENDER", nullable = false, length = 1)
	private Gender gender;

	@Column(name = "BIRTHDATE", columnDefinition = "DATE", nullable = false)
	private LocalDate birthdate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
}
