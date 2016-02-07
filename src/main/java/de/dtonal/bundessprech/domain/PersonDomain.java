/**
 * 
 */
package de.dtonal.bundessprech.domain;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import de.dtonal.bundessprech.HibernateUtil;
import de.dtonal.bundessprech.data.Person;

/**
 * @author dtonal_user
 *
 */
public class PersonDomain {

	public static void saveUserInDB(Person person) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();
			employeeID = (Integer) session.save(person);
			System.out.println("Person " + person + " was added with ID: " + employeeID);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void clearAll() {
		HibernateUtil.getSessionFactory().openSession().createQuery("delete from Person").executeUpdate();
		
	}
	

}
