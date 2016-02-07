/**
 * 
 */
package de.dtonal.bundessprech;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

import javax.management.modelmbean.InvalidTargetObjectTypeException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import de.dtonal.bundessprech.data.Person;
import de.dtonal.bundessprech.domain.FractionDomain;

/**
 * @author dtonal_user
 *
 */
public class CsvParser {

	/**
	 * Extracts a List of Persons from an given csvFile
	 * 
	 * @param csvFile
	 *            the csvFile
	 * @return list of Persons
	 */
	public static ArrayList<Person> readFromCsvFile(File csvFile) {
		if (csvFile == null) {
			return null;

		}
		HashMap<String, Integer> positions = null;
		CSVParser parser = null;
		try {
			parser = CSVParser.parse(csvFile, Charset.defaultCharset(), CSVFormat.DEFAULT);
			positions = getDataPositionsFromFile(parser.getRecords().get(0));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (!validatePositionMap(positions)) {
				System.out.println("Csv has not all needed columns");
			}
		} catch (InvalidTargetObjectTypeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}

		ArrayList<Person> persons = new ArrayList<Person>();

		try {
			parser = CSVParser.parse(csvFile, Charset.defaultCharset(), CSVFormat.DEFAULT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int counter = 1;
		for (CSVRecord csvRecord : parser) {
			if (parser.getCurrentLineNumber() > 1) {
				Person person = new Person();
				person.setDateOfBirth(getDateFromString(csvRecord.get(0)));
				person.setElectoralDistrictName(csvRecord.get(25));
				person.setFraction(FractionDomain.getInstance().getFractionFromname(csvRecord.get(31)));				
				person.setGender(de.dtonal.bundessprech.data.Gender.fromString(csvRecord.get(28)));
				person.setHomepageUrl(getUrlFromString(csvRecord.get(34)));
				person.setId(Integer.valueOf(csvRecord.get(7)));
				person.setParty(de.dtonal.bundessprech.data.Party.fromString(csvRecord.get(4)));
				person.setPrename(csvRecord.get(14));
				person.setProfession(csvRecord.get(12));
				person.setState(de.dtonal.bundessprech.data.State.fromString(csvRecord.get(33)));
				person.setSurname(csvRecord.get(5));
				persons.add(person);
				System.out.println("Person(" + counter + "): " + person);
				counter++;
			}
		}

		return persons;

	}

	private static boolean validatePositionMap(HashMap<String, Integer> positions)
			throws InvalidTargetObjectTypeException {
		ArrayList<String> neededHeaders = new ArrayList<String>();
		neededHeaders.add("geburtsdatum");
		neededHeaders.add("partei");
		neededHeaders.add("nachname");
		neededHeaders.add("id");
		neededHeaders.add("beruf");
		neededHeaders.add("vorname");
		neededHeaders.add("wk_name");
		neededHeaders.add("geschlecht");
		neededHeaders.add("fraktion");
		neededHeaders.add("homepage_url");

		for (String header : neededHeaders) {
			if (positions.get(header) == null) {
				System.out.println("Header '" + header + "' is not in the given CSV-File");
				throw new InvalidTargetObjectTypeException("Header '" + header + "' is not in the given CSV-File");
			}
		}

		return true;
	}

	private static HashMap<String, Integer> getDataPositionsFromFile(CSVRecord csvRecord) {
		HashMap<String, Integer> positionMap = new HashMap<String, Integer>();

		Iterator<String> csvRecordIterator = csvRecord.iterator();
		int index = 0;
		while (csvRecordIterator.hasNext()) {
			String value = csvRecordIterator.next();
			if (value != null && !value.equals("")) {
				positionMap.put(value, index);
			}
			index++;
		}
		return positionMap;
	}

	private static URL getUrlFromString(String string) {
		URL url;
		try {
			url = new URL(string);
		} catch (MalformedURLException e) {
			if (!string.equals("")) {

				System.out.println("Can't get URL from string: '" + string + "'");

			}
			return null;
		}
		return url;
	}

	private static java.util.Date getDateFromString(String string) {
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
		Date date;
		try {
			date = format.parse(string);
		} catch (ParseException e) {
			if (!string.equals("")) {
				System.out.println("Can't parse " + string + " cause of " + e.getMessage());
			}
			return null;
		}
		return date;
	}

}
