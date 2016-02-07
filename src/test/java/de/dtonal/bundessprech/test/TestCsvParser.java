package de.dtonal.bundessprech.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.dtonal.bundessprech.CsvParser;
import de.dtonal.bundessprech.data.Person;
import de.dtonal.bundessprech.domain.FractionDomain;

public class TestCsvParser {

	@Before
	public void setUpFractions()
	{
		FractionDomain.getInstance();
	}
	
	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void readPersonListFromCsvFile() {
		
		ArrayList<Person> personsFromCsvFile = CsvParser.readFromCsvFile(new File("C:\\Users\\dtonal_user\\Downloads\\person.csv"));
		assertNotNull(personsFromCsvFile);
		if(personsFromCsvFile != null)
		{
			assertTrue(!personsFromCsvFile.isEmpty());
		}
	}

}
