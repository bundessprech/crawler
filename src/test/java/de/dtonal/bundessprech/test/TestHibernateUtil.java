/**
 * 
 */
package de.dtonal.bundessprech.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Test;

import de.dtonal.bundessprech.HibernateUtil;

/**
 * @author dtonal_user
 *
 */
public class TestHibernateUtil {

	@Test
	public void test() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		assertNotNull(factory);
		HibernateUtil.shutdown();
	}

}
