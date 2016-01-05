package de.dtonal.bundessprech;

import java.io.File;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.dtonal.bundessprech.data.Gender;
import de.dtonal.bundessprech.data.Person;
import de.dtonal.bundessprech.db.HibernateDbAccess;

@SpringBootApplication
public class CrawlerApplication {
	static SessionFactory sessionFactory = null;

	public static void main(String[] args) {
		SpringApplication.run(CrawlerApplication.class, args);

		File csvFile = new File("person.csv");
		if (csvFile != null) {
			ArrayList<Person> persons = CsvParser.readFromCsvFile(csvFile);
		}
		for (int i = 0; i < 5; i++) {
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX");
		}

	}
	// /* Method to CREATE an employee in the database */
	// public static Integer addEmployee(String fname, String lname, int id){
	// Session session = sessionFactory.openSession();
	// Transaction tx = null;
	// Integer employeeID = null;
	// try{
	// tx = session.beginTransaction();
	// Person person = new Person();
	// person.setPrename(fname);
	// person.setSurname(lname);
	// person.setId(id);
	// person.setGender(Gender.FEMALE);
	// employeeID = (Integer) session.save(person);
	// tx.commit();
	// }catch (HibernateException e) {
	// if (tx!=null) tx.rollback();
	// e.printStackTrace();
	// }finally {
	// session.close();
	// }
	// return employeeID;
	// }
}
