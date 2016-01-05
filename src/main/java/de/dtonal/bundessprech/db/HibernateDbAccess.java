package de.dtonal.bundessprech.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import de.dtonal.bundessprech.data.Person;

public class HibernateDbAccess {
	
	private static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory == null)
		{
			try {

				Configuration configuration = new Configuration();

				configuration.configure("hibernate.cfg.xml");
				configuration.addAnnotatedClass(Person.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
		}
		
		return sessionFactory;
	}

}
