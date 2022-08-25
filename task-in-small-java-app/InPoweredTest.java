import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

enum Gender {
	MALE, FEMALE;
}

class AddressBook {
	String name;
	Gender gender;
	LocalDate birthdate;

	public AddressBook(String name, Gender gender, LocalDate birthdate) {
		this.name = name;
		this.gender = gender;
		this.birthdate = birthdate;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}
}

class InPoweredTest {

	public List<AddressBook> getDataFromCSV() {
		List<AddressBook> addressBooks = new ArrayList<>();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yy");

		try (BufferedReader fileReader = new BufferedReader(new FileReader("AddressBook.txt"))) {
			String line = "";
			while ((line = fileReader.readLine()) != null) {
				String[] columns = line.split(",");
				addressBooks.add(new AddressBook(columns[0].trim(), Gender.valueOf(columns[1].toUpperCase().trim()),
						LocalDate.parse(columns[2].trim(), dateFormatter)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return addressBooks;
	}
}

class Main {
	public static void main(String[] args) {

		InPoweredTest inPoweredTest = new InPoweredTest();
		List<AddressBook> addressBooks = inPoweredTest.getDataFromCSV();

		// 1. How many males are in the address book?
		long countMales = addressBooks.stream().filter(a -> a.gender == Gender.MALE).count();
		System.out.println("1. How many males are in the address book? " + countMales);

		// 2. Who is the oldest person in the address book?
		AddressBook oldestPerson = addressBooks.stream().min(Comparator.comparing(AddressBook::getBirthdate)).get();
		System.out.println("2. Who is the oldest person in the address book? " + oldestPerson.name);

		// 3. How many days older is Bill than Paul?
		AddressBook bill = addressBooks.stream().filter(value -> value.name.toUpperCase().contains("BILL")).findFirst()
				.get();
		AddressBook paul = addressBooks.stream().filter(value -> value.name.toUpperCase().contains("PAUL")).findFirst()
				.get();
		System.out.println("3. How many days older is Bill than Paul? "
				+ ChronoUnit.DAYS.between(bill.getBirthdate(), paul.getBirthdate()));
	}
}