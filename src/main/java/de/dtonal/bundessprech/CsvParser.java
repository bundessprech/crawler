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
import java.util.Locale;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import de.dtonal.bundessprech.data.Faction;
import de.dtonal.bundessprech.data.Gender;
import de.dtonal.bundessprech.data.Party;
import de.dtonal.bundessprech.data.Person;
import de.dtonal.bundessprech.data.State;

/**
 * @author dtonal_user
 *
 */
public class CsvParser {
	static ArrayList<Person> readFromCsvFile(File csvFile) {
		if (csvFile == null) {
			return null;
		}
		ArrayList<Person> persons = new ArrayList<Person>();
		try {
			CSVParser parser = CSVParser.parse(csvFile, Charset.defaultCharset(), CSVFormat.DEFAULT);
			for (CSVRecord csvRecord : parser) {
				if (parser.getCurrentLineNumber() > 1) {
					System.out.println("Record(" + parser.getCurrentLineNumber() + "): " + csvRecord.get(5));
					Person person = new Person();
					person.setDateOfBirth(getDateFromString(csvRecord.get(0)));
					person.setElectoralDistrictName(csvRecord.get(25));
					person.setFaction(Faction.fromString(csvRecord.get(31)));
					person.setGender(Gender.fromString(csvRecord.get(28)));
					person.setHomepageUrl(getUrlFromString(csvRecord.get(34)));
					person.setId(Integer.valueOf(csvRecord.get(7)));
					person.setParty(Party.fromString(csvRecord.get(4)));
					person.setPrename(csvRecord.get(14));
					person.setProfession(csvRecord.get(12));
					person.setState(State.fromString(csvRecord.get(33)));
					person.setSurname(csvRecord.get(5));
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

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
