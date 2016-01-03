/**
 * 
 */
package de.dtonal.bundessprech;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import de.dtonal.bundessprech.data.Person;

/**
 * @author dtonal_user
 *
 */
public class CsvParser {
	static ArrayList<Person> readFromCsvFile(File csvFile)
	{
		if(csvFile == null)
		{
			return null;
		}
		ArrayList<Person> persons = new ArrayList<Person>();
		try {
			CSVParser parser = CSVParser.parse(csvFile, Charset.defaultCharset(), CSVFormat.DEFAULT);
			for (CSVRecord csvRecord : parser) {
			     System.out.println("Record: " + csvRecord.get(5));
			 }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
