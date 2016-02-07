package de.dtonal.bundessprech;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import de.dtonal.bundessprech.data.Person;
import de.dtonal.bundessprech.domain.FractionDomain;
import de.dtonal.bundessprech.domain.PersonDomain;

public class DataBaseInitialiser{

	public static void initDB() {
		FractionDomain.getInstance();
		ArrayList<Person> personsFromCsvFile = CsvParser
				.readFromCsvFile(new File("C:\\Users\\dtonal_user\\Downloads\\person.csv"));
		if (personsFromCsvFile != null) {
			for(Person person : personsFromCsvFile)
			{
				PersonDomain.saveUserInDB(person);
			}
		}
	}

	public static void clearDb() {
		PersonDomain.clearAll();
		FractionDomain.clearAll();
	}
}
